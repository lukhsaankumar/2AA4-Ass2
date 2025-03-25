package ca.mcmaster.se2aa4.island.team46;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Collections;
import org.json.JSONObject;

import ca.mcmaster.se2aa4.island.team46.Interface.Finder;
import ca.mcmaster.se2aa4.island.team46.Interface.Commands;

public class ActionLogger implements Commands {
    
    private final Deque<JSONObject> commandLog;
    private static final int MAX_LOG_SIZE = 1000;

    public ActionLogger(List<Finder> trackers) {
        this.commandLog = new LinkedList<>();
        initializeTrackers(trackers);
    }

    private void initializeTrackers(List<Finder> trackers) {
        if (trackers == null) {
            throw new IllegalArgumentException("Trackers list cannot be null");
        }
        
        for (Finder tracker : trackers) {
            if (tracker != null) {
                tracker.addObserver(this);
            }
        }
    }

    @Override
    public void addCommand(JSONObject newCommand) {
        if (newCommand == null) {
            throw new IllegalArgumentException("Command cannot be null");
        }

        if (commandLog.size() >= MAX_LOG_SIZE) {
            commandLog.removeLast();
        }
        commandLog.push(newCommand);
    }

    @Override
    public JSONObject fetchLatestCommand() {
        return commandLog.isEmpty() ? null : commandLog.peek();
    }

    public List<JSONObject> retrieveAllCommands() {
        return Collections.unmodifiableList(new LinkedList<>(commandLog));
    }

    public void resetLog() {
        commandLog.clear();
    }
}
