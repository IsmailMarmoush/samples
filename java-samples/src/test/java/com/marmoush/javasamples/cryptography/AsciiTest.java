package com.marmoush.javasamples.cryptography;

import org.junit.jupiter.api.Test;

public class AsciiTest {
  public static int xor(int n1, int n2) {
    return n1 ^ n2;
  }

  public static String xor(String n1, String n2) {
    if (n1.length() != n2.length())
      return null;
    StringBuilder result = new StringBuilder();
    for (int i = 0; i < n1.length(); i++) {
      int k = n1.charAt(i) ^ n2.charAt(i);
      result.append((char) k);
    }
    return result.toString();
  }

  @Test
  public void encrypt() {
    String message = "BS";
    String asciiToBinary = AsciiToBinary(message);
    System.out.println(asciiToBinary);
  }

  public static String AsciiToBinary(String asciiString) {

    byte[] bytes = asciiString.getBytes();
    StringBuilder binary = new StringBuilder();
    for (byte b : bytes) {
      int val = b;
      for (int i = 0; i < 8; i++) {
        binary.append((val & 128) == 0 ? 0 : 1);
        val <<= 1;
      }
      // binary.append(' ');
    }
    return binary.toString();
  }
}
