package io.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.JAVA_INT;

import java.lang.foreign.MemoryLayout;

public class SequenceLayouts {

  void flatten() {
    var inner = MemoryLayout.sequenceLayout(2, JAVA_INT);
    var outer = MemoryLayout.sequenceLayout(5, inner);
    var flattened = outer.flatten();
    flattened.elementCount(); // 10
    flattened.elementLayout(); // JAVA_INT
  }

  void reshape() {
    var layout = MemoryLayout.sequenceLayout(24, JAVA_INT);
    var reshaped = layout.reshape(2, 3, 4);
    reshaped.elementCount(); // 2
    reshaped.elementLayout(); // sequence layout
  }

  public static void main(String[] args) {
    new SequenceLayouts().flatten();
    new SequenceLayouts().reshape();
  }
}
