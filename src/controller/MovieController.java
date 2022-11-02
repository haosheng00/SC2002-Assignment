package controller;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.*;


public class MovieController{
    static Scanner sc = new Scanner(System.in);
    private static  ArrayList<Movie> movies = new ArrayList<Movie>();

    public MovieController(){}
    public static int searchMovie(String movie){
        for(int i=0; i<movies.size(); i++){
            if(movies.get(i).getMovieTitle() == movie){
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
            Movie newMovie = new Movie(movieTitle);
            newMovie.setMovieTitle(movieTitle);
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

    // public int updateMovie(){
    //     String movieTitle;
    //     System.out.println("Enter movie title: ");
    //     movieTitle = sc.next();
    //     int index = searchMovie(movieTitle);

    //     return 0;
    // }

    // public void printMovie(String movieTitle){
    //     int index = searchMovie(username);
    //     if(index != -1){
    //         System.out.println("Movie Title: " );
    //     }
    // }
    public ArrayList<Movie> getMovieList(){
        return MovieController.movies;
    }





}