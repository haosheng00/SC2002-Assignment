package controller;

import initialiser.Initialise;
import serialiser.SerializeMovieDB;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import classes.*;

public class ScreeningController {
    static Scanner sc = new Scanner(System.in);

    public ScreeningController(){};
    public static void addScreening(ArrayList<Cineplex> cineplexes) throws IOException{
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        if (cineplexChoice == -1){
            return;
        }
        Cineplex cineplexChosen = cineplexes.get(cineplexChoice);
        int cinemaChoice = DropDownMenu.initiateCinemaChoice(cineplexChosen.getCinemas());
        if (cinemaChoice == -1){
            return;
        }
        Cinema cinemaChosen = cineplexChosen.getCinemas().get(cinemaChoice);
        int movieChoice = DropDownMenu.initiateMovieChoice(cineplexChosen, 1);
        if (movieChoice == -1){
            return;
        }
        Movie movieChosen = cineplexChosen.getMovies().get(movieChoice);
        System.out.println("Add date(YYYYMMDD): ");
        String dateChosen = sc.next();
        System.out.println("Add time(HHmmss): ");
        String timeChosen = sc.next();
        Initialise.screenings.add(new Screening(cinemaChosen,dateChosen,timeChosen,movieChosen));
        SerializeMovieDB.writeSerializedObject("Screening.dat", Initialise.screenings);
        System.out.println("Screening added successfully");
    }

    public static void deleteScreening(ArrayList<Cineplex> cineplexes) throws IOException{
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        if (cineplexChoice == -1){
            return;
        }
        int movieChoice = DropDownMenu.initiateMovieChoice(cineplexes.get(cineplexChoice), 1);
        if (movieChoice == -1){
            return;
        }
        Movie movieChosen = cineplexes.get(cineplexChoice).getMovies().get(movieChoice);
        int screeningChoice = DropDownMenu.initiateScreeningChoice(Initialise.screenings, movieChosen);
        Initialise.screenings.remove(screeningChoice);
        SerializeMovieDB.writeSerializedObject("Screening.dat", Initialise.screenings);
        System.out.println("Screening deleted successfully");
    }

    public static void showScreening(ArrayList<Cineplex> cineplexes){
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        if (cineplexChoice == -1){
            return;
        }
        int movieChoice = DropDownMenu.initiateMovieChoice(cineplexes.get(cineplexChoice), 1);
        if (movieChoice == -1){
            return;
        }
        Movie movieChosen = cineplexes.get(cineplexChoice).getMovies().get(movieChoice);
        int screeningChoice = DropDownMenu.initiateScreeningChoice(Initialise.screenings, movieChosen);
        if (screeningChoice == -1){
            return;
        }
        System.out.println("Printing screening information for Movie... " + movieChosen.getMovieTitle());
        System.out.println("Cinema: " + Initialise.screenings.get(screeningChoice).getCinema().getCinemaName());
        System.out.println("Show Date: " +Initialise.screenings.get(screeningChoice).getShowDate());
        System.out.println("Show Time: " + Initialise.screenings.get(screeningChoice).getShowTime());
        System.out.println();
    }
}
    
