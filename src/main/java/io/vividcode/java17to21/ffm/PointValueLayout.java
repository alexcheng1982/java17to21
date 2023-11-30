package io.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.JAVA_INT;

import java.lang.foreign.Arena;
import java.util.stream.IntStream;

public class PointValueLayout {

  void points() {
    var num = 100;
    var points = IntStream.range(0, num)
        .mapToObj(i -> new Point(i * 2, i * 2 + 1))
        .toList();
    var segment = Arena.ofAuto()
        .allocate(2 * num * JAVA_INT.byteSize(), JAVA_INT.byteAlignment());
    long i = 0;
    for (Point point : points) {
      segment.setAtIndex(JAVA_INT, 2 * i, point.x());
      segment.setAtIndex(JAVA_INT, 2 * i + 1, point.y());
      i++;
    }
    for (long j = 0; j < num; j++) {
      System.out.println(new Point(
          segment.getAtIndex(JAVA_INT, 2 * j),
          segment.getAtIndex(JAVA_INT, 2 * j + 1)
      ));
    }
  }

  public static void main(String[] args) {
    new PointValueLayout().points();
  }
}
