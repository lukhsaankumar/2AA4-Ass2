package ca.mcmaster.se2aa4.island.team46;

import java.io.StringReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import eu.ace_design.island.bot.IExplorerRaid;
import org.json.JSONObject;
import org.json.JSONTokener;

import ca.mcmaster.se2aa4.island.team46.Drone.DroneCommands;

public class Explorer implements IExplorerRaid {

    private final Logger logger = LogManager.getLogger();
    private DroneCommands droneCommands = new DroneCommands();
    private Controller controller;

    @Override
    public void initialize(String s) {
        logger.info("** Initializing the Exploration Command Center");
        JSONObject info = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Initialization info:\n{}", info.toString(2));
        
        String direction = info.getString("heading");
        int batteryLevel = info.getInt("budget");

        try {
            controller = new Controller(batteryLevel, direction);
            logger.info("Controller initialized successfully.");
        } catch (Exception e) {
            logger.error("Error initializing controller", e);
        }

        logger.info("The drone is facing {}", direction);
        logger.info("Battery level is {}", batteryLevel);
    }

    @Override
    public String takeDecision() {
        logger.info("** Taking decision");
        if (controller == null) {
            logger.error("Controller is not initialized! Stopping drone.");
            return droneCommands.stop().toString();
        }
        JSONObject command = controller.takeDecision(); 
        logger.info("** Action done: {}", command.toString());
        return command.toString();
    }

    @Override
    public void acknowledgeResults(String s) {
        JSONObject response = new JSONObject(new JSONTokener(new StringReader(s)));
        logger.info("** Response received:\n{}", response.toString(2));
        
        if (controller != null) {
            controller.updateDrone(response); 
        }
    }

    @Override 
    public String deliverFinalReport() {
        return "Rescue Mission MVP! : Drone navigated until ground detected and safely returned to base.";
    }
}
