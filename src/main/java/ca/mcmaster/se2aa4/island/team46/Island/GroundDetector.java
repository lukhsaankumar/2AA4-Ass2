package ca.mcmaster.se2aa4.island.team46.Island;

import org.json.JSONObject;

public class GroundDetector {

    public boolean isGroundFound(JSONObject response) {
        if (response == null || !response.has("extras")) {
            return false;
        }
        JSONObject extras = response.getJSONObject("extras");
        if (extras.has("found")) {
            String terrain = extras.getString("found");
            return "GROUND".equals(terrain);
        }
        return false;
    }

    public int getDetectionRange(JSONObject response) {
        int range = 0;
        if (response != null && response.has("extras")) {
            JSONObject extras = response.getJSONObject("extras");
            if (extras.has("range")) {
                range = extras.getInt("range");
            }
        }
        return range;
    }
}
