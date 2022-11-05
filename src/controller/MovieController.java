package controller;
import java.util.ArrayList;
import java.util.Scanner;
import Initialiser.Initialise;
import Classes.*;
import Classes.Enum.MovieGenre;
import Classes.Enum.MovieStatus;


public class MovieController {
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Movie> movies = Initialise.movies;
    static ArrayList<Movie> top5BySales = Initialise.top5BySales;
    static ArrayList<Movie> top5ByRatings = Initialise.top5ByRatings;
    
    public static int searchMovie(String movieTitle){
        movieTitle = movieTitle.toUpperCase();
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getMovieTitle() == movieTitle){
                return i;
            }
        }
        return -1;
    }
    public static void addMovie(){
        String movieTitle, synopsis, director;
        String[] casts;
        Classes.Enum.MovieGenre[] movieGenres;
        Classes.Enum.MovieStatus movieStatus;
        Classes.Enum.AgeRestriction ageRestriction;
        boolean is3D;
        double overallRating;
        Review[] reviews;
        int movieDuration;
        String s = null;
        String ms = null;

        // movieTitle = null;
        int exists = -2;
        System.out.println("Please enter new Movie Title:");
        movieTitle = sc.next();
        exists = searchMovie(movieTitle);
        while(exists!=-1){
            Movie newMovie = new Movie(movieTitle.toUpperCase());
            // System.out.println("Please enter Movie Status:");
            // ms = sc.next();
            // newMovie.setMovieStatus(ms);
            System.out.println("Please enter Movie Synopsis:");
            newMovie.setSynopsis(sc.next());
            System.out.println("Please enter Movie Director: ");
            newMovie.setDirector(sc.next());
            while (s != "Y" || s !="N"){
                System.out.println("Is the movie 3D? (Y/N)");
                s = sc.next();
                if (s == "Y") newMovie.setIs3D(true);
                else if (s == "N") newMovie.setIs3D(false);
            }
            break;
        }
    }
        
    public static int deleteMovie(){
        System.out.println("Please enter Movie to delete: ");
        String movieTitle = sc.next();
        int exists = searchMovie(movieTitle);
        if(exists == -1){
        movies.remove(exists);
        return 1;
        }
        else 
            System.out.println("Movie does not exist");
        
        return 0;
    }

    public static int updateMovie(){
        String movieTitle;
        System.out.println("Enter Movie Title: ");
        movieTitle = sc.next();
        int index = searchMovie(movieTitle);
        int choice = 0;

        System.out.println("Select one option:");
        System.out.println("(1) Update Movie Title");
        System.out.println("(2) Update Movie Status");
        System.out.println("(3) Back to previous menu");

        choice = sc.nextInt();
        switch(choice){
            case 1:
                movies.get(index).setMovieTitle(sc.next().toUpperCase());
                break;
            case 2:
                System.out.println("Update to:");
                System.out.println("(1) Coming soon");
                System.out.println("(2) Preview");
                System.out.println("(3) End of showing");
                System.out.println("(4) Now showing");
                int i = sc.nextInt();
                switch(i){
                    case 1:
                        movies.get(index).setMovieStatus(MovieStatus.COMING_SOON);
                        break;
                    case 2:
                        movies.get(index).setMovieStatus(MovieStatus.PREVIEW);
                        break;
                    case 3:
                        movies.get(index).setMovieStatus(MovieStatus.END_OF_SHOWING);
                        break;
                    case 4:
                        movies.get(index).setMovieStatus(MovieStatus.NOW_SHOWING);
                        break;
                }
                break;
                case 3:
                    break;
        }
        return 0;
    }

    public static void printMovie(String movieTitle){
        int index = searchMovie(movieTitle);
        if(index != -1){
            System.out.println("Movie Title: " );
        }

        //TODO: PRINT DETAILS 

    }
    public static ArrayList<Movie> getMovieList(){
        return MovieController.movies;
    }

    //TODO: create function for printing list of movies

    public static void getTop5Movies(int criteria){        
        
        int choice = sc.nextInt();
        
        if(criteria == 3){
            System.out.println("Sort by:");
            System.out.println("(1) - By Overall Rating");
            System.out.println("(2) - By Sales");
            //TODO: Catch invalid option
            if (choice == 1) {
                for (int i = 0; i < top5ByRatings.size(); i++){
                    MovieController.printMovie(top5ByRatings.get(i).getMovieTitle());
                }
            }
            else {
                for (int i = 0; i < top5BySales.size(); i++){
                    MovieController.printMovie(top5BySales.get(i).getMovieTitle());
                }
            }
        }
        else if (criteria == 1){
            System.out.println("Movies by Overall Rating: ");
            for (int i = 0; i < top5ByRatings.size(); i++){
                    MovieController.printMovie(top5ByRatings.get(i).getMovieTitle());
                }
        }
        else if (criteria == 2){
            System.out.println("Movies by Sales: ");
            for(int i = 0; i < top5BySales.size(); i++){
                MovieController.printMovie(top5BySales.get(i).getMovieTitle());
            }
        }
    }
}