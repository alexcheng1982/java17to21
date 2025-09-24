package me.vividcode.java17to21.javadoc;

import java.util.concurrent.Callable;

/**
 * A common task executor.
 * <p>
 * {@snippet :
 *  TaskExecutor executor = TaskExecutorFactory.getInstance();
 *  Runnable runnable = () -> System.out.println("Hello");
 *  long taskId = executor.submitTask(runnable); // @highlight substring=submitTask
 *  executor.queryTask(taskId);
 *}
 * {@snippet :
 *  TaskExecutor executor = TaskExecutorFactory.getInstance();
 *  // @replace regex='".*"' replacement="..." :
 *  Runnable runnable = () -> System.out.println("Hello");
 *  long taskId = executor.submitTask(runnable);
 *  executor.queryTask(taskId);
 *}
 * <p>
 * {@snippet file = "TaskExecutorExample.java"}
 * <p>
 * {@snippet file = "TaskExecutorExample.java" region = main}
 * <p>
 * {@snippet :
 *  TaskExecutor executor = TaskExecutorFactory.getInstance();
 *  // @link substring=Runnable target=Runnable :
 *  Runnable runnable = () -> System.out.println("Hello");
 *  long taskId = executor.submitTask(runnable);
 *  executor.queryTask(taskId);
 *}
 */
public interface TaskExecutor {

  long submitTask(Runnable task);

  <V> long submitTask(Callable<V> task);

  <V> TaskExecutionResult<V> queryTask(long taskId);
}
