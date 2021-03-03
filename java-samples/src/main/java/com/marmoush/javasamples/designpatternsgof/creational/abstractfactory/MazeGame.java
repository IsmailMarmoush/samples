package com.marmoush.javasamples.designpatternsgof.creational.abstractfactory;

import com.marmoush.javasamples.designpatternsgof.originalmaze.Direction;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Door;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Maze;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Room;

public class MazeGame {
  public static void main(String[] args) {
    /*
     * configuration: Read the configuration file If we want enchantedMazeFactory construct it and
     * pass it
     *
     * There can be a more abstraction through static build methods in factories
     */
    String config = "enchanted";
    MazeFactory mazeFactory = null;
    if (config.equals("enchanted"))
      mazeFactory = new EnchantedMazeFactory();
    else
      mazeFactory = new BombedMazeFactory();
    new MazeGame().createMaze(mazeFactory);
  }

  Maze createMaze(MazeFactory factory) {
    Maze aMaze = factory.makeMaze();
    Room r1 = factory.makeRoom(1);
    Room r2 = factory.makeRoom(2);
    Door aDoor = factory.makeDoor(r1, r2);
    aMaze.addRoom(r1);
    aMaze.addRoom(r2);
    r1.setSide(Direction.NORTH, factory.makeWall());
    r1.setSide(Direction.EAST, aDoor);
    r1.setSide(Direction.SOUTH, factory.makeWall());
    r1.setSide(Direction.WEST, factory.makeWall());
    r2.setSide(Direction.NORTH, factory.makeWall());
    r2.setSide(Direction.EAST, factory.makeWall());
    r2.setSide(Direction.SOUTH, factory.makeWall());
    r2.setSide(Direction.WEST, aDoor);
    return aMaze;
  }
}
