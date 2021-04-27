package com.neoland;

public class Complex extends Property{

    DriveWay driveWay;

    public Complex(String sEirCode) {
        super(sEirCode);
        driveWay=new DriveWay(100);
    }


    @Override
    public double getdPrice() {
        return super.getdPrice()+driveWay.dPrice;
    }
}
