package ui;

import controller.ListingController;
import initialiser.Initialise;

import java.util.Scanner;
public class AdminMenuUI{
    public static void adminMenuOptions(){
        Scanner scanner = new Scanner(System.in);
        int option = 0;
        do{
            System.out.println("========================================");
            System.out.println("Hello! Please select an option.");
            System.out.println("(1) - Movie Controls");
            System.out.println("(2) - Screening Controls");
            System.out.println("(3) - Ticket Controls");
            System.out.println("(4) - Listing Controls");
            System.out.println("(5) - Go Back to Main Menu");
            System.out.println("========================================");
            option = scanner.nextInt();
            switch(option){
                case 1:
                //2 separate movieUIs for customer and manager - need to create!!
                    MovieUI.initiateMovieUI();
                    break;
                case 2:
                    ScreeningUI.initiateScreeningUI();
                    break;
                case 3:
                    TicketUI.initiateAdminTicketUI();
                    break;
                case 4: 
                    ListingController.initiateListingUI();
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }while (option != 3);
        scanner.close();
    }
}