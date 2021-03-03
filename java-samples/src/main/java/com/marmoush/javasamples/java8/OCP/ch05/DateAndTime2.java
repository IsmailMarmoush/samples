package com.marmoush.javasamples.java8.OCP.ch05;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Properties;

public class DateAndTime2 {
  public static void main(String[] args) {
    LocalDate date = LocalDate.of(2016, Month.MARCH, 13);
    LocalTime time = LocalTime.of(1, 59);

    Properties props = new Properties();
    props.setProperty("dafdas", "asdf");
    props.setProperty("dafdass", "aasdf");
    props.keySet().stream().map(k -> props.get(k)).forEach(System.out::println);

    ZoneId zone = ZoneId.of("US/Eastern");

    ZonedDateTime dateTime1 = ZonedDateTime.of(date, time, zone);
    System.out.println(dateTime1);

    ZonedDateTime dateTime2 = dateTime1.plus(2, ChronoUnit.MINUTES);
    System.out.println(dateTime2);

    long hours = ChronoUnit.HOURS.between(dateTime1, dateTime2);
    int clock1 = dateTime1.getHour();
    int clock2 = dateTime2.getHour();
    System.out.println(hours + "," + clock1 + "," + clock2);
  }
}
