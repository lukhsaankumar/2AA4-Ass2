package ca.mcmaster.se2aa4.island.team46.Drone;

import org.json.JSONObject;
import ca.mcmaster.se2aa4.island.team46.Direction;

public class DroneCommands {

    public JSONObject heading(Direction.Compass direction) {
        JSONObject cmd = new JSONObject();
        JSONObject param = new JSONObject();
        cmd.put("action", "heading");
        param.put("direction", direction);
        cmd.put("parameters", param);
        return cmd;
    }

    public JSONObject fly() {
        JSONObject cmd = new JSONObject();
        cmd.put("action", "fly");
        return cmd;
    }

    public JSONObject stop() {
        JSONObject cmd = new JSONObject();
        cmd.put("action", "stop");
        return cmd;
    }

    public JSONObject echo(Direction.Compass direction) {
        JSONObject cmd = new JSONObject();
        JSONObject param = new JSONObject();
        cmd.put("action", "echo");
        param.put("direction", direction);
        cmd.put("parameters", param);
        return cmd;
    }

    public JSONObject scan() {
        JSONObject cmd = new JSONObject();
        cmd.put("action", "scan");
        return cmd;
    }
}
