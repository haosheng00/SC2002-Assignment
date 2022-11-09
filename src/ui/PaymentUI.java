package ui;

import java.util.Scanner;

import classes.*;
import controller.*;
//import initialiser.Initialise;

public class PaymentUI {
    public static void initiatePaymentUI(Customer customer) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (choice != 4) {
            System.out.println("========================================");
            System.out.println("Hi! Please select an option:");
            System.out.println("(1) View Tickets in Cart");
            System.out.println("(2) Checkout and Make Payment");
            System.out.println("(3) Go Back To Main Menu");
            System.out.println("========================================");
            choice = sc.nextInt();
            switch(choice) {
                case 1:
                    PaymentController.showTickets(customer.getCartTickets());
                    break;
                case 2:
                    PaymentController.checkoutUI(customer);
                    break;
                case 3:
                    CustomerMenuUI.customerMenuOptions(customer);
                    //return;
                default:
                    System.out.println("Invalid input!");
                    break;
            }
        }
    }
}
