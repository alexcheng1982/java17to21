package io.vividcode.java17to21.stringtemplate;

import io.vividcode.java17to21.stringtemplate.oldway.MessageFormatImpl;
import io.vividcode.java17to21.stringtemplate.oldway.StringBuilderImpl;
import io.vividcode.java17to21.stringtemplate.oldway.StringConcatenationImpl;
import io.vividcode.java17to21.stringtemplate.oldway.StringFormatImpl;
import io.vividcode.java17to21.stringtemplate.sms.StringTemplateImpl;
import java.util.List;

public class SmsMessageBuilderRunner {

  public static void main(String[] args) {
    var builders = List.of(
        StringConcatenationImpl.class,
        StringBuilderImpl.class,
        StringFormatImpl.class,
        MessageFormatImpl.class,
        StringTemplateImpl.class
    );
    builders.forEach(clazz -> {
      try {
        var builder = clazz.getConstructor().newInstance();
        var message = builder.buildMessage("Alex", "12345678",
            "DHL", "https://trackyourorder.com/12345678");
        System.out.printf("Builder: %s%nMessage: %s%n%n", clazz.getSimpleName(),
            message);
      } catch (Exception e) {
        System.err.println("Failed to build message using " + clazz);
      }
    });
  }
}
