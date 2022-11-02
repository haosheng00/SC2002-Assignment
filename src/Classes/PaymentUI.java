package Classes;

import java.util.Scanner;

public class PaymentUI {
    public static void initiatePaymentUI() {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("========================================");
            System.out.println("Hi! Please select an option:");
            System.out.println("(1) View Tickets in Cart");
            System.out.println("(2) Checkout and Make Payment");
            //need 2 separate ? --> tickets in cart and tickets in history
            System.out.println("(3) View Ticket History");
            System.out.println("(4) Go Back To Main Menu");
            System.out.println("========================================");
            choice = sc.nextInt();
            switch(choice) {
                //initialise class obj
                case 1:
                    //Ticket array and Cartticket array??
                    showAllTickets(cartTickets);
                case 2:
                    checkoutUI();
                case 3:
                    showAllTickets(cartTickets);
                case 4:
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }
}
