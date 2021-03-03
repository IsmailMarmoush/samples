package com.marmoush.javasamples.algorithms.crackingcodeinterview;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

public class Chp03Test {
  @Test
  public void testFifo() {
    MyQueue<Integer> q = new MyQueue<>();
    q.add(1);
    q.add(2);
    System.out.println(q);
  }

  public static class MyQueue<T> {
    private QueueNode<T> first;
    private QueueNode<T> last;

    public void add(T item) {

      QueueNode<T> t = new QueueNode<T>(item);
      if (last != null) {
        last.next = t;
      }
      last = t;
      if (first == null) {
        first = last;
      }
    }

    public T remove() {
      if (first == null)
        throw new NoSuchElementException();
      T data = first.data;
      first = first.next;
      if (first == null) {
        last = null;
      }
      return data;
    }

    public T peek() {
      if (first == null)
        throw new NoSuchElementException();
      return first.data;
    }

    public boolean isEmpty() {
      return first == null;
    }

    @Override
    public String toString() {
      return "MyQueue{" + "first=" + first + ", last=" + last + '}';
    }

    private static class QueueNode<T> {
      private T data;
      private QueueNode<T> next;

      public QueueNode(T data) {
        this.data = data;
      }

      @Override
      public String toString() {
        return "QueueNode{" + "data=" + data + ", next=" + next + '}';
      }
    }
  }
}
