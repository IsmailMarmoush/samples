package com.marmoush.javasamples.java8.OCP.ch08;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileSystems {
  public static void main(String[] args) throws IOException {
    new BufferedInputStream(new FileInputStream("data.txt"));

    /*--------------------*/

    new BufferedReader(new InputStreamReader(new BufferedInputStream(new FileInputStream("hello.txt"))));
    new BufferedReader(new InputStreamReader(new FileInputStream("hi.txt")));
    new BufferedReader(new FileReader("hello.txt"));

    //    new ObjectInputStream(new FileOutputStream("zoo-data.txt")); // DOES NOT COMPILE
    FileInputStream in = new FileInputStream("hell.txt");
    in.read();

    BufferedInputStream in2 = new BufferedInputStream(in);
    in2.read();

  }
}
