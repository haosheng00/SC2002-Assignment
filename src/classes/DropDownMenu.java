package classes;

import initialiser.Initialise;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the Class that prints out a dropdown menu of an object and returns the index of the chosen item,
 * returns -1 if back option is chosen
 */
public class DropDownMenu {
    static Scanner sc = new Scanner(System.in);

    /**
     * Prints out a dropdown menu of cineplexes in the cineplex array list and asks user to select one
     * @param cineplexes cineplexes in operation
     * @return index of the cineplex chosen
     */
    public static int initiateCineplexChoice(ArrayList<Cineplex> cineplexes) {
        int i = 0, cineplexChoice = 0;
        do {
            i = 0;
            cineplexChoice = 0;
            System.out.println("========================================");
            System.out.println("Select Cineplex: ");
            for (i = 0; i < cineplexes.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + cineplexes.get(i).getCineplexName());
            }
            System.out.println("(" + (i + 1) + ") Back");
            try{
            cineplexChoice = sc.nextInt();
            if (cineplexChoice == (i + 1)){
                return -1;
            }
            if (cineplexChoice <= 0 || cineplexChoice > (i+1)) {
                System.out.println("Invalid Input! Try again");
            }
            else{
                break;
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer: ");
            sc.next();
        }
        } while (true);
        return cineplexChoice - 1;
    }

    /**
     * Prints out the cineplexes currently operating and asks admin to choose which cineplex he wants to add the movie to
     * @param movie movie to be added
     */
    public static void initiateCineplexAddition(Movie movie) {
        int cineplexChoice;
        Cineplex cineplexChosen;
        boolean chosen = false;
        do {
            cineplexChoice = initiateCineplexChoice(Initialise.cineplexes);
            if (cineplexChoice == -1){
                return;
            }
            cineplexChosen = Initialise.cineplexes.get(cineplexChoice);
            for (int i = 0; i < cineplexChosen.getMovies().size(); i++){
                if (cineplexChosen.getMovies().get(i) == movie){
                    chosen = true;
                    System.out.println("Already Added");
                }
            }
            if (!chosen){
                Initialise.cineplexes.get(cineplexChoice).getMovies().add(movie);
                System.out.println("Added to " + Initialise.cineplexes.get(cineplexChoice).getCineplexName());
            }
            chosen = false;
        }while(true);
    }

