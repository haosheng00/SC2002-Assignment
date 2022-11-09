package classes;

import initialiser.Initialise;

import java.util.ArrayList;
import java.util.Scanner;

//The DropDownMenu will return the index of the chosen item
//-1 shall be back option
public class DropDownMenu {
    static Scanner sc = new Scanner(System.in);

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

    //Check if it actually writes to the cineplex
    public static void initiateCineplexAddition(ArrayList<Cineplex> cineplexes, Movie movie) {
        int cineplexChoice, counter = 0;
        ArrayList<Cineplex> cineplextemp = cineplexes;
        Cineplex cineplexChosen;
        do {
            cineplexChoice = initiateCineplexChoice(cineplextemp);
            if (cineplexChoice == -1){
                return;
            }
            cineplexChosen = cineplextemp.get(cineplexChoice);
            cineplexChosen.getMovies().add(movie);
            cineplextemp.remove(cineplexChosen);
        }while(cineplextemp.size()!=0);
    }

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

    public static int initiateScreeningChoice(ArrayList<Screening> screenings, Movie movie) {
        int i, screeningChoice;
        int counter = 0;
        int optionNo = 0;
        String movieTitle = movie.getMovieTitle();
        do {
            System.out.println("========================================");
            System.out.println("Select Screening: ");
            for (i = 0; i < screenings.size(); i++) {

                if (movieTitle.equals(screenings.get(i).getMovie().getMovieTitle())) {
                    optionNo++;
                    System.out.println("(" + optionNo + ") Date: " + screenings.get(i).getShowDate() + " Time: "
                            + screenings.get(i).getShowTime() + " Movie: " +movie.getMovieTitle());
                } else {
                    counter++;
                }
            }
            System.out.println("(" + (optionNo+1) + ") Back");
            screeningChoice = sc.nextInt();
            if (screeningChoice == optionNo+1){
                return -1;
            }
            if (screeningChoice < 0 || screeningChoice > i - counter) {
                System.out.println("Invalid Input! Try again");
            }
        } while (screeningChoice < 0 || screeningChoice > i - counter);
        return counter + screeningChoice - 1;
    }

    public static int initiateMovieChoice(Cineplex cineplex, int haveComingSoon) {
        int i, optionNo = 0;
        int movieChoice = 1, counter = 0, maxCounter = 0;
        if (haveComingSoon == 1) {
            do {
                System.out.println("========================================");
                System.out.println("Select Movie: ");
                for (i = 0; i < cineplex.getMovies().size(); i++) {
                    if (cineplex.getMovies().get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING) {
                        counter++;
                    } else {
                        optionNo = i + 1 - counter;
                        System.out.println("(" + optionNo + ") " + cineplex.getMovies().get(i + counter).getMovieTitle());
                        maxCounter++;
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice < 0 || movieChoice > maxCounter) {
                    System.out.println("Invalid Input! Try again");
                }
            } while (movieChoice < 0 || movieChoice > maxCounter);
        } else {
            do {
                System.out.println("========================================");
                System.out.println("Select Movie: ");
                for (i = 0; i < cineplex.getMovies().size(); i++) {
                    if (cineplex.getMovies().get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING
                            || cineplex.getMovies().get(i).getMovieStatus() == Enum.MovieStatus.COMING_SOON) {
                        counter++;
                    } else {
                        optionNo = i + 1 - counter;
                        System.out.println("(" + optionNo + ") " + cineplex.getMovies().get(i + counter).getMovieTitle());
                        maxCounter++;
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice < 0 || movieChoice > maxCounter) {
                    System.out.println("Invalid Input! Try again");
                }
            } while (movieChoice < 0 || movieChoice > maxCounter);
        }
        return movieChoice + counter - 1;
    }

    public static int initiateMovieChoice_CustomerMenu(int haveComingSoon) {
        int i, optionNo = 0;
        int movieChoice = 1, counter = 0, maxCounter = 0;
        if (haveComingSoon == 1) {
            do {
                System.out.println("========================================");
                System.out.println("Select Movie: ");
                for (i = 0; i < Initialise.movies.size(); i++) {
                    if (Initialise.movies.get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING) {
                        counter++;
                    } else {
                        optionNo = i + 1 - counter;
                        System.out.println("(" + optionNo + ")" + Initialise.movies.get(i + counter).getMovieTitle());
                        maxCounter++;
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice < 0 || movieChoice > maxCounter) {
                    System.out.println("Invalid Input! Try again");
                }
            } while (movieChoice < 0 || movieChoice > maxCounter);
        } else {
            do {
                System.out.println("========================================");
                System.out.println("Select Movie: ");
                for (i = 0; i < Initialise.movies.size(); i++) {
                    if (Initialise.movies.get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING
                            || Initialise.movies.get(i).getMovieStatus() == Enum.MovieStatus.COMING_SOON) {
                        counter++;
                    } else {
                        optionNo = i + 1 - counter;
                        System.out.println("(" + optionNo + ")" + Initialise.movies.get(i + counter).getMovieTitle());
                        maxCounter++;
                    }
                }
                System.out.println("(" + (optionNo+1) + ") Back");
                movieChoice = sc.nextInt();
                if (movieChoice == (optionNo+1)){
                    return -1;
                }
                if (movieChoice < 0 || movieChoice > maxCounter) {
                    System.out.println("Invalid Input! Try again");
                }
            } while (movieChoice < 0 || movieChoice > maxCounter);
        }
        return movieChoice + counter - 1;

    }

    public static int initiateAdminMovieChoice(ArrayList<Movie> movies) {
        int i, movieChoice;
        do {
            System.out.println("========================================");
            System.out.println("Select Movie: ");
            for (i = 0; i < movies.size(); i++) {
                System.out.println("(" + (i + 1) + ")" + movies.get(i).getMovieTitle());
            }
            System.out.println("(" + (i+2) + ") Back");
            movieChoice = sc.nextInt();
            if (movieChoice == (i+2)){
                return -1;
            }
            if (movieChoice < 0 || movieChoice > i+2) {
                System.out.println("Invalid Input! Try again");
            }
        } while (movieChoice < 0 || movieChoice > i+2);
        return movieChoice-1;
    }
}
