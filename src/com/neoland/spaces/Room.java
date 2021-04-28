package com.neoland.spaces;

import com.neoland.materials.Door;

import java.util.ArrayList;
import java.util.Arrays;

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

    public void removeDoor(Door oldDoor){
        //int iPosition=Arrays.binarySearch(doors,oldDoor);

        Door doorsDest[]=new Door[doors.length];
        int i=0;
        int j=0;
        for (i=0;i<doors.length;i++){
            if(doors[i]!=oldDoor){
                doorsDest[j]=doors[i];
                j++;
            }
            else{

            }
        }
        doors=doorsDest;
        iExistingDoors--;

        //ArrayList<Door> doorsNew=(ArrayList<Door>)Arrays.asList(doors);

        /*
        boolean blStop=false;
        int i=0;
        while(blStop==false && i<doors.length){
            if(doors[i]==oldDoor){
                blStop=true;
            }
            else{
                i++;
            }
        }

        if(blStop==true){
            System.out.println("POSTION OF THE DOOR IS: "+i);
            System.out.println("THE ARRAY NOW IS:"+Arrays.asList(doors));
            int j;
            if(i+1<doors.length) {
                for (j = (i + 1); j < doors.length; j++) {
                    doors[j - 1] = doors[j];
                }
            }
            else{
                doors[i]=null;
            }
            iExistingDoors--;
            System.out.println("THE ARRAY NOW IS:"+Arrays.asList(doors));
        }
        else{
            System.out.println("THERE IS NO DOOR OF THIS KIND IN THIS ROOM, I CANT REMOVE ANYTHING");
        }
        */

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

    @Override
    public String toString() {
        return "Room{" +
                "doors=" + Arrays.toString(doors) +
                ", iDoorsNumber=" + iDoorsNumber +
                ", iExistingDoors=" + iExistingDoors +
                ", dPrice=" + dPrice +
                '}';
    }

    public void destroy(){

    }
}