    /**
     * Prints out the cinemas under a cineplex, and asks user to choose one of the cinema
     * @param cinemas operating under a cineplex
     * @return index of the cinema
     */
    public static int initiateCinemaChoice(ArrayList<Cinema> cinemas) {
        int i = 0, cinemaChoice = 0;
        do {
            i = 0;
            cinemaChoice = 0;
            System.out.println("========================================");
            System.out.println("Select Cinema: ");
            for (i = 0; i < cinemas.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + cinemas.get(i).getCinemaName());
            }
            System.out.println("(" + (i + 1) + ") Back");
            try{
            cinemaChoice = sc.nextInt();
            if (cinemaChoice == (i + 1)){
                return -1;
            }
            if (cinemaChoice <= 0 || cinemaChoice > (i + 1)) {
                System.out.println("Invalid Input! Try again");
            }
            else break;
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer: ");
            sc.next();
        }
        } while (true);
        return cinemaChoice - 1;
    }

    /**
     * Prints out the screenings that screens a certain movie
     * @param screenings all the screenings in the cineplexes
     * @param movie chosen movie to filter screening choices
     * @return index of the screening
     * @throws ParseException
     */
    public static int initiateScreeningChoice(ArrayList<Screening> screenings, Movie movie) throws ParseException {
        int i = 0, screeningChoice = 0;
        int counter = 0;
        int optionNo = 0;
        ArrayList<Integer> Choice = new ArrayList<>();
        String movieTitle = movie.getMovieTitle();
        do {
            i = 0;
            screeningChoice = 0;
            counter = 0;
            optionNo = 0;
            Choice = new ArrayList<>();
            System.out.println("========================================");
            System.out.println("Select Screening: ");
            for (i = 0; i < screenings.size(); i++) {

                if (movieTitle.equals(screenings.get(i).getMovie().getMovieTitle())) {
                    optionNo++;
                    System.out.println("(" + optionNo + ") Date: " + DateTime.dateFormatter(screenings.get(i).getShowDate()) + " Time: "
                            + DateTime.timeFormatter(screenings.get(i).getShowTime()) + " Movie: " +movie.getMovieTitle());
                    Choice.add(optionNo-1+counter);
                } else {
                    counter++;
                }
            }
            System.out.println("(" + (optionNo+1) + ") Back");
        try{
            screeningChoice = sc.nextInt();}
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
            if (screeningChoice == (optionNo+1)){
                return -1;
            }
            if (screeningChoice <= 0 || screeningChoice > (optionNo+1)) {
                System.out.println("Invalid Input! Try again");
            }
            else{
                break;
            }
        } while (true);
        return Choice.get(screeningChoice-1);
    }

    /**
     * Prints out the screening choices after filtering through a given movie and cineplex
     * @param screenings the screenings in the cineplexes
     * @param movie chosen movie to filter the screening choices
     * @param cineplex chosen cineplex to filter the screening choices
     * @return index of the screening
     * * @throws ParseException
     */
    public static int initiateScreeningChoice(ArrayList<Screening> screenings, Movie movie, Cineplex cineplex) throws ParseException {
        int i = 0, screeningChoice = 0;
        int counter = 0;
        int optionNo = 0;
        ArrayList<Integer> Choice = new ArrayList<>();
        String movieTitle = movie.getMovieTitle();
        do {
            i = 0;
            screeningChoice = 0;
            counter = 0;
            optionNo = 0;
            Choice = new ArrayList<>();
            System.out.println("========================================");
            System.out.println("Select Screening: ");
            for (i = 0; i < screenings.size(); i++) {

                if (movieTitle.equals(screenings.get(i).getMovie().getMovieTitle())) {
                    if (cineplex.getCineplexName().equals(screenings.get(i).getCinema().getCineplexName())) {
                        optionNo++;
                        System.out.println("(" + optionNo + ") Date: " + DateTime.dateFormatter(screenings.get(i).getShowDate()) + " Time: "
                                + DateTime.timeFormatter(screenings.get(i).getShowTime()) + " Movie: " + movie.getMovieTitle());
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
            try{
            screeningChoice = sc.nextInt();
            if (screeningChoice == optionNo+1){
                return -1;
            }
            if (screeningChoice <= 0 || screeningChoice > (optionNo+1)) {
                System.out.println("Invalid Input! Try again");
            }
            else{
                break;
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer: ");
            sc.next();
        }
        } while (true);
        return (Choice.get(screeningChoice-1));
    }

    /**
     * Prints out the movie choices in a certain cineplex, and can choose to filter out either End of showing movie
     * or End of showing and Coming soon movie
     * @param cineplex certain cineplex
     * @param haveComingSoon choose whether to filter out coming soon movie or not
     * @return index of the movie
     */

    public static int initiateMovieChoice(Cineplex cineplex, int haveComingSoon) {
        int i, optionNo = 0;
        int movieChoice = 1, counter = 0;
        ArrayList<Integer> Choice = new ArrayList<>();
        if (haveComingSoon == 1) {
            do {
                i = 0;
                movieChoice = 0;
                counter = 0;
                optionNo = 0;
                Choice = new ArrayList<>();
                System.out.println("========================================");
                System.out.println("Select Movie: ");
                for (i = 0; i < cineplex.getMovies().size(); i++) {
                    if (cineplex.getMovies().get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING) {
                        counter++;
                    } else {
                        optionNo++;
                        System.out.println("(" + optionNo + ") " + cineplex.getMovies().get(i).getMovieTitle());
                        Choice.add(counter+optionNo-1);
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                try{
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice <= 0 || movieChoice > (optionNo+1)) {
                    System.out.println("Invalid Input! Try again");
                }
                else{
                    break;
                }
            }
                catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer: ");
                    sc.next();
                }
            } while (true);
        } else {
            do {
                i = 0;
                movieChoice = 0;
                counter = 0;
                optionNo = 0;
                Choice = new ArrayList<>();
                System.out.println("========================================");
                System.out.println("Select Movie: ");
                for (i = 0; i < cineplex.getMovies().size(); i++) {
                    if (cineplex.getMovies().get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING
                            || cineplex.getMovies().get(i).getMovieStatus() == Enum.MovieStatus.COMING_SOON || cineplex.getMovies().get(i) == null) {
                        counter++;
                    } else {
                        optionNo++;
                        System.out.println("(" + optionNo + ") " + cineplex.getMovies().get(i).getMovieTitle());
                        Choice.add(counter+optionNo-1);
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                try{
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice <= 0 || movieChoice > (optionNo+1)) {
                    System.out.println("Invalid Input! Try again");
                }
                else{
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
            } while (true);
        }
        return (Choice.get(movieChoice-1));
    }

    /**
     * Prints out all the movie, either excluding End of showing movie or excluding End of showing and Coming soon movies
     * @param haveComingSoon to choose whether to include coming soon movies
     * @return index of the movie
     */
    public static int initiateMovieChoice_CustomerMenu(int haveComingSoon) {
        int i, optionNo = 0;
        int movieChoice = 1, counter = 0;
        ArrayList<Integer> Choice = new ArrayList<>();
        if (haveComingSoon == 1) {
            do {
                i = 0;
                movieChoice = 0;
                counter = 0;
                optionNo = 0;
                Choice = new ArrayList<>();
                System.out.println("========================================");
                System.out.println("Select Movie: ");
                for (i = 0; i < Initialise.movies.size(); i++) {
                    if (Initialise.movies.get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING) {
                        counter++;
                    } else {
                        optionNo++;
                        System.out.println("(" + optionNo + ") " + Initialise.movies.get(i).getMovieTitle());
                        Choice.add(optionNo-1+counter);
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                try{
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice <= 0 || movieChoice > (optionNo+1)) {
                    System.out.println("Invalid Input! Try again");
                }
                else{
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
            } while (true);
        } else {
            do {
                i = 0;
                movieChoice = 0;
                counter = 0;
                optionNo = 0;
                Choice = new ArrayList<>();
                System.out.println("========================================");
                System.out.println("Select Movie: ");
                for (i = 0; i < Initialise.movies.size(); i++) {
                    if (Initialise.movies.get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING
                            || Initialise.movies.get(i).getMovieStatus() == Enum.MovieStatus.COMING_SOON) {
                        counter++;
                    } else {
                        optionNo++;
                        System.out.println("(" + optionNo + ") " + Initialise.movies.get(i).getMovieTitle());
                        Choice.add(optionNo-1+counter);
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                try{
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice <= 0 || movieChoice > (optionNo+1)) {
                    System.out.println("Invalid Input! Try again");
                }
                else{
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
            } while (true);
        }
        return (Choice.get(movieChoice-1));

    }

    /**
     * Prints out all the movies and allows the admin to choose the movie
     * @param movies all the movies in the cineplex
     * @return the index of the movie
     */
    public static int initiateAdminMovieChoice(ArrayList<Movie> movies) {
        int i = 0, movieChoice = 0;
        do {
            i = 0;
            movieChoice = 0;
            System.out.println("========================================");
            System.out.println("Select Movie: ");
            for (i = 0; i < movies.size(); i++) {
                System.out.println("(" + (i + 1) + ") " + movies.get(i).getMovieTitle());
            }
            System.out.println("(" + (i+1) + ") Back");
            try{
            movieChoice = sc.nextInt();
            if (movieChoice == (i+1)){
                return -1;
            }
            if (movieChoice <= 0 || movieChoice > (i+1)) {
                System.out.println("Invalid Input! Try again");
            }
            else{
                break;
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer: ");
            sc.next();
        }
        } while (true);
        return movieChoice-1;
    }
}
