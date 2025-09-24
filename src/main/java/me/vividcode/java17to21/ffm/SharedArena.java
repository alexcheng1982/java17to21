package me.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.JAVA_INT;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class SharedArena {

  void shared() {
    try (var arena = Arena.ofShared()) {
      var segment = arena.allocate(16 * JAVA_INT.byteSize(), JAVA_INT.byteAlignment());
      var batch = MemoryLayout.sequenceLayout(4, JAVA_INT);
      var counter = new AtomicInteger(0);
      segment.elements(batch)
          .parallel()
          .forEach((section) -> {
            System.out.println(STR. "In thread \{ Thread.currentThread().getName() }" );
            var value = counter.getAndIncrement();
            section.elements(JAVA_INT)
                .forEach(element -> element.setAtIndex(JAVA_INT, 0, value));
          });
      System.out.println(Arrays.toString(segment.toArray(JAVA_INT)));
    }
  }

  public static void main(String[] args) {
    new SharedArena().shared();
  }
}
