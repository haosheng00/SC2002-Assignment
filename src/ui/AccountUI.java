package ui;

import java.util.Scanner;

import classes.*;
import controller.*;
import initialiser.Initialise;
public class AccountUI {
    public static int index;
    //static AdminController adminPrac = new AdminController();
    //static CustomerController custPrac = new CustomerController(ArrayList<Customer>);

    public static void WelcomePage() throws Exception{
        System.out.println("========================================");
        System.out.println("Welcome to MOBLIMA");
        System.out.println("========================================");
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
    }

    public static void initiateLoginUI(int x) throws Exception{
        Scanner sc = new Scanner(System.in);
        int choice=0;
        do{
            System.out.println("========================================");
            System.out.println("Please select an option");
            System.out.println("(1) Login to an existing account");
            System.out.println("(2) Create a new account");
            System.out.println("(3) Delete account");
            System.out.println("(4) Change Password");
            System.out.println("(5) Back");
            
            try{
                choice = sc.nextInt();   
            }
            catch (Exception e){

            }
            sc.nextLine();

            switch(choice){
                case 1:
                    LoginUI(x);
                    break;
                case 2:
                    CustomerController.addCustomer();
                    break;
                case 3:
                    CustomerController.deleteCustomer();
                    break;
                case 4:
                    CustomerController.updateCustomerPassword();
                    break;
                case 5:
                    AccountUI.WelcomePage();
                    break;
                default:
                    System.out.println("Invalid Choice");
                    break;
            }
        }while(choice!=5);
    }
    public static void LoginUI(int x) throws Exception{
        Scanner sc = new Scanner(System.in);
        String username;
        String password;
        int success;
        int exitChoice=-3;
        do{
            System.out.println("========================================");
            System.out.println("Please enter username");
            username = sc.next();
            System.out.println("Please enter password");
            password = sc.next();
            //System.out.println(username + password + "atLoginUI");

            success = Login(username, password);
            //System.out.println("Success value is "+ success);
            switch (success){
                case 0:
                    System.out.println("Username or password incorrect");
                    System.out.println("========================================");
                    System.out.println("1: Try again");
                    System.out.println("2: Exit");
                    exitChoice = sc.nextInt();
                    break;
                case 1:
                    AdminMenuUI.adminMenuOptions();
                    break;
                case 2:
                    //int index = CustomerController.searchCustomer(username);
                    if (x == 2){
                        TicketController.createBooking(Initialise.cineplexes, Initialise.customers.get(index));
                    }
                    CustomerMenuUI.customerMenuOptions(Initialise.customers.get(index));
                    break;
                case 3:
                    CustomerMenuUI.guestMenuOptions();
                    break;
                case 4:
                    AccountUI.WelcomePage();
                    break;
                default:
                    AccountUI.WelcomePage();
                    break;
                    
            }
        }while(exitChoice != 2 && success<5);
        if (exitChoice == 2)
            AccountUI.initiateLoginUI(0);
    }

    private static int Login(String username, String password){
        System.out.println("Entered Login");
        //System.out.println(username + password + "at Login");
        int isAdmin = -2;
        isAdmin = AdminController.searchAdmin(username);
        int isCustomer = -2;

        if(isAdmin == -1){
            isCustomer = CustomerController.searchCustomer(username);
            //isCustomer = CustomerController.searchCustomer(username);
        }

        int isGuest=0;
        if(isCustomer == 0) isGuest = 1;
        

        if(isAdmin !=-1){
            if(Initialise.admins.get(isAdmin).getPassword().equals(password)){
                return 1;}
            else return 0;       
        }
        if(isCustomer >0){
            if(password.equals(Initialise.customers.get(isCustomer).getPassword())){
                index = isCustomer;
                return 2;
            }
            else return 0;
       }
       if(isGuest ==1){
            return 3;
        }
        System.out.println("Username does not exist");
        return 4;
    }

}


     
    

    