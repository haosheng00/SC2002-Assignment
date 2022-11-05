package ui;
import Initialiser.Initialise;
import java.util.Scanner;
import java.util.ArrayList;
import controller.*;
import Classes.*;

public class CustomerMenuUI{

    public static void customerMenuOptions(Customer customer){
        try (Scanner sc = new Scanner(System.in)) {
        int movieChoice = -1;
        int option = -1;
        int i = 0;
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
                    int exit = -1;
                    do{
                        System.out.println("Movie List");
                        for (i = 0; i < Initialise.Movies.size(); i++){
                            System.out.println("(" + (i+1) + ")" + " - " + Initialise.Movies.get(i).getMovieTitle());
                        }
                        System.out.println("Please select movie: ");
                        movieChoice = sc.nextInt();
                        //String movieTitle = sc.next();
                        //int index = MovieController.searchMovie(movieTitle);
                        if (movieChoice < 0 || movieChoice > i) {
                            System.out.println("The movie entered does not exist.");
                            System.out.println("(1) - Search again");
                            System.out.println("(2) - Exit");
                            exit = sc.nextInt();
                        }
                        //if movie exists --> show all the details of the movie 
                        else {
                            MovieController.printMovie(Initialise.Movies.get(movieChoice-1).getMovieTitle());
                            System.out.println("(1) - Search again");
                            System.out.println("(2) - Exit");
                            exit = sc.nextInt();
                        }
                        }while(exit != 2);
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
                    //current returns an array of top5 movies, to discuss with team on whether we need a movie UI
                    // because searchMovie also has a similar problem
                        ArrayList<Movie> top5 = MovieController.getTop5Movies();
                        for (i = 0; i < top5.size(); i++){
                            MovieController.printMovie(top5.get(i).getMovieTitle());
                        }
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
        int movieChoice = -1;
        int option = -1;
        int exit = -1;
        int i;
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
                    do{
                        System.out.println("Enter the title of the Movie: ");
                        for (i = 0; i < Initialise.Movies.size(); i++){
                            System.out.println("(" + (i+1) + ")" + " - " + Initialise.Movies.get(i).getMovieTitle());
                        }
                        movieChoice = sc.nextInt();
                        //String movieTitle = sc.next();
                        //int index = MovieController.searchMovie(movieTitle);
                        if (movieChoice < 0 || movieChoice > i) {
                            System.out.println("The movie entered does not exist.");
                            System.out.println("(1) - Search again");
                            System.out.println("(2) - Exit");
                            exit = sc.nextInt();
                        }
                        //if movie exists --> show all the details of the movie 
                        else {
                            MovieController.printMovie(Initialise.Movies.get(movieChoice-1).getMovieTitle());
                            System.out.println("(1) - Search again");
                            System.out.println("(2) - Exit");
                            exit = sc.nextInt();
                        }
                    }while(exit != 2);
                    break;
                case 2:
                    AccountUI.initiateLoginUI(2);
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
        sc.close();
    }
}
