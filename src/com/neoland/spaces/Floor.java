package com.neoland.spaces;

import com.neoland.materials.Door;

import java.util.Arrays;

public class Floor {

    private Room arRooms[];
    private int iNumberOfRooms;
    private int iExistingRooms;
    private double dPrice=0.0;

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

    public Door createNewDoor(Room room, double doorPrice){
        Door door=new Door(doorPrice);
        room.addDoor(door);
        return door;
    }

    public void removeDoor(Room room,Door door){
        room.removeDoor(door);
    }

    public void assignDoorToRoom(Room room,Door door){
        door.setBlShared(true);
        room.addDoor(door);
    }

    public double getdPrice(){
        calculateFloorPrice();
        return dPrice;
    }

    public void calculateFloorPrice(){
        dPrice=0.0;
        int i=0;
        for (i=0;i<iExistingRooms;i++){
            dPrice=dPrice+arRooms[i].getdPrice();
        }
    }

    public void destroy(){
        for (int i=0;i<arRooms.length;i++){
            arRooms[i].destroy();
            arRooms[i]=null;
        }
    }

    public Room[] getArRooms() {
        return arRooms;
    }

    public void setArRooms(Room[] arRooms) {
        this.arRooms = arRooms;
    }

    public int getiNumberOfRooms() {
        return iNumberOfRooms;
    }

    public void setiNumberOfRooms(int iNumberOfRooms) {
        this.iNumberOfRooms = iNumberOfRooms;
    }

    public int getiExistingRooms() {
        return iExistingRooms;
    }

    public void setiExistingRooms(int iExistingRooms) {
        this.iExistingRooms = iExistingRooms;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    @Override
    public String toString() {
        return "Floor{" +
                "arRooms=" + Arrays.toString(arRooms) +
                ", iNumberOfRooms=" + iNumberOfRooms +
                ", iExistingRooms=" + iExistingRooms +
                ", dPrice=" + dPrice +
                '}';
    }
}
