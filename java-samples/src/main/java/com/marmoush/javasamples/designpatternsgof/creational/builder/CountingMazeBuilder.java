package com.marmoush.javasamples.designpatternsgof.creational.builder;

import com.marmoush.javasamples.designpatternsgof.originalmaze.Maze;

class CountingMazeBuilder implements MazeBuilder {

  private int doors;
  private int rooms;

  public CountingMazeBuilder() {
    setRooms(0);
    setDoors(0);
  }

  @Override
  public void buildMaze() {}

  @Override
  public void buildRoom(int room) {
    setRooms(getRooms() + 1);
  }

  @Override
  public void buildDoor(int roomFrom, int roomTo) {
    setDoors(getDoors() + 1);
  }

  public int getDoors() {
    return doors;
  }

  public void setDoors(int doors) {
    this.doors = doors;
  }

  @Override
  public Maze getMaze() {
    return null;
  }

  public int getRooms() {
    return rooms;
  }

  public void setRooms(int rooms) {
    this.rooms = rooms;
  }
}
