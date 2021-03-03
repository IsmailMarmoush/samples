package com.marmoush.javasamples.java8.Other;

import java.util.Arrays;
import java.util.List;

public class MethodReference {
  public static void main(String[] args) {}

  public void instanceMethodRef() {
    List<String> items = Arrays.asList("aaa", "b", "cc");
    // instance::instanceMethod syntax
    items.forEach(System.out::print);
    // equivalent to:
    items.forEach((x) -> System.out.print(x));
  }

  public void staticMethodRef() {
    String[] items = {"aaa", "b", "cc"};
    // Class::staticMethod syntax
    Arrays.sort(items, Util::compareItems);

    // equivalent to:
    Arrays.sort(items, (a, b) -> Util.compareItems(a, b));
  }

  public void refToMethodOfArbitraryInstance() {
    List<Item> items = Arrays.asList(new Item("hi"), new Item("hello"), new Item("bye"));
    // Class::instanceMethod syntax
    items.forEach(Item::publish);

    // equivalent to:
    items.forEach((x) -> {
      x.publish();
    });
  }

  public void constructorRef() {
    // ConstructorReference cref = Item::new;
    // Item item = cref.constructor();
  }

  public static class Util {
    public static int compareItems(String a, String b) {
      return a.compareTo(b);
    }
  }

  public class Item {
    private String s;

    public Item() {}

    public Item(String s) {
      this.s = s;
    }

    public void publish() {
      System.out.println(s);
    }
  }
}
