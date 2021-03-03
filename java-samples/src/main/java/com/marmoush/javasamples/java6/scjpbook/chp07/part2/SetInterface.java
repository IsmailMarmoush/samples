package com.marmoush.javasamples.java6.scjpbook.chp07.part2;

public class SetInterface {
  public static void main(String[] args) {
    /*
     * Set Interface:
     *
     * A Set cares about uniqueness�it doesn't allow duplicates. Your good
     * friend the equals() method determines whether two objects are
     * identical (in which case only one can be in the set). The three Set
     * implementations are described in the following sections
     */

    /*
     * HashSet :
     *
     * A HashSet is an unsorted, unordered Set. It uses the hashcode of the
     * object being inserted, so the more efficient your hashCode()
     * implementation the better access performance you'll get. Use this
     * class when you want a collection with no duplicates and you don't
     * care about order when you iterate through it.
     */

    /*
     * LinkedHashSet:
     *
     * A LinkedHashSet is an ordered version of HashSet that maintains a
     * doubly-linked List across all elements. Use this class instead of
     * HashSet when you care about the iteration order. When you iterate
     * through a HashSet the order is unpredictable, while a LinkedHashSet
     * lets you iterate through the elements in the order in which they were
     * inserted.
     */

    /*
     * When using HashSet or LinkedHashSet, the objects you add to them must
     * override hashCode(). If they don�t override hashCode(), the default
     * Object.hashCode() method will allow multiple objects that you might
     * consider "meaningfully equal" to be added to your
     * "no duplicates allowed" set.
     */

    /*
     * T reeSet The TreeSet is one of two sorted collections (the other
     * being TreeMap). It uses a Red-Black tree structure (but you knew
     * that), and guarantees that the elements will be in ascending order,
     * according to natural order. Optionally, you can construct a TreeSet
     * with a constructor that lets you give the collection your own rules
     * for what the order should be (rather than relying on the ordering
     * defined by the elements' class) by using a Comparable or Comparator.
     * As of Java 6, TreeSet implements NavigableSet.
     */
  }
}
