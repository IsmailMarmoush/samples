package com.marmoush.javasamples.designpatternsgof.creational.builder;

import com.marmoush.javasamples.designpatternsgof.originalmaze.Maze;

public class MazeGame {
  public static void main(String[] args) {
    Maze maze = null;
    MazeGame game = new MazeGame();
    StandardMazeBuilder builder = new StandardMazeBuilder();
    game.createMaze(builder);
    maze = builder.getMaze();
  }

  Maze createMaze(MazeBuilder builder) {
    builder.buildMaze();
    builder.buildRoom(1);
    builder.buildRoom(2);
    builder.buildDoor(1, 2);
    return builder.getMaze();
  }

  Maze createComplexMaze(MazeBuilder builder) {
    builder.buildRoom(1);
    // ...
    builder.buildRoom(1001);
    return builder.getMaze();
  }
}
