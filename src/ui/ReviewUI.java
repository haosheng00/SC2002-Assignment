package ui;

import java.util.Scanner;
import Initialiser.Initialise;

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
            System.out.println("(4) Go Back To Main Menu");
            System.out.println("========================================");
            choice = sc.nextInt();

            switch(choice) {
                case 1: 
                    Initialise.rc.addReview(username);
                    break;
                case 2:
                    Initialise.rc.deleteReview(username);
                    break;
                case 3:
                    Initialise.rc.updateReview(username);
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
