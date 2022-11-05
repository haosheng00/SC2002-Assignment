package ui;

import java.util.Scanner;
import Classes.*;
import Initialiser.Initialise;
import controller.*;

import java.util.ArrayList;
public class AccountUI {
    //static AdminController adminPrac = new AdminController();
    //static CustomerController custPrac = new CustomerController(ArrayList<Customer>);

    public static void WelcomePage(){
        System.out.println("Welcome to MOBLIMA");
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            /*System.out.println("Customer: 1");
            System.out.println("Admin: 2");
            System.out.println("Back: 3");
            System.out.println("Choose login account type: ");*/
            System.out.println("(1) Login");
            System.out.println("(2) Continue as guest");
            choice = sc.nextInt();
            if(choice == 1){
                initiateLoginUI();
            }
            else if(choice == 2){

                //CustomerMenuUI.guestUI();
            }
            
        }while(choice<3);
        sc.close();
    }
    public static void initiateLoginUI(){
        
    }
    public static void initiateCustomerUI(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Please select an option");
            System.out.println("(1) Login to an existing account");
            System.out.println("(2) Create a new account");
            System.out.println("(3) Delete account");
            System.out.println("(4) Change Password");
            System.out.println("(5) back");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    logInCustomer();
                    //TODO: if logInCustomer == true, bring them to MainMenuUI for customer
                    break;
                case 2:
                    Initialise.cc.addCustomer();
                    break;
                case 3:
                    Initialise.cc.deleteCustomer();
                case 4:
                    Initialise.cc.updateCustomerPassword();
                default:
                    break;
            }
        }while(choice<5);
        sc.close();
    }

    public static void initiateAdminUI(){
        int choice;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Please select an option");
            System.out.println("(1) Login to an existing account");
            System.out.println("(2) back");
            
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    logInAdmin();
                    //TODO: if logInAdmin == true, bring them to MainMenuUI for customer
                    break;
                default:
                    break;
            }
        }while(choice<2);
        sc.close();
    }

    public static boolean logInCustomer(){
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        int i;
        ArrayList<Customer> arr = CustomerController.getCustomerList();
        int quit = 0;
        do{
            System.out.println("Enter username: ");
            username = sc.next();
            System.out.println("Enter password: ");
            password = sc.next();
            i = Initialise.cc.searchCustomer(username);
            if(i==-1){
                System.out.println("username not found");
                System.out.println("If you would like to quit enter 0 else enter 1");
                quit = sc.nextInt();
            }
            else {
                    if(arr.get(i).getPassword() == password){
                    System.out.println("Login Successful");
                    return true;
                    }
                    else{
                        System.out.println("Wrong password. Try again");
                        System.out.println("If you would like to quit enter 0 else enter 1");
                        quit = sc.nextInt();
                    }
                }
        }while(quit!=1);
        sc.close();
        return false;
    }

    public static boolean logInAdmin(){
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        int i;
        ArrayList<Admin> arr = Initialise.ac.getAdminsList();
        int quit = 0;
        do{
            System.out.println("Enter username: ");
            username = sc.next();
            System.out.println("Enter password: ");
            password = sc.next();
            i = Initialise.ac.searchAdmin(username);
            if(i==-1){
                System.out.println("Username not found");
                System.out.println("If you would like to quit enter 0 else enter 1");
                quit = sc.nextInt();
            }
            else {
                    if(arr.get(i).getPassword() == password){
                    System.out.println("Login Successful");
                    return true;
                    }
                    else{
                        System.out.println("Wrong password. Try again");
                        System.out.println("If you would like to quit enter 0 else enter 1");
                        quit = sc.nextInt();
                    }
                }
        }while(quit!=1);
        sc.close();
        return false;
    }
}

