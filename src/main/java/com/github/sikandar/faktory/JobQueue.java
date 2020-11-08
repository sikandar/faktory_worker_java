package com.github.sikandar.faktory;

/**
 * Faktory Job Queue
 * @author Sikandar Ali Awan
 */
public class JobQueue {
    String name;

    private JobQueue(String name) {
        this.name = name;
    }

    public static JobQueue of(String name) {
        return new JobQueue(name);
    }
}
