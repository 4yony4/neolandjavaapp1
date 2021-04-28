package com.neoland.infraestructure;

import com.neoland.spaces.Elevator;
import com.neoland.spaces.Floor;

public class Building extends Property{

    Elevator elevator;
    int iFloorsNumber;
    public Building(String sEirCode) {
        super(sEirCode);
        iFloorsNumber=0;
        elevator=new Elevator(20.0);
    }

    @Override
    public Floor addNewFloor(int iRoomNumber) {
        iFloorsNumber++;
        return super.addNewFloor(iRoomNumber);
    }

    @Override
    public double getdPrice() {
        double dPropertyPrice=super.getdPrice();
        return dPropertyPrice+(elevator.getdPrice()*iFloorsNumber);
    }
}
