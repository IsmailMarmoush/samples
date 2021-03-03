package com.marmoush.javasamples;

public class BitOperations {
  public static void main(String[] args) {
    // Turn a bit on
    System.out.println(
            "Turn bit on: " + Integer.toBinaryString(0b10111) + " -> " + Integer.toBinaryString(0b10111 | 1 << 3));

    // Turn a bit off
    System.out.println(
            "Turn bit off: " + Integer.toBinaryString(0b11111) + " -> " + Integer.toBinaryString(0b11111 & ~(1 << 3)));

    // Toggle a bit
    System.out.println(
            "Toggle bit: " + Integer.toBinaryString(0b10111) + " -> " + Integer.toBinaryString(0b10111 ^ (1 << 3)));

    //
    System.out.println(
            "Turn bit off: " + Integer.toBinaryString(0b111) + " -> " + Integer.toBinaryString(0b111 & (1 << 2)));
  }
}
