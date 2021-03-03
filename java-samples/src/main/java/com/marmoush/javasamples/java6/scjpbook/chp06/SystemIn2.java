package com.marmoush.javasamples.java6.scjpbook.chp06;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SystemIn2 {
  public static void main(String[] args) {
    try {
      InputStreamReader isr = new InputStreamReader(System.in);
      BufferedReader br = new BufferedReader(isr);
      System.out.println("Enter the line :- ");
      String s = br.readLine();
      System.out.println("You have Enterd :- " + s);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
