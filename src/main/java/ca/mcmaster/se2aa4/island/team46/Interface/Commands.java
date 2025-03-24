package ca.mcmaster.se2aa4.island.team46.Interface;

import org.json.JSONObject;

public interface Commands {
    
    public JSONObject getLastCommand();

    public void addCommand(JSONObject command);

}
