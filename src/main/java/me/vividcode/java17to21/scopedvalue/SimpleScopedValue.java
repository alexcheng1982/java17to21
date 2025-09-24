package me.vividcode.java17to21.scopedvalue;

public class SimpleScopedValue {

  private final static ScopedValue<String> VALUE = ScopedValue.newInstance();
  private final static ScopedValue<String> UNBOUND = ScopedValue.newInstance();

  public void print() {
    ScopedValue.runWhere(VALUE, "hello", () -> {
      System.out.println(VALUE.get());
    });
  }

  public void call() throws Exception {
    ScopedValue.callWhere(VALUE, "hello",
        () -> VALUE.get().toUpperCase());
  }

  public void get() {
    ScopedValue.getWhere(VALUE, "hello",
        () -> VALUE.get() + " world");
  }

  public void getOrElse() throws Exception {
    ScopedValue.callWhere(VALUE, "hello", () ->
        VALUE.get() + UNBOUND.orElse("default"));
  }

  public void rebound() {
    ScopedValue.runWhere(VALUE, "hello", () -> {
      var result = ScopedValue.getWhere(VALUE, "world",
          () -> VALUE.get().toUpperCase());
      System.out.println(result);
    });
  }


  public static void main(String[] args) {
    var sample = new SimpleScopedValue();
    sample.print();
    sample.rebound();
  }
}
