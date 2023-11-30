package io.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_INT;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;


public class CallStrlen {

  long strlen(String input) throws Throwable {
    MethodHandle strlen = Linker.nativeLinker()
        .downcallHandle(
            Linker.nativeLinker().defaultLookup().find("strlen").get(),
            FunctionDescriptor.of(JAVA_INT, ADDRESS)
        );
    MemorySegment segment = Arena.ofAuto().allocateUtf8String(input);
    return (int) strlen.invokeExact(segment);
  }

  public static void main(String[] args) throws Throwable {
    System.out.println(new CallStrlen().strlen("Hello"));
  }
}
