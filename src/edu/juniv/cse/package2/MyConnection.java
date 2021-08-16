package edu.juniv.cse.package2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public static Connection getConnection()
    {


        Connection con = null;
        try
        {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaproject", "root", "");
        } catch (SQLException | ClassNotFoundException e)
        {
            System.out.println(e.getMessage());

        }

        return con;
    }


}
