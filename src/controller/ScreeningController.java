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
    public static void deleteScreening(ArrayList<Cineplex> cineplexes){
        int i;
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        int movieChoice = DropDownMenu.initiateMovieChoice(cineplexes.get(cineplexChoice-1).getMovies());
        Movie movieChosen = cineplexes.get(cineplexChoice-1).getMovies().get(movieChoice-1);
        int screeningChoice = DropDownMenu.initiateScreeningChoice(movieChosen.getScreenings());
        movieChosen.getScreenings().remove(screeningChoice-1);
        System.out.println("deleteScreening success");
    }

    public static void showScreening(ArrayList<Cineplex> cineplexes){
        //TODO: showScreening based on cineplex->movie->print
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        int movieChoice = DropDownMenu.initiateMovieChoice(cineplexes.get(cineplexChoice-1).getMovies());
        Movie movieChosen = cineplexes.get(cineplexChoice-1).getMovies().get(movieChoice-1);
        System.out.println("Printing screening information for Movie " + movieChosen.getMovieTitle());
        for (int i = 0; i < movieChosen.getScreenings().size();i++){
            System.out.println("Cinema: " + movieChosen.getScreenings().get(i).getCinema());
            System.out.println("ShowTime: " + movieChosen.getScreenings().get(i).getShowDate() + " " + movieChosen.getScreenings().get(i).getShowTime());
            System.out.println();
        }
    }
}
