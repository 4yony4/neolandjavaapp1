package com.neoland;

import java.util.ArrayList;

public class Property {

    private String sEirCode;
    private String sCounty;
    private String sTown;
    private String sStreet;
    private double dSurface;
    private double dPrice;

    private ArrayList<Floor> arFloors;

    public Property(String sEirCode){
        this.sEirCode=sEirCode;
        arFloors=new ArrayList<Floor>();
        dPrice=0.0;
    }

    public Floor addNewFloor(int iRoomNumber){
        Floor floor=new Floor(iRoomNumber);
        arFloors.add(floor);
        return floor;
    }

    public void removeFloor(Floor floor){
        arFloors.remove(floor);
    }

    public double getdPrice() {
        calculatePrice();

        return dPrice;
    }

    private double calculatePrice(){
        dPrice=0.0;
        int i=0;
        for (i=0;i<arFloors.size();i++){
            Floor floor=arFloors.get(i);
            dPrice=dPrice+floor.getdPrice();
        }
        return dPrice;
    }
}
