package io.vividcode.java17to21.virtualthread;

import jdk.internal.vm.Continuation;
import jdk.internal.vm.ContinuationScope;

public class SimpleContinuation {

  private static final ContinuationScope scope = new ContinuationScope("Test");

  private static class SimpleTask implements Runnable {

    @Override
    public void run() {
      System.out.println("Before");
      Continuation.yield(scope);
      System.out.println("After");
    }
  }

  public static void main(String[] args) {
    Continuation continuation = new Continuation(scope, new SimpleTask());
    continuation.run(); // Before
    System.out.println(continuation.isDone()); // false
    continuation.run(); // After
    System.out.println(continuation.isDone()); // true
  }
}
