package controller;

import initialiser.Initialise;

import java.util.ArrayList;
import java.util.Scanner;

import classes.*;

public class ScreeningController {
    static Scanner sc = new Scanner(System.in);

    //TODO: getScreenings()?
    public ScreeningController(){};
    public static void addScreening(ArrayList<Cineplex> cineplexes){
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        int cinemaChoice = DropDownMenu.initiateCinemaChoice(cineplexes.get(cineplexChoice-1).getCinemas());
        int movieChoice = DropDownMenu.initiateMovieChoice(cineplexes.get(cineplexChoice-1).getMovies());
        System.out.println("Add date(YYYYMMDD): ");
        String dateChosen = sc.next();
        System.out.println("Add time(HHmmss): ");
        String timeChosen = sc.next();
        Cinema cinemaChosen = cineplexes.get(cinemaChoice-1).getCinemas().get(cinemaChoice-1);
        Movie movieChosen = cineplexes.get(cineplexChoice-1).getMovies().get(movieChoice-1);
        Initialise.screenings.add(new Screening(cinemaChosen,dateChosen,timeChosen,movieChosen));
        System.out.println("addScreening success");
    }
    public static void deleteScreening(ArrayList<Cineplex> cineplexes){
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        int movieChoice = DropDownMenu.initiateMovieChoice(cineplexes.get(cineplexChoice-1).getMovies());
        Movie movieChosen = cineplexes.get(cineplexChoice-1).getMovies().get(movieChoice-1);
        int counter = 0;
        int screeningChoice = DropDownMenu.initiateScreeningChoice(Initialise.screenings);
        Initialise.screenings.remove(screeningChoice-1);
        System.out.println("deleteScreening success");
    }

    public static void showScreening(ArrayList<Cineplex> cineplexes){
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
