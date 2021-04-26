package com.neoland;

public class Floor {

    private Room arRooms[];
    private int iNumberOfRooms;
    private int iExistingRooms;

    public Floor(int iNumberOfRooms){
        this.iNumberOfRooms=iNumberOfRooms;
        arRooms=new Room[iNumberOfRooms];
        iExistingRooms=0;
    }

    public Room createNewRoom(int iDoors){
        Room room=new Room(iDoors);
        arRooms[iExistingRooms]=room;
        iExistingRooms++;//SAME AS iExistingRooms=iExistingRooms+1
        return room;
    }

    public Door createNewDoor(Room room,double doorPrice){
        Door door=new Door(doorPrice);
        room.addDoor(door);
        return door;
    }

    public void assignDoorToRoom(Room room,Door door){
        room.addDoor(door);
    }

}
