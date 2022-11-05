package controller;

import java.util.Scanner;
import java.util.ArrayList;
import Classes.*;
import ui.*;
import Initialiser.Initialise;

public class PaymentController {

    //static and initialise all the arrays 

    //list of all payments made in the cinema
    //private static ArrayList<Payment> Payments;
    private static ArrayList<Payment> Payments = Initialise.payments;

    //constructor of PaymentController
    public PaymentController(ArrayList<Payment> Payments) {
        PaymentController.Payments = Payments;
    }


    //TODO: UPDATE TOP5 SALES ARRAY 

    //checkout all tickets in the cart
    public static void checkoutUI(Customer customer) {
        int choice = 0;
        int TID = 0;
        double totalCharges;
        String name;
        String cardNumber;
        String billingAddress;
        String cvc;
        Scanner sc = new Scanner(System.in);

        System.out.println("Cart: ");

        // //initialise customer array 
        // ArrayList <Customer> cus = Initialise.customers;
        // //get index of customer by searching their username 
        // //DONT NEED ACCOUNT FOR IF THEIR USERNAME DOESNT EXIST - MUST EXIST SINCE CAN LOG IN 
        // int customerIndex = CustomerController.searchCustomer(username);
        //get the cartTickets of the target customer 
        ArrayList <Ticket> cartTickets = customer.getCartTickets();

        //get cart tickets from customer class
        showTickets(cartTickets);
        System.out.println("Would you like to proceed to check out your cart? (Enter 1 for yes, 0 to cancel check out");
        choice = sc.nextInt();
        //if cancel checkout
        if (choice == 0) {
            System.out.println("Cancelling check out...");
            //TODO: undo isReserved
            return;
        }
        //proceed with the checkout
        totalCharges = calcPayment(cartTickets);
        //TODO: ADD DECIMALS FOR DIS 
        System.out.println("The total amount is: " + totalCharges);
        System.out.println("Please enter your credit card details");
        System.out.println("Full Name: ");
        name = sc.next();
        System.out.println("Card Number: ");
        cardNumber = sc.next();
        //TODO: ADD EXPIRY NUMBER 
        System.out.println("Billing Address: ");
        billingAddress = sc.next();
        System.out.println("Please enter your CVC/CVV: ");
        cvc = sc.next();
        System.out.println("The amount of " + totalCharges + "will be charged to your card, under the name " + name);
        TID = createTID(cartTickets.get(0));
        madePayment(TID, totalCharges, name, billingAddress, cardNumber);

        //print Receipt 
        printReceipt(cartTickets);

        //mark the seats as booked for all tickets in the cart 
        for (int i=0; i<cartTickets.size(); i++) {
            cartTickets.get(i).getSeat().setIsBooked(true);
        }

        //update Sales
        updateSales(cartTickets);

        //update Ticket History for each customer
        updateTicketHistory(customer);

        //clear cart tickets  - can remove func in customer class?
        cartTickets.clear();

        System.out.println("Thank you for your purchase. We hope you enjoy for movie!");

        CustomerMenuUI.customerMenuOptions(customer);
    }

    //made payment and add payment to the Payment list
    public static void madePayment(int TID, double totalCharges, String CreditCardName, String billingAddress, String billingCardNumber) {
        Payments.add(new Payment(TID,totalCharges,CreditCardName,billingAddress,billingCardNumber));
    }

    public static int createTID(Ticket t) {
        //Each payment will have a transaction id (TID). 
        //The TID is of the format XXXYYYYMMDDhhmm (Y : year, M : month, D : day, h : hour, m : minutes, XXX:cinemacodeinletters)
        
        //get XXX (CinemaCode) 
        String cinemaCode = t.getCinema().getCinemaCode();
        //get YYYYMMDDhhmm
        String dateTime = Initialise.dt.paymentDateTime();
        //combine to get TID 
        String StringTID = cinemaCode + dateTime;
        //convert string to int
        int TID = Integer.parseInt(StringTID);
        return TID;
    }

    public static double calcPayment(ArrayList<Ticket> cartTickets) {
        int size = cartTickets.size();
        int sum = 0;
        for (int i=0; i<size; i++) {
            //change name accordingly
            sum += cartTickets.get(i).getTicketPrice();
        }
        return sum;
    }

    public static void printReceipt(ArrayList<Ticket> cartTickets) {
        int size = cartTickets.size();
        System.out.println("Receipt:");
        for (int i=0; i<size; i++) {
            //ticket number
            System.out.println("Ticket " + (i+1));
            TicketController.printTicket(cartTickets.get(i));
            // System.out.println("Movie: " + cartTickets.get(i).getMovie());
            // System.out.println("Showtime: "+ cartTickets.get(i).getShowDate() + " " + cartTickets.get(i).getShowTime());
            // System.out.println("Cineplex: " + cartTickets.get(i).getCineplex() + " Cinema " + cartTickets.get(i).getCinema());
            // System.out.println("Seat Number: " + cartTickets.get(i).getSeat().getSeatId());
            // System.out.println("Ticket Price: " + cartTickets.get(i).getTicketPrice());
        }
        System.out.println("Total Payment: " + calcPayment(cartTickets));
    }

    public static void showTickets(ArrayList<Ticket> Tickets) {
        int size = Tickets.size();
        System.out.println("Here are the details of your tickets:");
        for (int i=0; i<size; i++) {
            //ticket number
            System.out.println("Ticket " + (i+1));
            TicketController.printTicket(Tickets.get(i));
            // System.out.println("Movie: " + Tickets.get(i).getMovie());
            // System.out.println("Showtime: "+ Tickets.get(i).getShowDate() + " " + Tickets.get(i).getShowTime());
            // System.out.println("Cineplex: " + Tickets.get(i).getCineplex() + " Cinema " + Tickets.get(i).getCinema());
            // System.out.println("Seat Number: " + Tickets.get(i).getSeat().getSeatId());
            // System.out.println("Ticket Price: " + Tickets.get(i).getTicketPrice());
        }
    }
 
    //update sales of each movie
    public static void updateSales(ArrayList <Ticket> cartTickets) {

        int size = cartTickets.size();
        //iterate thru Tickets --> find movie and add ticketprice to sales 
        for (int i=0; i<size; i++) {
            //find movie for each ticket 
            Movie movie = cartTickets.get(i).getMovie();
            //update sales for each ticket 
            movie.setSales(movie.getSales() + cartTickets.get(i).getTicketPrice());
        }
    }

    //update ticket history for each customer
    //add cartTickets to the boughtTix array
    public static void updateTicketHistory(Customer cus) {
        ArrayList <Ticket> cartTickets = cus.getCartTickets();
        int size = cartTickets.size(); 
        for (int i=0; i<size; i++) {
            cus.getBoughtTickets().add(cartTickets.get(i));
        }
    }

}