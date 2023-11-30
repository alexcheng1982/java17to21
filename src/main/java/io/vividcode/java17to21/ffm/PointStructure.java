package io.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.JAVA_INT;

import java.lang.foreign.Arena;
import java.lang.foreign.MemoryLayout;
import java.lang.foreign.MemoryLayout.PathElement;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SequenceLayout;
import java.lang.invoke.VarHandle;
import java.util.ArrayList;
import java.util.List;

public class PointStructure {

  private final MemoryLayout pointLayout = MemoryLayout.structLayout(
      JAVA_INT.withName("x"),
      JAVA_INT.withName("y")
  );
  private final SequenceLayout pointsLayout = MemoryLayout.sequenceLayout(
      pointLayout);
  private final VarHandle xHandle = pointsLayout.varHandle(
      PathElement.sequenceElement(),
      PathElement.groupElement("x"));
  private final VarHandle yHandle = pointsLayout.varHandle(
      PathElement.sequenceElement(),
      PathElement.groupElement("y"));

  public MemorySegment save(List<Point> points) {
    MemorySegment segment = Arena.ofAuto().allocate(
        pointLayout.byteSize() * points.size());
    for (int i = 0; i < points.size(); i++) {
      Point point = points.get(i);
      xHandle.set(segment, (long) i, point.x());
      yHandle.set(segment, (long) i, point.y());
    }
    return segment;
  }

  public List<Point> load(MemorySegment segment) {
    int numberOfPoints = (int) (segment.byteSize()
        / pointLayout.byteSize());
    List<Point> points = new ArrayList<>(numberOfPoints);
    for (int i = 0; i < numberOfPoints; i++) {
      int x = (int) xHandle.get(segment, (long) i);
      int y = (int) yHandle.get(segment, (long) i);
      points.add(new Point(x, y));
    }
    return points;
  }
}
