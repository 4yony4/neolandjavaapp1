package com.neoland.threads;

public class Process implements Runnable{

    private String sName="";
    public Process(String sName){
        this.sName=sName;
    }

    @Override
    public void run() {
        int i=0;
        while(i<10){
            System.out.println(this.sName+" "+getMeRandomBetween(10,100));
            i++;
        }
    }

    public int getMeRandomBetween(int min,int max){
        return min+(int)(Math.random()*(max-min));
    }



}
