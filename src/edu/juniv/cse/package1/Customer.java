package edu.juniv.cse.package1;

import edu.juniv.cse.package2.MyConnection;
import edu.juniv.cse.package3.Menu;
import java.sql.*;

public class Customer extends Users {


    private int id;
    private String name;
    private String email;
    private String mobile;


    public Customer(String userName, String password, int id, String name,String email, String mobile) {
        super(userName, password);
        this.id = id;
        this.name = name;
        this.email = email;
        this.mobile = mobile;

    }

    public Customer(String userName)
    {
        super(userName);
    }
    public Customer(String userName, String password) {
        super(userName, password);
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getUsername(){return userName;}

    public String getMobile(){return mobile;}

    @Override
    public boolean register()
    {
        boolean registered=false;
        PreparedStatement preparedStatement=null;
        ResultSet resultSet=null;
        Connection connection= MyConnection.getConnection();
        String query="select * from customer where cus_username=? and cus_password=?";
        try {
                preparedStatement=connection.prepareStatement(query);
                preparedStatement.setString(1,userName);
                preparedStatement.setString(2,password);
                resultSet=preparedStatement.executeQuery();
              if(resultSet.next())
                {
                    System.out.println("This username/password has already used");
                }
              else
              {
                  query = "INSERT INTO customer VALUES (?,?,?,?,?,?)";
                  preparedStatement = MyConnection.getConnection().prepareStatement(query);

                  preparedStatement.setString(1, this.userName);
                  preparedStatement.setString(2, this.password);
                  preparedStatement.setInt(3, this.id);
                  preparedStatement.setString(4, this.name);
                  preparedStatement.setString(5, this.email);
                  preparedStatement.setString(6, this.mobile);
                 // preparedStatement.setString(6, this.order);

                  if (preparedStatement.executeUpdate() > 0)
                  {
                      registered = true;
                      System.out.println("Successfully Sign Up");
                  }
                  else
                  {
                      System.out.println("Invalid username/password\nTry again");
                  }
              }

        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return registered;
    }

    @Override
    public boolean login() {

        boolean loggedIn = false;
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String query = "SELECT * FROM customer WHERE cus_username=? AND  cus_password=?";
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
    public static int getNoCustomers()
    {
        int count = 0;
        try
        {

            Connection connection=MyConnection.getConnection();
            Statement statement=connection.createStatement();
            //PreparedStatement statement = connection.prepareStatement();
            ResultSet rs = statement.executeQuery("SELECT count(*) FROM customer");
            if (rs.next())
            {
                count = rs.getInt("count(*)");
                System.out.println("number of customer "+count);
            }
        } catch (SQLException ex)
        {
          ex.printStackTrace();
        }
        return count;

    }

   /* public static void main(String[] args) {

        Customer obj=new Customer("rupak","12645",6,"Rupak","rupak@gmail.com","01749284652");

        boolean ans=obj.register();
        System.out.println(ans);
        Customer obj2=new Customer("xyz","45");
        boolean ans2=obj2.login();
        System.out.println(ans2);
        if(ans2==true)
        {
            System.out.println("successfully logged in");
        }
       Customer obj=new Menu();
        obj.register();
    }*/
}