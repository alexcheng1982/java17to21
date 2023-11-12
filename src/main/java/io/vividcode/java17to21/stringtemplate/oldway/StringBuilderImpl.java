package io.vividcode.java17to21.stringtemplate.oldway;

import io.vividcode.java17to21.stringtemplate.SmsMessageBuilder;

public class StringBuilderImpl implements SmsMessageBuilder {

  @Override
  public String buildMessage(String customerName, String orderNumber,
      String courier, String trackingUrl) {
    return new StringBuilder()
        .append("Hi ")
        .append(customerName)
        .append(", Your order ")
        .append(orderNumber)
        .append(" has shipped via ")
        .append(courier)
        .append(". Track your order here: ")
        .append(trackingUrl)
        .append(".")
        .toString();
  }
}
