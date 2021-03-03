package com.marmoush.javasamples.designpatternsgof.behavioural.command;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CommandQueue {

  public static void main(String[] args) {
    List<Command> queue = produceRequests();
    workOffRequests(queue);
  }

  public static List<Command> produceRequests() {
    List<Command> queue = new ArrayList<>();
    queue.add(new DomesticEngineer());
    queue.add(new Politician());
    queue.add(new Programmer());
    return queue;
  }

  public static void workOffRequests(List<Command> queue) {
    for (Iterator<Command> it = queue.iterator(); it.hasNext(); )
      ((Command) it.next()).execute();
  }

  interface Command {
    void execute();
  }

  static class DomesticEngineer implements Command {
    public void execute() {
      System.out.println("take out the trash");
    }
  }

  static class Politician implements Command {
    public void execute() {
      System.out.println("take money from the rich, take votes from the poor");
    }
  }

  static class Programmer implements Command {
    public void execute() {
      System.out.println("sell the bugs, charge extra for the fixes");
    }
  }
}
