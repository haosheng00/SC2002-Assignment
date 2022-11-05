package ui;

import java.util.Scanner;
import controller.*;

public class ReviewUI {

    public static void initiateReviewUI() {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        String username = "Hello";

        do {
            System.out.println("========================================");
            System.out.println("Please select an option:");
            System.out.println("(1) Add Review ");
            System.out.println("(2) Delete Review ");
            System.out.println("(3) Edit Review ");
            System.out.println("(4) Back");
            System.out.println("========================================");
            choice = sc.nextInt();

            switch(choice) {
                case 1: 
                    ReviewController.addReview(username);
                    break;
                case 2:
                    ReviewController.deleteReview(username);
                    break;
                case 3:
                    ReviewController.updateReview(username);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            } 
        } while (choice != 4);
    }
}
