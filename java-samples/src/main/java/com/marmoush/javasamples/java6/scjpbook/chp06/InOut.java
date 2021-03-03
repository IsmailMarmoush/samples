package com.marmoush.javasamples.java6.scjpbook.chp06;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class InOut {
  public static void main(String[] args) {
    /*
     * Stream classes are used to read and write bytes, and Readers and
     * Writers are used to read and write characters. Since all of the file
     * I/O on the exam is related to characters, if you see API class names
     * containing the word "Stream", for instance DataOutputStream, then the
     * question is probably about serialization, or something unrelated to
     * the actual I/O objective
     */

    // The next returns false if the file is already there
    // System.out.println(file.createNewFile());

    /*
     * flush() method guarantees that the last of the data you thought you
     * had already written actually gets out to the file.
     */

    /*
     * Combining I/O classes is sometimes called wrapping and sometimes
     * called chaining.
     */
    File file = new File("foo"); // no file yet
    try {
      PrintWriter pw = new PrintWriter(file);

    } catch (FileNotFoundException e) {

      e.printStackTrace();
    } // make a PrintWriter object AND
    // make a file, "foo" to which
    // 'file' is assigned, AND assign
    // 'pw' to the PrintWriter

    File myDir = new File("mydir"); // create an object
    myDir.mkdir();

    File myFile = new File(myDir, "myFile.txt");
    try {
      myFile.createNewFile();
    } catch (IOException e) {

      e.printStackTrace();
    }
    File existingDir = new File("existingDir"); // assign a dir
    System.out.println(existingDir.isDirectory());
    File existingDirFile = new File(existingDir, "existingDirFile.txt"); // assign
    // a
    // file
    System.out.println(existingDirFile.isFile());
    FileReader fr;
    try {
      fr = new FileReader(existingDirFile);

      BufferedReader br = new BufferedReader(fr); // make a Reader
      String s;
      while ((s = br.readLine()) != null)
        // read data
        System.out.println(s);
      br.close();

    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }

    /*
     * You can't delete a directory if it's not empty, which is why the
     * invocation delDir.delete() failed.
     */

    String[] files = new String[100];
    File search = new File("searchThis");
    files = search.list(); // create the list
    for (String fn : files) {
      // iterate through it
      System.out.println("found " + fn);
    }
  }
}
