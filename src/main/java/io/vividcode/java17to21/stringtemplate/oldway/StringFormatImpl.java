package io.vividcode.java17to21.stringtemplate.oldway;

public class StringFormatImpl implements SmsMessageBuilder {

  @Override
  public String buildMessage(String customerName, String orderNumber,
      String courier, String trackingUrl) {
    return String.format(
        "Hi %s, Your order %s has shipped via %s. Track your order here: %s.",
        customerName, orderNumber, courier, trackingUrl);
  }
}
