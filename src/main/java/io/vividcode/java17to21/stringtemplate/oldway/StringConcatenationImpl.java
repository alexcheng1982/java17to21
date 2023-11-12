package io.vividcode.java17to21.stringtemplate.oldway;

import io.vividcode.java17to21.stringtemplate.SmsMessageBuilder;

public class StringConcatenationImpl implements SmsMessageBuilder {

  @Override
  public String buildMessage(String customerName, String orderNumber,
      String courier, String trackingUrl) {
    return "Hi " + customerName
        + ", Your order " + orderNumber
        + " has shipped via " + courier
        + ". Track your order here: " + trackingUrl + ".";
  }

}
