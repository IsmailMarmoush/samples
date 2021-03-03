package com.marmoush.javasamples.java8.OCP.ch05;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class DateAndTime {
  public static void main(String[] args) {
    System.out.println(Period.of(1, 0, 7));
    LocalDate date = LocalDate.of(2015, 1, 20);
    LocalTime time = LocalTime.of(6, 15);
    LocalDateTime dateTime = LocalDateTime.of(date, time);
    Duration duration = Duration.ofHours(6);
    System.out.println(dateTime.plus(duration)); // 2015–01–20T12:15
    System.out.println(time.plus(duration));  // 12:15
    //    System.out.println(date.plus(duration)); // Throws exception

    Duration d = Duration.ofDays(2).ofDays(3).ofHours(20); // 20H
    System.out.println(d);
    System.out.println(date.plus(d));
  }
}
