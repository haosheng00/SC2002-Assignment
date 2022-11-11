package ui;

import java.util.Scanner;

import classes.DropDownMenu;
import controller.MovieController;
import initialiser.Initialise;
 
/**
 * Contains the initiation of UI for admin to manage movies available
 */
public class MovieUI {

    /**
     * Prints the methods that admin can call to make changes/view the movies array list
     * @throws Exception
     */
    public static void initiateMovieUI() throws Exception {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {
            System.out.println("Please select an option");
            System.out.println("(1) Add Movie");
            System.out.println("(2) Delete Movie");
            System.out.println("(3) Update Movie");
            System.out.println("(4) Search Movie");
            System.out.println("(5) Back");
            try {
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        MovieController.addMovie();
                        break;
                    case 2:
                        MovieController.deleteMovie();
                        break;
                    case 3:
                        MovieController.updateMovie();
                        break;
                    case 4:
                        int movieChoice = DropDownMenu.initiateAdminMovieChoice(Initialise.movies);
                        if (movieChoice == -1) {
                            break;
                        }
                        MovieController.printMovie(movieChoice);
                        break;
                    case 5:
                        break;
                    default:
                        System.out.println("Invalid option. Please enter an integer (1-5):");
                        break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer:");
                sc.next();
            }
        } while (choice!=5);
        AdminMenuUI.adminMenuOptions();
    }
}
