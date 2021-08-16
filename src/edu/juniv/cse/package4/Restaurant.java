package edu.juniv.cse.package4;

import edu.juniv.cse.package1.Customer;
import edu.juniv.cse.package1.Manager;
import edu.juniv.cse.package3.Bill;
import edu.juniv.cse.package3.Menu;

import java.util.Scanner;

public class Restaurant
{


    public static void managerTask()
    {

        Scanner scanner=new Scanner(System.in);
        boolean b;
        //System.out.println("--Press 1 to view the customer list--");
        System.out.println("--Press 2 to view the Menu --");
        System.out.println("--Press 3 to insert item into the Menu --");
        System.out.println("--Press 4 to delete item from the Menu --");
        System.out.println("--Press 5 to update item quantity  --");
        System.out.println("--Press 6 to go back to homepage  --");
        while (b=true) {
            System.out.print(">>");
            int x = scanner.nextInt();

                   /* if (x == 1) {
                        manager2.viewCustomer();
                    } else*/
                   if (x == 2) {
                Menu obj2 = new Menu();
                obj2.veiwItem();
            } else if (x == 3) {
                Menu obj2 = new Menu();
                obj2.insertItem();
            } else if (x == 4) {
                System.out.print("enter item id to delete : ");
                int dlt = scanner.nextInt();
                Menu obj2 = new Menu(dlt);
                obj2.deleteItem();
            } else if (x == 5) {
                int iid, available;
                System.out.print("enter item id : ");
                iid = scanner.nextInt();
                System.out.print("enter available quantity : ");
                available = scanner.nextInt();
                Menu obj2 = new Menu(iid, available);
                obj2.updateQuantity();
            }
            else if (x==6)
            {
                Main obj=new Main();
                obj.display();
            }
            else {
                b=false;
                System.out.println("invalid number");
            }
        }

    }

    public static void customerTask()
    {
        System.out.println("--Press 1 to view the Menu --");
        System.out.println("--Press 2 to make a order  --");
        System.out.println("--Press 3 to show the bill --");
        System.out.println("--Press 4 to go back to homepage  --");

        boolean a;
        while (a=true) {
            int y;
            Scanner scanner = new Scanner(System.in);
            System.out.print(">>");
            y = scanner.nextInt();

            if (y == 1) {
                Menu obj2 = new Menu();
                obj2.veiwItem();
            } else if (y == 2) {
                int cusId, itemId, quantity;
                Scanner scanner1 = new Scanner(System.in);
                System.out.println("enter the customer Id : ");
                cusId = scanner1.nextInt();
                System.out.println("enter the item Id : ");
                itemId = scanner1.nextInt();
                System.out.println("enter the number of quantity you want : ");
                quantity = scanner1.nextInt();
                Bill obj = new Bill(cusId, itemId, quantity);
                obj.myOrder();
                Bill obj2 = new Bill(quantity);
                obj.totalBill();
            }
            else if (y == 3) {
                int cusId;
                System.out.println("enter customer id :");
                cusId=scanner.nextInt();
                Bill obj3 = new Bill(cusId);
                obj3.showBill();

            } else if (y == 4) {
                Main obj = new Main();
                obj.display();
            }
            else {
                a=false;
                System.out.println("Invalid number");
            }
        }
    }

    public static void  managerAll()
    {
        Scanner scanner=new Scanner(System.in);
        int k=scanner.nextInt();
        String username,password,name,email,mobile;
        int id;
        if(k==3)
        {
            System.out.print("enter username :");
            username=scanner.next();
            scanner.nextLine();
            System.out.print("enter password :");
            password=scanner.nextLine();
            scanner.nextLine();
            System.out.print("enter name :");
            name=scanner.nextLine();
            scanner.nextLine();
            System.out.print("enter email :");
            email=scanner.nextLine();
            scanner.nextLine();
            System.out.print("enter mobile :");
            mobile=scanner.nextLine();
            scanner.nextLine();
            /*enter username :tisha
             enter password :12345
             enter name :Tisha Jannat
             enter email :tisha@gmail.com
             enter mobile :01427482947
            */
            Manager manager=new Manager(username,password,name,email,mobile);
            boolean ans=manager.register();
            if(ans==true)
            {
                managerTask();
            }

        }
        else if(k==5)
        {
            System.out.print("enter username :");
            username=scanner.next();
            scanner.nextLine();
            System.out.print("enter password :");
            password=scanner.nextLine();
            scanner.nextLine();
            Manager manager2=new Manager(username,password);
            boolean ans2=manager2.login();
            System.out.println(ans2);
            if(ans2==true) {
                // System.out.println("Successfully Logged In");
                managerTask();
            }

        }

        else if(k==4)
        {
            System.out.print("enter username :");
            username=scanner.next();
            scanner.nextLine();
            System.out.print("enter password :");
            password=scanner.nextLine();
            scanner.nextLine();
            System.out.print("enter id :");
            id=scanner.nextInt();
            scanner.nextLine();
            System.out.print("enter name :");
            name=scanner.nextLine();
            scanner.nextLine();
            System.out.print("enter email :");
            email=scanner.nextLine();
            scanner.nextLine();
            System.out.print("enter mobile number :");
            mobile=scanner.nextLine();
            scanner.nextLine();

            Customer customer=new Customer(username,password,id,name,email,mobile);
            boolean ans3=customer.register();
            if(ans3==true)
            {
                customerTask();
            }
        }
        else if(k==6)
        {
            System.out.print("enter username :");
            username=scanner.next();
            scanner.nextLine();
            System.out.print("enter password :");
            password=scanner.nextLine();
            scanner.nextLine();
            Customer customer2=new Customer(username,password);
            boolean ans4=customer2.login();
            System.out.println(ans4);
            if(ans4==true)
            {
               // System.out.println("Successfully Logged In");
                customerTask();

            }
        }
        else {
            System.out.println("Invalid number");
        }
    }
}
