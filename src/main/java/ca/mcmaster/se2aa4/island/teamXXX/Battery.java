package ca.mcmaster.se2aa4.island.teamXXX;

public class Battery {
    private int charge;

    public Battery(int charge) {
        this.charge = charge;
    }

    public void depleteCharge(int cost) {
        charge -= cost;
    }

    public int getCharge() {
        return charge;
    }
}