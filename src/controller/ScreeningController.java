package controller;

import Classes.*;

import java.util.ArrayList;
import java.util.Scanner;

public class ScreeningController {
    static Scanner sc = new Scanner(System.in);

    public ScreeningController(){};
    public static void addScreening(ArrayList<Cineplex> cineplexes){
        int i;
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        int cinemaChoice = DropDownMenu.initiateCinemaChoice(cineplexes.get(cineplexChoice-1).getCinemas());
        int movieChoice = DropDownMenu.initiateMovieChoice(cineplexes.get(cineplexChoice-1).getMovies());
        System.out.println("Add date(YYYYMMDD): ");
        String dateChosen = sc.next();
        System.out.println("Add time(HHmmss): ");
        String timeChosen = sc.next();
        Cinema cinemaChosen = cineplexes.get(cinemaChoice-1).getCinemas().get(cinemaChoice-1);
        Movie movieChosen = cineplexes.get(cineplexChoice-1).getMovies().get(movieChoice-1);
        cinemaChosen.getScreenings().add(new Screening(cinemaChosen,dateChosen,timeChosen,movieChosen));
        System.out.println("addScreening success");
    }
    public static void deleteScreening(Cineplex cineplex){
        int i;
        System.out.println("Cinema: ");
        for (i = 1; i <= cineplex.getCinemas().size(); i++) {
            System.out.println("(" + i + ")" + cineplex.getCinemas().get(i - 1).getCinemaName());
        }
        int cinemaChoice = sc.nextInt();
        if (cinemaChoice <= 0 || cinemaChoice > i){
            System.out.println("Invalid Input");
            System.out.println("deleteScreening fail");
            return;
        }
        System.out.println("Select screening: ");
        for (i = 1; i <= cineplex.getCinemas().get(cinemaChoice-1).getScreenings().size();i++){
            System.out.println("(" + i + ")" + cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(i-1).getShowDateTime());
        }
        int screeningChoice = sc.nextInt();
        if (screeningChoice <= 0 || screeningChoice > i){
            System.out.println("Invalid Input");
            System.out.println("deleteScreening fail");
            return;
        }
        cineplex.getCinemas().get(cinemaChoice - 1).getScreenings().remove(screeningChoice-1);
        System.out.println("deleteScreening success");
    }

    public static void showScreening(Cineplex cineplex){
        //TODO: showScreening based on cineplex->movie->print
        int i;
        System.out.println("Cinema: ");
        for (i = 1; i <= cineplex.getCinemas().size(); i++) {
            System.out.println("(" + i + ")" + cineplex.getCinemas().get(i - 1).getCinemaName());
        }
        int cinemaChoice = sc.nextInt();
        if (cinemaChoice <= 0 || cinemaChoice > i){
            System.out.println("Invalid Input");
            System.out.println("deleteScreening fail");
            return;
        }
        for (i = 1; i <= cineplex.getCinemas().get(cinemaChoice-1).getScreenings().size();i++){
            System.out.println("(" + i + ")" + cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(i-1).getShowDateTime());
        }
        int screeningChoice = sc.nextInt();
        if (screeningChoice <= 0 || screeningChoice > i){
            System.out.println("Invalid Input");
            System.out.println("showScreening fail");
            return;
        }
        System.out.println("Cinema: " + cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(screeningChoice-1).getCinema().getCinemaName());
        System.out.println("ShowTime: " + cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(screeningChoice-1).getShowDateTime());
        System.out.println("Movie: " + cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(screeningChoice-1).getMovie().getMovieTitle());

        //TESTING
        if (cineplex.getCinemas().get(cinemaChoice-1).getCinemaType() == CinemaType.ORDINARY){
            LayoutPrinterOrdinary.printLayout(cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(screeningChoice-1));
        }
        else if (cineplex.getCinemas().get(cinemaChoice-1).getCinemaType() == CinemaType.PLATINUMMOVIESUITES){
            LayoutPrinterPlat.printLayout(cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(screeningChoice-1));
        }
    }
}
