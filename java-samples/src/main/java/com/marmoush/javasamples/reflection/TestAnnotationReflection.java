package com.marmoush.javasamples.reflection;

import com.marmoush.javasamples.annotations.AnnotationRunner;
import com.marmoush.javasamples.annotations.CanRun;

import java.lang.reflect.Method;

public class TestAnnotationReflection {
  public static void main(String[] args) {
    AnnotationRunner runner = new AnnotationRunner();
    Method[] methods = runner.getClass().getMethods();

    for (Method method : methods) {
      CanRun annos = method.getAnnotation(CanRun.class);
      if (annos != null) {
        try {
          method.invoke(runner);
        } catch (Exception e) {
          e.printStackTrace();
        }
      }
    }
  }
}
