package me.vividcode.java17to21.stringtemplate;

import static java.lang.StringTemplate.RAW;

public class SimpleStringTemplate {

  void fragmentsAndValues() {
    var name = "Alex";
    StringTemplate st = RAW. "My name is \{ name }" ;
    System.out.println(st.fragments());
    System.out.println(st.values());
    System.out.println(interpolate(st));
    System.out.println(st.interpolate());
    System.out.println(STR. "My name is \{ name }" );
  }

  String interpolate(StringTemplate st) {
    var builder = new StringBuilder();
    var fragments = st.fragments();
    var values = st.values();
    var size = fragments.size();
    for (int i = 0; i < size; i++) {
      builder.append(fragments.get(i));
      if (i != size - 1) {
        builder.append(values.get(i));
      }
    }
    return builder.toString();
  }

  public static void main(String[] args) {
    var sst = new SimpleStringTemplate();
    sst.fragmentsAndValues();
  }
}
