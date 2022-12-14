package ui;

import java.util.Scanner;

import classes.Customer;
import controller.*;
import initialiser.Initialise;
/**
 * Prints the "homepage" of the application, containing login and other methods related to admin/customer account
 */
public class AccountUI {
    //public static int index;
    public static Customer customer;
    //static AdminController adminPrac = new AdminController();
    //static CustomerController custPrac = new CustomerController(ArrayList<Customer>);

    /**
     * Prints options to allow user to choose between logging in and continuing as guest
     * @throws Exception
     */
    public static void WelcomePage() throws Exception{
        System.out.println("========================================");
        System.out.println("Welcome to MOBLIMA Athay");
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do{
            try {
                System.out.println("========================================");
                System.out.println("(1) Login");
                System.out.println("(2) Continue as guest");
                System.out.println("(3) Exit");
                System.out.println("========================================");
                choice = sc.nextInt();
                if (choice == 1) {
                    initiateLoginUI(0);
                } else if (choice == 2) {
                    Login("guest", "guest");
                    CustomerMenuUI.guestMenuOptions();
                }
                else if (choice == 3){
                    System.out.println("Thank you for using MOBLIMA Athay");
                    System.exit(0);
                }
                else{
                    System.out.println("Invalid Input. Please enter an integer (1-3):");
                }
            }
            catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer: ");
            sc.next();
        }
        }while(true);
    }

    /**
     * Prints options for user to login or make changes to account details
     * @param x choice
     * @throws Exception
     */
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
            System.out.println("========================================");
            try{
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
                    break;
                case 4:
                    CustomerController.updateCustomerPassword();
                    break;
                case 5:
                    AccountUI.WelcomePage();
                    break;
                default:
                    System.out.println("Invalid Choice. Please enter an integer (1-5): ");
                    break;
            }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
        }while(choice!=5);
    }

    /**
     * Allows user to log in with username and password and brings user to the respective UI according to account type of user
     * @param x choice
     * @throws Exception
     */
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

            success = Login(username, password);
            switch (success){
                case 0:
                    System.out.println("Username or password is incorrect");
                    System.out.println("========================================");
                    System.out.println("(1) Try again");
                    System.out.println("(2) Exit");
                    exitChoice = sc.nextInt();
                    break;
                case 1:
                    System.out.println("Logged in successfully");
                    AdminMenuUI.adminMenuOptions();
                    break;
                case 2:
                    if (x == 2){
                        TicketController.createBooking(Initialise.cineplexes, customer);
                    }
                    else{
                        System.out.println("Logged in successfully");
                        CustomerMenuUI.customerMenuOptions(customer);
                    }
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

    /**
     * Checks if the user is an admin, if not check if user is customer, else user is guest. 
     * Proceeds to validate if password matches that of the username.
     * @param username entered username
     * @param password entered password
     * @return 0 if password is wrong, 1 if log in successfully as admin, 
     * 2 if log in successfully as customer, 3 if user is guest, and 4 if username is not found
     */
    private static int Login(String username, String password){
        //System.out.println("Entered Login");
        int isAdmin = -2;
        isAdmin = AdminController.searchAdmin(username);
        int isCustomer = -2;

        if(isAdmin == -1){
            isCustomer = CustomerController.searchCustomer(username);
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
                customer = Initialise.customers.get(isCustomer);
                return 2;
            }
            else return 0;
       }
       if(isGuest ==1){
            return 3;
        }
        System.out.println("Sorry, this username does not exist");
        return 4;
    }

    }


     
    

    