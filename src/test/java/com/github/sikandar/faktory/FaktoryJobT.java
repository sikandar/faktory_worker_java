package com.github.sikandar.faktory;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.Map;
import java.util.Objects;

@RunWith(JUnit4.class)
public class FaktoryJobT {

    @Test
    public void initializesARandomJID() {
        FaktoryJob job1 = new FaktoryJob(JobType.of("JBT"), "2");
        FaktoryJob job2 = new FaktoryJob(JobType.of("JBT"), "2");
        Assert.assertFalse(job1.getJid().isBlank());

        Assert.assertFalse(Objects.equals(job1, job2));
        Assert.assertFalse(Objects.equals(job1.hashCode(), job2.hashCode()));
    }

    @Test
    public void initializesWithJobQueue() {
        FaktoryJob job = new FaktoryJob(JobQueue.of("queue"), "2");
        Assert.assertEquals(job.getJobType(), "default");
        Assert.assertEquals(job.getQueue(), "queue");
    }

    @Test
    public void initializesWithJobTypeAndJobQueue() {
        FaktoryJob job = new FaktoryJob(JobType.of("JBT"), JobQueue.of("queue"), "2");
        Assert.assertEquals(job.getJobType(), "JBT");
        Assert.assertEquals(job.getQueue(), "queue");
    }

    @Test
    public void useDefaultQueueAndJobType() {
        FaktoryJob job = new FaktoryJob(new Gson().toJson(Map.of("name", "ali")));
        Assert.assertEquals(job.getJobType(), "default");
        Assert.assertEquals(job.getQueue(), "default");
        Assert.assertEquals(job.getArgs()[0], "{\"name\":\"ali\"}");

    }
}