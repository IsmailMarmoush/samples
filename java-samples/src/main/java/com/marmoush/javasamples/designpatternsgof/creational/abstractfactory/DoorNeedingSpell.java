package com.marmoush.javasamples.designpatternsgof.creational.abstractfactory;

import com.marmoush.javasamples.designpatternsgof.originalmaze.Door;
import com.marmoush.javasamples.designpatternsgof.originalmaze.Room;

public class DoorNeedingSpell extends Door {

  public DoorNeedingSpell(Room room1, Room room2) {
    super(room1, room2);
  }
}
