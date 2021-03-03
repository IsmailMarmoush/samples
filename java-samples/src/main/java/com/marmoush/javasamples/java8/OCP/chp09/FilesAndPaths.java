package com.marmoush.javasamples.java8.OCP.chp09;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FilesAndPaths {
  public static void main(String[] args) throws IOException {
    getFileName();
    System.out.println("");
    toAbsolute();
    System.out.println("");
    subpath();
    System.out.println("");
    resolve();
    System.out.println("");
    resolve2();
    System.out.println("");
    owner();
    System.out.println("");
    test1();
  }

  static void getFileName() {
    Path path = Paths.get("/land/hippo/harry.happy");
    System.out.println("The Path Name is: " + path);
    System.out.println("The file Name is: " + path.getFileName());
    System.out.println("The file system is: " + path.getFileSystem());
    for (int i = 0; i < path.getNameCount(); i++) {
      System.out.println("Element " + i + " is: " + path.getName(i));
    }
  }

  static void toAbsolute() {
    Path path2 = Paths.get("birds/condor.txt");
    System.out.println("Path2 is Absolute? " + path2.isAbsolute());
    System.out.println("Absolute Path2 " + path2.toAbsolutePath());
    System.out.println("");
  }

  static void subpath() {
    Path path3 = Paths.get("/mammal/carnivore/raccoon.image");
    System.out.println("Path is: " + path3);
    System.out.println("Subpath from 0 to 3 is: " + path3.subpath(0, 3));
    System.out.println("Subpath from 1 to 3 is: " + path3.subpath(1, 3));
    System.out.println("Subpath from 1 to 2 is: " + path3.subpath(1, 2));
  }

  static void resolve() {
    final Path path1 = Paths.get("/cats/../panther");
    final Path path2 = Paths.get("food");
    System.out.println(path1.resolve(path2));
  }

  static void resolve2() throws IOException {
    //    final Path path1 = Paths.get("./a/b/c");
    //    final Path path2 = Paths.get("./b/d");
    //
    //    Files.copy(path1, path2, REPLACE_EXISTING);
    //    System.out.println(path1.resolve(path2));
  }

  static void owner() throws IOException {
    // Read owner of file
    Path path = Paths.get("pom.xml");
    System.out.println(Files.getOwner(path).getName());
    // Change owner of file
    //    UserPrincipal owner =
    //
    // path.getFileSystem().getUserPrincipalLookupService().lookupPrincipalByName("heisenberg");
    //    Files.setOwner(path, owner);
    //    // Output the updated owner information
    //    System.out.println(Files.getOwner(path).getName());
  }

  static void test1() {
    Path path = Paths.get("/user/.././root", "../kodiacbear.txt");
    System.out.println(path);
    Path p = path.normalize();
    System.out.println(p);
    System.out.println(p.relativize(Paths.get("/lion")));
    // Notice that ..\ is included at the start of
    // the first set of examples. Since our path value points to a file, we need to move to the
    // parent
    // directory that contains the file.
    System.out.println(Paths.get("/hello/world").relativize(Paths.get("/hello/bye")));
    System.out.println("hi" + Paths.get(".").normalize().getParent());
  }
}
