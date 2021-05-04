package com.neoland;

import com.neoland.dataclass.User;
import com.neoland.infraestructure.Property;
import com.neoland.model.DBAdmin;
import com.neoland.views.MainView;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class Principal{



    public static void main(String args[]){

        //MainView mainView=new MainView();

        DBAdmin dbAdmin=new DBAdmin();
        Property property=dbAdmin.getPropertyByEIRCode("99999V");
        System.out.println(property);

    }



    public static void mainV1(String args[]){
        //MainView mainView=new MainView();
        DBAdmin dbAdmin=new DBAdmin();
        //dbAdmin.getUserTable();
        //dbAdmin.insertUser(8,"GABRIEL");
        //dbAdmin.updateUsers(8,"HALLOWEEN");
        HashMap<String, User> mapUsers = dbAdmin.getUserTable();

        System.out.println(mapUsers);

        User userTemp=mapUsers.get("7");

        System.out.println(userTemp);

        userTemp.iname="DAVE V3";

        User user1= dbAdmin.getUserByID("16");
        System.out.println(user1);
        //dbAdmin.updateUsers(userTemp);

        //System.out.println(userTemp);




        //Principal p=new Principal();
        //p.loadSerializableFromFile();
        //p.saveSerializableToFile(mapUsers);
    }

    private void saveSerializableToFile(HashMap<String, User> mapUsers){
        try{
            FileOutputStream fout=new FileOutputStream("f.txt");
            //ByteOutputStream bout=new ByteOutputStream();
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(mapUsers);
            out.flush();
            //closing the stream
            out.close();
            fout.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private HashMap<String, User> loadSerializableFromFile(){
        HashMap<String, User> users=null;
        try{
            //Creating stream to read the object
            FileInputStream fis=new FileInputStream("f.txt");
            ObjectInputStream in=new ObjectInputStream(fis);
            users=(HashMap<String, User>)in.readObject();
            //printing the data of the serialized object
            System.out.println(users);
            //closing the stream
            in.close();
            fis.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return users;
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
