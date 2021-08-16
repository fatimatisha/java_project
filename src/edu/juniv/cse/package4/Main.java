package edu.juniv.cse.package4;

import edu.juniv.cse.package1.Customer;
import edu.juniv.cse.package1.Manager;

import java.util.Scanner;

public class Main {

    public static void display()
    {
        System.out.println();
        System.out.println();
        System.out.println("----------Restaurant Management System----------");
        System.out.println();
        System.out.println();
        System.out.println("-----Press 1 to Sign Up-----");
        System.out.println("-----Press 2 to Login-----");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        if (n==1) {
            System.out.println("--press 3 to Manager Sign Up--");
            System.out.println("--press 4 to Customer Sign Up--");
            Restaurant obj=new Restaurant();
            obj.managerAll();
        }
        else if(n==2){
            System.out.println("--Press 5 to Manager Login--");
            System.out.println("--Press 6 to Customer Login--");
            Restaurant obj2=new Restaurant();
            obj2.managerAll();
        }
    }
    public static void main(String[] args) {
        display();
    }
    /* Manager obj2=new Manager("shuvo","234536");
        boolean ans2=obj2.login();
        System.out.println(ans2);
        if(ans2==true)
        {
            System.out.println("successfully logged in");
        }*/
}