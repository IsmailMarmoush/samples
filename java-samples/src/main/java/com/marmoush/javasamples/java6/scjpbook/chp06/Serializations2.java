package com.marmoush.javasamples.java6.scjpbook.chp06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Cat implements Serializable {

  private static final long serialVersionUID = 7168400355944724386L;
}

class Collar implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = 234947414341003056L;

  private int collarSize;

  public Collar(int size) {
    collarSize = size;
  }

  public int getCollarSize() {
    return collarSize;
  }
}

/*
 * Object references marked transient will always be reset to null, regardless
 * of whether they were initialized at the time of declaration in the class.
 */

class Dog implements Serializable {
  /**
   *
   */
  private static final long serialVersionUID = -5337865494708141729L;

  private Collar theCollar;
  private int dogSize;

  public Dog(Collar collar, int size) {
    theCollar = collar;
    dogSize = size;
  }

  public Collar getCollar() {
    return theCollar;
  }

  public int getDogSize() {
    return dogSize;
  }

  public void setDogSize(int dogSize) {
    this.dogSize = dogSize;
  }

  public Collar getTheCollar() {
    return theCollar;
  }

  public void setTheCollar(Collar theCollar) {
    this.theCollar = theCollar;
  }
}

public class Serializations2 {
  public static void main(String[] args) {}
}

class SerializeCat {
  public static void main(String[] args) {
    Cat c = new Cat();
    try {
      FileOutputStream fs = new FileOutputStream("testSer.ser");
      ObjectOutputStream os = new ObjectOutputStream(fs);
      os.writeObject(c);
      os.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      FileInputStream fis = new FileInputStream("testSer.ser");
      ObjectInputStream ois = new ObjectInputStream(fis);
      c = (Cat) ois.readObject();
      ois.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
}

class SerializeDog {
  public static void main(String[] args) {
    Collar c = new Collar(3);
    Dog d = new Dog(c, 5);
    System.out.println("before: collar size is " + d.getCollar().getCollarSize());
    try {
      FileOutputStream fs = new FileOutputStream("testSer.ser");
      ObjectOutputStream os = new ObjectOutputStream(fs);
      os.writeObject(d);
      os.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    try {
      FileInputStream fis = new FileInputStream("testSer.ser");
      ObjectInputStream ois = new ObjectInputStream(fis);
      d = (Dog) ois.readObject();
      ois.close();
    } catch (Exception e) {
      e.printStackTrace();
    }
    System.out.println("after: collar size is " + d.getCollar().getCollarSize());
  }
}

/*
 * If you are a serializable class, but your superclass is NOT serializable,
 * then any instance variables you INHERIT from that superclass will be reset to
 * the values they were given during the original construction of the object.
 * This is because the non-serializable class constructor WILL run!
 */

/*
 * If you serialize a collection or an array, every element must be
 * serializable! A single non-serializable element will cause serialization to
 * fail. Note also that while the collection interfaces are not serializable,
 * the concrete collection classes in the Java API are.
 */
// Serialization Is Not for Statics
/*
 * As simple as serialization code is to write, versioning problems can occur in
 * the real world. If you save a Dog object using one version of the class, but
 * attempt to deserialize it using a newer, different version of the class,
 * deserialization might fail. See the Java API for details about versioning
 * issues and solutions.
 */
