package ca.mcmaster.se2aa4.island.team46;

import ca.mcmaster.se2aa4.island.team46.Interface.Commands;

public class Drone {
    private Battery battery;
    private int cost;

    private DroneCommands droneCommands = new DroneCommands();

    public Drone(Integer charge, String startPosition){
        this.battery = new Battery(charge);

        
    }
    
}
