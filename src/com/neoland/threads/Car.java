package com.neoland.threads;

public class Car implements Runnable{

    private int I_WAITING=0;
    private int I_PASSING=1;
    private int I_CROSSED=2;

    private String sName;
    private int iState;

    ZebraCrossing zebraCrossing;

    public Car(String sName,ZebraCrossing zebraCrossing){
        this.sName=sName;
        this.zebraCrossing=zebraCrossing;
        iState=I_WAITING;
    }

    @Override
    public void run() {
        while(iState!=I_CROSSED){
            if(iState==I_WAITING){
                System.out.println(sName+" IS ATTEMPTING TO CROSS");
                zebraCrossing.setsCrossingCarName(sName);
                iState=I_CROSSED;
            }

        }
        System.out.println("THE CAR: "+sName+" FINISHED CROSSING");
    }
}
