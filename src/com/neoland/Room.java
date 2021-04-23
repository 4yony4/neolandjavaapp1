package com.neoland;

public class Room {


    private Door doors[];
    private int iDoorsNumber;
    private int iExistingDoors;

    public Room(int iDoorsNumber){
        this.iDoorsNumber=iDoorsNumber;
        doors = new Door[iDoorsNumber];
        iExistingDoors=0;
    }

    public void addDoor(Door newDoor){
        doors[iExistingDoors]=newDoor;
        iExistingDoors=iExistingDoors+1;
    }

}
