package me.vividcode.java17to21.stringtemplate.custom;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonTemplateProcessor implements
    StringTemplate.Processor<JsonNode, JacksonException> {

  public static final JsonTemplateProcessor JSON = new JsonTemplateProcessor();

  private final ObjectMapper objectMapper = new ObjectMapper();

  @Override
  public JsonNode process(StringTemplate stringTemplate)
      throws JacksonException {
    return objectMapper.readTree(stringTemplate.interpolate());
  }
}
