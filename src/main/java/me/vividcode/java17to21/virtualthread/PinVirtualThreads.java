package me.vividcode.java17to21.virtualthread;

import java.time.Duration;
import java.util.concurrent.Executors;

public class PinVirtualThreads {

  private static final Object lock = new Object();

  public void willPin() {
    try (var executor = Executors.newVirtualThreadPerTaskExecutor()) {
      executor.submit(this::pin);
    }
  }

  private void pin() {
    synchronized (lock) {
      try {
        Thread.sleep(Duration.ofSeconds(1));
      } catch (InterruptedException e) {
        // ignore
      }
    }
  }
}
