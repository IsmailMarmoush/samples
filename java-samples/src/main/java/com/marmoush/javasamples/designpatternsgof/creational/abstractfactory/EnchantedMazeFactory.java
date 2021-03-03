package com.marmoush.javasamples.designpatternsgof.creational.abstractfactory;

import com.marmoush.javasamples.designpatternsgof.originalmaze.Door;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Maze;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Room;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Wall;

class EnchantedMazeFactory implements MazeFactory {

  public EnchantedMazeFactory() {}

  public Room MakeRoom(int n) {
    return new EnchantedRoom(n, CastSpell());
  }

  protected Spell CastSpell() {
    return null;
  }

  Door MakeDoor(Room r1, Room r2) {
    return new DoorNeedingSpell(r1, r2);
  }

  @Override
  public Maze makeMaze() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Wall makeWall() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Room makeRoom(int n) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public Door makeDoor(Room r1, Room r2) {
    // TODO Auto-generated method stub
    return null;
  }
}
