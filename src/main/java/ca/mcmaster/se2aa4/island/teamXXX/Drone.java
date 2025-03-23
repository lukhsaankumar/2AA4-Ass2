package ca.mcmaster.se2aa4.island.teamXXX;

import org.json.JSONObject;

public class Drone{

    private Compass inDir;
    private Compass direct;
    
    public Drone(Integer charge, String dir){
        Compass compass = Compass.NORTH;
        Compass direction  = compass.StringToCompass(dir);
        this.inDir = direction;
        this.direct = direction;
    }
}
