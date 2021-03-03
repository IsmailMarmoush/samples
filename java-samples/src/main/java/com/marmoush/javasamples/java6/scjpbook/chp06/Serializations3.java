package com.marmoush.javasamples.java6.scjpbook.chp06;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class Dimension {
  private int height;
  private int width;

  public Dimension() {}

  public Dimension(int height, int width) {
    this.height = height;
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  @Override
  public String toString() {
    return "Dimension [height=" + height + ", width=" + width + "]";
  }
}

class MyDog implements Serializable {
  private static final long serialVersionUID = 1432825064636993686L;
  private transient Dimension dimension;
  private String name;

  public MyDog() {}

  public Dimension getDimension() {
    return dimension;
  }

  public void setDimension(Dimension dogDimension) {
    this.dimension = dogDimension;
  }

  public String getName() {
    return name;
  }

  public void setName(String dogName) {
    name = dogName;
  }

  private void readObject(ObjectInputStream inStream) throws IOException, ClassNotFoundException {
    inStream.defaultReadObject();
    dimension = new Dimension(inStream.readInt(), inStream.readInt());
  }

  @Override
  public String toString() {
    return "MyDog [Name=" + name + "], [Dimension=" + dimension + "] ";
  }

  /*
   * Remember, the most common reason to implement writeObject() and
   * readObject() is when you have to save some part of an object's state
   * manually.
   */
  /*
   * Like most I/O-related methods writeObject() can throw exceptions. You can
   * declare them or handle them but we recommend handling them.
   */
  private void writeObject(ObjectOutputStream outStream) throws IOException {
    outStream.defaultWriteObject();
    outStream.writeInt(dimension.getHeight());
    outStream.writeInt(dimension.getWidth());
  }
}

// First problem the dog/ transient collar problem
/*
 * But what would happen if we didn't have access to the Collar class source
 * code? In other words, what if making the Collar class serializable was not an
 * option? Are we stuck with a non-serializable Dog? Obviously we could subclass
 * the Collar class, mark the subclass as Serializable, and then use the Collar
 * subclass instead of the Collar class. But that's not always an option either
 * for several potential reasons:
 */
/*
 * 1. The Collar class might be final, preventing subclassing. OR
 *
 * 2. The Collar class might itself refer to other non-serializable objects, and
 * without knowing the internal structure of Collar, you aren't able to make all
 * these fixes (assuming you even wanted to TRY to go down that road). OR
 *
 * 3. Subclassing is not an option for other reasons related to your design.
 * So�THEN what do you do if you want to save a Dog? That's where the transient
 * modifier comes in.
 *
 * If you mark the Dog's Collar instance variable with transient, then
 * serialization will simply skip the Collar during serialization:
 */

public class Serializations3 {
  static {
    System.out.println("hello static main");
  }

  public static void main(String[] args) {
    MyDog blackJack = new MyDog();
    blackJack.setDimension(new Dimension(5, 10));
    blackJack.setName("rocky");

    try {
      FileOutputStream fos = new FileOutputStream(new File("dog.ser"));
      ObjectOutputStream oos = new ObjectOutputStream(fos);
      oos.writeObject(blackJack);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
    System.out.println(blackJack);

    try {
      FileInputStream fis = new FileInputStream(new File("dog.ser"));
      ObjectInputStream ois = new ObjectInputStream(fis);
      MyDog mydog = (MyDog) ois.readObject();
      System.out.println(mydog);
    } catch (FileNotFoundException e) {

      e.printStackTrace();
    } catch (IOException e) {

      e.printStackTrace();
    } catch (ClassNotFoundException e) {

      e.printStackTrace();
    }
  }
}

// Second Problem nullpointer exception to collar
/*
 * Now we have a Serializable Dog, with a non-serializable Collar, but the Dog
 * has marked the Collar transient; the output is before: collar size is 3
 * Exception in thread "main" java.lang.NullPointerException So NOW what can we
 * do? Using writeObject and readObject
 */
