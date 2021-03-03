package com.marmoush.javasamples.java8.OCP.ch07;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Threading {
  public static void main(String[] args) throws ExecutionException, InterruptedException {
    new Thread(() -> System.out.println("hello"));
    ExecutorService service = null;
    try {
      service = Executors.newCachedThreadPool();
      service.execute(() -> System.out.println("hello"));
      Future<List<String>> l = service.submit(() -> Arrays.asList("a", "b", "h"), Arrays.asList("hiiii"));
      System.out.println(l.get());

      Future<String> f = service.submit(() -> {
        return "from inside callable";
      });
      System.out.println(f.get());

    } finally {
      if (service != null)
        service.shutdown();

    }
  }
}
