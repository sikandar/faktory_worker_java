package com.github.sikandar.faktory;

/**
 * Faktory JobType
 * @author Sikandar Ali Awan
 */
public class JobType {
    String name;

    private JobType(String name) {
        this.name = name;
    }

    public static JobType of(String name) {
        return new JobType(name);
    }
}
