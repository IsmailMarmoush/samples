package com.marmoush.javasamples.java8;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;
import java.util.Stack;

public class Exam01 {
  public static void main(String[] args) throws IOException {
    Scanner in = new Scanner(System.in);
    final String fileName = System.getenv("OUTPUT_PATH");
    BufferedWriter bw = null;
    if (fileName != null) {
      bw = new BufferedWriter(new FileWriter(fileName));
    } else {
      bw = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    String[] res;
    int values_size = 0;
    values_size = Integer.parseInt(in.nextLine().trim());

    String[] values = new String[values_size];
    for (int i = 0; i < values_size; i++) {
      String values_item;
      try {
        values_item = in.nextLine();
      } catch (Exception e) {
        values_item = null;
      }
      values[i] = values_item;
    }

    res = braces(values);
    for (int res_i = 0; res_i < res.length; res_i++) {
      bw.write(String.valueOf(res[res_i]));
      bw.newLine();
    }

    bw.close();
  }

  /*
   * Complete the function below.
   */
  static String[] braces(String[] values) {
    String[] result = new String[values.length];
    for (int i = 0; i < values.length; i++) {
      result[i] = check(values[i]) ? "YES" : "NO";
    }
    return result;
  }

  private static boolean check(String row) {
    boolean result = false;
    Stack<Character> st = new Stack<Character>();
    for (int i = 0; i < row.length(); i++) {
      char c = row.charAt(i);
      if (c == '{' || c == '(' || c == '[') {
        st.push(c);
      }

      if (c == '}' || c == ')' || c == ']') {
        if (st.isEmpty()) {
          return false;
        }
        char p = st.peek();
        if (c == '}' && p == '{') {
          st.pop();
        }
        if (c == ')' && p == '(') {
          st.pop();
        }

        if (c == ']' && p == '[') {
          st.pop();
        }
      }
    }
    if (st.isEmpty())
      return true;
    return result;
  }
}
