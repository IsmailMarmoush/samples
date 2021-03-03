package com.marmoush.javasamples.java6.scjpbook.chp07.part3;

import java.util.SortedMap;
import java.util.TreeMap;

public class BackedCollection {
  public static void main(String[] args) {
    TreeMap<String, String> map = new TreeMap<String, String>();
    map.put("a", "ant");
    map.put("d", "dog");
    map.put("h", "horse");
    SortedMap<String, String> submap;
    submap = map.subMap("b", "g"); // #1 create a backed collection
    System.out.println(map + " " + submap); // #2 show contents
    map.put("b", "bat"); // #3 add to original
    submap.put("f", "fish"); // #4 add to copy
    map.put("r", "raccoon"); // #5 add to original - out of range
    // submap.put("p", "pig"); // #6 add to copy - out of range
    System.out.println(map + " " + submap); // #7 show final contents

    // headSet(e, b*)
    // Returns a subset ending at element e and exclusive of e

    // headMap(k, b*)
    // Returns a submap ending at key k and exclusive of key k

    // tailSet(e, b*)
    // Returns a subset starting at and inclusive of element e

    // tailMap(k, b*)
    // Returns a submap starting at and inclusive of key k

    // subSet(s, b*, e, b*)
    // Returns subset starting at element s and ending just before element e

    // subMap(s, b*, e, b*)
    // Returns a submap starting at key s and ending just before key s

    /*
     * Note : These boolean arguments are optional. If they exist it�s a
     * Java 6 method that lets you specify whether the endpoint is
     * exclusive, and these methods return a NavigableXxx. If the boolean
     * argument(s) don�t exist, the method returns either a SortedSet or a
     * SortedMap.
     */

    /*
     * Let�s say that you�ve created a backed collection using either a
     * tailXxx() or subXxx() method. Typically in these cases the original
     * and copy collections have different �first� elements. For the exam
     * it�s important that you remember that the pollFirstXxx() methods will
     * always remove the first entry from the collection on which they�re
     * invoked, but they will remove an element from the other collection
     * only if it has same value. So it�s most likely that invoking
     * pollFirstXxx() on the copy will remove an entry from both
     * collections, but invoking pollFirstXxx() on the original will remove
     * only the entry from the original.
     */

  }
}
