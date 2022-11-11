package ui;

import java.util.Scanner;

import classes.DropDownMenu;
import controller.MovieController;
import initialiser.Initialise;
 
/**
 * Prints the methods that admin can call to make changes/view the movies array list
 * @throws Exception
 */
public class MovieUI {

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
            try{
            choice = sc.nextInt();}
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
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
                    if (movieChoice == -1){
                        break;
                    }
                    MovieController.printMovie(movieChoice);
                    break;
                default:
                    break;
            }
        } while (choice < 5);
        AdminMenuUI.adminMenuOptions();
    }
}
