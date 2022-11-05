package controller;

import Classes.*;

import java.util.Scanner;

public class ScreeningController {
    static Scanner sc = new Scanner(System.in);

    public ScreeningController(){};
    public static void addScreening(Cineplex cineplex){
        int i;
        System.out.println("Movie Title: ");
        String movieTitle = sc.next();
        // (1) - OPTIOISND
        // (2) - SDAJSDASD
        //TODO: do drop-down options
        //TODO: Don't Create a Movie 
        Movie movie = new Movie(movieTitle);
        System.out.println("Add date(TODO:format): ");
        //TODO: parsing of date and time format
        System.out.println("Add time(TODO:format): ");
        System.out.println("Cinema: ");
        for (i = 1; i <= cineplex.getCinemas().size(); i++) {
            System.out.println("(" + i + ")" + cineplex.getCinemas().get(i - 1).getCinemaName());
        }
        int cinemaChoice = sc.nextInt();
        if (cinemaChoice <= 0 || cinemaChoice > i){
            System.out.println("Invalid Input");
            System.out.println("addScreening fail");
            return;
        }
        //TODO: Update the showDateTime
        cineplex.getCinemas().get(cinemaChoice - 1).getScreenings().add(new Screening(cineplex.getCinemas().get(cinemaChoice - 1), "160400", movie));
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
