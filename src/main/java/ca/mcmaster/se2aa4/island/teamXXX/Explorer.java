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
        // Parse initialization JSON (e.g., {"budget":10000, "heading":"E"})
        logger.info("Initializing Rescue Mission Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        String direction = info.getString("heading");
        int batteryLevel = info.getInt("budget");
        logger.info("Drone initialized: Heading = {}, Battery Level = {}", direction, batteryLevel);
    }

    @Override
    public String takeDecision() {
        // Minimal working decision: stop the mission immediately.
        JSONObject decision = new JSONObject();
        decision.put("action", "stop");
        logger.info("Decision taken: {}", decision.toString());
        return decision.toString();
    }

    @Override
    public void acknowledgeResults(String s) {
        // Log any results received from the drone.
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("Acknowledging results:\n{}", response.toString(2));
    }

    @Override
    public String deliverFinalReport() {
        // Return a minimal final report.
        return "Rescue Mission Walking Skeleton: No creek found.";
    }
}
