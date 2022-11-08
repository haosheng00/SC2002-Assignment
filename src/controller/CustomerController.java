package controller;
import java.util.ArrayList;
import java.util.Scanner;
import ui.AccountUI;
import classes.Customer;
import classes.Ticket;
import initialiser.Initialise;
import ui.CustomerMenuUI;


public class CustomerController{
    static Scanner sc = new Scanner(System.in);
    private  static ArrayList<Customer> customers = Initialise.customers;

    public static int searchCustomer(String username){
        for(int i=0; i<customers.size(); i++){
            //System.out.println("iterating through for loop. Username: " + customers.get(i).getUserName());
            if(username.equals(customers.get(i).getUserName())){
                //System.out.println("returning"+ i);
                return i;
            }
        }
        return -1;
        
    }
    public static void addCustomer(){
        String username, password,email, phno;
        username = null;
        int exit = -1;
        int customerExists = -2;
        int adminExists = -2;
       do{
            System.out.println("Please enter username to create new account:");
            username = sc.next();
            customerExists = searchCustomer(username);
            adminExists = AdminController.searchAdmin(username);
            if(customerExists==-1 && adminExists ==-1){
                exit = 2;
                System.out.println("Please enter password to create new account:");
                password = sc.next();
                System.out.println("Please enter your email: ");
                email = sc.next();
                System.out.println("Please enter your mobile number: ");
                phno = sc.next();
                System.out.println("New account created");
                //Customer newCust = new Customer(username, password, email, phno);
                customers.add(new Customer(username, password, email, phno));
                //System.out.println(Initialise.customers.get(0).getUserName());
                //sortCustomersList();
                break;
            }
            else {
                System.out.println("Username already exists ");
                System.out.println("Please choose: ");
                System.out.println("(1): Try again");
                System.out.println("(2): Back");
                exit = sc.nextInt();
            }

        } while(exit != 2);
        if(exit == 2){
            AccountUI.initiateLoginUI(0);
        } 

    }

    public static void sortCustomersList()
	{
        int min;
		Customer temp;
		for (int index = 0; index < customers.size()-1; index++)
		{
			min = index;
			for (int scan = index+1; scan < customers.size(); scan++)
				if (customers.get(scan).getUserName().compareTo(customers.get(min).getUserName())<0)
					min = scan;
			// Swap the values
			temp = customers.get(min);
			customers.set(min, customers.get(index));
            customers.set(index, temp);
		}
	}
    public static void deleteCustomer(){
        int exit=-1;
        do{
            System.out.println("Please enter username of account to delete: ");
            String username = sc.next();
            int exists = searchCustomer(username);
            if(exists != -1){
                customers.remove(exists);
                System.out.println("Removed customer");
                sortCustomersList();
                exit = 2;
            //to access in a static way --> CustomerController.sortCustomersList();
            }
            else{
                System.out.println("Account with this username does not exist");
                System.out.println("Do you want to try again or exit? ");
                System.out.println("(1): Try again");
                System.out.println("(2): Exit");
                exit = sc.nextInt();
            }
        }while(exit != 2);
        if(exit ==2){
            AccountUI.LoginUI(0);
        }
    }

    public static void updateCustomerPassword(){
        String username;
        int exit = -1;
        do{
            System.out.println("Enter username: ");
            username = sc.next();
            int index = searchCustomer(username);
            String match;
            String newpass;
            if(index != -1){
                System.out.println("Enter current Password: ");
                match = sc.next();
                if(customers.get(index).getPassword() == match){
                    System.out.println("Enter new Password: ");
                    newpass = sc.next();
                    customers.get(index).setPassword(newpass);
                }
                else{
                    System.out.println("Wrong password ");
                    System.out.println("Do you want to try again or exit? ");
                    System.out.println("(1): Try again");
                    System.out.println("(2): Exit");
                    exit = sc.nextInt();
                }
            }
            else{
                System.out.println("Sorry, user account with this username does not exist");
                System.out.println("Do you want to try again or exit? ");
                System.out.println("(1): Try again");
                System.out.println("(2): Exit");
                exit = sc.nextInt();
            }
        }while(exit!=2);
        if(exit == 2){
            AccountUI.LoginUI(0);
        }
    }

    public static void printCustomer(String username){
        int index = searchCustomer(username);
        if(index != -1){
            System.out.println("Customer account username: " + username);
            System.out.println("Customer email: " + customers.get(index).getEmailAddress());
            System.out.println("Customer mobile number: " + customers.get(index).getMobileNumber());
        }
    }

    // public static void viewPastTickets(String username){
    //     int index = searchCustomer(username);
    //     System.out.println("Tickets you purchased in the past: ");
    //     ArrayList<Ticket> arr;
    //     arr=customers.get(index).getBoughtTickets();
    //     for(int x=0;x<arr.size();x++){
    //         TicketController.printTicket(arr.get(x));
    //     }
    // }

    //TODO: Too many searches, past in Customer object instead?
    public static void viewPastTickets(Customer customer){
        System.out.println("Tickets you purchased in the past: ");
        ArrayList<Ticket> arr = customer.getBoughtTickets();
        for(int x=0;x<arr.size();x++){
            TicketController.printTicket(arr.get(x));
        }
        if(customer.getUserName() == "guest")
        CustomerMenuUI.guestMenuOptions();
        else
            CustomerMenuUI.customerMenuOptions(customer);
    }

    // public static void clearCart(String username){
    //     int index = searchCustomer(username);
    //     customers.get(index).getCartTickets().clear();
    // }
    
    public static ArrayList<Customer> getCustomersList(){
        return customers;
    }
}