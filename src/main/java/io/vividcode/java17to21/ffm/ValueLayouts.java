package io.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.JAVA_INT;

import java.lang.foreign.Arena;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class ValueLayouts {

  private final Random random = ThreadLocalRandom.current();

  void intLayout() {
    var num = 100;
    var segment = Arena.ofAuto()
        .allocate(num * JAVA_INT.byteSize(), JAVA_INT.byteAlignment());
    for (int i = 0; i < num; i++) {
      segment.setAtIndex(JAVA_INT, i, random.nextInt());
    }
    for (int i = 0; i < num; i++) {
      System.out.println(segment.getAtIndex(JAVA_INT, i));
    }
  }

  public static void main(String[] args) {
    new ValueLayouts().intLayout();
  }
}
