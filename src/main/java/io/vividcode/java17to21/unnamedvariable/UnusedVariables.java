package io.vividcode.java17to21.unnamedvariable;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UnusedVariables {

  public void localVariable() {
    var list = List.of(1, 2, 3);
    var _ = list.removeFirst();
    var _ = list.removeFirst();
    var third = list.removeFirst();
    System.out.println(third);
  }

  public void tryWithResources() {
    try (var _ = SomeContext.create()) {
      System.out.println("Do in the context");
    }
  }

  private int takeSomeAction() {
    return 123;
  }

  public void basicFor() {
    for (int i = 0, _ = takeSomeAction(); i < 10; i++) {
      System.out.println("Hello World");
    }
  }

  public void enhancedFor() {
    var list = List.of(1, 2, 3);
    for (var _ : list) {
      System.out.println("Hello");
    }
  }

  public int catchException(String port) {
    try {
      return Integer.parseInt(port);
    } catch (NumberFormatException _) {
      return 80;
    }
  }

  public void lambdaExpression() {
    var list = List.of("a", "b", "c");
    var map = list.stream()
        .collect(Collectors.toMap(Function.identity(), _ -> 0));
    System.out.println(map);
  }
}
