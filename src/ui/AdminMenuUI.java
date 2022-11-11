package ui;

import java.util.Scanner;
public class AdminMenuUI{
    public static void adminMenuOptions() throws Exception{
        Scanner scanner = new Scanner(System.in);
        int option = 0;
            System.out.println("========================================");
            System.out.println("Hello! Please select an option.");
            System.out.println("(1) - Movie Controls");
            System.out.println("(2) - Screening Controls");
            System.out.println("(3) - Ticket Controls");
            System.out.println("(4) - Listing Controls");
            System.out.println("(5) - Log out");
        do{
            try {
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
                    ListingUI.initiateListingUI();
                    break;
                case 5:
                    AccountUI.initiateLoginUI(0);
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                scanner.next();
            }
        }while (option != 5);
        
    }
}