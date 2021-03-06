package com.neoland.infraestructure;

import com.neoland.spaces.Floor;

import java.util.ArrayList;

public class Property extends Object {

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

    public String getsEirCode() {
        return sEirCode;
    }

    public String getsCounty() {
        return sCounty;
    }

    public String getsTown() {
        return sTown;
    }

    public String getsStreet() {
        return sStreet;
    }

    public double getdSurface() {
        return dSurface;
    }

    public ArrayList<Floor> getArFloors() {
        return arFloors;
    }

    public void setsEirCode(String sEirCode) {
        this.sEirCode = sEirCode;
    }

    public void setsCounty(String sCounty) {
        this.sCounty = sCounty;
    }

    public void setsTown(String sTown) {
        this.sTown = sTown;
    }

    public void setsStreet(String sStreet) {
        this.sStreet = sStreet;
    }

    public void setdSurface(double dSurface) {
        this.dSurface = dSurface;
    }

    public void setdPrice(double dPrice) {
        this.dPrice = dPrice;
    }

    public void setArFloors(ArrayList<Floor> arFloors) {
        this.arFloors = arFloors;
    }

    @Override
    public String toString() {
        return "Property{" +
                "sEirCode='" + sEirCode + '\'' +
                ", sCounty='" + sCounty + '\'' +
                ", sTown='" + sTown + '\'' +
                ", sStreet='" + sStreet + '\'' +
                ", dSurface=" + dSurface +
                ", dPrice=" + dPrice +
                ", arFloors=" + arFloors +
                '}';
    }
}
