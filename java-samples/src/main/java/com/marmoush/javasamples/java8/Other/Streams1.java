package com.marmoush.javasamples.java8.Other;

import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public class Streams1 {
  public Streams1() {}

  public static void main(String[] args) {
    Predicate<Integer> isOdd = n -> n % 2 != 0;
    System.out.println(isOdd.test(41));
    System.out.println("hello java 8");
    Runnable runner = () -> {
      System.out.println("Hello World!");
    };
    runner.run();

    Integer[] arr = {10, 11, 12, 13};
    Stream.of(arr).forEach(new Consumer<Integer>() {

      @Override
      public void accept(Integer t) {
        // TODO Auto-generated method stub

      }
    });
    Stream.of(arr).forEach(x -> System.out.println(x));
    Stream.of(arr).forEach(Streams1::sayHello);
    // So new Consumer<Integer> ... = Main::sayHello ??
    Consumer<Integer> con = Streams1::sayHello;
  }

  public static void sayHello(Integer k) {
    System.out.println("hello");
  }
}
