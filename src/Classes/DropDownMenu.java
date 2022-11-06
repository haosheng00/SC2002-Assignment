package Classes;

import java.util.ArrayList;
import java.util.Scanner;

public class DropDownMenu {
    static Scanner sc = new Scanner(System.in);
    public static int initiateCineplexChoice(ArrayList<Cineplex> cineplexes){
        int i, cineplexChoice;
        do {
            System.out.println("========================================");
            System.out.println("Select Cineplex: ");
            for (i = 0; i < cineplexes.size(); i++) {
                System.out.println("(" + i + 1 + ")" + cineplexes.get(i).getCineplexName());
            }
            cineplexChoice = sc.nextInt();
            if (cineplexChoice < 0 || cineplexChoice > i) {
                System.out.println("Invalid Input! Try again");
            }
        } while (cineplexChoice < 0 || cineplexChoice > i);
        return cineplexChoice;
    }

    public static int initiateCinemaChoice(ArrayList<Cinema> cinemas){
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
        return cinemaChoice;
    }

    public static int initiateScreeningChoice(ArrayList<Screening> screenings){
        int i, screeningChoice;
        do {
            System.out.println("========================================");
            System.out.println("Select Screening: ");
            for (i = 0; i < screenings.size(); i++) {
                System.out.println("(" + i + 1 + ")" + screenings.get(i).getShowDate() + " " + screenings.get(i).getShowTime());
            }
            screeningChoice = sc.nextInt();
            if (screeningChoice < 0 || screeningChoice > i) {
                System.out.println("Invalid Input! Try again");
            }
        } while (screeningChoice < 0 || screeningChoice > i);
        return screeningChoice;
    }

    public static int initiateMovieChoice(ArrayList<Movie> movies) {
        int i, movieChoice;
        int counter = 0, maxCounter = 0;
        do {
            System.out.println("========================================");
            System.out.println("Select Movie: ");
            for (i = 0; i < movies.size(); i++) {
                if (movies.get(i).getMovieStatus() == Enum.MovieStatus.END_OF_SHOWING){
                    counter++;
                }
                else {
                    System.out.println("(" + i + 1 + ")" + movies.get(i+counter).getMovieTitle());
                    maxCounter++;
                }
            }
            movieChoice = sc.nextInt();
            if (movieChoice < 0 || movieChoice > maxCounter) {
                System.out.println("Invalid Input! Try again");
            }
        } while (movieChoice < 0 || movieChoice > maxCounter);
        return movieChoice;
    }

    public static int initiateAdminMovieChoice(ArrayList<Movie> movies) {
        int i, movieChoice;
        do {
            System.out.println("========================================");
            System.out.println("Select Movie: ");
            for (i = 0; i < movies.size(); i++) {
                System.out.println("(" + i + 1 + ")" + movies.get(i).getMovieTitle());
            }
            movieChoice = sc.nextInt();
            if (movieChoice < 0 || movieChoice > i) {
                System.out.println("Invalid Input! Try again");
            }
        } while (movieChoice < 0 || movieChoice > i);
        return movieChoice;
    }
}
