package com.neoland.infraestructure;

import com.neoland.spaces.DriveWay;

public class Complex extends Property{

    public DriveWay driveWay;

    public Complex(String sEirCode) {
        super(sEirCode);
        driveWay=new DriveWay(100);
    }


    @Override
    public double getdPrice() {
        return super.getdPrice()+driveWay.dPrice;
    }
}
