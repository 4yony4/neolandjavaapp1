package com.neoland.threads;

public class ZebraCrossing {

    private String sCrossingCarName;

    public ZebraCrossing(){

    }

    synchronized public void setsCrossingCarName(String sCrossingCarName){
        try{
            this.sCrossingCarName=sCrossingCarName;

            System.out.println("THE CAR: "+this.sCrossingCarName+" IS CROSSING NOW");

            wait(5000);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
