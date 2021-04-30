package com.neoland;

import com.neoland.dataclass.User;
import com.neoland.model.DBAdmin;

import java.util.ArrayList;
import java.util.HashMap;

public class Principal{


    public static void main(String args[]){
        //MainView mainView=new MainView();
        DBAdmin dbAdmin=new DBAdmin();
        //dbAdmin.getUserTable();
        //dbAdmin.insertUser(8,"GABRIEL");
        //dbAdmin.updateUsers(8,"HALLOWEEN");
        HashMap<String, User> mapUsers = dbAdmin.getUserTable();
        User userTemp=mapUsers.get("7");

        System.out.println(userTemp);

        userTemp.iname="DAVE V3";

        //dbAdmin.updateUsers(userTemp);

        System.out.println(userTemp);




        //new Principal();
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
