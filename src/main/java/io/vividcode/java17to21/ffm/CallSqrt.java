package io.vividcode.java17to21.ffm;

import static java.lang.foreign.ValueLayout.JAVA_DOUBLE;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.invoke.MethodHandle;

public class CallSqrt {

  double sqrt(double v) throws Throwable {
    MethodHandle sqrt = Linker.nativeLinker()
        .downcallHandle(
            Linker.nativeLinker().defaultLookup().find("sqrt").get(),
            FunctionDescriptor.of(JAVA_DOUBLE, JAVA_DOUBLE)
        );
    return (double) sqrt.invokeExact(v);
  }

  public static void main(String[] args) throws Throwable {
    System.out.println(new CallSqrt().sqrt(2.0));
  }
}
