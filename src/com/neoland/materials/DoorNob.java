package com.neoland.materials;

import com.neoland.singleton.DataHolder;

public class DoorNob {

    private String sColor;
    private double dPrice;

    public DoorNob(double dPrice){
        this.dPrice=dPrice+ DataHolder.dECO_TAX;
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
