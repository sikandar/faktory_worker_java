package com.github.sikandar.faktory;

import com.google.gson.Gson;

import java.io.IOException;

/**
 * This class is the public client to integrate with Faktory.
 * It can send a job to Faktory.
 *
 * property uri the URI from the Faktory Server. If empty it will use the FAKTORY_URL environment variable and if it
 * is also empty, it will use the localhost.
 *
 * @author Sikandar Ali Awan
 */

public class FaktoryClient {

    private final FaktoryConnection connection;
    public static String url = "tcp://localhost:7419";

    public FaktoryClient(final String urlParam) {
        url = urlParam == null ? url : urlParam;
        connection = new FaktoryConnection(url);
    }

    public FaktoryClient() {
        this(System.getenv("FAKTORY_URL"));
    }


    public void push(final FaktoryJob job) throws IOException {
        final String payload = new Gson().toJson(job);
        connection.connect();
        connection.send("PUSH " + payload);
        connection.close();
    }


}