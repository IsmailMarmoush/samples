package com.marmoush.javasamples.java6.scjpbook.chp06;

import java.io.IOException;

public class SystemIn {
  public static void main(String[] args) {
    String strInput = "";
    while (true) {
      try {
        int tmp = System.in.read();
        if (tmp == -1)
          break;
        char c = (char) tmp;
        strInput = strInput + c;
      } catch (IOException e) {
      }
    }
    System.out.println("Echo = " + strInput);
  }
}
