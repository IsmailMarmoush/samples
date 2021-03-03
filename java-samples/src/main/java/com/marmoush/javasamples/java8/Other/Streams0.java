package com.marmoush.javasamples.java8.Other;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Streams0 {
  public static void main(String[] args) {}

  public void count() {
    List<String> strings = Arrays.asList("aaa", "b", "cc");
    long n = strings.stream().filter(x -> !x.isEmpty()).count();
    System.out.println(n);
  }

  public void join() {
    List<Item> items = Arrays.asList(new Item("hi"), new Item("hello"));
    String names = items.stream().map((x) -> x.getTitle()).collect(Collectors.joining(", "));
    System.out.println(names);
  }

  public class Item {
    String title;

    Item() {}

    Item(String t) {
      this.title = t;
    }

    public String getTitle() {
      return title;
    }
  }
}
