import me.vividcode.java17to21.javadoc.TaskExecutorFactory;

public class TaskExecutorExample {

  void execute() {
    // @start region=main
    var executor = TaskExecutorFactory.getInstance();
    Runnable runnable = () -> System.out.println("Hello");
    var taskId = executor.submitTask(runnable);
    var result = executor.queryTask(taskId);
    System.out.println(result.status());
    // @end
  }
}