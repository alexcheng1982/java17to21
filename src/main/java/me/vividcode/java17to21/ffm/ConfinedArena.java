package me.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.JAVA_INT;

import java.lang.foreign.Arena;

public class ConfinedArena {

  void confined() {
    try (var arena = Arena.ofConfined()) {
      var segment = arena.allocate(32 * JAVA_INT.byteSize(), JAVA_INT.byteAlignment());
      new Thread(() -> {
        segment.setAtIndex(JAVA_INT, 0, 1);
      }).start();
    }
  }

  public static void main(String[] args) {
    new ConfinedArena().confined();
  }
}
