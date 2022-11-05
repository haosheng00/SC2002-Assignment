package ui;

import Initialiser.Initialise;
import controller.CustomerController;
import controller.MovieController;
import controller.TicketController;

import java.util.Scanner;

public class CustomerMenuUI{

    public static void customerMenuOptions(){
        try (Scanner sc = new Scanner(System.in)) {
            int option = 0;
            do{
                System.out.println("========================================");
                System.out.println("Hello! Please select an option.");
                System.out.println("(1) - Search Movie");
                System.out.println("(2) - Book Tickets");
                System.out.println("(3) - View Past Tickets");
                System.out.println("(4) - Back");
                option = sc.nextInt();
                switch(option){
                    case 1: 
                        System.out.println("Enter the title of the Movie: ");
                        String movieTitle = sc.next();
                        int index = MovieController.searchMovie(movieTitle);
                        do {
                            if (index == -1) {
                            System.out.println("The movie entered does not exists. Please enter the title again");
                        }
                        //if movie exists --> show all the details of the movie 
                        else {
                            Initialise.mc.printMovie(movieTitle);
                        }
                        } while (index != -1);
                        break;
                    case 2:
                        TicketController.createBooking(Initialise.cineplexes);
                        break;
                    case 3:
                        //TODO: CREATE VIEW PAST TICKETS METHOD UNDER CUSTOMER CONTROLLER
                        //use serialiser to call username of the customer
                        CustomerController.viewPastTickets (username);
                    case 4: 
                        break;
                    default:
                        System.out.println("Invalid Input");
                        break;
                }
            }while (option != 3);
        }
    }
}