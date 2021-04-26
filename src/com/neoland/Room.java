package com.neoland;

public class Room {


    private Door doors[];
    private int iDoorsNumber;
    private int iExistingDoors;
    private double dPrice;


    /**
     * Constructor of the Room, will require a predefined number of doors you want in the room
     * @param iDoorsNumber Number of doors in the room (holes for doors).
     */
    public Room(int iDoorsNumber){
        this.iDoorsNumber=iDoorsNumber;
        doors = new Door[iDoorsNumber];
        iExistingDoors=0;
        dPrice=0;
    }

    public void addDoor(Door newDoor){
        doors[iExistingDoors]=newDoor;
        iExistingDoors=iExistingDoors+1;
    }

    /**
     * This function will compute the total price of the room, based on the sum of all the doors, windows, etc. in it.
     * @return a double with the value of dPrice.
     */
    public double getdPrice(){
        calculatePrice();
        return dPrice;
    }

    private void calculatePrice(){
        dPrice=0.0;
        int i=0;
        for (i=0;i<iExistingDoors;i++){
            dPrice=dPrice+doors[i].getdPrice();
        }

    }

}
