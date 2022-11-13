package controller;

import java.io.IOException;
import java.text.ParseException;
import java.util.*;

import classes.*;
import initialiser.Initialise;
import ui.*;
import serialiser.*;

/**
 * Contains the methods related to pre-, during, and post-payment of movie tickets
 */
public class PaymentController {

    private static ArrayList<Payment> Payments = Initialise.payments;


    /**
     * Allows the customer to check out the tickets added with only credit card purchase option
     * @param customer customer object
     * @throws Exception
     */
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

        ArrayList <Ticket> cartTickets = customer.getCartTickets();

        //get cart tickets from customer class
        showTickets(cartTickets);
        System.out.println("========================================");
        System.out.println("Would you like to proceed to check out your cart? (Enter 1 for yes, 0 to cancel check out)");
        
        do {
            try {
                choice = sc.nextInt();
                if (choice != 0 && choice != 1) {
                    System.out.println("Invalid option. Please enter 0 or 1:");
                }
                //if cancel checkout
                else if (choice == 0) {
                    System.out.println("Cancelling check out...");
                    for (int i = 0; i < customer.getCartTickets().size(); i++){
                        customer.getCartTickets().get(i).getSeat().setIsReserved(false);
                    }
                    customer.getCartTickets().clear();
                    SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);
                    CustomerMenuUI.customerMenuOptions(customer);
                }
                else break;
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer:");
                sc.next();
            }
        } while (true);
    
        //proceed with the checkout
        totalCharges = calcPayment(cartTickets);
        System.out.println("========================================");
        System.out.println(" ");
        System.out.println("Please enter your credit card details:");
        System.out.println(" ");
        String buffer = sc.nextLine();
        System.out.println("Full Name: ");
        name = sc.nextLine();
        System.out.println("Card Number: ");
        cardNumber = sc.nextLine();
        System.out.println("Expiration Date (mm/YY):");
        cardExpirationDate = sc.nextLine();
        System.out.println("Billing Address: ");
        billingAddress = sc.nextLine();
        System.out.println("Please enter your CVC/CVV: ");
        cvc = sc.nextLine();
        System.out.printf("The amount of $%.2f ", totalCharges);
        System.out.println("will be charged to your card, under the name " + name); 

        TID = createTID(cartTickets.get(0));
        madePayment(TID, totalCharges, name, cardExpirationDate, billingAddress, cardNumber);

        //Print Receipt 
        printReceipt(cartTickets, TID);

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
        customer.getCartTickets().clear();

        SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);

        System.out.println(" ");
        System.out.println("Thank you for your purchase. We hope you enjoy your movie!");

        CustomerMenuUI.customerMenuOptions(customer);
    }

    /**
     * Adds the payment details of the current checkout to the payments array list
     * @param TID transaction ID
     * @param totalCharges total ticket cost
     * @param CreditCardName cardholder's name of card used for payment
     * @param CardExpirationDate credit card's expiry date in format MMYY
     * @param billingAddress billing address registered to card used
     * @param billingCardNumber card number of credit card used
     * @throws IOException
     */
    public static void madePayment(String TID, double totalCharges, String CreditCardName, String CardExpirationDate, String billingAddress, String billingCardNumber) throws IOException {
        Payments.add(new Payment(TID,totalCharges,CreditCardName,CardExpirationDate,billingAddress,billingCardNumber));
        SerializeMovieDB.writeSerializedObject("Payment.dat", Initialise.payments);
    }

    /**
     * Creates a transaction ID for the payment made
     * @param t ticket
     * @return transaction ID
     */
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

    /**
     * Adds up the total cost of the tickets added and returns the total cost
     * @param cartTickets array list of tickets added and pending payment
     * @return total cost of tickets added
     */
    public static double calcPayment(ArrayList<Ticket> cartTickets) {
        int size = cartTickets.size();
        double sum = 0;
        for (int i=0; i<size; i++) {
            //change name accordingly
            sum += cartTickets.get(i).getTicketPrice();
        }
        return sum;
    }

    /**
     * Prints the details of the tickets added with the total cost of all the tickets added
     * @param cartTickets tickets added
     * @throws ParseException
     */
    public static void printReceipt(ArrayList<Ticket> cartTickets, String TID) throws ParseException {
        int size = cartTickets.size();
        System.out.println(" ");
        System.out.println("Receipt:");
        System.out.println(" ");
        System.out.println("TID: " + TID);
        System.out.println(" ");
        for (int i=0; i<size; i++) {
            //ticket number
            System.out.println("Ticket " + (i+1));
            TicketController.printTicket(cartTickets.get(i));
            System.out.println("\n");
        }
        System.out.printf("Total Payment: $%.2f", calcPayment(cartTickets));    
    }

    /**
     * Prints the details of the tickets added/purchased
     * @param Tickets tickets added/purchased
     * @throws ParseException
     */
    public static void showTickets(ArrayList<Ticket> Tickets) throws ParseException {
        System.out.println(" ");
        int size = Tickets.size();
        System.out.println("Tickets in cart:");
        System.out.println(" ");
        for (int i=0; i<size; i++) {
            //ticket number
            System.out.println("Ticket " + (i+1));
            TicketController.printTicket(Tickets.get(i));
            System.out.println("\n");
        }

        double totalCharges = calcPayment(Tickets);
        System.out.printf("The total amount is $%.2f\n", totalCharges);
    }
 
    /**
     * Updates the sales amount of the movie by adding the ticket charges of the movie in current payment to current total sales amount
     * @param cartTickets tickets added/purchased
     * @throws IOException
     */
    public static void updateSales(ArrayList <Ticket> cartTickets) throws IOException {

        int i = 0;
        
        int size = cartTickets.size();
        int movieIndex = 0;
        //iterate thru Tickets --> find movie and add ticketprice to sales 
        //all tickets in cart have the same movie
        Movie movie = cartTickets.get(0).getMovie();
        ArrayList <Movie> movies = Initialise.movies;
        //get index of movie
        for (i=0; i<movies.size(); i++) {
            if (movie.getMovieTitle().equals(movies.get(i).getMovieTitle())) {
                movieIndex = i;
                break;
            }
        }
        Movie targetMovie = Initialise.movies.get(movieIndex);
        //System.out.println("Before: " + targetMovie.getSales());

        for (i=0; i<size; i++) {
            //update sales for each ticket 
            //System.out.println("Ticket Price: " + cartTickets.get(i).getTicketPrice());
            targetMovie.setSales(targetMovie.getSales() + cartTickets.get(i).getTicketPrice());
        }
        //System.out.println("After: " + targetMovie.getSales());

        SerializeMovieDB.writeSerializedObject("Movie.dat", Initialise.movies);

        int exist = 0;
        //movie sales updated
        //update top5 sales array 
        ArrayList <Movie> top5Sales = Initialise.top5BySales;
        //check if movie is alr in the top5sales
        for (i=0; i< top5Sales.size(); i++) {
            if (movie.getMovieTitle().equals(top5Sales.get(i).getMovieTitle())) {
                //System.out.println("Hello");
                exist = 1;
                //if exists, replace with movie with updated sales 
                top5Sales.set(i,targetMovie);
                break;
            }
        }
        //add movie with updated sales into the top5sales array (if it isn't alr in the top5array)
        if (exist == 0) {
            top5Sales.add(targetMovie);
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

    /**
     * Compares the sales amounts of two specific movies
     */
    static class CompareBySales implements Comparator<Movie> {
        /**
         * Subtracts the sales amount of movie a from sales amount of movie b to get the difference in the sales amounts
         * @param a movie a
         * @param b movie b
         */
        public int compare(Movie a, Movie b) {
            if (a.getSales() > b.getSales()) return -1;
            if (a.getSales() < b.getSales()) return 1;
            return 0;
        }
    }
 
    /**
     * Updates the ticket history of the customer by adding tickets that was just purchased into bought tickets array list
     * @param cus customer
     * @throws IOException
     */
    public static void updateTicketHistory(Customer cus) throws IOException {
        ArrayList <Ticket> cartTickets = cus.getCartTickets();
        int size = cartTickets.size(); 
        for (int i=0; i<size; i++) {
            cus.getBoughtTickets().add(cartTickets.get(i));
            //cus.setBoughtTickets(cus.getBoughtTickets());
        }
        SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);
    }
}