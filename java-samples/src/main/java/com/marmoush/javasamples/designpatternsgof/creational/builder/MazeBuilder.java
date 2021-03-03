package com.marmoush.javasamples.designpatternsgof.creational.builder;

import com.marmoush.javasamples.designpatternsgof.originalmaze.Maze;

interface MazeBuilder {
  public void buildMaze();

  void buildRoom(int room);

  void buildDoor(int roomFrom, int roomTo);

  Maze getMaze();
}
