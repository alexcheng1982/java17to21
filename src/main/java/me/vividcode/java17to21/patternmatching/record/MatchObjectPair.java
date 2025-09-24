package me.vividcode.java17to21.patternmatching.record;

public class MatchObjectPair {

  public void match(Object obj) {
    if (obj instanceof ObjectPair(String l, String r)) {
      System.out.printf("(%s, %s)%n", l, r);
    } else if (obj instanceof ObjectPair(Integer x, Integer y)) {
      System.out.println(x + y);
    } else if (obj instanceof ObjectPair(String str, Integer count)) {
      System.out.println(str.repeat(count));
    } else {
      System.out.println("Unknown object");
    }
  }

  public static void main(String[] args) {
    var matchObjectPair = new MatchObjectPair();
    matchObjectPair.match(new ObjectPair("Hello", "World"));
    matchObjectPair.match(new ObjectPair(10, 20));
    matchObjectPair.match(new ObjectPair("Hello", 3));
    matchObjectPair.match(new ObjectPair(4, "Hello"));
  }
}
