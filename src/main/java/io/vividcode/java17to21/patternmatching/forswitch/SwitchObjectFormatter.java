package io.vividcode.java17to21.patternmatching.forswitch;

public class SwitchObjectFormatter {

  public static String format(Object input) {
    return switch (input) {
      case String s -> String.format("[String] %s", s);
      case Integer i -> String.format("[int] %d", i);
      case Double d -> String.format("[double] %f", d);
      case null, default -> String.format("[Other] %s", input);
    };
  }
}
