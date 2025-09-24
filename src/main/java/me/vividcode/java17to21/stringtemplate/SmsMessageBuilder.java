package me.vividcode.java17to21.stringtemplate;

public interface SmsMessageBuilder {

  String buildMessage(
      String customerName,
      String orderNumber,
      String courier,
      String trackingUrl);
}
