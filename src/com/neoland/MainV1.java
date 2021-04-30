package com.neoland;


import java.util.Scanner;

/**
 * MY MAIN CLASS
 * @version 1.0
 * @author Yony44
 * @since 22/04/2021
 */
public class MainV1 {

    private Double dHeight=1.84;    //dHeight represents the height of Main
    final static int iAge=19;       //iAge the age of the user
    static char cLetter='Y';
    public static final String sHairColor="Black";
    private final String sEyeColor="Black";
    protected static final int iFingers=20;
    public static final int PAGE_ERROR=3030;

    static int iHoleNumber=10;
    static int iDecimal=33333;

    //private vs protected vs public
    //private --> variable that can be accessed only in the context of the class it exists in
    //protected--> stops the developer from changing the value of the variable outside the class
    //public --> opens the variable for change and access from anywhere in the application

    //static--> app global variable.
    //final--> locks the value of the variable forever.


    /**
     *
     * @param args
     */
    public static void mainV1(String[] args) {
       int iMenuOptionSelected=-1;
       while(iMenuOptionSelected!=3){
           iMenuOptionSelected=menu();
           if(iMenuOptionSelected==1){
               //System.out.println("LETS ADD THE NUMBERS");
               double dResult=addNumbers();
               System.out.println("RESULT: "+dResult);
           }
           else if(iMenuOptionSelected==2){
               Scanner scanner = new Scanner(System.in);
               System.out.println("Please input first number:");
               double dNum1=scanner.nextDouble();
               System.out.println("Please input second number:");
               double dNum2=scanner.nextDouble();
               double dResult=powerOf(dNum1,dNum2);
               System.out.println("RESULT: "+dResult);
           }
           else if(iMenuOptionSelected==3){
               System.out.println("GOODBYE");
           }
       }
       System.gc();
    }

    /**
     * menu function, it will show the menu to the user (in the console), and ask
     * him to choose an option, represented in a number, which will be returned to the
     * calling function.
     * @return returns the menu choice in number format.
     */
    private static int menu(){
        System.out.println("WELCOME TO THE SUPER CALCULATOR. " +
                "PLEASE CHOOSE AN OPTION AND THEN PRESS ENTER");

        System.out.println("1. Add 2 numbers");
        System.out.println("2. Number power of a Number");
        System.out.println("3. Exit");
        Scanner scanner = new Scanner(System.in);
        String sInputLine= scanner.nextLine();
        int iMenuOption=Integer.parseInt(sInputLine);
        return iMenuOption;
    }
    private static double addNumbers(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please input first number:");
        double dNum1=scanner.nextDouble();
        System.out.println("Please input second number:");
        double dNum2=scanner.nextDouble();
        double dResult=dNum1+dNum2;
        return dResult;
    }
    private static double powerOf(double x, double y){

        double dResult=Math.pow(x,y);
        return dResult;
    }

    /**
     * This function will be responsible of calculating the area between 2 parameters (x and y)
     * @param x one side of the area
     * @param y second side of the area
     * @return the area value
     */
    public static double cube(double x,double y){
        double dArea=x*y;
        return dArea;
    }
}



    //OLD CODE
    // write your code here
    //iFingers
    //String sMyFingers="NUMBER OF FINGERS: "+iFingers;
    //System.out.println(iAge%iHoleNumber);//19%10
    //19/10---> 16+3 -->(16+2+1)/(8+2)

    //== EQUAL COMPARISON, != NOT EQUAL, ! NOT, >, <, >=, <=
    //&& = AND, || = OR
        /*int i=0;
        int iSum=0;//THE SUM OF ALL NUMBERS BETWEEN 0 AND 20
        boolean blKeepGoing=true;

        while(blKeepGoing==true){//same as !blEnd, blEnd==false
            iSum=iSum+i;
            if(iSum>100)blKeepGoing=false;
            i++;
        }
        System.out.println(" SUM: "+iSum);

        i=0;
        iSum=0;
        blKeepGoing=true;
        do {
            iSum=iSum+i;
            if(iSum>100)blKeepGoing=false;
            i++;
        }while(blKeepGoing);
        System.out.println(" SUM: "+iSum);*/

        /*
        for (i=4;i>=0;i--){//
            sum=sum+i;
            System.out.println("I: "+i+" SUM: "+sum);
        }
        System.out.println(" SUM: "+sum);*/

        /*int num1=14;

        if(num1>10 && num1%2==0){
            System.out.println("EVEN AND LARGER THAN 10");
        }
        else if(num1<10 && num1%2==0){
            System.out.println("EVEN AND SMALLER THAN 10");
        }
        else if(num1%2==1){
            System.out.println("ODD");
        }*/

