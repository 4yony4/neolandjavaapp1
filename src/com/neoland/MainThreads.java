package com.neoland;

import com.neoland.threads.*;
import com.neoland.threads.Process;
import com.neoland.views.MainView;

public class MainThreads {

    public static void mainV1(String[] args)
    {
        PrinterQueue printerQueue = new PrinterQueue();
        Thread thread[] = new Thread[10];
        for (int i = 0; i < 10; i++)
        {
            PrintingJob printingJob=new PrintingJob(printerQueue);
            thread[i] = new Thread(printingJob, "Thread " + i);
        }
        for (int i = 0; i < 10; i++)
        {
            thread[i].start();
        }
    }

    public static void main(String args[]){

        /*Process process =new Process("Process1");
        Process process2 =new Process("Process2");
        Thread thread=new Thread(process);
        Thread thread2=new Thread(process2);
        thread.start();
        thread2.start();*/
        Thread thread[] = new Thread[10];
        ZebraCrossing zebraCrossing=new ZebraCrossing();
        int i=0;
        while(i<10){
            Car car=new Car("Car"+i,zebraCrossing);
            thread[i]=new Thread(car);
            i++;
        }
        i=0;
        while(i<10){
            thread[i].start();
            i++;
        }


        /*i=0;
        while(i<10){
            try{
                thread[i].join();
            }catch(Exception e){
                e.printStackTrace();
            }
            i++;
        }*/

        //MainView mainView=new MainView();

        //System.out.println("------->>>>>>>FINISHED THE MAIN PROCESS APP");
    }


}
