package com.neoland;

public class Main {

    public static void main(String args[]){
        int x=5;
        int y=10;
        int z=x;

        Room roomLiving=new Room(3);
        Room roomKitchen=new Room(1);

        Door doorRoomLiving1=new Door(20.0);
        Door doorRoomLiving2=new Door(10.0);

        Door doorRoomKitchen1=new Door(40.0);//20Kbytes in RAM
        //Door testDoor=doorRoomKitchen1;//NOT CLONNING THE DOOR, JUST ADDING A NEW REFERENCE TO THE SAME DOOR
        //System.out.println(testDoor+"    "+doorRoomKitchen1+"    "+doorRoomLiving1);

        roomLiving.addDoor(doorRoomLiving1);
        roomLiving.addDoor(doorRoomLiving2);
        roomLiving.addDoor(doorRoomKitchen1);

        roomKitchen.addDoor(doorRoomKitchen1);

        doorRoomLiving1.setsColor("RED");
        doorRoomLiving1.setsColor("BLUE");
        doorRoomLiving1.setsColor("PINK");

        doorRoomKitchen1.setsColor("YELLOW");

        System.out.println("PRICE OF LIVING ROOM: "+roomLiving.getdPrice());
        System.out.println("PRICE OF KITCHEN ROOM: "+roomKitchen.getdPrice());

        /*
        Door doorRoom1=new Door(20.0);//Creating a new object Door based on the Door class Template
        Door doorRoom2=new Door(30.0);

        doorRoom1.setDoorNobColor("Gold");
        doorRoom2.setDoorNobColor("Bronze");

        System.out.println("COLOR OF DOOR1 IS: "+doorRoom1.getsColor());
        System.out.println("PRICE OF DOOR1 IS: "+doorRoom1.getdPrice());
        //System.out.println("COLOR OF DOOR2 IS: "+doorRoom2.getsColor());
        System.out.println("WINDOW PANE OF DOOR2 IS: "+doorRoom1.isBlHasWindowPane());

        doorRoom1.setsColor("RED");
        doorRoom1.setBlHasWindowPane(true);
        doorRoom2.setsColor("YELLOW");


        System.out.println("COLOR OF DOOR1 IS: "+doorRoom1.getsColor());
        System.out.println("PRICE OF DOOR1 IS: "+doorRoom1.getdPrice());
        //System.out.println("COLOR OF DOOR2 IS: "+doorRoom2.getsColor());
        System.out.println("WINDOW PANE OF DOOR2 IS: "+doorRoom1.isBlHasWindowPane());
         */
    }

}
