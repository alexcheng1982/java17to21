package io.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_INT;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;


public class CallQsort {

  public int[] qsort(int[] array)
      throws Throwable {
    MethodHandle qsort = Linker.nativeLinker().downcallHandle(
        Linker.nativeLinker().defaultLookup().find("qsort").get(),
        FunctionDescriptor.ofVoid(ADDRESS, JAVA_INT,
            JAVA_INT, ADDRESS)
    );
    MethodHandle compare = MethodHandles.lookup()
        .findStatic(CallQsort.class, "compare", MethodType.methodType(
            int.class, MemorySegment.class, MemorySegment.class
        ));
    MemorySegment compareFuncPointer = Linker.nativeLinker()
        .upcallStub(compare,
            FunctionDescriptor.of(
                JAVA_INT, ADDRESS.withTargetLayout(JAVA_INT),
                ADDRESS.withTargetLayout(JAVA_INT)),
            Arena.ofAuto());
    MemorySegment nativeArray = Arena.ofAuto().allocate(
        JAVA_INT.byteSize() * array.length);
    nativeArray.copyFrom(MemorySegment.ofArray(array));
    qsort.invokeExact(
        nativeArray,
        array.length,
        (int) JAVA_INT.byteSize(),
        compareFuncPointer);
    return nativeArray.toArray(JAVA_INT);
  }

  public static int compare(MemorySegment address1, MemorySegment address2) {
    return address1.get(JAVA_INT, 0) - address2.get(JAVA_INT, 0);
  }
}
