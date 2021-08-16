package edu.juniv.cse.package3;

import edu.juniv.cse.package2.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Bill {
    private int cusId;
    private int itemId;
    private int quantity;
    private int bill;

    public Bill(int cusId) {
        this.cusId = cusId;
    }

    public Bill(int cusId, int itemId, int quantity) {
        this.cusId = cusId;
        this.itemId = itemId;
        this.quantity = quantity;
    }

    public Bill() {
    }
    public void myOrder()
    {
        PreparedStatement preparedStatement;
        String query = "insert into bill values(?,?,?,?)";
        try {
            preparedStatement = MyConnection.getConnection().prepareStatement(query);

            preparedStatement.setInt(1,cusId);
            preparedStatement.setInt(2,itemId);
            preparedStatement.setInt(3,quantity);
            preparedStatement.setInt(4,0);

            int i = preparedStatement.executeUpdate();
            if (i!=0) {
                System.out.println("Ordered");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void totalBill()
    {
        PreparedStatement preparedStatement;
        String query = "update bill,item2 set bill.total_bill=bill.total_bill+item2.price_per_unit*?,item2.available_unit=available_unit-? where bill.cus_id=? and bill.item_id=item2.item_id ";
        try {
            preparedStatement = MyConnection.getConnection().prepareStatement(query);

            preparedStatement.setInt(1,quantity);
            preparedStatement.setInt(2,quantity);
            preparedStatement.setInt(3,cusId);
            int i = preparedStatement.executeUpdate();
           /* if (i!=0) {
                System.out.println("Updated");
            }*/
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void showBill()
    {
        PreparedStatement preparedStatement;
        ResultSet resultSet;
        String query = "select cus_id,total_bill from bill where cus_id=?";
        try {
            preparedStatement = MyConnection.getConnection().prepareStatement(query);

            preparedStatement.setInt(1,cusId);
           // preparedStatement.setString(2, );

            resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                System.out.println("Customer Id : "+resultSet.getInt("cus_id")+" "+"Total bill : "+resultSet.getInt("total_bill"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

   /* public static void main(String[] args) {
        Bill obj=new Bill(1,3,4);
        obj.myOrder();
    }*/
}