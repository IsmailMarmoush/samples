package com.marmoush.javasamples.java6.scjpexam;

import java.io.File;
import java.util.Scanner;

public class ExamG {
  public static void main(String[] args) {
    scan();
  }

  public static void scan() {
    String csv = "sue,5,true,3";
    Scanner sc = new Scanner(csv);
    sc.useDelimiter(",");
    int k2 = sc.nextInt();
    System.out.println(k2);
    File f = new File("cool");
  }
}
