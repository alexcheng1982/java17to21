package io.vividcode.java17to21.structuredconcurrency;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.StructuredTaskScope;
import java.util.concurrent.StructuredTaskScope.Subtask.State;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class InvokeAny {

  public static void main(String[] args) throws Exception {
    System.out.println(new InvokeAny().invokeAny());
  }

  public long invokeAny() throws InterruptedException {
    try (var scope = new StructuredTaskScope.ShutdownOnSuccess<>()) {
      var subtasks = subTasks().map(scope::fork).toList();
      scope.join();
      return subtasks.stream().filter(f -> Objects.equals(f.state(), State.SUCCESS))
          .count();
    }
  }

  private Stream<Callable<Integer>> subTasks() {
    return IntStream.range(0, 1000)
        .mapToObj(
            i ->
                () -> {
                  try {
                    Thread.sleep(Duration.ofSeconds(
                        1 + ThreadLocalRandom.current().nextLong(5)));
                  } catch (InterruptedException e) {
                    // ignore
                  }
                  return i;
                });
  }
}
