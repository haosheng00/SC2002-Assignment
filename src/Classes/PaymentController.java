package Classes;

import java.util.Scanner;
import java.util.ArrayList;

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
        double totalCharges;
        String name;
        String cardNumber;
        String billingAddress;
        String cvc;

        System.out.println("Cart: ");
        //how to get tickets array from ticket class?
        showAllTickets(cartTickets);
        System.out.println("Would you like to proceed to check out your cart? (Enter 1 for yes, 0 to cancel check out");
        choice = sc.nextInt();
        //if cancel checkout
        if (choice == 0) {
            System.out.println("Cancelling check out...");
            return;
        }
        //proceed with the checkout
        totalCharges = calcPayment(cartTickets)*(1+GST);
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
        //NEED TO MAKE A PAYMENT ID - DISCUSS HOW TO MAKE PAYMENT ID
        madePayment(TID, totalCharges, name, billingAddress, cardNumber);
        System.out.println("Thank you for your purchase. We hope you enjoy for movie!");
    }

    //made payment and add payment to the Payment list
    public void madePayment(int TID, double totalCharges, String CreditCardName, String billingAddress, String billingCardNumber) {
        Payments.add(new Payment(TID,totalCharges,CreditCardName,billingAddress,billingCardNumber));
    }

    //what is checkout()
    public double calcPayment(Ticket[] cartTickets) {
        int size = cartTickets.length;
        int sum = 0;
        for (int i=0; i<size; i++) {
            sum += cartTickets[i].ticketPrice;
        }
        return sum;
    }

    public void printReceipt(Ticket[] cartTickets) {
        int size = cartTickets.length;
        System.out.println("Receipt:");
        for (int i=0; i<size; i++) {
            //System.out.println("Name: " + cartTickets[i].);
            //ticket number
            System.out.println("Ticket " + (i+1));
            System.out.println("Movie: " + cartTickets[i].movie);
            System.out.println("Showtime: "+ cartTickets[i].showDate + " " + cartTickets[i].showTime);
            System.out.println("Cineplex: " + cartTickets[i].cineplex + " Cinema " + cartTickets[i].cinema);
            System.out.println("Seat Number: " + cartTickets[i].seat.seatID);
            System.out.println("Ticket Price: "+ cartTickets[i].ticketPrice);
        }
        System.out.println("Total Payment: " + calcPayment(cartTickets));

    }

    //show all tickets in the cart?
    public void showAllTickets(Ticket[] cartTickets) {
        int size = cartTickets.length;
        System.out.println("Tickets in cart:");
        for (int i=0; i<size; i++) {
            //System.out.println("Name: " + cartTickets[i].);
            //ticket number
            System.out.println("Ticket " + (i+1));
            System.out.println("Movie: " + cartTickets[i].movie);
            System.out.println("Showtime: "+ cartTickets[i].showDate + " " + cartTickets[i].showTime);
            System.out.println("Cineplex: " + cartTickets[i].cineplex + " Cinema " + cartTickets[i].cinema);
            System.out.println("Seat Number: " + cartTickets[i].seat.seatID);
            System.out.println("Ticket Price: "+ cartTickets[i].ticketPrice);
        }
    }
}
