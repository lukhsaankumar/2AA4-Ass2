package ca.mcmaster.se2aa4.island.team46.Drone;

public class Battery {

    private int charge;
    private int initialCharge;


    public Battery(int initialCharge){
        if (initialCharge >= 0){
            this.initialCharge = initialCharge;
        this.charge  = initialCharge;
        }
        else{
            throw new IllegalArgumentException("Initial Capactiy cannot be negative"); //Handle the exception where the  initial charge cannot be negative
        }
        
    }


    public int drainBattery(int cost){
        if (cost > this.charge){
            throw new IllegalArgumentException("Not enough charge the perform task"); //Handle where the cost of charge needed to action is less than the intial charge
        }
        else{
            this.charge -= cost;
             return this.charge;
        }

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
