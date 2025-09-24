package me.vividcode.java17to21.patternmatching.record;

public class MatchGenericPair {

  public void match(Object obj) {
    if (obj instanceof GenericPair(String l, String r)) {
      System.out.printf("(%s, %s)%n", l, r);
    } else if (obj instanceof GenericPair(Object l, Object r)) {
      System.out.printf("Pair<%s, %s>%n", l, r);
    } else {
      System.out.println("Not a GenericPair");
    }
  }

  public void match(GenericPair<String, String> pair) {
    if (pair instanceof GenericPair<String, String>(var s1, var s2)) {
      System.out.println(s1 + ", " + s2);
    }
  }

  public void matchNested(
      GenericPair<GenericPair<String, Integer>,
          GenericPair<String, Double>> pair) {
    if (pair instanceof GenericPair(
        GenericPair(var l1, var r1),
        GenericPair(var l2, var r2)
    )) {
      System.out.println(l1 + l2);
    }
  }

  public static void main(String[] args) {
    new MatchGenericPair().match(new GenericPair<>("Hello", "World"));
    new MatchGenericPair().match(new GenericPair<>(4, "World"));
  }
}
