package ca.mcmaster.se2aa4.island.team46.Interface;

import ca.mcmaster.se2aa4.island.team46.Direction;


public interface Moves {

    public void moveForward();

    public void turnRight();

    public void turnLeft();

    public void stop();

    public int getInitialBatteryLevel();

    public int getBatteryLevel();

    public void useBattery(int batteryLevel);

    public int getX();

    public int getY();

    public Direction.Compass getDirection();
}

