package com.neoland.model;

import java.sql.*;
import java.util.Properties;

public class DBAdmin {

    private Connection conn;

    public DBAdmin(){

        try {
            //OPTION1 ADVANCED
            String url = "jdbc:postgresql://rogue.db.elephantsql.com/aaxmvslp";
            Properties props= new Properties();
            props.setProperty("user","aaxmvslp");
            props.setProperty("password","qg2UIHZnJqXKL8TUgmXEff1c38lNn11Q");
            props.setProperty("ssl","false");
            conn = DriverManager.getConnection(url, props);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //OPTION2 BASIC
        //String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
        //Connection conn = DriverManager.getConnection(url);
    }

    public void getUserTable(){
        try{
            Statement stmt= conn.createStatement();
            ResultSet resultSet=stmt.executeQuery("SELECT * FROM \"public\".\"users\"");

            while (resultSet.next()==true){
                int id=resultSet.getInt("id");
                String name=resultSet.getString("name");
                System.out.println("THE ROW IS: "+id+"  "+name);
            }

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }

    }

}
