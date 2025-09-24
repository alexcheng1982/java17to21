package me.vividcode.java17to21.stringtemplate.sms;

public class SmsTemplateProcessor implements
    StringTemplate.Processor<SmsMessage, RuntimeException> {

  public static final SmsTemplateProcessor SMS = new SmsTemplateProcessor();

  private static final int MAX_LENGTH = 140;

  @Override
  public SmsMessage process(StringTemplate stringTemplate) throws RuntimeException {
    var message = stringTemplate.interpolate();
    if (message.length() > MAX_LENGTH) {
      throw new RuntimeException(
          "SMS message is too long, max length is " + MAX_LENGTH);
    }
    return new SmsMessage(message);
  }
}
