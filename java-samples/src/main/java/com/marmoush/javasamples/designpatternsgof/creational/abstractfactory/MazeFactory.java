package com.marmoush.javasamples.designpatternsgof.creational.abstractfactory;

import com.marmoush.javasamples.designpatternsgof.originalmaze.Door;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Maze;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Room;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Wall;

interface MazeFactory {

  public Maze makeMaze();

  Wall makeWall();

  Room makeRoom(int n);

  Door makeDoor(Room r1, Room r2);
}
