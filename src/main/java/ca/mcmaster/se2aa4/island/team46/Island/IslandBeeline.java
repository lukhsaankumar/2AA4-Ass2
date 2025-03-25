package ca.mcmaster.se2aa4.island.team46.Island;

import org.json.JSONObject;
import ca.mcmaster.se2aa4.island.team46.Drone.Sensor;
import ca.mcmaster.se2aa4.island.team46.Interface.Moves;

public class IslandBeeline extends State {

    private int remainingDistance;

    public IslandBeeline(Moves drone, Sensor sensor, int distance) {
        super(drone, sensor);
        this.remainingDistance = distance;
    }

    @Override
    public State getNextState(JSONObject response) {
        if (remainingDistance > 0) {
            drone.moveForward();
            remainingDistance--;
            return this;
        }
        drone.stop();
        return this;
    }
}
