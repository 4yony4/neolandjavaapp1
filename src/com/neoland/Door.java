package com.neoland;

public class Door {
    //CLASS VARIABLES ARE ATTRIBUTES
    private String sColor;//THIS REPRESENTS THE COLOR OF THE COMPLETE DOOR
    double dHeight;
    double dWidth;
    int iDoorNobType;//The type exists in a different catalog list.
    private boolean blHasWindowPane;
    private double dPrice;
    private DoorNob doorNob;


    /**
     * CONSTRUCTOR
     */
    public Door(double dPrice){
        this.dPrice=dPrice;
        this.downloadData();
        this.doorNob=new DoorNob();
    }


    public void setDoorNobColor(String sColor){
        this.doorNob.setsColor(sColor);
        this.dPrice=this.dPrice+5;
    }

    public void downloadData(){
        this.sColor="White";
        this.dHeight=1.5;
        this.dWidth=1.0;
        this.iDoorNobType=303;
        this.blHasWindowPane=false;
    }

    public void setdHeight(double dHeight) {
        this.dHeight = dHeight;
    }

    /**
     * This method defines the color of the door, it will add a cost of 2.0 to each color change.
     * @param sNewColor The color you want to assign to the door.
     */
    public void setsColor(String sNewColor){
        sColor=sNewColor;
        dPrice=dPrice+2.0;
    }

    public void setBlHasWindowPane(boolean blPane){

        if(blPane==true && blHasWindowPane==false){
            dPrice=dPrice+5.0;
            blHasWindowPane=blPane;
        }
        else if(blPane==false && blHasWindowPane==true){
            dPrice=dPrice-5.0;
            blHasWindowPane=blPane;
        }

    }

    public String getsColor(){
        return sColor;
    }

    public double getdHeight() {
        return dHeight;
    }

    public double getdWidth() {
        return dWidth;
    }

    public int getiDoorNobType() {
        return iDoorNobType;
    }

    public boolean isBlHasWindowPane() {
        return blHasWindowPane;
    }

    public double getdPrice() {
        return dPrice;
    }


}
