package com.marmoush.javasamples.designpatternsgof.creational.abstractfactory;

import com.marmoush.javasamples.designpatternsgof.originalmaze.Door;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Maze;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Room;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Wall;

public class BombedMazeFactory implements MazeFactory {
  @Override
  public Maze makeMaze() {
    // TODO Auto-generated method stub
    return null;
  }

  public Wall makeWall() {
    return new BombedWall();
  }

  @Override
  public Room makeRoom(int n) {
    return new RoomWithABomb(n);
  }

  @Override
  public Door makeDoor(Room r1, Room r2) {
    // TODO Auto-generated method stub
    return null;
  }
}
