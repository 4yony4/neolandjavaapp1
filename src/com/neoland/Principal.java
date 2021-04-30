package com.neoland;

import com.neoland.model.DBAdmin;

public class Principal{


    public static void main(String args[]){
        //MainView mainView=new MainView();
        DBAdmin dbAdmin=new DBAdmin();
        dbAdmin.getUserTable();
        dbAdmin.insertUser(8,"GABRIEL");
        dbAdmin.getUserTable();

        new Principal();
    }

    public Principal(){
        System.out.println(mathSum(5,10));
        System.out.println(mathSum(13.5,22.78));
        System.out.println(mathSum("13.5","22.78"));
    }

    public int mathSum(int a, int b){
        return a+b;
    }

    public double mathSum(double a, double b){
        return a+b;
    }

    public double mathSum(String a, String b){
        return Double.parseDouble(a)+Double.parseDouble(b);
    }

}
