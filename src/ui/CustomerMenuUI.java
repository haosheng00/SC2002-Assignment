package ui;
import java.util.Scanner;

import classes.*;
import controller.*;
import initialiser.Initialise;
import classes.DropDownMenu;

/**
 * Contains the methods related to customer's main menu
 */
public class CustomerMenuUI{

    //private static final String Syst = null;

    /**
     * Prints the available options for customer to navigate/view in the movie booking system and calls the respective methods
     * @throws Exception
     */
    public static void customerMenuOptions(Customer customer) throws Exception{
        Scanner sc = new Scanner(System.in);
        int option = -1;
            do {
                System.out.println("========================================");
                System.out.println("Please select an option.");
                System.out.println("(1) - Search Movie");
                System.out.println("(2) - Book Tickets");
                System.out.println("(3) - View Past Tickets");
                System.out.println("(4) - Your Reviews");
                System.out.println("(5) - See Top 5 Movies");
                System.out.println("(6) - Log Out");
                System.out.println("========================================");
                try {
                    option = sc.nextInt();
                    switch (option) {
                        case 1:
                            int movieIndex = -1;
                            movieIndex = DropDownMenu.initiateMovieChoice_CustomerMenu(1);
                            if (movieIndex == -1) {
                                break;
                            }
                            MovieController.printMovie(movieIndex);
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
                            //ADD TO SERIALIZER
                            MovieController.getTop5Movies(Initialise.listingCriteria.get(0));
                            break;
                        case 6:
                            break;
                        default:
                            System.out.println("Invalid option. Please enter an integer (1-6):");
                            break;
                    }
                }
                catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer: ");
                    sc.next();
                }
        }while (option !=6);
            AccountUI.WelcomePage();
    }
    

    /**
     * Prints the available options for guest to navigate/view in the movie booking system and calls the respective methods
     * @throws Exception
     */
    public static void guestMenuOptions() throws Exception{

        int option = 0;
        
        do{
        Scanner sc = new Scanner(System.in);
            System.out.println("========================================");
            System.out.println("Please select an option.");
            System.out.println("(1) - Search Movie");
            System.out.println("(2) - Book Tickets");
            System.out.println("(3) - See Top 5 Movies");
            System.out.println("(4) - Back");
            System.out.println("========================================");
        
            try {
                option = sc.nextInt();
                switch (option) {
                    case 1:
                        int movieIndex = -1;
                        movieIndex = DropDownMenu.initiateMovieChoice_CustomerMenu(1);
                        if (movieIndex == -1) {
                            break;
                        }
                        MovieController.printMovie(movieIndex);
                        break;
                    case 2:
                        AccountUI.initiateLoginUI(2);
                        break;
                    case 3:
                        MovieController.getTop5Movies(Initialise.listingCriteria.get(0));
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid option. Please enter an integer (1-4):");
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
        }while(option!=4);
    
    }

}