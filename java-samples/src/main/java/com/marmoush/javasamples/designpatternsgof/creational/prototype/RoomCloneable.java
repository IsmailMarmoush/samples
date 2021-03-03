package com.marmoush.javasamples.designpatternsgof.creational.prototype;

import com.marmoush.javasamples.designpatternsgof.originalmaze.Room;

public class RoomCloneable extends Room implements Cloneable {
  public RoomCloneable() {}

  /*
   * Copy constructor
   *
   * @param room
   */
  public RoomCloneable(RoomCloneable room) {
    this.setRoomNumber(room.getRoomNumber());
    // ... deep or shallow copy
  }

  void init(int roomNumber) {
    this.setRoomNumber(roomNumber);
  }

  @Override
  public Object clone() {
    Object clone = null;
    try {
      clone = super.clone();
    } catch (CloneNotSupportedException e) {
      e.printStackTrace();
    }
    return clone;
  }
}
