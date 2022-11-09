package controller;

import java.io.IOException;
import java.util.*;

import classes.*;
//import controller.*;
import initialiser.Initialise;
import ui.*;
import serialiser.*;

public class PaymentController {

    //static and initialise all the arrays 

    //list of all payments made in the cinema
    //private static ArrayList<Payment> Payments;
    private static ArrayList<Payment> Payments = Initialise.payments;

    //constructor of PaymentController
    public PaymentController(ArrayList<Payment> Payments) {
        PaymentController.Payments = Payments;
    }

    //checkout all tickets in the cart
    public static void checkoutUI(Customer customer) throws Exception {
        int choice = 0;
        String TID;
        double totalCharges;
        String name;
        String cardNumber;
        String cardExpirationDate;
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
        System.out.println("Would you like to proceed to check out your cart? (Enter 1 for yes, 0 to cancel check out)");
        choice = sc.nextInt();
        //if cancel checkout
        if (choice == 0) {
            System.out.println("Cancelling check out...");
            //TODO: undo isReserved --> Don't you undo isReserved before they make payment (after they select the seats)?
            sc.close();
            return;
        }
        //proceed with the checkout
        totalCharges = calcPayment(cartTickets);
        System.out.printf("The total amount is: %.2f\n", totalCharges);
        System.out.println("Please enter your credit card details:");
        System.out.println("Full Name: ");
        name = sc.next();
        System.out.println("Card Number: ");
        cardNumber = sc.next();
        System.out.println("Expiration Date:");
        cardExpirationDate = sc.next();
        System.out.println("Billing Address: ");
        billingAddress = sc.next();
        System.out.println("Please enter your CVC/CVV: ");
        cvc = sc.next();
        System.out.printf("The amount of %.2f ", totalCharges);
        System.out.println("will be charged to your card, under the name " + name); 
        TID = createTID(cartTickets.get(0));
        madePayment(TID, totalCharges, name, cardExpirationDate, billingAddress, cardNumber);

        //print Receipt 
        printReceipt(cartTickets);

        //mark the seats as booked for all tickets in the cart 
        for (int i=0; i<cartTickets.size(); i++) {
            cartTickets.get(i).getSeat().setIsBooked(true);
        }

        SerializeMovieDB.writeSerializedObject("Screening.dat", Initialise.screenings);

        //update Sales
        updateSales(cartTickets);

        //update Ticket History for each customer
        updateTicketHistory(customer);

        //clear cart tickets  - can remove func in customer class?
        cartTickets.clear();

        System.out.println("Thank you for your purchase. We hope you enjoy your movie!");

        CustomerMenuUI.customerMenuOptions(customer);
       sc.close();
    }

    //made payment and add payment to the Payment list
    public static void madePayment(String TID, double totalCharges, String CreditCardName, String CardExpirationDate, String billingAddress, String billingCardNumber) throws IOException {
        Payments.add(new Payment(TID,totalCharges,CreditCardName,CardExpirationDate,billingAddress,billingCardNumber));
        SerializeMovieDB.writeSerializedObject("Payment.dat", Initialise.payments);
    }

    public static String createTID(Ticket t) {
        //Each payment will have a transaction id (TID). 
        //The TID is of the format XXXYYYYMMDDhhmm (Y : year, M : month, D : day, h : hour, m : minutes, XXX:cinemacodeinletters)
        
        //get XXX (CinemaCode) 
        String cinemaCode = t.getCinema().getCinemaCode();
        //get YYYYMMDDhhmm
        String dateTime = Initialise.dt.paymentDateTime();
        //combine to get TID 
        String StringTID = cinemaCode + dateTime;
        //convert string to int
        //int TID = Integer.parseInt(StringTID);
        return StringTID;
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
            System.out.println("\n");
            // System.out.println("Movie: " + Tickets.get(i).getMovie());
            // System.out.println("Showtime: "+ Tickets.get(i).getShowDate() + " " + Tickets.get(i).getShowTime());
            // System.out.println("Cineplex: " + Tickets.get(i).getCineplex() + " Cinema " + Tickets.get(i).getCinema());
            // System.out.println("Seat Number: " + Tickets.get(i).getSeat().getSeatId());
            // System.out.println("Ticket Price: " + Tickets.get(i).getTicketPrice());
        }
    }
 
    //update sales of each movie and top5 array 
    public static void updateSales(ArrayList <Ticket> cartTickets) throws IOException {

        int size = cartTickets.size();
        //iterate thru Tickets --> find movie and add ticketprice to sales 
        //all tickets in cart have the same movie 
        Movie movie = cartTickets.get(0).getMovie();

        for (int i=0; i<size; i++) {
            //update sales for each ticket 
            movie.setSales(movie.getSales() + cartTickets.get(i).getTicketPrice());
        }

        SerializeMovieDB.writeSerializedObject("Movie.dat", Initialise.movies);

        int exist = 0;
        //movie sales updated
        //update top5 sales array 
        ArrayList <Movie> top5Sales = MovieController.getTop5BySales();
        //check if movie is alr in the top5sales
        for (int i=0; i< top5Sales.size(); i++) {
            if (movie.getMovieTitle() == top5Sales.get(i).getMovieTitle()) {
                exist = 1;
                break;
            }
        }
        //add movie with updated sales into the top5sales array (if it isn't alr in the top5array)
        if (exist == 0) {
            //TO DO(MC) NEED NEW MOVIE CONSTRUCTOR --> TO put in movie with the new sales value 
            top5Sales.add(movie);

        }
        //sort the array 
        Collections.sort(top5Sales, new CompareBySales());
        //remove last index if (size > 5)
        if (top5Sales.size() > 5) {
            //remove the sixth movie 
            top5Sales.remove(5);
        }

        SerializeMovieDB.writeSerializedObject("Top5BySales.dat", Initialise.top5BySales);

    }

    static class CompareBySales implements Comparator<Movie> {
        public int compare(Movie a, Movie b) {
                    return (int)(a.getSales() - b.getSales());
        }   
    }
 
    //update ticket history for each customer
    //add cartTickets to the boughtTix array
    public static void updateTicketHistory(Customer cus) throws IOException {
        ArrayList <Ticket> cartTickets = cus.getCartTickets();
        int size = cartTickets.size(); 
        for (int i=0; i<size; i++) {
            cus.getBoughtTickets().add(cartTickets.get(i));
            //cus.setBoughtTickets(cus.getBoughtTickets());
            SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);
        }
        //SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);
    }

}