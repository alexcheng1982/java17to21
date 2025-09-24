package me.vividcode.java17to21.patternmatching.forswitch;

sealed interface Signal permits TrafficLight {

}

enum TrafficLight implements Signal {
  RED,
  YELLOW,
  GREEN
}

public class QualifiedEnumConstants {

  void checkSignal(Signal signal) {
    switch (signal) {
      case TrafficLight.RED -> System.out.println("Stop");
      case TrafficLight.YELLOW -> System.out.println("Wait");
      case TrafficLight.GREEN -> System.out.println("Go");
      case null, default -> System.out.println("Unknown signal");
    }
  }
}
