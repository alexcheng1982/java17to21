package io.vividcode.java17to21.patternmatching.record;

public class UseTypePattern {

  public void showPoint(Object obj) {
    if (obj instanceof Point point) {
      System.out.printf("Point(%d, %d)%n", point.x(), point.y());
    }
  }

  public static void main(String[] args) {
    new UseTypePattern().showPoint(new Point(10, 20));
  }
}
