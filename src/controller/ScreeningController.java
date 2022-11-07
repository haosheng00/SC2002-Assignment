package controller;

import initialiser.Initialise;

import java.util.ArrayList;
import java.util.Scanner;

import classes.*;

public class ScreeningController {
    static Scanner sc = new Scanner(System.in);

    public ScreeningController(){};
    public static void addScreening(ArrayList<Cineplex> cineplexes){
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        Cineplex cineplexChosen = cineplexes.get(cineplexChoice);
        int cinemaChoice = DropDownMenu.initiateCinemaChoice(cineplexChosen.getCinemas());
        int movieChoice = DropDownMenu.initiateMovieChoice(cineplexChosen, 1);
        System.out.println("Add date(YYYYMMDD): ");
        String dateChosen = sc.next();
        System.out.println("Add time(HHmmss): ");
        String timeChosen = sc.next();
        Cinema cinemaChosen = cineplexChosen.getCinemas().get(cinemaChoice);
        Movie movieChosen = cineplexChosen.getMovies().get(movieChoice);
        Initialise.screenings.add(new Screening(cinemaChosen,dateChosen,timeChosen,movieChosen));
        System.out.println("addScreening success");
    }

    public static void deleteScreening(ArrayList<Cineplex> cineplexes){
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        int movieChoice = DropDownMenu.initiateMovieChoice(cineplexes.get(cineplexChoice), 1);
        Movie movieChosen = cineplexes.get(cineplexChoice).getMovies().get(movieChoice);
        int screeningChoice = DropDownMenu.initiateScreeningChoice(Initialise.screenings, movieChosen);
        Initialise.screenings.remove(screeningChoice);
        System.out.println("deleteScreening success");
    }

    public static void showScreening(ArrayList<Cineplex> cineplexes){
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        int movieChoice = DropDownMenu.initiateMovieChoice(cineplexes.get(cineplexChoice), 1);
        Movie movieChosen = cineplexes.get(cineplexChoice).getMovies().get(movieChoice);
        int screeningChoice = DropDownMenu.initiateScreeningChoice(Initialise.screenings, movieChosen);
        System.out.println("Printing screening information for Movie " + movieChosen.getMovieTitle());
        System.out.println("Cinema: " + Initialise.screenings.get(screeningChoice).getCinema().getCinemaName());
        System.out.println("ShowTime: " +Initialise.screenings.get(screeningChoice).getShowDate() + " " + Initialise.screenings.get(screeningChoice-1).getShowTime());
        System.out.println();
    }
}
    
