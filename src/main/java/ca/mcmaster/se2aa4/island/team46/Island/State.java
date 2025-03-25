package ca.mcmaster.se2aa4.island.team46.Island;

import org.json.JSONObject;
import ca.mcmaster.se2aa4.island.team46.Drone.Sensor;
import ca.mcmaster.se2aa4.island.team46.Interface.Moves;

public abstract class State {
    protected final Moves drone;
    protected final Sensor sensor;

    public State(Moves drone, Sensor sensor) {
        this.drone = drone;
        this.sensor = sensor;
    }

    public abstract State getNextState(JSONObject command);
}
