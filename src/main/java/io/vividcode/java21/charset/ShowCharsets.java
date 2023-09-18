package io.vividcode.java21.charset;

import java.nio.charset.Charset;
import java.util.function.Supplier;

public class ShowCharsets {

  public static void main(String[] args) {
    showValue("Default charset", () -> Charset.defaultCharset().name());
    showValue("file.encoding", () -> System.getProperty("file.encoding"));
    showValue("native.encoding", () -> System.getProperty("native.encoding"));
  }

  private static void showValue(String name, Supplier<String> supplier) {
    System.out.printf("%15s -> %s%n", name, supplier.get());
  }
}
