# FaktoryWorker for Java
(Continue improvements, but curenlty it is production ready)
- Java 1.8+
- Gradle 6.4.1

This library will handle the communication between JVM languages to [Faktory](http://contribsys.com/faktory/).

It will allows you to push and consume Faktory jobs to process based on Queue and JobType

## Examples Client Code:

### Java

#### Pushing a Job

```java
  FaktoryClient client = new FaktoryClient();
  FaktoryJob job = new FaktoryJob(JobType.of("job-type"), JobQueue.of("myQueue"), "{json}");
  client.push(job);
```

##### Support Contact
* Email:  'mysialkot@gmail.com'
* LinkedIn: sikandar-ali
