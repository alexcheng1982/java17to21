package io.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.invoke.MethodHandle;

/**
 * double sqrt(double x)
 */
public class CallSqrt {

  double sqrt(double v) throws Throwable {
    Linker linker = Linker.nativeLinker();
    MethodHandle sqrt = linker
        .downcallHandle(
            linker.defaultLookup().find("sqrt").get(),
            FunctionDescriptor.of(JAVA_DOUBLE, JAVA_DOUBLE)
        );
    return (double) sqrt.invokeExact(v);
  }

}
