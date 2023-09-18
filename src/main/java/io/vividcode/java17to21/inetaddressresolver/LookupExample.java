package io.vividcode.java17to21.inetaddressresolver;

import java.net.Inet4Address;
import java.net.UnknownHostException;

public class LookupExample {

  public static void main(String[] args) throws UnknownHostException {
    System.out.println(Inet4Address.getByName("www.google.com"));
  }
}
