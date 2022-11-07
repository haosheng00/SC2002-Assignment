package ui;

import java.util.Scanner;

import classes.*;
import controller.*;
import initialiser.Initialise;
public class AccountUI {
    public static Customer current;
    //static AdminController adminPrac = new AdminController();
    //static CustomerController custPrac = new CustomerController(ArrayList<Customer>);

    public static void WelcomePage(){
        System.out.println("Welcome to MOBLIMA");
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("(1) Login");
            System.out.println("(2) Continue as guest");
            choice = sc.nextInt();
            if(choice == 1){
                initiateLoginUI(0);
            }
            else if(choice == 2){
                Login("guest","guest");
                CustomerMenuUI.guestMenuOptions();
            }  
        }while(choice<3);
        sc.close();
    }

    public static void initiateLoginUI(int x){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Please select an option");
            System.out.println("(1) Login to an existing account");
            System.out.println("(2) Create a new account");
            System.out.println("(3) Delete account");
            System.out.println("(4) Change Password");
            System.out.println("(5) Back");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    LoginUI(x);
                    break;
                case 2:
                    CustomerController.addCustomer();
                    break;
                case 3:
                    CustomerController.deleteCustomer();
                case 4:
                    CustomerController.updateCustomerPassword();
                default:
                    break;
            }
        }while(choice<5);
        sc.close();
    }
    public static void LoginUI(int x){
        Scanner sc = new Scanner(System.in);
        String username;
        int success;
        int exitChoice=-3;
        do{
            System.out.println("Please enter username");
            username = sc.next();
            System.out.println("Please enter password");
            String password = sc.next();
            success = Login(username, password);
            switch (success){
                case 0:
                    System.out.println("Username or password incorrect");
                    System.out.println("1: Try again");
                    System.out.println("2: Exit");
                    exitChoice = sc.nextInt();
                    break;
                case 1:
                    AdminMenuUI.adminMenuOptions();
                case 2:
                    //int index = CustomerController.searchCustomer(username);
                    if (x == 2){
                        TicketController.createBooking(Initialise.cineplexes, current);
                    }
                    CustomerMenuUI.customerMenuOptions(current);
            }
        }while(exitChoice !=2);
        sc.close();
    }

    private static int Login(String username, String password){
        int isAdmin = -2;
        isAdmin = AdminController.searchAdmin(username);
        int isCustomer = -2;

        if(isAdmin == -1){
            isCustomer = CustomerController.searchCustomer(username);
        }

        int isGuest=0;
        if(isCustomer == 0) isGuest = 1;
        

        if(isAdmin !=-1){
            if(AdminController.getAdminsList().get(isAdmin).getPassword()==password){
                return 1;}
            else 
                return 0;
                
        }
        if(isCustomer >0){
            if(CustomerController.getCustomersList().get(isCustomer).getPassword()==password){
                current = Initialise.customers.get(isCustomer);
                return 2;
            }
            else 
                return 0;
       }
       if(isGuest ==1){
            return 3;
        }
        
        return 4;
    }

     
    

    /*public static void initiateAdminUI(){
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
    }*/
}

