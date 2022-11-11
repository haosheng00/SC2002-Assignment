package classes;

import initialiser.Initialise;

import java.util.ArrayList;
import java.util.Scanner;

//The DropDownMenu will return the index of the chosen item
//-1 shall be back option
public class DropDownMenu {
    static Scanner sc = new Scanner(System.in);

    public static int initiateCineplexChoice(ArrayList<Cineplex> cineplexes) {
        int i = 0, cineplexChoice = 0;
        do {
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
            if (cineplexChoice < 0 || cineplexChoice > i) {
                System.out.println("Invalid Input! Try again");
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer: ");
            sc.next();
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
            if (!chosen){
                Initialise.cineplexes.get(cineplexChoice).getMovies().add(movie);
                System.out.println("Added to " + Initialise.cineplexes.get(cineplexChoice).getCineplexName());
            }
            chosen = false;
        }while(true);
    }

    public static int initiateCinemaChoice(ArrayList<Cinema> cinemas) {
        int i = 0, cinemaChoice = 0;
        do {
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
            if (cinemaChoice < 0 || cinemaChoice > i) {
                System.out.println("Invalid Input! Try again");
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer: ");
            sc.next();
        }
        } while (cinemaChoice < 0 || cinemaChoice > i);
        return cinemaChoice - 1;
    }

    public static int initiateScreeningChoice(ArrayList<Screening> screenings, Movie movie) {
        int i = 0, screeningChoice = 0;
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
                            + screenings.get(i).getShowTime() + " Movie: " +movie.getMovieTitle());
                    Choice.add(optionNo-1+counter);
                } else {
                    counter++;
                }
            }
            System.out.println("(" + (optionNo+1) + ") Back");
            try{
            screeningChoice = sc.nextInt();
            if (screeningChoice == (optionNo+1)){
                return -1;
            }
            if (screeningChoice < 0 || screeningChoice > (optionNo+1)) {
                System.out.println("Invalid Input! Try again");
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer: ");
            sc.next();
        }
        } while (screeningChoice < 0 || screeningChoice > (optionNo+1));
        return Choice.get(screeningChoice-1);
    }

    public static int initiateScreeningChoice(ArrayList<Screening> screenings, Movie movie, Cineplex cineplex) {
        int i = 0, screeningChoice = 0;
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
            try{
            screeningChoice = sc.nextInt();
            if (screeningChoice == optionNo+1){
                return -1;
            }
            if (screeningChoice < 0 || screeningChoice > (optionNo+1)) {
                System.out.println("Invalid Input! Try again");
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer: ");
            sc.next();
        }
        } while (screeningChoice < 0 || screeningChoice > (optionNo+1));
        return (Choice.get(screeningChoice-1));
    }

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
                try{
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice < 0 || movieChoice > (optionNo+1)) {
                    System.out.println("Invalid Input! Try again");
                }
            }
                catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer: ");
                    sc.next();
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
                try{
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice < 0 || movieChoice > (optionNo+1)) {
                    System.out.println("Invalid Input! Try again");
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
            } while (movieChoice < 0 || movieChoice > (optionNo+1));
        }
        return (Choice.get(movieChoice-1));
    }

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
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                try{
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice < 0 || movieChoice > (optionNo+1)) {
                    System.out.println("Invalid Input! Try again");
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
            } while (movieChoice < 0 || movieChoice > optionNo+1);
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
                try{
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice < 0 || movieChoice > (optionNo+1)) {
                    System.out.println("Invalid Input! Try again");
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
            } while (movieChoice < 0 || movieChoice > (optionNo+1));
        }
        return (Choice.get(movieChoice-1));

    }

    public static int initiateAdminMovieChoice(ArrayList<Movie> movies) {
        int i = 0, movieChoice = 0;
        do {
            System.out.println("========================================");
            System.out.println("Select Movie: ");
            for (i = 0; i < movies.size(); i++) {
                System.out.println("(" + (i + 1) + ")" + movies.get(i).getMovieTitle());
            }
            System.out.println("(" + (i+2) + ") Back");
            try{
            movieChoice = sc.nextInt();
            if (movieChoice == (i+2)){
                return -1;
            }
            if (movieChoice < 0 || movieChoice > (i+2)) {
                System.out.println("Invalid Input! Try again");
            }
        }
        catch (Exception e) {
            System.out.println("Invalid input. Please enter an integer: ");
            sc.next();
        }
        } while (movieChoice < 0 || movieChoice > (i+2));
        return movieChoice-1;
    }
}
