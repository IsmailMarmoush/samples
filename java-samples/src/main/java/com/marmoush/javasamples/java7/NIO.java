package com.marmoush.javasamples.java7;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NIO {
  public static void main(String[] args) {
    Path path = Paths.get("/home/hi");
    System.out.println("Number of Nodes:" + path.getNameCount());
    System.out.println("File Name:" + path.getFileName());
    System.out.println("File Root:" + path.getRoot());
    System.out.println("File Parent:" + path.getParent());
  }
}
