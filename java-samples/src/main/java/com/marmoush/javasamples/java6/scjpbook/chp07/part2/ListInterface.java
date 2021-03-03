package com.marmoush.javasamples.java6.scjpbook.chp07.part2;

public class ListInterface {
  public static void main(String[] args) {

    /*
     * List Interface:
     *
     * A List cares about the index. The one thing that List has that
     * non-lists don't have is a set of methods related to the index. Those
     * key methods include things like get(int index), indexOf(Object o),
     * add(int index, Object obj), and so on. All three List implementations
     * are ordered by index position�a position that you determine either by
     * setting an object at a specific index or by adding it without
     * specifying position, in which case the object is added to the end.
     * The three List implementations are described in the following
     * sections.
     */

    /*
     * ArrayList
     *
     * now implements the new RandomAccess interface�a marker interface
     * (meaning it has no methods) that says,
     * "this list supports fast (generally constant time) random access."
     * Choose this over a LinkedList when you need fast iteration but aren't
     * as likely to be doing a lot of insertion and deletion.
     */

    /*
     * Vector
     *
     * methods are synchronized for thread safety. You'll normally want to
     * use ArrayList instead of Vector because the synchronized methods add
     * a performance hit you might not need. And if you do need thread
     * safety, there are utility methods in class Collections that can help.
     * Vector is the only class other than ArrayList to implement
     * RandomAccess.
     */

    /*
     * LinkedList
     *
     * may iterate more slowly than an ArrayList, but it's a good choice
     * when you need fast insertion and deletion. As of Java 5, the
     * LinkedList class has been enhanced to implement the java.util.Queue
     * interface. As such, it now supports the common queue methods: peek(),
     * poll(), and offer().
     */
  }
}
