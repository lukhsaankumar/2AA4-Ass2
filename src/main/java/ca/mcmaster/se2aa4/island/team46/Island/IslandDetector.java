package ca.mcmaster.se2aa4.island.team46.Island;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team46.Drone.Sensor;
import ca.mcmaster.se2aa4.island.team46.Interface.Moves;

public class IslandDetector extends State {

    private final GroundDetector landDetector = new GroundDetector();
    private boolean turnRight;
    private boolean turnLeft;
    private boolean echo;

    public IslandDetector(Moves drone, Sensor sensor) {
        super(drone, sensor);
        this.turnRight = true;
        this.turnLeft = false;
        this.echo = false;
    }

    @Override
    public State getNextState(JSONObject command) {
        if (landDetector.isGroundFound(command)) {
            int distance = landDetector.getDetectionRange(command);
            return new IslandBeeline(drone, sensor, distance); 
        }

        if (echo) {
            sensor.echoForward();
            echo = false;
        } else if (turnRight) {
            drone.turnRight();  
            turnRight = false;
            turnLeft = true;
            echo = true;
        } else if (turnLeft) {
            drone.turnLeft();  
            turnLeft = false;
            turnRight = true;
            echo = true;
        } return this;
    }
}
