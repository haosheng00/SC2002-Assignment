package controller;

import java.util.Scanner;
import java.util.TimeZone;

import Classes.*;

public class ScreeningController {
    static Scanner sc = new Scanner(System.in);

    public ScreeningController(){};
    public static void addScreening(Cineplex cineplex){
        int i;
        System.out.println("Movie Title: ");
        String movieTitle = sc.next();
        //TODO: create a check movieTitle function in movie, if it aligns, returns me the movie object OR do drop-down options
        //TODO: Don't Create a Movie 
        Movie movie = new Movie(movieTitle);
        System.out.println("Show Time: ");
        //TODO: parsing of date and time format
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
        cineplex.getCinemas().get(cinemaChoice - 1).getScreenings().add(new Screening(cineplex.getCinemas().get(cinemaChoice - 1), TimeZone.getTimeZone("Singapore"), movie));
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
            System.out.println("(" + i + ")" + cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(i-1).getShowTime());
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
    public static void updateScreening(Cineplex cineplex){
    }
    public static void showScreening(Cineplex cineplex){
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
            System.out.println("(" + i + ")" + cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(i-1).getShowTime());
        }
        int screeningChoice = sc.nextInt();
        if (screeningChoice <= 0 || screeningChoice > i){
            System.out.println("Invalid Input");
            System.out.println("showScreening fail");
            return;
        }
        System.out.println("Cinema: " + cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(screeningChoice-1).getCinema().getCinemaName());
        System.out.println("ShowTime: " + cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(screeningChoice-1).getShowTime());
        System.out.println("Movie: " + cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(screeningChoice-1).getMovie().getMovieName());

        //TESTING
        if (cineplex.getCinemas().get(cinemaChoice-1).getCinemaType() == CinemaType.ORDINARY){
            LayoutPrinterOrdinary.printLayout(cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(screeningChoice-1));
        }
        else if (cineplex.getCinemas().get(cinemaChoice-1).getCinemaType() == CinemaType.PLATINUMMOVIESUITES){
            LayoutPrinterPlat.printLayout(cineplex.getCinemas().get(cinemaChoice-1).getScreenings().get(screeningChoice-1));
        }
    }
}
