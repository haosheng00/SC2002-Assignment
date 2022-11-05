package ui;
import Initialiser.Initialise;
import java.util.Scanner;

import controller.*;

public class CustomerMenuUI{

    public static void customerMenuOptions(){
        try (Scanner sc = new Scanner(System.in)) {
        int option = 0;
        do{
                System.out.println("========================================");
                System.out.println("Please select an option.");
                System.out.println("(1) - Search Movie");
                System.out.println("(2) - Book Tickets");
                System.out.println("(3) - View Past Tickets");
                System.out.println("(4) - Movie reviews");
                System.out.println("(5) - See Top 5 Movies");
                System.out.println("(6) - Log Out");
                option = sc.nextInt();
                switch(option){
                    case 1: 
                        System.out.println("Enter the title of the Movie: ");
                        String movieTitle = sc.next();
                        int index = MovieController.searchMovie(movieTitle);
                        if (index == -1) {
                        System.out.println("The movie entered does not exist. Please enter the title again");}
                        //if movie exists --> show all the details of the movie 
                        else {
                            MovieController.printMovie(movieTitle);
                        }
                        break;
                    case 2:
                        TicketController.createBooking(Initialise.cineplexes);
                        break;
                    case 3:
                        //Use serialiser here 
                        CustomerController.viewPastTickets (current.username);
                        break;
                    case 4: 
                        ReviewUI.initiateReviewUI();
                        break;
                    case 5:
                    //current returns an array of top5 movies, tp discuss with team on whether we need a movie UI
                    // because searchMovie also has a similar problem
                        MovieController.getTop5Movies();
                        break;
                    case 6:
                        break;
                    default:
                    System.out.println("Invalid Input");
                    break;
                }
            }while (option < 6);
        }
    }

    public static void guestMenuOptions(){
        Scanner sc = new Scanner(System.in);
        int option;
        do{
            System.out.println("========================================");
            System.out.println("Please select an option.");
            System.out.println("(1) - Search Movie");
            System.out.println("(2) - Book Tickets");
            System.out.println("(3) - See Top 5 Movies");
            System.out.println("(4) - back");
            option = sc.nextInt();
            switch(option){
                case 1: 
                System.out.println("Enter the title of the Movie: ");
                String movieTitle = sc.next();
                int index = MovieController.searchMovie(movieTitle);
                if (index == -1) {
                System.out.println("The movie entered does not exist. Please enter the title again");}
                //if movie exists --> show all the details of the movie 
                else {
                    MovieController.printMovie(movieTitle);
                }
                break;
            case 2:
                TicketController.createBooking(Initialise.cineplexes);
                break;
            case 3:
                MovieController.getTop5Movies();
                break;
            case 4:
                break;
            default:
                break;
            }
        }while(option<4);
    }
}
