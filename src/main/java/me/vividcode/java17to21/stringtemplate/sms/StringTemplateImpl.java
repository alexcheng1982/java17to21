package me.vividcode.java17to21.stringtemplate.sms;

import static me.vividcode.java17to21.stringtemplate.sms.SmsTemplateProcessor.SMS;

import me.vividcode.java17to21.stringtemplate.SmsMessageBuilder;

public class StringTemplateImpl implements SmsMessageBuilder {

  @Override
  public String buildMessage(String customerName, String orderNumber, String courier,
      String trackingUrl) {
    return SMS. """
      Hi \{ customerName }, Your order \{ orderNumber } has shipped via \{ courier }. \
      Track your order here: \{ trackingUrl }.""" .message();
  }
}
