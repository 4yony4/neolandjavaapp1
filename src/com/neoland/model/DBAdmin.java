package com.neoland.model;

import com.neoland.dataclass.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class DBAdmin {

    private Connection conn;

    public DBAdmin(){
        initPostgresConnection();
        //initAS400Connection();

    }

    public void initPostgresConnection(){
        try {

            //OPTION1 ADVANCED
            String url = "jdbc:postgresql://rogue.db.elephantsql.com/aaxmvslp";
            Properties props= new Properties();
            props.setProperty("user","aaxmvslp");
            props.setProperty("password","qg2UIHZnJqXKL8TUgmXEff1c38lNn11Q");
            props.setProperty("ssl","false");
            conn = DriverManager.getConnection(url, props);
            //jdbc:db2://dashdb-txn-sbox-yp-lon02-13.services.eu-gb.bluemix.net:50001/BLUDB:user=rwq82195;password=<your_password>;sslConnection=true;

            /*String url = "jdbc:db2://dashdb-txn-sbox-yp-lon02-13.services.eu-gb.bluemix.net:50000/BLUDB:user=rwq82195;password=ClassDB2021";
            conn = DriverManager.getConnection(url);*/

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        //OPTION2 BASIC
        //String url = "jdbc:postgresql://localhost/test?user=fred&password=secret&ssl=true";
        //Connection conn = DriverManager.getConnection(url);
    }

    public void initAS400Connection(String user,String Password){
        try {

            //OPTION1 ADVANCED
            String url = "jdbc:as400://hfi_dev;TGLCQA";
            Properties props = new Properties();

            System.out.println("Trying to Connect to DB2......");

            Class.forName("com.ibm.as400.access.AS400JDBCDriver");
            conn = DriverManager.getConnection(url, user, Password);
            System.out.println("Connected to DB2...Hurray");

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public HashMap<String,User> getUserTable(){
        HashMap<String,User> mapUsers=new HashMap();
        try{
            Statement stmt= conn.createStatement();
            ResultSet resultSet=stmt.executeQuery("SELECT * FROM \"public\".\"users\"");
            boolean blHasNext=resultSet.next();
            while (blHasNext==true){
                int id=resultSet.getInt("iuser");
                String name=resultSet.getString("iname");

                User user=new User(id,name);
                mapUsers.put(user.iuser+"",user);
                //arUsers.add(user);
                //System.out.println("THE ROW IS: "+user.iuser+"  "+ user.iname);
                blHasNext=resultSet.next();
            }
            resultSet.close();
            stmt.close();
            //System.out.println(arUsers);
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return mapUsers;
    }

    public void insertUser(int id,String name){
        try{
            //OPTION 1 FOR INSERT QUERY CREATION
            //Statement stmt= conn.createStatement();


            //String sQuery="INSERT INTO users(iuser,iname) VALUES("+id+",'"+name+"')";
            //System.out.println(sQuery);

            //OPTION 2 FOR INSERT QUERY CREATION
            // the mysql insert statement
            String sQuery = "insert into users (iuser,iname) values (?, ?)";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(sQuery);
            preparedStmt.setInt (1, id);
            preparedStmt.setString (2, name);
            System.out.println(preparedStmt);

            preparedStmt.execute();
            preparedStmt.close();

        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateUsers(User user){
        try{
            String sQuery = "update users set iname=? where iuser=?";

            // create the mysql insert preparedstatement
            PreparedStatement preparedStmt = conn.prepareStatement(sQuery);
            preparedStmt.setString (1, user.iname);
            preparedStmt.setInt (2, user.iuser);
            System.out.println(preparedStmt);

            boolean blExecuteOK=preparedStmt.execute();
            preparedStmt.close();
        }catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void destroy(){
        try{
            conn.close();
        }catch (SQLException e){
            e.printStackTrace();
        }

    }

}
