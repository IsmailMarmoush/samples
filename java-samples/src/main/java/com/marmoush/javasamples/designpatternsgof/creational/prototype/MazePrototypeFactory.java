package com.marmoush.javasamples.designpatternsgof.creational.prototype;

import com.marmoush.javasamples.designpatternsgof.originalmaze.Door;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Maze;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Wall;

class MazePrototypeFactory implements MazeFactory {
  private Maze _prototypeMaze;
  private RoomCloneable _prototypeRoom;
  private Wall _prototypeWall;
  private Door _prototypeDoor;

  MazePrototypeFactory(Maze maze, Wall wall, RoomCloneable room, Door door) {
    this._prototypeMaze = maze;
    this._prototypeWall = wall;
    this._prototypeRoom = room;
    this._prototypeDoor = door;
  }

  Maze MakeMaze() {
    return null;
  }

  RoomCloneable MakeRoom(int roomNumber) {
    return (RoomCloneable) this._prototypeRoom.clone();
  }

  Wall MakeWall() {
    return null;
  }

  Door MakeDoor(RoomCloneable r1, RoomCloneable r2) {
    return null;
  }
}
