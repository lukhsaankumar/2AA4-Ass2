package ca.mcmaster.se2aa4.island.team46;

import org.json.JSONObject;

public class Drone{

    private Compass inDir;
    private Compass direct;
    private Battery battery;
   

    
    public Drone(Integer charge, String dir){
        Compass compass = Compass.NORTH;
        Compass direction  = compass.StringToCompass(dir);
        this.battery = new Battery(charge);
        this.inDir = direction;
        this.direct = direction;
    }

    public DroneState getDroneState(){
        return this.droneState;
    }
}
