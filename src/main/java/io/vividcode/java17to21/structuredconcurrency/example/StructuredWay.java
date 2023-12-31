package io.vividcode.java17to21.structuredconcurrency.example;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class StructuredWay {

  int takeAction(String input) throws InterruptedException, ExecutionException {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      var v1 = scope.fork(() -> callOp1(input));
      var v2 = scope.fork(() -> callOp2(input));
      scope.join();
      scope.throwIfFailed();
      return combine(v1.get(), v2.get());
    }
  }

  int combine(int result1, int result2)
      throws InterruptedException, ExecutionException {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      var r = scope.fork(() -> callOp3(result1, result2));
      scope.join();
      scope.throwIfFailed();
      return r.get();
    }
  }

  private int callOp3(int result1, int result2) {
    return result1 * result2;
  }

  private int callOp2(String input) {
    return 1;
  }

  private int callOp1(String input) {
    return 2;
  }

  public static void main(String[] args)
      throws ExecutionException, InterruptedException {
    System.out.println(new StructuredWay().takeAction("hello"));
  }
}
