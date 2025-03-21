package ca.mcmaster.se2aa4.island.teamXXX;

import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eu.ace_design.island.bot.IExplorerRaid;
import org.json.JSONObject;
import org.json.JSONTokener;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();

    @Override
    public void initialize(String s) {
        // Parse the initialization JSON input (e.g., {"budget":10000, "heading":"W"})
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        String direction = info.getString("heading");
        int batteryLevel = info.getInt("budget");
        logger.info("Initializing Explorer with heading {} and battery level {}", direction, batteryLevel);
    }

    @Override
    public String takeDecision() {
        // Walking skeleton: immediately stop exploration.
        JSONObject decision = new JSONObject();
        decision.put("action", "stop");
        logger.info("Decision taken: {}", decision.toString());
        return decision.toString();
    }

    @Override
    public void acknowledgeResults(String s) {
        // Log the response (minimal handling).
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("Response received: {}", response.toString(2));
    }

    @Override
    public String deliverFinalReport() {
        // Minimal final report.
        return "Rescue mission walking skeleton complete: Drone initialized and stopped.";
    }
}
