package io.vividcode.java17to21.unnamedvariable;

public class UnusedExceptionVariable {

  public int parseHttpPort(String port) {
    try {
      return Integer.parseInt(port);
    } catch (NumberFormatException e) {
      return 80;
    }
  }
}
