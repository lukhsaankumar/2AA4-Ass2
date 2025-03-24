package ca.mcmaster.se2aa4.island.team46;

import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eu.ace_design.island.bot.IExplorerRaid;
import org.json.JSONObject;
import org.json.JSONTokener;

import ca.mcmaster.se2aa4.island.team46.Enums.Direction.Compass;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    private int moves = 0; // Counter for number of forward moves made
    private DroneCommands droneCommands = new DroneCommands();
    private DetectLand detectLand = new DetectLand();
    


    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n{}", info.toString(2));
        String direction = info.getString("heading");
        int batteryLevel = info.getInt("budget");
        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);
    }

    @Override
    public String takeDecision() {
        JSONObject decision = new JSONObject();
        if (!isOverGround()) {
            // Continue flying if a ground cell hasn't been reached yet.
            moves++;
            decision = droneCommands.fly();
            decision.put("steps", 1); // Move one step forward
            logger.info("Flying... (move {})", moves);
            
            // Debugging: Ensure decision JSON is properly formatted
            logger.debug("Decision JSON: {}", decision.toString());
    
        } else {
            // Once over a ground cell, stop to return to base.
            decision = droneCommands.stop();
            logger.info("Ground detected. Stopping mission.");
        }
        return decision.toString();
    }
    @Override
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Response received:\n{}", response.toString(2));
    }

    @Override 
    public String deliverFinalReport() {
        return "Rescue Mission MVP! : Drone navigated until ground detected and safely returned to base.";
    }

    private boolean isOverGround() {
       JSONObject decision = new JSONObject();
       decision = droneCommands.echo(Compass.N);
       if (detectLand.locatedGround(decision)){
         return true;
       }
       else{
        return false;
       }

    }

}
