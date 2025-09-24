package me.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;
import static java.lang.foreign.ValueLayout.JAVA_FLOAT;
import static java.lang.foreign.ValueLayout.JAVA_INT;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;

public class GroupLayouts {

  void struct() {
    var rectLayout = MemoryLayout.structLayout(
        JAVA_INT.withName("topLeftX"),
        JAVA_INT.withName("topLeftY"),
        JAVA_INT.withName("weight"),
        JAVA_INT.withName("height")
    );
    var segment = Arena.ofAuto().allocateArray(rectLayout, 100);
    System.out.println(segment.byteSize()); // 1600 = 4 * 4 * 100
  }

  void union() {
    var valueLayout = MemoryLayout.unionLayout(
        JAVA_INT.withName("int"),
        JAVA_LONG.withName("long"),
        JAVA_FLOAT.withName("float"),
        JAVA_DOUBLE.withName("double")
    );
    var segment = Arena.ofAuto().allocateArray(valueLayout, 100);
    System.out.println(segment.byteSize()); // 800 = 8 * 100
    segment.set(JAVA_INT, 0, Integer.MIN_VALUE);
    segment.set(JAVA_LONG, 0, Long.MAX_VALUE);
    System.out.println(segment.get(JAVA_INT, 0));
    System.out.println(segment.get(JAVA_LONG, 0));
  }

  public static void main(String[] args) {
    new GroupLayouts().struct();
    new GroupLayouts().union();
  }
}
