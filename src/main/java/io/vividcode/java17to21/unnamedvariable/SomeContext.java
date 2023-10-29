package io.vividcode.java17to21.unnamedvariable;

public class SomeContext implements AutoCloseable {

  public static SomeContext create() {
    return new SomeContext();
  }

  @Override
  public void close() {

  }
}
