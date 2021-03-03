package com.marmoush.javasamples.designpatternsgof.creational.factorymethod;

import com.marmoush.javasamples.designpatternsgof.originalmaze.Direction;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Door;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Maze;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Room;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Wall;

class MazeGame {

  Maze createMaze() {
    Maze aMaze = MakeMaze();
    Room r1 = MakeRoom(1);
    Room r2 = MakeRoom(2);
    Door theDoor = MakeDoor(r1, r2);
    aMaze.addRoom(r1);
    aMaze.addRoom(r2);
    r1.setSide(Direction.NORTH, MakeWall());
    r1.setSide(Direction.EAST, theDoor);
    r1.setSide(Direction.SOUTH, MakeWall());
    r1.setSide(Direction.WEST, MakeWall());
    r2.setSide(Direction.NORTH, MakeWall());
    r2.setSide(Direction.EAST, MakeWall());
    r2.setSide(Direction.SOUTH, MakeWall());
    r2.setSide(Direction.WEST, theDoor);
    return aMaze;
  }

  // factory methods:
  Maze MakeMaze() {
    return new Maze();
  }

  Room MakeRoom(int n) {
    return new Room(n);
  }

  Door MakeDoor(Room r1, Room r2) {
    return new Door(r1, r2);
  }

  Wall MakeWall() {
    return new Wall();
  }
};
