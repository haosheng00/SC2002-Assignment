package classes;

import java.util.ArrayList;
import java.util.Scanner;
import initialiser.Initialise;

//The DropDownMenu will return the index of the chosen item
public class DropDownMenu {
    static Scanner sc = new Scanner(System.in);

    public static int initiateCineplexChoice(ArrayList<Cineplex> cineplexes) {
        int i, cineplexChoice;
        do {
            System.out.println("========================================");
            System.out.println("Select Cineplex: ");
            for (i = 0; i < cineplexes.size(); i++) {
                System.out.println("(" + (i + 1) + ")" + cineplexes.get(i).getCineplexName());
            }
            cineplexChoice = sc.nextInt();
            if (cineplexChoice < 0 || cineplexChoice > i) {
                System.out.println("Invalid Input! Try again");
            }
        } while (cineplexChoice < 0 || cineplexChoice > i);
        return cineplexChoice - 1;
    }

    public static void initiateCineplexAddition(ArrayList<Cineplex> cineplexes, Movie movie) {
        int i, cineplexChoice;
        ArrayList<Integer> selectedCineplexes = new ArrayList<Integer>();

        System.out.println("========================================");
        System.out.println("Select Cineplex: ");
        for (i = 0; i < cineplexes.size(); i++) {
            System.out.println("(" + (i + 1) + ")" + cineplexes.get(i).getCineplexName());
        }
        int exit = i + 1;
        System.out.println("(" + exit + ")" + " Exit");
        do {
            cineplexChoice = sc.nextInt();
            boolean alreadySelected = false;
            if (cineplexChoice > 0 && cineplexChoice < exit) {
                for (int j = 0; j < selectedCineplexes.size(); j++) {
                    if (cineplexChoice == selectedCineplexes.get(j)) {
                        System.out.println(
                                "Cineplex " + cineplexes.get(cineplexChoice).getCineplexName() + "already added");
                        alreadySelected = true;
                    }
                }
                if (alreadySelected) {
                    if (cineplexChoice > 0 && cineplexChoice < exit) {
                        System.out.println("Added to Cineplex " + cineplexes.get(cineplexChoice).getCineplexName()
                                + " successfully");
                        cineplexes.get(cineplexChoice).getMovies().add(movie);
                    }
                }
            }
        } while (cineplexChoice != exit);
    }

    public static int initiateCinemaChoice(ArrayList<Cinema> cinemas) {
        int i, cinemaChoice;
        do {
            System.out.println("========================================");
            System.out.println("Select Cinema: ");
            for (i = 0; i < cinemas.size(); i++) {
                System.out.println("(" + i + 1 + ")" + cinemas.get(i).getCinemaName());
            }
            cinemaChoice = sc.nextInt();
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
                    System.out.println("(" + optionNo + ")" + screenings.get(i).getShowDate() + " "
                            + screenings.get(i).getShowTime());
                } else {
                    counter++;
                }
            }
            screeningChoice = sc.nextInt();
            if (screeningChoice < 0 || screeningChoice > i - counter) {
                System.out.println("Invalid Input! Try again");
            }
        } while (screeningChoice < 0 || screeningChoice > i - counter);
        return screeningChoice + counter - 1;
    }

    public static int initiateMovieChoice(Cineplex cineplex, int haveComingSoon) {
        int i, optionNo;
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
                        System.out
                                .println("(" + optionNo + ")" + cineplex.getMovies().get(i + counter).getMovieTitle());
                        maxCounter++;
                    }
                }
                movieChoice = sc.nextInt();
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
                        System.out
                                .println("(" + optionNo + ")" + cineplex.getMovies().get(i + counter).getMovieTitle());
                        maxCounter++;
                    }
                }
                movieChoice = sc.nextInt();
                if (movieChoice < 0 || movieChoice > maxCounter) {
                    System.out.println("Invalid Input! Try again");
                }
            } while (movieChoice < 0 || movieChoice > maxCounter);
        }
        return movieChoice + counter - 1;

    }

    public static int initiateMovieChoice_CustomerMenu(int haveComingSoon) {
        int i, optionNo;
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
                movieChoice = sc.nextInt()-1;
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
                movieChoice = sc.nextInt();
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
            movieChoice = sc.nextInt();
            if (movieChoice < 0 || movieChoice > i) {
                System.out.println("Invalid Input! Try again");
            }
        } while (movieChoice < 0 || movieChoice > i);
        return movieChoice;
    }
}
