package io.vividcode.java17to21.patternmatching.record;

public class UseRecordPattern {

  public void showPoint(Object obj) {
    if (obj instanceof Point(int x, int y)) {
      System.out.printf("Point(%d, %d)%n", x, y);
    }
  }

  public static void main(String[] args) {
    new UseRecordPattern().showPoint(new Point(10, 20));
  }
}
