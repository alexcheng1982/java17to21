package me.vividcode.java17to21.javadoc;

import java.util.concurrent.Callable;

public class TaskExecutorFactory {

  private static final DefaultTaskExecutor INSTANCE = new DefaultTaskExecutor();

  public static TaskExecutor getInstance() {
    return INSTANCE;
  }

  private static class DefaultTaskExecutor implements TaskExecutor {

    @Override
    public long submitTask(Runnable task) {
      return 0;
    }

    @Override
    public <V> long submitTask(Callable<V> task) {
      return 0;
    }

    @Override
    public <V> TaskExecutionResult<V> queryTask(long taskId) {
      return null;
    }
  }
}
