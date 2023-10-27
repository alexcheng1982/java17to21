package io.vividcode.java17to21.scopedvalue;

public class SimpleScopedValue {

  private final static ScopedValue<String> VALUE = ScopedValue.newInstance();

  public void print() {
    ScopedValue.runWhere(VALUE, "hello", () -> {
      System.out.println(VALUE.get());
    });
  }

  public static void main(String[] args) {
    new SimpleScopedValue().print();
  }
}
