package com.guzov.threads;

import java.util.concurrent.TimeUnit;

public class Plane implements Runnable{

    private String name;

    public Plane(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println("Plane " + name + " is ready to departure");
        Runaway occupiedRunway = null;
        try {
            Airport.semaphore.acquire();
            synchronized (Airport.runaways) {
                for (int i = 0; i < Airport.runaways.length; i++) {
                    if (Airport.runaways[i].isRunawayAvailable()) {
                        occupiedRunway = Airport.runaways[i];
                        break;
                    }
                }
                occupiedRunway.occupyRunway();
                System.out.println(name + " started going to the " + occupiedRunway.getRunawayName());
            }

            TimeUnit.SECONDS.sleep(3);
            System.out.println(name + " flew away ");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            occupiedRunway.clearRunway();
            Airport.semaphore.release();
        }
    }
}
