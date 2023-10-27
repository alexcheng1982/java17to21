package io.vividcode.java17to21.patternmatching.unnamed;

import io.vividcode.java17to21.patternmatching.record.Point;

public class UnnamedPattern {

  public void match(Object input) {
    if (input instanceof Point(int x, _)) {
      System.out.println("X: " + x);
    }
  }

  public void match2(Object input) {
    if (input instanceof Point(int x, int _)) {
      System.out.println("X: " + x);
    }
  }
}
