package ui;
import java.util.Scanner;

import Classes.MovieController;

public class MovieUI {

    public void initiateMovieUI(){
        Scanner sc = new Scanner(System.in);
        int choice;
        do{
            System.out.println("Please select an option");
            System.out.println("(1) Add Movie");
            System.out.println("(2) Delete Movie");
            System.out.println("(3) Update Movie");
            System.out.println("(4) Search Movie");
            System.out.println("(5) back");
            choice = sc.nextInt();
            switch(choice){
                case 1:
                    MovieController.addMovie();
                    break;
                case 2:
                    MovieController.deleteMovie();
                    break;
                case 3:
                    // MovieController.updateMovie();
                case 4:
                    String movieTitle = sc.next();
                    MovieController.searchMovie(movieTitle);
                default:
                    break;
            }
        }while(choice<5);
        sc.close();
    }
}

