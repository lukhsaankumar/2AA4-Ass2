package ca.mcmaster.se2aa4.island.team46;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team46.Interface.Commands;
import ca.mcmaster.se2aa4.island.team46.Interface.Finder;

public class Tracker implements Commands {
    private Deque<JSONObject> commands = new LinkedList<>();
    public Tracker(List<Finder> drones){
        for (Finder drone : drones){
            drone.addObserver(this);
        }
    }

    @Override
    public void addCommand(JSONObject command){
        commands.push(command);
    }

    public JSONObject getLastCommand(){
        return commands.peek();
    }
}
