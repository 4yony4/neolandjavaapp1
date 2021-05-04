package com.neoland;

import com.neoland.threads.Car;
import com.neoland.threads.Process;
import com.neoland.threads.ZebraCrossing;

public class MainThreads {

    public static void main(String args[]){

        /*Process process =new Process("Process1");
        Process process2 =new Process("Process2");
        Thread thread=new Thread(process);
        Thread thread2=new Thread(process2);
        thread.start();
        thread2.start();*/
        ZebraCrossing zebraCrossing=new ZebraCrossing();
        int i=0;
        while(i<10){
            Car car=new Car("Car"+i,zebraCrossing);
            Thread thread=new Thread(car);
            thread.start();
            i++;
        }


    }


}
