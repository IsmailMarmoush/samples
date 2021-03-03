package com.marmoush.javasamples.designpatternsgof.originalmaze;

public class Door extends MapSite {

  private Room room1;
  private Room room2;
  private boolean isOpen;

  public Door() {}

  public Door(Room room1, Room room2) {}

  public void Enter() {}

  public Room otherSideFrom(Room room) {
    return null;
  }

  public Room getRoom1() {
    return room1;
  }

  public void setRoom1(Room room1) {
    this.room1 = room1;
  }

  public Room getRoom2() {
    return room2;
  }

  public void setRoom2(Room room2) {
    this.room2 = room2;
  }

  public boolean isOpen() {
    return isOpen;
  }

  public void setOpen(boolean isOpen) {
    this.isOpen = isOpen;
  }
}
