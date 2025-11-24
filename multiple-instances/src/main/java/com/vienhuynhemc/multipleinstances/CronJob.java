/* vienhuynhemc */
package com.vienhuynhemc.multipleinstances;

import jakarta.annotation.Nonnull;
import java.util.concurrent.TimeUnit;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class CronJob {

  @Scheduled(fixedRate = 1, timeUnit = TimeUnit.SECONDS)
  public void cronJob() {
    executeJob("Job 1");
  }

  @Scheduled(fixedRate = 1, timeUnit = TimeUnit.SECONDS)
  public void cronJob2() {
    executeJob("Job 2");
  }

  public void executeJob(@Nonnull String jobName) {
    final String threadName = Thread.currentThread().getName();
    log.info("Job starting... in [{}-{}]", jobName, threadName);
    try {
      Thread.sleep(5000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    log.info("Job completed... in [{}-{}]", jobName, threadName);
  }
}
