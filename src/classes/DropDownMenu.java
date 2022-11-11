package classes;

import initialiser.Initialise;

import java.util.ArrayList;
import java.util.Scanner;

//The DropDownMenu will return the index of the chosen item
//-1 shall be back option

/**
 * Represents the drop down menu class that will return the index of the item given some inputs
 */
public class DropDownMenu {
    static Scanner sc = new Scanner(System.in);

    /**
     * Prints out all the cineplexes in the cinplexes array list and returns the index of chosen cineplex in the array list
     * @param cineplexes
     * @return index of the chosen cineplex
     */
    public static int initiateCineplexChoice(ArrayList<Cineplex> cineplexes) {
        int i, cineplexChoice;
        do {
            System.out.println("========================================");
            System.out.println("Select Cineplex: ");
            for (i = 0; i < cineplexes.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + cineplexes.get(i).getCineplexName());
            }
            System.out.println("(" + (i + 1) + ") Back");
            cineplexChoice = sc.nextInt();
            if (cineplexChoice == (i + 1)){
                return -1;
            }
            if (cineplexChoice < 0 || cineplexChoice > i) {
                System.out.println("Invalid Input! Try again");
            }
        } while (cineplexChoice < 0 || cineplexChoice > i);
        return cineplexChoice - 1;
    }

    /**
     * Prints out the cineplex that can be added to the cineplex
     * @param movie
     */
    public static void initiateCineplexAddition(Movie movie) {
        int cineplexChoice;
        Cineplex cineplexChosen;
        boolean chosen = false;
        int counter = 0;
        do {
            cineplexChoice = initiateCineplexChoice(Initialise.cineplexes);
            if (cineplexChoice == -1){
                return;
            }
            cineplexChosen = Initialise.cineplexes.get(cineplexChoice);
            for (int i = 0; i < cineplexChosen.getMovies().size(); i++){
                if (cineplexChosen.getMovies().get(i) == movie){
                    chosen = true;
                    System.out.println("Already Chosen");
                }
            }
            if (chosen == false){
                Initialise.cineplexes.get(cineplexChoice+counter).getMovies().add(movie);
            }
        }while(true);
    }

    /**
     * Prints our the list of cinemas in the cinema array list and returns the index of the chosen cinema in the array list
     * @param cinemas
     * @return index of the chosen cinema
     */
    public static int initiateCinemaChoice(ArrayList<Cinema> cinemas) {
        int i, cinemaChoice;
        do {
            System.out.println("========================================");
            System.out.println("Select Cinema: ");
            for (i = 0; i < cinemas.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + cinemas.get(i).getCinemaName());
            }
            System.out.println("(" + (i + 1) + ") Back");
            cinemaChoice = sc.nextInt();
            if (cinemaChoice == (i + 1)){
                return -1;
            }
            if (cinemaChoice < 0 || cinemaChoice > i) {
                System.out.println("Invalid Input! Try again");
            }
        } while (cinemaChoice < 0 || cinemaChoice > i);
        return cinemaChoice - 1;
    }

    /**
     * Prints out the list of screenings of a given movie, then returns the index of the chosen screening in the screening array list
     * @param screenings
     * @param movie
     * @return index of the screening
     */
    public static int initiateScreeningChoice(ArrayList<Screening> screenings, Movie movie) {
        int i, screeningChoice;
        int counter = 0;
        int optionNo = 0;
        ArrayList<Integer> Choice = new ArrayList<>();
        String movieTitle = movie.getMovieTitle();
        do {
            System.out.println("========================================");
            System.out.println("Select Screening: ");
            for (i = 0; i < screenings.size(); i++) {
                if (movieTitle.equals(screenings.get(i).getMovie().getMovieTitle())) {
                        optionNo++;
                        System.out.println("(" + optionNo + ") Date: " + screenings.get(i).getShowDate() + " Time: "
                                + screenings.get(i).getShowTime() + " Movie: " + movie.getMovieTitle());
                        Choice.add(optionNo-1+counter);
                } else {
                    counter++;
                }
            }
            System.out.println("(" + (optionNo+1) + ") Back");
            screeningChoice = sc.nextInt();
            if (screeningChoice == (optionNo+1)){
                return -1;
            }
            if (screeningChoice < 0 || screeningChoice > (optionNo+1)) {
                System.out.println("Invalid Input! Try again");
            }
        } while (screeningChoice < 0 || screeningChoice > (optionNo+1));
        return (Choice.get(screeningChoice-1));
    }

    /**
     * Prints out the screening of a given movie in a given cineplex and returns the index of the screening in the array list
     * @param screenings
     * @param movie
     * @param cineplex
     * @return index of the screening
     */
    public static int initiateScreeningMovieChoice(ArrayList<Screening> screenings, Movie movie, Cineplex cineplex) {
        int i, screeningChoice;
        int counter = 0;
        int optionNo = 0;
        ArrayList<Integer> Choice = new ArrayList<>();
        String movieTitle = movie.getMovieTitle();
        do {
            System.out.println("========================================");
            System.out.println("Select Screening: ");
            for (i = 0; i < screenings.size(); i++) {
                if (movieTitle.equals(screenings.get(i).getMovie().getMovieTitle())) {
                    if (cineplex.getCineplexName().equals(screenings.get(i).getCinema().getCineplexName())) {
                        optionNo++;
                        System.out.println("(" + optionNo + ") Date: " + screenings.get(i).getShowDate() + " Time: "
                                + screenings.get(i).getShowTime() + " Movie: " + movie.getMovieTitle());
                        Choice.add(optionNo-1+counter);
                    }
                    else{
                        counter++;
                    }
                } else {
                    counter++;
                }
            }
            System.out.println("(" + (optionNo+1) + ") Back");
            screeningChoice = sc.nextInt();
            if (screeningChoice == optionNo+1){
                return -1;
            }
            if (screeningChoice < 0 || screeningChoice > (optionNo+1)) {
                System.out.println("Invalid Input! Try again");
            }
        } while (screeningChoice < 0 || screeningChoice > (optionNo+1));
        return (Choice.get(screeningChoice-1));
    }

    /**
     * Prints our the movies in the movie array list and returns the index of the movie in the array list
     * @param movies
     * @return index of the movie
     */
    public static int initiateMovieChoice(ArrayList<Movie> movies){
        int i, movieChoice;
        do {
            System.out.println("========================================");
            System.out.println("Select Movie: ");
            for (i = 0; i < movies.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + movies.get(i).getMovieTitle());
            }
            System.out.println("(" + (i + 1) + ") Back");
            movieChoice = sc.nextInt();
            if (movieChoice == (i + 1)){
                return -1;
            }
            if (movieChoice < 0 || movieChoice > i) {
                System.out.println("Invalid Input! Try again");
            }
        } while (movieChoice < 0 || movieChoice > i);
        return movieChoice - 1;
    }

    /**
     * Returns the movies with either ENDOFSHOWING or ENDOFSHOWING + COMINGSOON given a cineplex
     * @param cineplex
     * @param haveComingSoon
     * @return index of the movie in the cineplex
     */
    public static int initiateMovieChoice(Cineplex cineplex, int haveComingSoon) {
        int i, optionNo = 0;
        int movieChoice = 1, counter = 0;
        ArrayList<Integer> Choice = new ArrayList<>();
        if (haveComingSoon == 1) {
            do {
                System.out.println("========================================");
                System.out.println("Select Movie: ");
                for (i = 0; i < cineplex.getMovies().size(); i++) {
                    if (cineplex.getMovies().get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING) {
                        counter++;
                    } else {
                        optionNo++;
                        System.out.println("(" + optionNo + ") " + cineplex.getMovies().get(i + counter).getMovieTitle());
                        Choice.add(counter+optionNo-1);
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice < 0 || movieChoice > (optionNo+1)) {
                    System.out.println("Invalid Input! Try again");
                }
            } while (movieChoice < 0 || movieChoice > (optionNo+1));
        } else {
            do {
                System.out.println("========================================");
                System.out.println("Select Movie: ");
                for (i = 0; i < cineplex.getMovies().size(); i++) {
                    if (cineplex.getMovies().get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING
                            || cineplex.getMovies().get(i).getMovieStatus() == Enum.MovieStatus.COMING_SOON) {
                        counter++;
                    } else {
                        optionNo++;
                        System.out.println("(" + optionNo + ") " + cineplex.getMovies().get(i + counter).getMovieTitle());
                        Choice.add(counter+optionNo-1);
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice < 0 || movieChoice > (optionNo+1)) {
                    System.out.println("Invalid Input! Try again");
                }
            } while (movieChoice < 0 || movieChoice > (optionNo+1));
        }
        return (Choice.get(movieChoice-1));
    }

    /**
     * Prints out the list of moviechoices (either with END_OF_SHOWING or END_OF_SHOWING & COMINGSOON) and returns the index of the movie in the DB
     * @param haveComingSoon
     * @return index of the movie
     */
    public static int initiateMovieChoice_CustomerMenu(int haveComingSoon) {
        int i, optionNo = 0;
        int movieChoice = 1, counter = 0;
        ArrayList<Integer> Choice = new ArrayList<>();
        if (haveComingSoon == 1) {
            do {
                System.out.println("========================================");
                System.out.println("Select Movie: ");
                for (i = 0; i < Initialise.movies.size(); i++) {
                    if (Initialise.movies.get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING) {
                        counter++;
                    } else {
                        optionNo++;
                        System.out.println("(" + optionNo + ")" + Initialise.movies.get(i + counter).getMovieTitle());
                        Choice.add(optionNo-1+counter);
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice < 0 || movieChoice > (optionNo+1)) {
                    System.out.println("Invalid Input! Try again");
                }
            } while (movieChoice < 0 || movieChoice > (optionNo+1));
        } else {
            do {
                System.out.println("========================================");
                System.out.println("Select Movie: ");
                for (i = 0; i < Initialise.movies.size(); i++) {
                    if (Initialise.movies.get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING
                            || Initialise.movies.get(i).getMovieStatus() == Enum.MovieStatus.COMING_SOON) {
                        counter++;
                    } else {
                        optionNo++;
                        System.out.println("(" + optionNo + ")" + Initialise.movies.get(i + counter).getMovieTitle());
                        Choice.add(optionNo-1+counter);
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice < 0 || movieChoice > (optionNo+1)) {
                    System.out.println("Invalid Input! Try again");
                }
            } while (movieChoice < 0 || movieChoice > (optionNo+1));
        }
        return (Choice.get(movieChoice-1));

    }

    /**
     * Prints out all the movies in the DB and returns the index of the movie
     * @param movies
     * @return index of the movie
     */
    public static int initiateAdminMovieChoice(ArrayList<Movie> movies) {
        int i, movieChoice;
        do {
            System.out.println("========================================");
            System.out.println("Select Movie: ");
            for (i = 0; i < movies.size(); i++) {
                System.out.println("(" + (i + 1) + ")" + movies.get(i).getMovieTitle());
            }
            System.out.println("(" + (i+2) + ") Done");
            movieChoice = sc.nextInt();
            if (movieChoice == (i+2)){
                return -1;
            }
            if (movieChoice < 0 || movieChoice > (i+2)) {
                System.out.println("Invalid Input! Try again");
            }
        } while (movieChoice < 0 || movieChoice > (i+2));
        return movieChoice-1;
    }
}
