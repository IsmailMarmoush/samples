package com.marmoush.javasamples.java8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exam02 {
  public static void main(String args[]) throws Exception {
    Scanner sc = new Scanner(System.in);
    int cities = sc.nextInt();
    int clinics = sc.nextInt();
    List<Integer> cityPop = new ArrayList<>();
    double[] percent = new double[cities];
    double sum = 0;
    for (int c = 0; c < cities; c++) {
      int population = sc.nextInt();
      cityPop.add(population);
      sum += population;
    }
    clinics -= cities;

    for (int c = 0; c < clinics; c++) {
      Collections.sort(cityPop);
      int min = Collections.min(cityPop);
      int max = Collections.max(cityPop);
    }
  }
}
