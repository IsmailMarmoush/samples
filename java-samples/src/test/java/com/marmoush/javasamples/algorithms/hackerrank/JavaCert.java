package com.marmoush.javasamples.algorithms.hackerrank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class JavaCert {
  public static void main(String[] args) {
    //    Float f = new Float(3.0);
    //    System.out.println(f.byteValue() + f.intValue());
    //    int mask = 0x000f;
    //    int value = 0x2222;
    //    System.out.println(value & mask);
    //    LinkedList<String> q = new LinkedList<>();
    //    q.addFirst("1");
    //    q.addFirst("2");
    //    System.out.println(q.poll());
    List<String> strings = Arrays.asList("((()))", "({}{})", "({)})", "}{", ")(", ")()", "({)}");
    //    List<String> strings = Arrays.asList("({)}");
    strings.forEach(s -> System.out.print(isBalanced3(s) + ","));
    System.out.println();
    strings.forEach(s -> System.out.print(isBalanced2(s) + ","));
    System.out.println();
    strings.forEach(s -> System.out.print(isBalanced(s) + ","));
    System.out.println();
  }

  public static boolean isBalanced3(String expression) {
    if ((expression.length() % 2) == 1)
      return false;
    else {
      Stack<Character> s = new Stack<>();
      for (char bracket : expression.toCharArray())
        switch (bracket) {
          case '{':
            s.push('}');
            break;
          case '(':
            s.push(')');
            break;
          case '[':
            s.push(']');
            break;
          default:
            if (s.isEmpty() || bracket != s.peek()) {
              return false;
            }
            s.pop();
        }
      return s.isEmpty();
    }
  }

  public static boolean isBalanced2(String s) {
    LinkedList<Character> q = new LinkedList<>();
    for (char c : s.toCharArray()) {
      if (c == '{' || c == '[' || c == '(') {
        q.push(c);
      } else {
        if (q.isEmpty())
          return false;
        char pop = q.pop();
        if ((pop == '{' && c != '}') || (pop == '(' && c != ')') || (pop == '[' && c != ']')) {
          return false;
        }
      }
    }
    return q.isEmpty();
  }

  public static boolean isBalanced(String s) {
    LinkedList<Character> q = new LinkedList<>();
    for (char c : s.toCharArray()) {
      switch (c) {
        case '{':
          q.addFirst(c);
          break;
        case '(':
          q.addFirst(c);
          break;
        case '}':
          if (q.peekFirst() != null && q.peekFirst() == '{')
            q.pollFirst();
          else
            q.addFirst(c);
          break;
        case ')':
          if (q.peekFirst() != null && q.peekFirst() == '(')
            q.pollFirst();
          else
            q.addFirst(c);
          break;
      }
    }
    return q.size() == 0;
  }
}
