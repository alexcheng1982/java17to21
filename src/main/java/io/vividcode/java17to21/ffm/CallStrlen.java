package io.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_INT;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

/**
 * size_t strlen(const char *string)
 */
public class CallStrlen {

  long strlen(String input) throws Throwable {
    Linker linker = Linker.nativeLinker();
    MethodHandle strlen = linker
        .downcallHandle(
            linker.defaultLookup().find("strlen").get(),
            FunctionDescriptor.of(JAVA_INT, ADDRESS)
        );
    MemorySegment segment = Arena.ofAuto().allocateUtf8String(input);
    return (int) strlen.invokeExact(segment);
  }
}
