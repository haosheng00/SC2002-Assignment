package controller;

import java.util.Scanner;
import java.util.ArrayList;
import Classes.Payment;
import Classes.Customer;
import controller.CustomerController;
import Classes.Ticket;
import Initialiser.Initialise;

public class PaymentController {
    Scanner sc = new Scanner(System.in);

    //list of all payments made in the cinema
    private ArrayList<Payment> Payments;

    //constructor of PaymentController
    public PaymentController(ArrayList<Payment> Payments) {
        this.Payments = Payments;
    }

    //checkout all tickets in the cart
    public void checkoutUI() {
        int choice = 0;
        int TID = 0;
        double totalCharges;
        String name;
        String cardNumber;
        String billingAddress;
        String cvc;

        System.out.println("Cart: ");


        //HOW TO USE USERNAME FROM LOGIN???
        String username = "Hello";

        //initialise customer array 
        ArrayList <Customer> cus = Initialise.customers;
        //initialise customer controller
        CustomerController cusController = Initialise.cc;
        //get index of customer by searching their username 
        //DONT NEED ACCOUNT FOR IF THEIR USERNAME DOESNT EXIST - MUST EXIST SINCE CAN LOG IN 
        int customerIndex = cusController.searchCustomer(username);
        //get the cartTickets of the target customer 
        ArrayList <Ticket> cartTickets = cus.get(customerIndex).getCartTickets();

        //get cart tickets from customer class
        showTickets(cartTickets);
        System.out.println("Would you like to proceed to check out your cart? (Enter 1 for yes, 0 to cancel check out");
        choice = sc.nextInt();
        //if cancel checkout
        if (choice == 0) {
            System.out.println("Cancelling check out...");
            return;
        }
        //proceed with the checkout
        totalCharges = calcPayment(cartTickets);
        //ADD DECIMALS FOR DIS 
        System.out.println("The total amount is: " + totalCharges);
        System.out.println("Please enter your credit card details");
        System.out.println("Name: ");
        name = sc.next();
        System.out.println("Card Number: ");
        cardNumber = sc.next();
        System.out.println("Billing Address: ");
        billingAddress = sc.next();
        System.out.println("Please enter your CVC/CVV: ");
        cvc = sc.next();
        System.out.println("The amount of " + totalCharges + "will be charged to your card, under the name " + name);
        TID = createTID();
        madePayment(TID, totalCharges, name, billingAddress, cardNumber);
        System.out.println("Thank you for your purchase. We hope you enjoy for movie!");
    }

    //made payment and add payment to the Payment list
    //do we need to cfm the seats is booked or sth?
    //clear cart tickets 
    //add tickets to customers' ticket array?

    public void madePayment(int TID, double totalCharges, String CreditCardName, String billingAddress, String billingCardNumber) {
        Payments.add(new Payment(TID,totalCharges,CreditCardName,billingAddress,billingCardNumber));
    }

    public int createTID() {

        //one TID for each payment

        //Each payment will have a transaction id (TID). 
        //The TID is of the format XXXYYYYMMDDhhmm (Y : year, M : month, D : day, h : hour, m : minutes, XXX:cinemacodeinletters)

        //CinemaCode --> First letter of cineplex + 

        //get cineplex from the ticket of the customer 




       


        
    }

    public double calcPayment(ArrayList<Ticket> cartTickets) {
        int size = cartTickets.size();
        int sum = 0;
        for (int i=0; i<size; i++) {
            //change name accordingly
            sum += cartTickets.get(i).getTicketPrice();
        }
        return sum;
    }

    public void printReceipt(ArrayList<Ticket> cartTickets) {
        int size = cartTickets.size();
        System.out.println("Receipt:");
        for (int i=0; i<size; i++) {
            //ticket number
            System.out.println("Ticket " + (i+1));
            System.out.println("Movie: " + cartTickets.get(i).getmovie());
            System.out.println("Showtime: "+ cartTickets.get(i).getshowDate() + " " + cartTickets.get(i).getshowTime());
            System.out.println("Cineplex: " + cartTickets.get(i).getcineplex() + " Cinema " + cartTickets.get(i).getcinema());
            System.out.println("Seat Number: " + cartTickets.get(i).getseat().getseatId());
            System.out.println("Ticket Price: " + cartTickets.get(i).getticketPrice());
        }
        System.out.println("Total Payment: " + calcPayment(cartTickets));
    }

    public void showTickets(ArrayList<Ticket> Tickets) {
        int size = Tickets.size();
        System.out.println("Tickets:");
        for (int i=0; i<size; i++) {
            //ticket number
            System.out.println("Ticket " + (i+1));
            System.out.println("Movie: " + Tickets.get(i).getmovie());
            System.out.println("Showtime: "+ Tickets.get(i).getshowDate() + " " + Tickets.get(i).getshowTime());
            System.out.println("Cineplex: " + Tickets.get(i).getcineplex() + " Cinema " + Tickets.get(i).getcinema());
            System.out.println("Seat Number: " + Tickets.get(i).getseat().getseatId());
            System.out.println("Ticket Price: " + Tickets.get(i).getticketPrice());
        }
    }
 

}
