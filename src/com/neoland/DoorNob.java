package com.neoland;

public class DoorNob {

    private String sColor;

    public DoorNob(){
        sColor="Silver";
    }

    public String getsColor() {
        return sColor;
    }

    public void setsColor(String sColor) {
        this.sColor = sColor;
        System.out.println("THE NEW COLOR FOR DOORNOB IS: "+this.sColor);
    }
}
