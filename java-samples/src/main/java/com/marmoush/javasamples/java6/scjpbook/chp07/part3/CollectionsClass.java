package com.marmoush.javasamples.java6.scjpbook.chp07.part3;

public class CollectionsClass {
  public static void main(String[] args) {
    /*
     * collection (lowercase c), which represents any of the data structures
     * in which objects are stored and iterated over.
     *
     * Collection (capital C), which is actually the java.util.Collection
     * interface from which Set, List, and Queue extend. (That's right,
     * extend, not implement. There are no direct implementations of
     * Collection.)
     *
     * Collections (capital C and ends with s) is the java.util.Collections
     * class that holds a pile of static utility methods for use with
     * collections.
     */

    /*
     * An implementation class can be unsorted and unordered, ordered but
     * unsorted, or both ordered and sorted. But an implementation can never
     * be sorted but unordered, because sorting is a specific type of
     * ordering, as you'll see in a moment. For example, a HashSet is an
     * unordered, unsorted set, while a LinkedHashSet is an ordered (but not
     * sorted) set that maintains the order in which objects were inserted.
     */

    /*
     * Ordered:
     *
     * When a collection is ordered, it means you can iterate through the
     * collection in a specific (not-random) order. A Hashtable collection
     * is not ordered.
     */

    /*
     * Sorted:
     *
     * A sorted collection means that the order in the collection is
     * determined according to some rule or rules, known as the sort order.
     * A sort order has nothing to do with when an object was added to the
     * collection, or when was the last time it was accessed, or what
     * "position" it was added at. Sorting is done based on properties of
     * the objects themselves.
     */

    // Very important
    /*
     * There is no natural order for Foo unless or until the Foo developer
     * provides one, through an interface (Comparable)that defines how
     * instances of a class can be compared to one another (does instance a
     * come before b, or does instance b come before a?).
     */

  }
}
