package me.vividcode.java17to21.patternmatching.forswitch;

public class NullInSwitch {

  public static void process(String command) {
    switch (command) {
      case "Run" -> System.out.println("Run!");
      case "Stop" -> System.out.println("Stop!");
      case null -> System.out.println("Invalid command");
      default -> System.out.println("Unknown command " + command);
    }
  }
}
