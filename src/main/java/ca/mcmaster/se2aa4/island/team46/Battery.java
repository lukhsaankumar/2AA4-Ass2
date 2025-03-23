package ca.mcmaster.se2aa4.island.team46;

public class Battery {
    private int charge;

    public Battery(int charge) {
        this.charge = charge;
    }

    public void drainCharge(int drainval) {
        charge -= drainval;
    }

    public int getCharge() {
        return charge;
    }


}