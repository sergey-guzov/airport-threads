package com.guzov.threads;

public class Runaway {
    private boolean runawayStatus = true;
    private final String runawayName;

    public String getRunawayName() {
        return runawayName;
    }

    public Runaway(String runawayName) {
        this.runawayName = runawayName;
    }

    public void occupyRunway() {
        this.runawayStatus = false;
        System.out.println(this.runawayName +  " is occupied by plane");
    }

    public void clearRunway() {
        this.runawayStatus = true;
        System.out.println(this.runawayName +  " is free now");
    }

    public boolean isRunawayAvailable () {
        return this.runawayStatus;
    }


}
