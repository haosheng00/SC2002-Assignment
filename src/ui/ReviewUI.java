package ui;

import java.util.Scanner;

import classes.*;
import controller.*;

/**
 * Contains the initiation of UI related to customer's reviews
 */
public class ReviewUI {

    /**
     * Initiate Review UI which allows customers to add, delete, edit or view the reviews 
     * @param customer customer object 
     * @throws Exception
     */

    public static void initiateReviewUI(Customer customer) throws Exception {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("========================================");
            System.out.println("Please select an option:");
            System.out.println("(1) Add Review ");
            System.out.println("(2) Delete Review ");
            System.out.println("(3) Edit Review ");
            System.out.println("(4) View your review(s) ");
            System.out.println("(5) Back");
            System.out.println("========================================");
            try {
                choice = sc.nextInt();            
                switch(choice) {
                    case 1: 
                        ReviewController.addReview(customer);
                        break;
                    case 2:
                        ReviewController.deleteReview(customer);
                        break;
                    case 3:
                        ReviewController.updateReview(customer);
                        break;
                    case 4:
                        ReviewController.printCustomerReviews(customer);
                        break;
                    case 5:
                        return;
                    default:
                        System.out.println("Invalid option. Please enter an integer (1-5):");
                        break;
                } 
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer:");
                sc.next();
            }
        } while (choice != 5);
    }
}
