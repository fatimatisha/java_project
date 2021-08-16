package edu.juniv.cse.package1;

import java.sql.SQLException;

abstract public class Users {
      String userName,password;

    public Users(String userName, String password) {

        this.userName = userName;
        this.password = password;
    }


    public Users(String userName) {
        this.userName = userName;
    }

    public abstract boolean register();
    public abstract boolean login() ;

}
