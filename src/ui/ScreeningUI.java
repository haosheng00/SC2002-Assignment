package ui;

import controller.ScreeningController;
import initialiser.Initialise;

import java.io.IOException;
import java.util.Scanner;


/**
 * Contains the initiation of the UI for admin to manage screenings of movies
 */
public class ScreeningUI {

    /**
     * Prints available options for admin to manage screenings and calls the respective function
     * @throws IOException
     */
    public static void initiateScreeningUI() throws IOException {
        int option = 0;
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("========================================");
            System.out.println("Please select an option:");
            System.out.println("(1) Add Screening");
            System.out.println("(2) Delete Screening");
            System.out.println("(3) Show Screening");
            System.out.println("(4) Back");
            System.out.println("========================================");
            try {
                option = sc.nextInt();
            switch (option) {
                case 1:
                    ScreeningController.addScreening();
                    break;
                case 2:
                    ScreeningController.deleteScreening();
                    break;
                case 3:
                    ScreeningController.showScreening(Initialise.cineplexes);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Input. Please enter an integer (1-4):");
                    break;
            }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
    }while (option != 4);
    }
}
