package controller;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Customer;
import Classes.Ticket;
import Initialiser.Initialise;


public class CustomerController{
    Scanner sc = new Scanner(System.in);
    private  ArrayList<Customer> customers = new ArrayList<Customer>();

    public CustomerController(ArrayList<Customer> custList){
        this.customers = custList;

    }

    public int searchCustomer(String username){
        for(int i=0; i<customers.size(); i++){
            if(customers.get(i).getUserName() == username){
                return i;
                
            }
        }
        return -1;
    }
    public void addCustomer(){
        String username, password,email, phno;
        username = null;
        int exists = -2;
        System.out.println("Please enter username to create new account:");
        while(exists!=-1 && username != "0"){
            username = sc.next();
            exists = searchCustomer(username);
            if(exists==-1){
                System.out.println("Please enter password to create new account:");
                password = sc.next();
                System.out.println("Please enter your email: ");
                email = sc.next();
                System.out.println("Please enter your mobile number: ");
                phno = sc.next();
                Customer newCust = new Customer(username, password, email, phno);
                customers.add(newCust);
                this.sortCustomerList();
                break;
            }
            else {
                System.out.println("Username already exists please enter another username: ");
                System.out.println("Enter 0 to quit");
            }

        }
        
    }

    public void sortCustomerList ()
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
    public int deleteCustomer(){
        System.out.println("Please enter username of account to delete: ");
        String username = sc.next();
        int exists = searchCustomer(username);
        if(exists == -1){
        customers.remove(exists);
        this.sortCustomerList();
        return 1;
        }
        else 
            System.out.println("Account with this username does not exist");
        
        return 0;
    }

    public int updateCustomerPassword(){
        String username;
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
                return 1;
            }
            else
                System.out.println("Wrong password, try again");
        }
        else 
            System.out.println("Sorry, user account with this username does not exist");

        return 0;
    }

    public void printCustomer(String username){
        int index = searchCustomer(username);
        if(index != -1){
            System.out.println("Customer account username: " + username);
            System.out.println("Customer email: " + customers.get(index).getEmailAddress());
            System.out.println("Customer mobile number: " + customers.get(index).getMobileNumber());
        }
    }
    

    public  void viewPastTickets(String username){
        int index = searchCustomer(username);
        ArrayList<Ticket> arr;
        arr=customers.get(index).getBoughtTickets();
        for(int x=0;x<arr.size();x++){
            Initialise.tc.printTicket();
        }

    
    }

    public void clearcart(String username){
        int index = searchCustomer(username);
        customers.get(index).getCartTickets().clear();
    }
    
    




}