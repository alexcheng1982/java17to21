package io.vividcode.java17to21.stringtemplate.oldway;

import java.text.MessageFormat;

public class MessageFormatImpl implements SmsMessageBuilder {

  @Override
  public String buildMessage(String customerName, String orderNumber,
      String courier, String trackingUrl) {
    return MessageFormat.format(
        "Hi {0}, Your order {1} has shipped via {2}. Track your order here: {3}.",
        customerName,
        orderNumber,
        courier,
        trackingUrl);
  }
}
