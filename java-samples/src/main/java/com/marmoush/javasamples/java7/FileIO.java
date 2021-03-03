package com.marmoush.javasamples.java7;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Behind the scenes, the resources that should be auto closed must implement java.lang.AutoCloseable interface.
 *
 * <p>Any resource that implements AutoCloseble interface can be a candidate for automatic resource
 * management. The AutoCloseable is the parent of java.io.Closeable interface and has just one method close() that would
 * be called by the JVM when the control comes out of the try block.
 *
 * @author jazri
 */
public class FileIO {
  public static void main(String[] args) {
    try (FileOutputStream fos = new FileOutputStream("movies.txt"); DataOutputStream dos = new DataOutputStream(fos)) {

      dos.writeUTF("Java 7 Block Buster");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
