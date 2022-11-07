package ui;
import java.util.Scanner;

import classes.*;
import controller.*;
import initialiser.Initialise;
import classes.DropDownMenu;

public class CustomerMenuUI{

    //private static final String Syst = null;

    public static void customerMenuOptions(Customer customer){
        Scanner sc = new Scanner(System.in);
        int option = -1;
        do{
                System.out.println("========================================");
                System.out.println("Please select an option.");
                System.out.println("(1) - Search Movie");
                System.out.println("(2) - Book Tickets");
                System.out.println("(3) - View Past Tickets");
                System.out.println("(4) - Your Reviews");
                System.out.println("(5) - See Top 5 Movies");
                System.out.println("(6) - Log Out");
                option = sc.nextInt();
                switch(option){
                    case 1: 
                        int movieIndex = -1;
                        movieIndex = DropDownMenu.initiateMovieChoice_CustomerMenu(1);
                        MovieController.printMovie(Initialise.movies.get(movieIndex).getMovieTitle());
                        break;
                    case 2:
                        TicketController.createBooking(Initialise.cineplexes, customer);
                        break;
                    case 3:
                        //Use serialiser here 
                        CustomerController.viewPastTickets(customer);
                        break;
                    case 4: 
                        ReviewUI.initiateReviewUI(customer);
                        break;
                    case 5:
                        MovieController.getTop5Movies(ListingController.getListingCriteria());
                        break;
                    case 6:
                        break;
                    default:
                    System.out.println("Invalid Input");
                    break;
                }
            }while (option < 6);
            sc.close();
        }
    

    public static void guestMenuOptions(){
        Scanner sc = new Scanner(System.in);
        int option = 0;
        do{
            System.out.println("========================================");
            System.out.println("Please select an option.");
            System.out.println("(1) - Search Movie");
            System.out.println("(2) - Book Tickets");
            System.out.println("(3) - See Top 5 Movies");
            System.out.println("(4) - Back");
            option = sc.nextInt();
            switch(option){
                case 1: 
                    int movieIndex = -1;
                    movieIndex = DropDownMenu.initiateMovieChoice_CustomerMenu(1);
                    MovieController.printMovie(Initialise.movies.get(movieIndex).getMovieTitle());
                    break;
                case 2:
                    AccountUI.initiateLoginUI(2);
                    break;
                case 3:
                    MovieController.getTop5Movies(ListingController.getListingCriteria());
                    break;
                case 4:
                    break;
                default:
                    break;
            }
        }while(option<4);
        sc.close();
    }

}