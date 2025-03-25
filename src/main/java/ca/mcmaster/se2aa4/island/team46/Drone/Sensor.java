package ca.mcmaster.se2aa4.island.team46.Drone;

import ca.mcmaster.se2aa4.island.team46.Direction;
import ca.mcmaster.se2aa4.island.team46.Interface.Finder;

public class Sensor extends Finder {
    private Navigator navigator = new Navigator();
    private DroneCommands droneCommands = new DroneCommands();
    private Direction.Compass direction;

    public Sensor(Direction.Compass direction) {
        this.direction = direction;
    }

    public void echoForward(){
        update(droneCommands.echo(this.direction));
    }

    public void echoRight(){
        update(droneCommands.echo(navigator.getRight(this.direction)));
    }

    public void echoLeft(){
        update(droneCommands.echo(navigator.getLeft(this.direction)));
    }

    public void setHeading(Direction.Compass direction){
        this.direction = direction;
    }

    public void scan(){
        update(droneCommands.scan());
    }
}
