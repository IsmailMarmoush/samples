package com.marmoush.javasamples.designpatternsgof.creational.factorymethod;

import com.marmoush.javasamples.designpatternsgof.creational.abstractfactory.BombedWall;
import com.marmoush.javasamples.designpatternsgof.creational.abstractfactory.RoomWithABomb;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Room;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Wall;

class BombedMazeGame extends MazeGame {

  BombedMazeGame() {}

  Room MakeRoom(int n) {
    return new RoomWithABomb(n);
  }

  Wall MakeWall() {
    return new BombedWall();
  }
}
