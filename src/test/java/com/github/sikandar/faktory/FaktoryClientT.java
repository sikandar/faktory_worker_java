package com.github.sikandar.faktory;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.EnvironmentVariables;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class FaktoryClientT {
    private FaktoryClient client = new FaktoryClient();

    @Rule
    public EnvironmentVariables environmentVariables = new EnvironmentVariables();

    @Test
    public void initializeClientWithoutUriAndWithoutEnvVars() {
        Assert.assertEquals("tcp://localhost:7419", client.url);
    }

    @Test
    public void initializeClientWithoutUriButWithEnvVars() {
        environmentVariables.set("FAKTORY_URL", "tcp://192.168.0.2:7419");
        FaktoryClient anotherClient = new FaktoryClient();

        Assert.assertEquals("tcp://192.168.0.2:7419", anotherClient.url);
    }

    @Test
    public void initializeClientWithACustomUri() {
        FaktoryClient client = new FaktoryClient("tcp://192.168.0.1:7419");
        Assert.assertEquals("tcp://192.168.0.1:7419", client.url);
    }


    @Test(expected = FaktoryException.class)
    public void pushFaktoryJobWithoutConnection() throws Exception {
        FaktoryConnection connection=new FaktoryConnection("tcp://localhost:7419");
        connection.send("some-message");
    }

    @Test
    public void pushFaktoryJob() throws Exception {
        FaktoryClient client = new FaktoryClient();
        FaktoryJob job = new FaktoryJob(JobType.of("job"), JobQueue.of("myQueue"), "{json}");
        client.push(job);
    }
}