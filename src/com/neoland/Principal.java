package com.neoland;

import com.neoland.dataclass.User;
import com.neoland.infraestructure.Property;
import com.neoland.materials.Door;
import com.neoland.model.DBAdmin;
import com.neoland.model.DBAdminListener;
import com.neoland.views.MainView;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.Consumer;

public class Principal implements DBAdminListener {

    static DBAdmin dbAdmin;
    static Consumer<Door> method = (door) -> {
        System.out.println(door.getsColor());
        System.out.println(door.getdPrice());
    };

    static Comparator<Door> doorComparator=(o1, o2) -> {

        if(o1.getdPrice()>o2.getdPrice()) {
            return 1;
        }
        else if(o1.getdPrice()<o2.getdPrice()){
            return -1;
        }
        return 0;
    };

    public static void main(String args[]){

        ArrayList<Door> numbers = new ArrayList<Door>();
        numbers.add(new Door(Math.random()*100));
        numbers.add(new Door(Math.random()*100));
        numbers.add(new Door(Math.random()*100));
        numbers.add(new Door(Math.random()*100));
        //numbers.forEach( method );

        //ArrayList<Door> numbers2 = new ArrayList<Door>();
        numbers.add(new Door(Math.random()*100));
        numbers.add(new Door(Math.random()*100));
        numbers.add(new Door(Math.random()*100));
        numbers.add(new Door(Math.random()*100));

        //numbers2.forEach( method );
        System.out.println("BEFORE THEY ARE SORTED: "+numbers);
        numbers.sort(doorComparator);
        System.out.println("AFTER THEY ARE SORTED: "+numbers);

        LocalDate myObj = LocalDate.now(); // Create a date object
        System.out.println(myObj); // Display the current date

        LocalTime myObj2 = LocalTime.now();
        System.out.println(myObj2);

        LocalDateTime myObj3 = LocalDateTime.now();
        System.out.println(myObj3);

        LocalDateTime myDateObj = LocalDateTime.now();
        System.out.println("Before formatting: " + myDateObj);
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("yyyy-dd-MM ss:HH:mm");

        String formattedDate = myDateObj.format(myFormatObj);
        System.out.println("After formatting: " + formattedDate);

        /*NameFunction nameFunction1= (str, str2, str3) -> {
            return str+str2+str3;
        };

        NameFunction nameFunction2= (str, str2, str3) -> {
            return str3+str2+str;
        };

        System.out.println(nameFunction1.run("one","two","three"));

        System.out.println(nameFunction2.run("one","two","three"));*/
        /*Door arDoor[]=new Door[10];



        int i=0;
        while(i<10){
            arDoor[i]=new Door(Math.random()*100);
        }

        System.out.println(arDoor);*/
        //MainView mainView=new MainView();
        /*Principal principal=new Principal();

        dbAdmin=new DBAdmin();


        MainView mainView=new MainView(dbAdmin);
        dbAdmin.addListener(principal);
        dbAdmin.initPostgresConnection();
        System.out.println("WELCOME TO PRINCIPAL APP");*/
        //Property property=dbAdmin.getPropertyByEIRCode("99999V");
        //System.out.println(property);


    }

    @Override
    public void conexionSuccess(boolean blSuccess) {
        System.out.println("LISTENER IS: Principal ----> THE CONEXION WAS: "+blSuccess);
        if(blSuccess==true){
            dbAdmin.getUserTable();
            //Property property=dbAdmin.getPropertyByEIRCode("99999V");
            //System.out.println(property);
        }
    }

    @Override
    public void dbResponseUsers(HashMap<String, User> mapUsers) {
        System.out.println("LISTENER IS: Principal ----> USERS ARE: "+mapUsers);
    }

    @Override
    public void dbResponseProperyElement(Property property) {
        System.out.println("PRINCIPAL LISTENER: ->> PROPERTY IS: "+property);
    }


    public static void mainV1(String args[]){
        //MainView mainView=new MainView();
        DBAdmin dbAdmin=new DBAdmin();
        //dbAdmin.getUserTable();
        //dbAdmin.insertUser(8,"GABRIEL");
        //dbAdmin.updateUsers(8,"HALLOWEEN");
        dbAdmin.getUserTable();

        /*System.out.println(mapUsers);

        User userTemp=mapUsers.get("7");

        System.out.println(userTemp);

        userTemp.iname="DAVE V3";

        User user1= dbAdmin.getUserByID("16");
        System.out.println(user1);*/
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
