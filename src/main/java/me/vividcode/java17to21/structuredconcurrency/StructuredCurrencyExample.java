package me.vividcode.java17to21.structuredconcurrency;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.StructuredTaskScope;

public class StructuredCurrencyExample {

  public static void main(String[] args) throws Exception {
    System.out.println("Result is " + new StructuredCurrencyExample().calculate());
  }

  public int calculate() throws InterruptedException, ExecutionException {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      var v1 = scope.fork(this::op1);
      int v2 = calculateInner();
      scope.join();
      scope.throwIfFailed();
      return v1.get() * v2;
    }
  }

  private int calculateInner() throws InterruptedException, ExecutionException {
    try (var scope = new StructuredTaskScope.ShutdownOnFailure()) {
      var v21 = scope.fork(this::op21);
      var v22 = scope.fork(this::op22);
      scope.join();
      scope.throwIfFailed();
      return v21.get() + v22.get();
    }
  }

  private int op1() {
    System.out.println("Operation 1 starts");
    try {
      Thread.sleep(Duration.ofSeconds(3));
    } catch (InterruptedException e) {
      // ignored
    }
    System.out.println("Operation 1 finishes");
    return 2;
  }

  private int op21() {
    System.out.println("Operation 2.1 starts");
    try {
      Thread.sleep(Duration.ofSeconds(4));
    } catch (InterruptedException e) {
      // ignored
    }
    System.out.println("Operation 2.1 finishes");
    return 3;
  }

  private int op22() {
    System.out.println("Operation 2.2 starts");
    try {
      Thread.sleep(Duration.ofSeconds(2));
    } catch (InterruptedException e) {
      // ignored
    }
    System.out.println("Operation 2.2 finishes");
    return 3;
  }
}
