package ca.mcmaster.se2aa4.island.team46;

import static eu.ace_design.island.runner.Runner.run;
import java.io.File;

public class Runner {

    public static void main(String[] args) {
        String filename = args[0];
        try {
            run(Explorer.class)
                .exploring(new File(filename))
                .withSeed(42L)
                .startingAt(1, 1, "EAST")
                .backBefore(7000)
                .withCrew(5)
                .collecting(1000, "WOOD")
                .storingInto("./outputs")
                .withName("Island")
                .fire();
        } catch(Exception e) {
            System.err.println("Error during rescue mission run: " + e.getMessage());
            e.printStackTrace(System.err);
            System.exit(1);
        }
    }
}
