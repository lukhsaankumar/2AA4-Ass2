package ca.mcmaster.se2aa4.island.team46.Drone;

public class Battery {

    private int charge;
    private int initialCharge;


    public Battery(int initialCharge){
        this.initialCharge = initialCharge;
        this.charge  = initialCharge;
    }


    public int drainBattery(int cost){
        this.charge -= cost;
        return this.charge;
    }


    public int getInitialCharge(){
        return initialCharge;
    }


    public int getCharge(){
        return charge;
    }

    public boolean goHome(int x, int y, int costPerMove) {
        int costToGoHome = (x + y) * costPerMove;
        return charge <= costToGoHome;
    }
}
