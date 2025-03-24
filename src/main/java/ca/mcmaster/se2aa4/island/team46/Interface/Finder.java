package ca.mcmaster.se2aa4.island.team46.Interface;

import org.json.JSONObject;

public abstract class Finder {

    private Commands observer;


        protected void update(JSONObject decision) {
            if (observer != null) {
                observer.addCommand(decision);
            }
        }

        public void addObserver(Commands observer) {
            this.observer = observer;
        }

}
