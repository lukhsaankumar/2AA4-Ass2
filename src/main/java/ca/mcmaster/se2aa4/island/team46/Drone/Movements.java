package ca.mcmaster.se2aa4.island.team46.Drone;

import ca.mcmaster.se2aa4.island.team46.Interface.Moves;
import ca.mcmaster.se2aa4.island.team46.Direction;
import ca.mcmaster.se2aa4.island.team46.Direction.Compass;
import ca.mcmaster.se2aa4.island.team46.Interface.Finder;

public class Movements extends Finder implements Moves {

    private Navigator navigator = new Navigator();
    private Battery battery;
    private Direction.Compass direction;
    private int x;
    private int y;
    private DroneCommands commands = new DroneCommands();

    public Movements(Integer chargeAmount, String startPosition) {
        this.battery = new Battery(chargeAmount);
        x = 0; 
        y = 0;
        try {
            this.direction = Compass.valueOf(startPosition);
        } catch (Exception e) {
            e.printStackTrace(System.err);
        }
    }

    private void move() {
        int[] movement = navigator.getForwardMovement(this.direction);
        this.x += movement[0];
        this.y += movement[1];
    }

    @Override
    public void moveForward() {
        move();
        update(commands.fly());
    }

    @Override
    public void turnRight() {
        move();
        this.direction = navigator.getRight(this.direction);
        move();
        update(commands.heading(this.direction));
    }

    @Override
    public void turnLeft() {
        move();
        this.direction = navigator.getLeft(this.direction);
        move();
        update(commands.heading(this.direction));
    }

    @Override
    public void stop() {
        update(commands.stop());
    }

    @Override
    public int getBatteryLevel() {
        return battery.getCharge();
    }

    @Override
    public void useBattery(int batteryLevel) {
        battery.drainBattery(batteryLevel);
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }

    @Override
    public Compass getDirection() {
        return direction;
    }

    @Override
    public int getInitialBatteryLevel() {
        return battery.getInitialCharge();
    }
}
