package ca.mcmaster.se2aa4.island.team46.Island;

import org.json.JSONObject;
import ca.mcmaster.se2aa4.island.team46.Drone.Sensor;
import ca.mcmaster.se2aa4.island.team46.Interface.Moves;

public class IslandSearch extends State {

    public IslandSearch(Moves drone, Sensor sensor) {
        super(drone, sensor);
    }

    @Override
    public State getNextState(JSONObject response) {
        if (response.has("extras") && response.getJSONObject("extras").has("found")) {
            String foundType = response.getJSONObject("extras").getString("found");
            if (foundType.equals("GROUND")) {
                drone.stop();
                return this;
            }
        }
        return this;
    }
}
