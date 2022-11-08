package ui;

import controller.ScreeningController;
import initialiser.Initialise;

import java.io.IOException;
import java.util.Scanner;

//import classes.Cineplex;
public class ScreeningUI {
    public static void initiateScreeningUI() throws IOException {
        int option = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("========================================");
            System.out.println("Please select an option:");
            System.out.println("(1) Add Screening");
            System.out.println("(2) Delete Screening");
            System.out.println("(3) Show Screening");
            System.out.println("(4) Go Back To Previous Page");
            System.out.println("========================================");
            option = sc.nextInt();
            switch (option) {
                case 1:
                    ScreeningController.addScreening(Initialise.cineplexes);
                    break;
                case 2:
                    ScreeningController.deleteScreening(Initialise.cineplexes);
                    break;
                case 3:
                    ScreeningController.showScreening(Initialise.cineplexes);
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid Input");
            }
    }while (option != 4);
    sc.close();
    }
}
