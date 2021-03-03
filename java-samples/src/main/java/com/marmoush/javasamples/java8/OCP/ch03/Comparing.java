package com.marmoush.javasamples.java8.OCP.ch03;

import java.util.TreeSet;

public class Comparing {
  public static void main(String[] args) {
    TreeSet<String> t = new TreeSet<>();
  }

  public <T> T hello(T t) {
    return t;
  }
}
