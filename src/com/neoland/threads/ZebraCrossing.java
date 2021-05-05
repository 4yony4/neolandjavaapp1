package com.neoland.threads;

import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ZebraCrossing {

    private final Lock queueLock = new ReentrantLock();
    private String sCrossingCarName;

    public ZebraCrossing(){

    }

    public void setsCrossingCarName(String sCrossingCarName){
        //ALL THE THREADS WILL BE BLOCKED, EXCEPT 1
        queueLock.lock();
        try
        {
            Long duration = (long) (Math.random() * 10000);//RANDOM RETURNS A DOUBLE BETWEEN 0 and 0.999
            System.out.println(sCrossingCarName + ": CROSSING:  ITS GOING TO TAKE THE CAR: " +
                    (duration / 1000) + " seconds :: Time - " + new Date());
            Thread.sleep(duration);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            //System.out.println("CAR: "+sCrossingCarName+" JUST FINISHED CROSSING");
            queueLock.unlock();
        }
    }

}
