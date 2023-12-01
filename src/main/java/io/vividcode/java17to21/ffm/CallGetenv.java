package io.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.ADDRESS;

import java.lang.foreign.Arena;
import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.invoke.MethodHandle;

/**
 * char *getenv(const char *varname)
 */
public class CallGetenv {

  String getenv(String env) throws Throwable {
    MethodHandle getenv = Linker.nativeLinker()
        .downcallHandle(
            Linker.nativeLinker().defaultLookup().find("getenv").get(),
            FunctionDescriptor.of(ADDRESS, ADDRESS)
        );
    MemorySegment segment = Arena.ofAuto().allocateUtf8String(env);
    MemorySegment result = (MemorySegment) getenv.invokeExact(segment);
    return result.reinterpret(512).getUtf8String(0);
  }
}
