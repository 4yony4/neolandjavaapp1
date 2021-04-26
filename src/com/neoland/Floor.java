package com.neoland;

public class Floor {

    private Room arRooms[];
    private int iNumberOfRooms;

    public Floor(int iNumberOfRooms){
        this.iNumberOfRooms=iNumberOfRooms;
        arRooms=new Room[iNumberOfRooms];
    }

}
