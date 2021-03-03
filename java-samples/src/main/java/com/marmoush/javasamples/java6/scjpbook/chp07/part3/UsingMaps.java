package com.marmoush.javasamples.java6.scjpbook.chp07.part3;

import java.util.HashMap;
import java.util.Map;

enum Pets {
  DOG,
  CAT,
  HORSE
}

class Cat4map {}

class Dog4map {
  public String name;

  public Dog4map(String n) {
    name = n;
  }

  @Override
  public int hashCode() {
    return name.length();
  }

  @Override
  public boolean equals(Object o) {
    if ((o instanceof Dog4map) && (((Dog4map) o).name == name)) {
      return true;
    } else {
      return false;
    }
  }
}

public class UsingMaps {
  public static void main(String[] args) {

    Map<Object, Object> m = new HashMap<Object, Object>();
    m.put("k1", new Dog4map("aiko")); // add some key/value pairs
    m.put("k2", Pets.DOG);
    m.put(Pets.CAT, "CAT key");
    Dog4map d1 = new Dog4map("clover"); // let's keep this reference
    m.put(d1, "Dog key");
    m.put(new Cat4map(), "Cat key");
    System.out.println(m.get("k1")); // #1
    String k2 = "k2";
    System.out.println(m.get(k2)); // #2
    Pets p = Pets.CAT;
    System.out.println(m.get(p)); // #3
    System.out.println(m.get(d1)); // #4
    System.out.println(m.get(new Cat4map())); // #5
    System.out.println(m.size()); // #6
  }
}
