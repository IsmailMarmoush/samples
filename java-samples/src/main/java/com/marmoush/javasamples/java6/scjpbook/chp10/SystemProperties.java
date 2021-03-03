package com.marmoush.javasamples.java6.scjpbook.chp10;

import java.util.Properties;

public class SystemProperties {
  public static void main(String[] args) {
    Properties p = System.getProperties();
    p.setProperty("myProp", "myValue");
    p.list(System.out);
  }
  /*
   * If this file is compiled and invoked as follows:
   *
   * java -DcmdProp=cmdVal TestProps
   */
}
