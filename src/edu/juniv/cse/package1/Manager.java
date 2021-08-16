package edu.juniv.cse.package1;


import edu.juniv.cse.package2.MyConnection;
import edu.juniv.cse.package3.Bill;
import edu.juniv.cse.package3.Menu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;

public class Manager extends Users {
    private String name;
    private String email;
    private String mobile;

    public Manager(String userName, String password, String name, String email, String mobile) {
        super(userName, password);
        this.name = name;
        this.email = email;
        this.mobile = mobile;
    }

    public Manager(String userName, String password) {
        super(userName, password);
    }



    @Override
    public boolean register() {
        boolean registered = false;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Connection connection = MyConnection.getConnection();
        String query = "select * from manager where man_username=? or man_password=? ";
        try {
            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, this.userName);
            preparedStatement.setString(2, this.password);
            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("invalid username/password");
            } else {
                query = "INSERT INTO manager VALUES (?,?,?,?,?)";
                preparedStatement = MyConnection.getConnection().prepareStatement(query);

                preparedStatement.setString(1, userName);
                preparedStatement.setString(2, password);

                preparedStatement.setString(3, name);
                preparedStatement.setString(4, email);
                preparedStatement.setString(5, mobile);

                if (preparedStatement.executeUpdate() > 0) {
                    registered = true;
                    System.out.println("Successfully Sign up");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return registered;
    }

    @Override
    public boolean login() {
        boolean loggedIn = false;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String query = "SELECT * FROM manager WHERE man_username=? AND  man_password=?";
        try {
            preparedStatement = MyConnection.getConnection().prepareStatement(query);

            preparedStatement.setString(1, userName);
            preparedStatement.setString(2, password);

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {

                loggedIn = true;
                System.out.println("Successfully Logged In");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loggedIn;
    }

    public void viewCustomer() {
        try {
            Connection connection = MyConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM customer");
            while (resultSet.next()) {
                System.out.println(resultSet.getString(1) + "  " + resultSet.getString(2) + "  " +
                        resultSet.getInt(3) + "  " + resultSet.getString(4) + "  " + resultSet.getString(5) + " " + resultSet.getString(6));
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }
   /* public static void main(String[] args) {
        Manager obj3=new Manager("kamal","234536","Kamal","01978667456");

        boolean ans=obj3.register();
        System.out.println(ans);
        if(ans==true)
        {
            System.out.println("signed up");
        }

       /*Menu obj=new Menu(2,"Chocolate Milkshake","Drinks");
         Menu obj2=new Menu(1);
       obj2.deleteItem();
       Bill obj=new Bill(1);
       obj.totalBill(4);
    }*/

}
