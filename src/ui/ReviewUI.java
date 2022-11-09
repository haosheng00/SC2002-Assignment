package ui;

import java.util.Scanner;

import classes.*;
import controller.*;

public class ReviewUI {

    public static void initiateReviewUI(Customer customer) throws Exception {

        Scanner sc = new Scanner(System.in);
        int choice = 0;

        do {
            System.out.println("========================================");
            System.out.println("Please select an option:");
            System.out.println("(1) Add Review ");
            System.out.println("(2) Delete Review ");
            System.out.println("(3) Edit Review ");
            System.out.println("(4) Back");
            System.out.println("========================================");
            choice = sc.nextInt();
            
            // try{
            //     choice = sc.nextInt();
            //     //choice = Integer.parseUnsignedInt(choice); 
            // }
            // catch (Exception e) {
            //     //return;
            // }

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
                    break;
                default:
                    System.out.println("Invalid input!");
                    break;
            } 
        } while (choice < 4);
        //sc.close();
    }
    
}
