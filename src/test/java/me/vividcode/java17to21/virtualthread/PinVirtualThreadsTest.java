package me.vividcode.java17to21.virtualthread;

import io.quarkus.test.junit5.virtual.ShouldPin;
import io.quarkus.test.junit5.virtual.VirtualThreadUnit;
import org.junit.jupiter.api.Test;

@VirtualThreadUnit
class PinVirtualThreadsTest {

  @Test
  @ShouldPin
  void testPin() {
    new PinVirtualThreads().willPin();
  }
}