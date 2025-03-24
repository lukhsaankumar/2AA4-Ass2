package ca.mcmaster.se2aa4.island.team46.Interface;

import ca.mcmaster.se2aa4.island.team46.Enums.Direction;


public interface Move {

    public void moveForward();

    public void turnLeft();

    public void turnRight();

    public void stop();

    public Direction.Compass getDirection();
}

