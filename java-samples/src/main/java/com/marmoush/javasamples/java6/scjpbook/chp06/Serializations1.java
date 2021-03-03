package com.marmoush.javasamples.java6.scjpbook.chp06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Cat2 implements Serializable {
  private static final long serialVersionUID = 1L;
  int num = 10;
  String s = "Hello string";
}

public class Serializations1 {
  public static void main(String[] args) {
    Cat2 kitten = new Cat2(); // 2
    try {
      FileOutputStream fs = new FileOutputStream("testSer.ser");
      ObjectOutputStream os = new ObjectOutputStream(fs);
      os.writeObject(kitten); // 3
      os.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      FileInputStream fis = new FileInputStream("testSer.ser");
      ObjectInputStream ois = new ObjectInputStream(fis);
      kitten = (Cat2) ois.readObject(); // 4
      ois.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}
