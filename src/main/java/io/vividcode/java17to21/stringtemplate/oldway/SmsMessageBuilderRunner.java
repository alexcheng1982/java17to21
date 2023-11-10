package io.vividcode.java17to21.stringtemplate.oldway;

import java.util.List;

public class SmsMessageBuilderRunner {

  public static void main(String[] args) {
    var builders = List.of(
        StringConcatenationImpl.class,
        StringBuilderImpl.class,
        StringFormatImpl.class,
        MessageFormatImpl.class
    );
    builders.forEach(clazz -> {
      try {
        var builder = clazz.getConstructor().newInstance();
        var message = builder.buildMessage("Alex", "12345678",
            "DHL", "https://trackyourorder.com/12345678");
        System.out.printf("Builder: %s%nMessage: %s%n%n", clazz.getSimpleName(), message);
      } catch (Exception e) {
        System.err.println("Failed to build message using " + clazz);
      }
    });
  }
}
