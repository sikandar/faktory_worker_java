package com.github.sikandar.faktory;

import java.util.Objects;
import java.util.UUID;

/**
 * FaktoryJob
 *
 * @author Sikandar Ali Awan
 */
public class FaktoryJob {

    private final String jid = UUID.randomUUID().toString();
    private final String jobType;
    private final Object[] args;
    private final String queue;

    public FaktoryJob(Object payload) {
        this(null, null, payload);
    }

    public FaktoryJob(JobType jobType, Object payload) {
        this(jobType, null, payload);
    }

    public FaktoryJob(JobQueue queue, Object payload) {
        this(null, queue, payload);
    }

    public FaktoryJob(JobType jobType, JobQueue queue, Object payload) {
        this(jobType, queue, new Object[]{payload});
    }

    public FaktoryJob(JobType jobType, JobQueue queue, Object[] args) {
        this.jobType = jobType == null ? "default" : jobType.name;
        this.queue = queue == null ? "default" : queue.name;
        this.args = args;
    }

    public String getJid() {
        return jid;
    }

    public String getJobType() {
        return this.jobType;
    }

    public Object[] getArgs() {
        return args;
    }

    public String getQueue() {
        return queue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FaktoryJob that = (FaktoryJob) o;
        return Objects.equals(jid, that.jid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(jid);
    }
}