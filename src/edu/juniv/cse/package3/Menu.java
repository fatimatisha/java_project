package edu.juniv.cse.package3;

import edu.juniv.cse.package2.MyConnection;

import java.sql.*;

public class Menu {
   private int Id;
   private String itemName;
   private int price;
   private int availableQ;
   private String category;
   private String isAvailable;

    public Menu(int id, String itemName, int price, int availableQ, String category, String isAvailable) {
        Id = id;
        this.itemName = itemName;
        this.price = price;
        this.availableQ = availableQ;
        this.category = category;
        this.isAvailable = isAvailable;
    }

    public Menu(int id) {
        Id = id;
    }

    public Menu(int id, int availableQ) {
        Id = id;
        this.availableQ = availableQ;
    }

    public Menu() {

    }

    public int getitemId() {
        return Id;
    }

    public String getItemName() {
        return itemName;
    }

    public String getCategory() {
        return category;
    }

     public void insertItem()
    {
        PreparedStatement preparedStatement;
        String query = "insert into item values(?,?,?,?,?)";
        try {
            preparedStatement = MyConnection.getConnection().prepareStatement(query);

            preparedStatement.setInt(1,Id);
            preparedStatement.setString(2,itemName);
            preparedStatement.setInt(3,price);
            preparedStatement.setInt(4,availableQ);
            preparedStatement.setString(5,category);
            preparedStatement.setString(6,isAvailable);

            int i = preparedStatement.executeUpdate();
            if (i!=0) {
                System.out.println("item inserted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void deleteItem()
    {
        PreparedStatement preparedStatement;
        String query = "delete from item where item_id=?";
        try {
            preparedStatement = MyConnection.getConnection().prepareStatement(query);


            preparedStatement.setInt(1,Id);
            int i = preparedStatement.executeUpdate();
            if (i!=0) {
                System.out.println("item deleted successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void updateQuantity()
    {
        PreparedStatement preparedStatement;
        String query = "update item set available_unit=? where item_id=?";
        try {
            preparedStatement = MyConnection.getConnection().prepareStatement(query);

            preparedStatement.setInt(1,availableQ);
            preparedStatement.setInt(2,Id);
            int i = preparedStatement.executeUpdate();
            if (i!=0) {
                System.out.println("item quantity updated successfully");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void veiwItem()
    {
        try {
            Connection connection=MyConnection.getConnection();
            Statement statement=connection.createStatement();
            ResultSet resultSet=statement.executeQuery("SELECT * FROM item order by category");
            while(resultSet.next()){
                System.out.println(resultSet.getInt(1) +"  "+ resultSet.getString(2)+"  "+
                        resultSet.getInt(3)+"  "+resultSet.getInt(4)+"  "+resultSet.getString(5)+" "+resultSet.getString(6));
            }
            }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}