package ui;

import Initialiser.Initialise;

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
            System.out.println("(4) - Listing Controlsl");
            System.out.println("(5) - Go Back to Main Menu");
            System.out.println("========================================");
            option = scanner.nextInt();
            switch(option){
                case 1:
                //2 separate movieUIs for customer and manager - need to create!!
                    MovieUI.initiateMovieUI();
                    break;
                case 2:
                    System.out.println("Choose the Cineplex: ");
                    for (int i = 0; i < Initialise.cineplexes.size(); i++){
                        System.out.println("("+(i+1)+") "+Initialise.cineplexes.get(i).getCineplexName());
                    }
                    int cineplexChoice = scanner.nextInt();
                    ScreeningUI.initiateScreeningUI(Initialise.cineplexes.get(cineplexChoice-1));
                    break;
                case 3:
                    TicketUI.initiateTicketUI();
                    break;
                default:
                    System.out.println("Invalid Input");
                    break;
            }
        }while (option != 3);
    }
}