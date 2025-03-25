package ca.mcmaster.se2aa4.island.team46;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team46.Drone.Battery;
import ca.mcmaster.se2aa4.island.team46.Drone.Constraints;
import ca.mcmaster.se2aa4.island.team46.Drone.Movements;
import ca.mcmaster.se2aa4.island.team46.Drone.Sensor;
import ca.mcmaster.se2aa4.island.team46.Interface.Finder;
import ca.mcmaster.se2aa4.island.team46.Island.IslandDetector;
import ca.mcmaster.se2aa4.island.team46.Island.State;

public class Controller {

    private static final Logger logger = LogManager.getLogger(Controller.class);

    private Tracker droneTracker;
    private Movements drone;
    private Sensor sensor;
    private Battery battery;
    private Constraints constraints;
    private State currentState;
    private JSONObject previousCommand;

    public Controller(int batteryLevel, String direction) {
        // Set initial direction, defaulting to East if invalid
        Direction.Compass startDirection = Direction.Compass.E;
        try {
            startDirection = Direction.Compass.valueOf(direction);
        } catch (Exception e) {
            logger.error("Invalid direction provided, defaulting to East", e);
        }

        // Initialize components
        this.battery = new Battery(batteryLevel);
        this.drone = new Movements(batteryLevel, direction);
        this.sensor = new Sensor(startDirection);
        this.constraints = new Constraints(this.drone);

        // Start in the FindIsland state
        this.currentState = new IslandDetector(this.drone, this.sensor);

        // Track drone actions
        List<Finder> subjects = Arrays.asList(this.drone, this.sensor);
        this.droneTracker = new Tracker(subjects);

        logger.info("DroneController initialized with direction: {}", startDirection);
    }
    public int getBatteryLevel() {
        return this.drone.getBatteryLevel();  // Ensure MovementController has this method
    }
    
    public int getInitialBatteryLevel() {
        return this.drone.getInitialBatteryLevel();  // Ensure MovementController has this method
    }

    private void updateBatteryLevel() {
        if (previousCommand != null && previousCommand.has("cost")) {
            int batteryUsed = previousCommand.getInt("cost");
            this.drone.useBattery(batteryUsed);
            logger.info("Battery updated: {} remaining", this.drone.getBatteryLevel());
        }
    }

    private JSONObject stopMoving() {
        logger.info("Stopping drone due to low battery.");
        this.drone.stop();
        return droneTracker.getLastCommand();
    }

    public JSONObject takeDecision() {
        updateBatteryLevel();

        // Stop if battery is insufficient
        if (!constraints.enoughBattery()) {
            return stopMoving();
        }

        State nextState;
        State currentState;

        // Keep transitioning states until no change occurs
        do {
            currentState = this.currentState; // Store current state
            nextState = this.currentState.getNextState(previousCommand);
            this.currentState = nextState; // Update to next state
        } while (!currentState.equals(nextState));

        return droneTracker.getLastCommand();
    }

    public void updateDrone(JSONObject command) {
        this.previousCommand = command;
    }
}
