package com.marmoush.javasamples.algorithms.searching;

public class BinaryTreeLinked {
  private int key;
  private String value;
  private BinaryTreeLinked leftChild;
  private BinaryTreeLinked rightChild;

  public BinaryTreeLinked() {}

  public BinaryTreeLinked(int key, String value) {
    this.key = key;
    this.value = value;
  }

  public static void main(String[] args) {
    BinaryTreeLinked btl = new BinaryTreeLinked(0, "");
    btl.addNode(7, "");
    btl.addNode(4, "");
    btl.addNode(5, "");
    btl.addNode(6, "");
    btl.addNode(1, "");
    btl.addNode(3, "");
    btl.addNode(2, "");
    inOrderTraverseTree(btl);
    System.out.println("----------");
    preOrderTraverseTree(btl);
    System.out.println("----------");
    postOrderTraverseTree(btl);
  }

  public static void inOrderTraverseTree(BinaryTreeLinked focusBinaryTreeLinked) {
    if (focusBinaryTreeLinked != null) {
      inOrderTraverseTree(focusBinaryTreeLinked.leftChild);
      // Visit the currently focused on BinaryTreeLinked
      System.out.println(focusBinaryTreeLinked);
      // Traverse the right BinaryTreeLinked
      inOrderTraverseTree(focusBinaryTreeLinked.rightChild);
    }
  }

  public static void preOrderTraverseTree(BinaryTreeLinked focusBinaryTreeLinked) {
    if (focusBinaryTreeLinked != null) {
      System.out.println(focusBinaryTreeLinked);
      preOrderTraverseTree(focusBinaryTreeLinked.leftChild);
      preOrderTraverseTree(focusBinaryTreeLinked.rightChild);
    }
  }

  public static void postOrderTraverseTree(BinaryTreeLinked focusBinaryTreeLinked) {
    if (focusBinaryTreeLinked != null) {
      postOrderTraverseTree(focusBinaryTreeLinked.leftChild);
      postOrderTraverseTree(focusBinaryTreeLinked.rightChild);
      System.out.println(focusBinaryTreeLinked);
    }
  }

  public static BinaryTreeLinked findBinaryTreeLinked(int key, BinaryTreeLinked focusBinaryTreeLinked) {
    while (focusBinaryTreeLinked.key != key) {
      // If we should search to the left
      if (key < focusBinaryTreeLinked.key) {
        // Shift the focus BinaryTreeLinked to the left child
        focusBinaryTreeLinked = focusBinaryTreeLinked.leftChild;
      } else {
        // Shift the focus BinaryTreeLinked to the right child
        focusBinaryTreeLinked = focusBinaryTreeLinked.rightChild;
      }
      // The BinaryTreeLinked wasn't found
      if (focusBinaryTreeLinked == null)
        return null;
    }
    return focusBinaryTreeLinked;
  }

  public void addNode(int key, String name) {
    // Create a new Node and initialize it
    BinaryTreeLinked newNode = new BinaryTreeLinked(key, name);
    BinaryTreeLinked focusNode = this;
    // Future parent for our new Node
    BinaryTreeLinked parent;
    while (true) {
      // root is the top parent so we start there
      parent = focusNode;
      // Check if the new node should go on the left side of the parent node
      if (key < focusNode.key) {
        // Switch focus to the left child
        focusNode = focusNode.leftChild;
        // If the left child has no children
        if (focusNode == null) {
          // then place the new node on the left of it
          parent.leftChild = newNode;
          return;
        }
      } else { // If we get here put the node on the right
        focusNode = focusNode.rightChild;
        // If the right child has no children
        if (focusNode == null) {
          // then place the new node on the right of it
          parent.rightChild = newNode;
          return;
        }
      }
    }
  }

  @Override
  public String toString() {
    return "(" + key + "," + value + ")";
  }
}
