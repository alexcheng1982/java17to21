package me.vividcode.java17to21.ffm;

import java.lang.foreign.Arena;
import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;

public class CreateMemorySegments {

  void createOnHeap() {
    MemorySegment.ofArray(new int[]{1, 2, 3, 4});
    MemorySegment.ofArray(new double[]{1.1, 2.2, 3.3, 4.4});
    MemorySegment.ofBuffer(ByteBuffer.allocate(64));
  }

  void createOffHeap() {
    Arena.global().allocate(128, 1);
    Arena.ofAuto().allocate(128, 1);
    try (var arena = Arena.ofConfined()) {
      arena.allocate(128, 1);
    }
    try (var arena = Arena.ofShared()) {
      arena.allocate(128, 1);
    }
  }
}
