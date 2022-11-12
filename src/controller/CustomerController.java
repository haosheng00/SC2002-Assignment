package controller;

import java.util.ArrayList;
import java.util.Scanner;
import ui.AccountUI;
import classes.Customer;
import classes.Ticket;
import initialiser.Initialise;
import ui.CustomerMenuUI;

import serialiser.SerializeMovieDB;

/**
 * Contains the methods related the the customer database and the past tickets they purchased
 */
public class CustomerController {
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<Customer> customers = Initialise.customers;

    /**
     * Transverses through the customers array list check if entered username below to an existing customer
     * @param username username entered by user
     * @return index of customer in array list if username is a customer; -1 if username not found in customers array list
     */
    public static int searchCustomer(String username) {
        for (int i = 0; i < Initialise.customers.size(); i++) {
            // System.out.println("iterating through for loop. Username: " +
            // customers.get(i).getUserName());
            if (username.equals(Initialise.customers.get(i).getUserName())) {
                // System.out.println("returning"+ i);
                return i;
            }
        }
        return -1;

    }

    /**
     * Adds a new customer to the customers array list
     * @throws Exception
     */
    public static void addCustomer() throws Exception {
        String username, password, email, phno;
        username = null;
        int exit = -1;
        int customerExists = -2;
        int adminExists = -2;
        do {
            System.out.println("Please enter username to create new account:");
            username = sc.next();
            customerExists = searchCustomer(username);
            adminExists = AdminController.searchAdmin(username);
            if (customerExists == -1 && adminExists == -1) {
                exit = 2;
                System.out.println("Please enter password to create new account:");
                password = sc.next();
                System.out.println("Please enter your email: ");
                email = sc.next();
                System.out.println("Please enter your mobile number: ");
                phno = sc.next();
                System.out.println("New account created");
                // Customer newCust = new Customer(username, password, email, phno);
                Initialise.customers.add(new Customer(username, password, email, phno));
                SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);
                // System.out.println(Initialise.customers.get(0).getUserName());
                // sortCustomersList();
                break;
            } else {
                System.out.println("Username already exists ");
                System.out.println("Please choose: ");
                System.out.println("(1): Try again");
                System.out.println("(2): Back");
                exit = sc.nextInt();
            }

        } while (exit != 2);
        if (exit == 2) {
            AccountUI.initiateLoginUI(0);
        }

    }

    
    /**
     * Deletes/Removes the customer with the inserted username from the customers array list
     * @throws Exception
     */
    public static void deleteCustomer() throws Exception {
        int exit = -1;
        do {
            System.out.println("Please enter username of account to delete: ");
            String username = sc.next();
            int exists = searchCustomer(username);
            System.out.println(exists);
            if (exists != -1) {
                Initialise.customers.remove(exists);
                SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);
                System.out.println("Removed customer");
                //exit = 2;
                break;
                // to access in a static way --> CustomerController.sortCustomersList();
            } else {
                System.out.println("Account with this username does not exist");
                System.out.println("Do you want to try again or exit? ");
                System.out.println("(1): Try again");
                System.out.println("(2): Exit");
                exit = sc.nextInt();
            }
        } while (exit != 2);
        if (exit == 2) {
            AccountUI.LoginUI(0);
        }
    }

    /**
     * Allows the customer to update the password of their login account after validating username and current password
     * @throws Exception
     */
    public static void updateCustomerPassword() throws Exception {
        String username;
        int exit = -1;
        do {
            System.out.println("Please enter username: ");
            username = sc.next();
            int index = searchCustomer(username);
            String match;
            String newpass;
            if (index != -1) {
                System.out.println("Please enter current Password: ");
                match = sc.next();
                if (match.equals(customers.get(index).getPassword())) {
                    System.out.println("Please enter new Password: ");
                    newpass = sc.next();
                    customers.get(index).setPassword(newpass);
                    System.out.println("Password successfully changed!");
                    SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);
                    exit = 2;
                } else {
                    System.out.println("Wrong password ");
                    System.out.println("Do you want to try again or exit? ");
                    System.out.println("(1): Try again");
                    System.out.println("(2): Exit");
                    exit = sc.nextInt();
                }
            } else {
                System.out.println("Sorry, user account with this username does not exist");
                System.out.println("Do you want to try again or exit? ");
                System.out.println("(1): Try again");
                System.out.println("(2): Exit");
                exit = sc.nextInt();
            }
        } while (exit != 2);
        if (exit == 2) {
            AccountUI.WelcomePage();
        }
    }

    /**
     * Prints the customer details (username, email and mobile number) of the specified username
     * @param username username of customer
     */
    public static void printCustomer(String username) {
        int index = searchCustomer(username);
        if (index != -1) {
            System.out.println("Customer account username: " + username);
            System.out.println("Customer email: " + customers.get(index).getEmailAddress());
            System.out.println("Customer mobile number: " + customers.get(index).getMobileNumber());
        }
    }

    /**
     * Prints the details of the tickets bought by the customer in the past
     * @param customer customer object from customers array list
     * @throws Exception
     */
    public static void viewPastTickets(Customer customer) throws Exception {
        System.out.println("========================================");
        System.out.println("Tickets you purchased in the past: ");
        ArrayList<Ticket> arr = customer.getBoughtTickets();
        for (int x = 0; x < arr.size(); x++) {
            TicketController.printTicket(arr.get(x));
            System.out.println();
        }
        if (customer.getUserName() == "guest")
            CustomerMenuUI.guestMenuOptions();
        else
            CustomerMenuUI.customerMenuOptions(customer);
    }

    /**
     * Returns an array of the customers list
     * @return customers array list
     */
    public static ArrayList<Customer> getCustomersList() {
        return customers;
    }
}