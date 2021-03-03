package com.marmoush.javasamples.designpatternsgof.originalmaze;

public class Room extends MapSite {
  private int roomNumber;
  private MapSite[] mapSite;

  public Room() {}

  public Room(int roomNumber) {
    this.setRoomNumber(roomNumber);
  }

  public MapSite getSide(Direction d) {
    return null;
  }

  public void setSide(Direction d, MapSite m) {}

  public int getRoomNumber() {
    return roomNumber;
  }

  public void setRoomNumber(int roomNumber) {
    this.roomNumber = roomNumber;
  }

  public MapSite[] getMapSite() {
    return mapSite;
  }

  public void setMapSite(MapSite[] mapSite) {
    this.mapSite = mapSite;
  }
}
