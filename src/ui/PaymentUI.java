package ui;

import java.util.Scanner;

import classes.*;
import controller.*;

/**
 * Contains the initiation of UI for customer trying to make payment
 */
public class PaymentUI {
    /**
     * Prints the available options customer can choose from while trying to checkout
     * @param customer
     * @throws Exception
     */
    public static void initiatePaymentUI(Customer customer) throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        System.out.println("========================================");
        System.out.println("Please select an option:");
        System.out.println("(1) View Tickets in Cart");
        System.out.println("(2) Checkout and Make Payment");
        System.out.println("(3) Go Back To Main Menu");
        System.out.println("========================================");
        
        do {
            choice = sc.nextInt();
            try {
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
                        System.out.println("Invalid option. Please enter an integer (1-3): ");
                        break;
                    }    
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
        } while (true);
    }
        
}
