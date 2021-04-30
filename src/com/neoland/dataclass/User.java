package com.neoland.dataclass;

public class User implements java.io.Serializable{

    //YOU HAVE TO HAVE THE SAME NAME FOR THE ATTRIBUTES AND COLUMNS!!!! THEY HAVE TO BE THE SAME, EVEN UPPER AND LOWER CASE
    public int iuser;
    public String iname;

    public User(int iuser,String iname){
        this.iuser=iuser;
        this.iname=iname;
    }

    @Override
    public String toString() {
        return "User{" +
                "iuser=" + iuser +
                ", iname='" + iname + '\'' +
                '}';
    }
}
