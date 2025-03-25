package ca.mcmaster.se2aa4.island.team46.Drone;

import java.util.EnumMap;
import java.util.Map;
import ca.mcmaster.se2aa4.island.team46.Direction.Compass;

public class Navigator {

    private final Map<Compass, Compass> rightTurnMap;
    private final Map<Compass, Compass> leftTurnMap;
    private final Map<Compass, int[]> movementMap;

    public Navigator() {
        this.rightTurnMap = new EnumMap<>(Compass.class);
        this.rightTurnMap.put(Compass.N, Compass.E);
        this.rightTurnMap.put(Compass.E, Compass.S);
        this.rightTurnMap.put(Compass.S, Compass.W);
        this.rightTurnMap.put(Compass.W, Compass.N);

        this.leftTurnMap = new EnumMap<>(Compass.class);
        this.leftTurnMap.put(Compass.N, Compass.W);
        this.leftTurnMap.put(Compass.W, Compass.S);
        this.leftTurnMap.put(Compass.S, Compass.E);
        this.leftTurnMap.put(Compass.E, Compass.N);

        this.movementMap = new EnumMap<>(Compass.class);
        this.movementMap.put(Compass.N, new int[]{0, 1});
        this.movementMap.put(Compass.S, new int[]{0, -1});
        this.movementMap.put(Compass.E, new int[]{1, 0});
        this.movementMap.put(Compass.W, new int[]{-1, 0});
    }

    public Compass getRight(Compass currentDirection) {
        return rightTurnMap.get(currentDirection);
    }

    public Compass getLeft(Compass currentDirection) {
        return leftTurnMap.get(currentDirection);
    }

    public int[] getForwardMovement(Compass currentDirection) {
        return movementMap.get(currentDirection);
    }
}
