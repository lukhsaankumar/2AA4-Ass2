package ca.mcmaster.se2aa4.island.team46.Drone;

import java.util.EnumMap;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import ca.mcmaster.se2aa4.island.team46.Direction.Compass;

public class Constraints {

    private final Movements drone;
    private final Logger log = LogManager.getLogger();
    private final Map<Compass, Compass> restricted;

    public Constraints(Movements drone) {
        this.drone = drone;
        this.restricted = new EnumMap<>(Compass.class);
        this.restricted.put(Compass.N, Compass.S);
        this.restricted.put(Compass.S, Compass.N);
        this.restricted.put(Compass.E, Compass.W);
        this.restricted.put(Compass.W, Compass.E);
    }

    public boolean isInvalidUTurn(Compass current, Compass newHeading) {
        return restricted.get(current) == newHeading;
    }

    public boolean shouldReturnHome() {
        int currentBattery = drone.getBatteryLevel();
        int initialBattery = drone.getInitialBatteryLevel();
        if (currentBattery < (initialBattery * 0.5)) {
            log.warn("Battery critically low! Returning to base.");
            return true;
        }
        return false;
    }

    public boolean enoughBattery() {
        return drone.getBatteryLevel() >= (drone.getInitialBatteryLevel() * 0.007);
    }
}
