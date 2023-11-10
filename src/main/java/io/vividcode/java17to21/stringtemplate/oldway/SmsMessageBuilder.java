package io.vividcode.java17to21.stringtemplate.oldway;

public interface SmsMessageBuilder {

  String buildMessage(
      String customerName,
      String orderNumber,
      String courier,
      String trackingUrl);
}
