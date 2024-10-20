package com.guzov.threads;

import java.util.concurrent.Semaphore;

public class Airport {

    public static Semaphore semaphore = new Semaphore(5, true);
    public static Runaway [] runaways = new Runaway[5];
    public static void main(String[] args) {

        for (int i = 0; i < 5; i++) {
            runaways[i] = new Runaway("Runaway " + i);
        }

        for (int i = 0; i < 10; i++) {
            Thread thread = new Thread(new Plane("Plane " + i));
            thread.start();
        }

    }
}
