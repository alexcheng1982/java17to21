package me.vividcode.java17to21.stringtemplate.custom;

import static me.vividcode.java17to21.stringtemplate.custom.JsonTemplateProcessor.JSON;

import com.fasterxml.jackson.core.JacksonException;

public class UseJson {

  public static void main(String[] args) {
    var name = "Alex";
    var email = "alex@example.com";
    try {
      var node = JSON. """
          {
            "name": "\{ name }",
            "email": "\{ email }"
          }
          """ ;
      System.out.println(node.get("name"));
    } catch (JacksonException e) {
      e.printStackTrace();
    }
  }
}
