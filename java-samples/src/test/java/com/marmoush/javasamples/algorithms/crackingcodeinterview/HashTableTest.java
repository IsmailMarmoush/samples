package com.marmoush.javasamples.algorithms.crackingcodeinterview;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class HashTableTest {

  @Test
  public void addRemoveTest() {
    int size = 10;
    HashTable<String> ht = new HashTable<>(size);
    ht.add("hello");
    ht.add("jello");
    Assertions.assertEquals("hello", ht.value.get("hello".hashCode() % size).getFirst());
    ht.remove("hello");
    Assertions.assertTrue(ht.value.get("hello".hashCode() % size).isEmpty());
  }

  public static class HashTable<T> {
    // public for testing
    public final List<LinkedList<T>> value;

    public HashTable(int size) {
      this.value = new ArrayList<>(size);
      for (int i = 0; i < size; i++) {
        this.value.add(new LinkedList<>());
      }
    }

    public void add(T t) {
      this.value.get(t.hashCode() % value.size()).add(t);
    }

    public void remove(T t) {
      this.value.get(t.hashCode() % value.size()).remove(t);
    }
  }
}
