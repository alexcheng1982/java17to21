package me.vividcode.java17to21.sequencedcollection;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class SequencedCollections {

  public static void main(String[] args) {
    System.out.println(List.of(1, 2, 3).reversed());

    var list = new ArrayList<>(List.of(1, 2, 3));
    list.addFirst(0);
    list.addLast(4);
    System.out.println(list);

    list = new ArrayList<>(List.of(1, 2, 3));
    list.removeFirst();
    list.removeLast();
    System.out.println(list);

    list = new ArrayList<>(List.of(1, 2, 3));
    System.out.println(list.getFirst());
    System.out.println(list.getLast());

    System.out.println("set");
    var set = new LinkedHashSet<>(Set.of(1, 2, 3));
    System.out.println(set.reversed());
    set.addFirst(0);
    set.addLast(5);
    set.removeFirst();
    set.removeLast();
    System.out.println(set);

    var map = new LinkedHashMap<String, Integer>();
    map.put("a", 1);
    map.put("b", 2);
    map.put("c", 3);
    map.firstEntry();
    map.lastEntry();
    map.pollFirstEntry();
    map.pollLastEntry();
    map.putFirst("d", 4);
    map.putLast("e", 5);
    System.out.println(map);
  }
}
