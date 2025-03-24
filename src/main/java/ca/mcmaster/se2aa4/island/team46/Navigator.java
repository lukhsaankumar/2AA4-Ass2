package ca.mcmaster.se2aa4.island.team46;

import java.util.EnumMap;
import java.util.Map;
import ca.mcmaster.se2aa4.island.team46.Enums.Direction.Compass;


public class Navigator {

    private final Map<Compass, Compass> rightTurns;
    private final Map<Compass, Compass> leftTurns;
    private final Map<Compass, int[]> movements;

    public Navigator() {
    
        this.rightTurns = new EnumMap<>(Compass.class);
        this.rightTurns.put(Compass.N, Compass.E);
        this.rightTurns.put(Compass.E, Compass.S);
        this.rightTurns.put(Compass.S, Compass.W);
        this.rightTurns.put(Compass.W, Compass.N);

        this.leftTurns = new EnumMap<>(Compass.class);
        this.leftTurns.put(Compass.N, Compass.W);
        this.leftTurns.put(Compass.W, Compass.S);
        this.leftTurns.put(Compass.S, Compass.E);
        this.leftTurns.put(Compass.E, Compass.N);

        this.movements = new EnumMap<>(Compass.class);
        this.movements.put(Compass.N, new int[]{0, 1});  
        this.movements.put(Compass.S, new int[]{0, -1}); 
        this.movements.put(Compass.E, new int[]{1, 0});  
        this.movements.put(Compass.W, new int[]{-1, 0}); 
    }

    public Compass getRight(Compass currDirection) {
        return rightTurns.get(currDirection);
    }

    public Compass getLeft(Compass currDirection){
        return leftTurns.get(currDirection);
    }

    public int[] getForwardMovement(Compass currDirection) {
        return movements.get(currDirection);
    }
}
