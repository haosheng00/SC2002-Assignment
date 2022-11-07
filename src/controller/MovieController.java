package controller;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import classes.*;
import classes.Enum.AgeRestriction;
import classes.Enum.MovieGenre;
import classes.Enum.MovieStatus;
import ui.MovieUI;
import initialiser.Initialise;


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
        String movieTitle;
        String[] casts = null;
        classes.Enum.MovieGenre[] movieGenres = null;
        String s = null;

        int exists = -2;
        int j = -1;
        System.out.println("Please enter new Movie Title:");
        movieTitle = sc.next();
        exists = searchMovie(movieTitle);
        while(exists!=-1){
            Movie newMovie = new Movie(movieTitle.toUpperCase());
            System.out.println("Please select movie status:");
            System.out.println("(1) Coming soon");
            System.out.println("(2) Preview");
            System.out.println("(3) End of showing");
            System.out.println("(4) Now showing");
            int i = sc.nextInt();
            switch(i){
                case 1:
                    newMovie.setMovieStatus(MovieStatus.COMING_SOON);
                    break;
                case 2:
                    newMovie.setMovieStatus(MovieStatus.PREVIEW);
                    break;
                case 3:
                    newMovie.setMovieStatus(MovieStatus.END_OF_SHOWING);
                    break;
                case 4:
                    newMovie.setMovieStatus(MovieStatus.NOW_SHOWING);
                    break;
            }
            System.out.println("Please select movie genre: ");
            do{
                System.out.println("(1) Action");
                System.out.println("(2) Horror");
                System.out.println("(3) Thriller");
                System.out.println("(4) Adventure");
                System.out.println("(5) Comedy");
                System.out.println("(6) Anime");
                System.out.println("(7) Romance");
                System.out.println("(8) Drama");
                System.out.println("(9) True Story");
                System.out.println("(10) Others");
                System.out.println("(0) Go to Next Section");
                i = sc.nextInt();
                movieGenres = Arrays.copyOf(movieGenres, movieGenres.length+1);
                switch(i){
                    case 1:
                        movieGenres[movieGenres.length-1] = MovieGenre.ACTION;
                        break;
                    case 2:
                        movieGenres[movieGenres.length-1] = MovieGenre.HORROR;
                        break;
                    case 3:
                        movieGenres[movieGenres.length-1] = MovieGenre.THRILLER;
                        break;
                    case 4:
                        movieGenres[movieGenres.length-1] = MovieGenre.ADVENTURE;
                        break;
                    case 5:
                        movieGenres[movieGenres.length-1] = MovieGenre.COMEDY;
                        break;
                    case 6:
                        movieGenres[movieGenres.length-1] = MovieGenre.ANIME;
                        break;
                    case 7:
                        movieGenres[movieGenres.length-1] = MovieGenre.ROMANCE;
                        break;
                    case 8:
                        movieGenres[movieGenres.length-1] = MovieGenre.DRAMA;
                        break;
                    case 9:
                        movieGenres[movieGenres.length-1] = MovieGenre.TRUE_STORY;
                        break;
                    case 10:
                        movieGenres[movieGenres.length-1] = MovieGenre.OTHERS;
                        break;
                }
            }while (i != 0);
            System.out.println("Please enter Movie Synopsis:");
            newMovie.setSynopsis(sc.next());
            System.out.println("Please enter movie duration in mins:");
            newMovie.setMovieDuration(sc.nextInt());
            System.out.println("Please set age rating/restriction:");
            System.out.println("(1) G");
            System.out.println("(2) PG");
            System.out.println("(3) PG13");
            System.out.println("(4) NC16");
            System.out.println("(5) M18");
            System.out.println("(6) R21");
            i = sc.nextInt();
            switch(i){
                case 1:
                    newMovie.setAgeRestriction(AgeRestriction.G);
                    break;
                case 2:
                    newMovie.setAgeRestriction(AgeRestriction.PG);
                    break;
                case 3:
                    newMovie.setAgeRestriction(AgeRestriction.PG13); 
                    break;
                case 4:
                    newMovie.setAgeRestriction(AgeRestriction.NC16);
                    break;
                case 5:
                    newMovie.setAgeRestriction(AgeRestriction.M18);
                    break;
                case 6:
                    newMovie.setAgeRestriction(AgeRestriction.R21);
                    break;
            }
            System.out.println("Please enter Movie Director: ");
            newMovie.setDirector(sc.next());
            System.out.println("Please enter name of cast:");
            do{
                casts = Arrays.copyOf(casts, casts.length+1);
                casts[casts.length-1] = sc.next();
                System.out.println("Please enter name of next cast or 0 to continue");
            }while (j != 0);
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
            System.out.println("Movie Title: " + movieTitle);
            System.out.println("Movie Status: " + movies.get(index).getMovieStatus());
            System.out.println("Movie Genre(s): " + movies.get(index).getMovieGenres());
            System.out.println("Director: " + movies.get(index).getDirector());
            System.out.println("Casts: " + movies.get(index).getCasts());
            System.out.println("Synopsis: " + movies.get(index).getSynopsis());
            System.out.println("Age Rating: " + movies.get(index).getAgeRestriction());
            System.out.println(movies.get(index).getIs3D() ? "3D" : "2D");
            System.out.println("Duration: " + movies.get(index).getMovieDuration());
            System.out.println("Rating: " + movies.get(index).getOverallRating());
            System.out.println();
            System.out.println("(1) - See Reviews");
            System.out.println("(0) - Back");

            int choice = sc.nextInt();
            do {
                System.out.println("Invalid option, try again:");
                choice = sc.nextInt();
            }while (choice != 1 || choice != 0);

            if (choice == 1){
                ReviewController.printReview(movies.get(index));
            }
            else MovieUI.initiateMovieUI();
        }

    }
    public static ArrayList<Movie> getMovieList(){
        return MovieController.movies;
    }

    public static ArrayList<Movie> getTop5ByRatings(){
        return top5ByRatings;
    }

    public static ArrayList<Movie> getTop5BySales(){
        return top5BySales;
    }

    public static void getTop5Movies(int criteria){        
        
        int choice = sc.nextInt();
        
        if(criteria == 3){
            System.out.println("Sort by:");
            System.out.println("(1) - By Overall Rating");
            System.out.println("(2) - By Sales");
            
            while (choice != 1 || choice != 2) {
                System.out.println("Invalid option, try again: ");
                choice = sc.nextInt();
            }
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