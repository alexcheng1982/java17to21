package io.vividcode.java17to21.ffm;

import java.io.IOException;
import java.lang.foreign.MemorySegment;
import java.nio.ByteBuffer;

public class CreateMemorySegments {

  public void createOnHeap() throws IOException {
    MemorySegment.ofArray(new int[]{1, 2, 3, 4});
    MemorySegment.ofArray(new double[]{1.1, 2.2, 3.3, 4.4});
    MemorySegment.ofBuffer(ByteBuffer.allocate(64));
  }
}
