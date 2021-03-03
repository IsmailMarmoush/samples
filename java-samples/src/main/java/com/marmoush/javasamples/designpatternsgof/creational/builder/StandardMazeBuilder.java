package com.marmoush.javasamples.designpatternsgof.creational.builder;

import com.marmoush.javasamples.designpatternsgof.originalmaze.Direction;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Door;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Maze;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Room;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Wall;

class StandardMazeBuilder implements MazeBuilder {

  Maze currentMaze;

  public StandardMazeBuilder() {
    currentMaze = null;
  }

  @Override
  public void buildMaze() {
    currentMaze = new Maze();
  }

  @Override
  public void buildRoom(int roomNumber) {
    // the #RoomNo(n) is findRoom(n)
    // if there are no rooms with number n
    if (currentMaze.findRoom(roomNumber) == null) {
      Room room = new Room(roomNumber);
      currentMaze.addRoom(room);
      room.setSide(Direction.NORTH, new Wall());
      room.setSide(Direction.SOUTH, new Wall());
      room.setSide(Direction.EAST, new Wall());
      room.setSide(Direction.WEST, new Wall());
    }
  }

  @Override
  public void buildDoor(int n1, int n2) {
    Room r1 = currentMaze.findRoom(n1);
    Room r2 = currentMaze.findRoom(n2);
    Door d = new Door(r1, r2);
    r1.setSide(commonWall(r1, r2), d);
    r2.setSide(commonWall(r2, r1), d);
  }

  Direction commonWall(Room r1, Room r2) {
    return null;
  }

  @Override
  public Maze getMaze() {
    return currentMaze;
  }
}
