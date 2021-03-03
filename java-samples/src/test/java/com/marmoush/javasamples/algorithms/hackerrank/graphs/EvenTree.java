package com.marmoush.javasamples.algorithms.hackerrank.graphs;

import java.util.Scanner;

public class EvenTree {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    @SuppressWarnings("unused")
    int verts = in.nextInt();
    int edges = in.nextInt();
    Tree[] t = new Tree[edges];
    for (int i = 0; i < edges; i++) {
      t[i] = new Tree(in.nextInt(), in.nextInt());
    }
    System.out.println(checkEven(t));
    in.close();
  }

  public static int checkEven(Tree[] t) {
    int result = 0;
    for (int i = 0; i < t.length; i++) {
      t[i].visited = true;
      int right = counter(0, t[i].a, t) + 1;
      int left = counter(0, t[i].b, t) + 1;
      // System.out.print(right + ":" + t[i].a);
      // System.out.print("-----");
      // System.out.print(left + ":" + t[i].b);
      // System.out.println();
      if (right != 0 && left != 0 && right % 2 == 0 && left % 2 == 0)
        result++;
      clearVisits(t);
    }

    return result;
  }

  public static void clearVisits(Tree[] t) {
    for (Tree e : t) {
      e.visited = false;
    }
  }

  public static int counter(int c, int root, Tree[] t) {
    int counter = c;
    for (int i = 0; i < t.length; i++) {
      int newRoot = -1;
      if (t[i].a == root && !t[i].visited) {
        t[i].visited = true;
        newRoot = t[i].b;
      }
      if (t[i].b == root && !t[i].visited) {
        t[i].visited = true;
        newRoot = t[i].a;
      }
      if (newRoot != -1) {
        // System.out.println(newRoot);
        counter++;
        counter += counter(c, newRoot, t);
      }
    }
    return counter;
  }

  public static class Tree {
    public final int a;
    public final int b;
    public boolean visited;

    Tree(int a, int b) {
      this.a = a;
      this.b = b;
    }
  }
}
