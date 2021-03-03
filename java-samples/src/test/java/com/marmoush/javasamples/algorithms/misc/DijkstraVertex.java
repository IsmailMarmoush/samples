package com.marmoush.javasamples.algorithms.misc;

class DijkstraVertex implements Comparable<DijkstraVertex> {
  public final String name;
  public Edge[] adjacencies;
  public double minDistance = Double.POSITIVE_INFINITY;
  public DijkstraVertex previous;

  public DijkstraVertex(String argName) {
    name = argName;
  }

  public String toString() {
    return name;
  }

  public int compareTo(DijkstraVertex other) {
    return Double.compare(minDistance, other.minDistance);
  }
}
