package io.vividcode.java17to21.scopedvalue;

public class ChainedScopedValues {

  private final static ScopedValue<String> V1 = ScopedValue.newInstance();
  private final static ScopedValue<String> V2 = ScopedValue.newInstance();

  public void run() throws Exception {
    ScopedValue.where(V1, "hello")
        .where(V2, "world")
        .run(() -> System.out.println(V1.get() + V2.get()));

    var result = ScopedValue.where(V1, "hello")
        .call(() -> V1.get().toUpperCase());

    var result2 = ScopedValue.where(V1, "hello")
        .get(() -> "world");
  }
}
