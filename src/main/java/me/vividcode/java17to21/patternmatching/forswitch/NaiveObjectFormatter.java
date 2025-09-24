package me.vividcode.java17to21.patternmatching.forswitch;

public class NaiveObjectFormatter {

  public static String format(Object input) {
    String result;
    if (input instanceof String s) {
      result = String.format("[String] %s", s);
    } else if (input instanceof Integer i) {
      result = String.format("[int] %d", i);
    } else if (input instanceof Double d) {
      result = String.format("[double] %f", d);
    } else {
      result = String.format("[Other] %s", input);
    }
    return result;
  }
}
