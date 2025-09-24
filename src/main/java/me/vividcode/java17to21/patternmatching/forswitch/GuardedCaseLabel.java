package me.vividcode.java17to21.patternmatching.forswitch;

public class GuardedCaseLabel {

  public static void process(Object input) {
    final String prefix = "custom/";
    switch (input) {
      case String s when s.equalsIgnoreCase("yes") -> System.out.println("Yes!");
      case String s when s.equalsIgnoreCase("no") -> System.out.println("No!");
      case String s when s.startsWith(prefix) -> System.out.println(s.substring(prefix.length()));
      case null, default -> System.out.println("Invalid input!");
    }
  }

  public static void main(String[] args) {
    GuardedCaseLabel.process("YES");
    GuardedCaseLabel.process("NO");
    GuardedCaseLabel.process("custom/12345");
    GuardedCaseLabel.process("abc");
  }
}
