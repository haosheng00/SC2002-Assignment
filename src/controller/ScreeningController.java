package controller;

import initialiser.Initialise;
import serialiser.SerializeMovieDB;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

import classes.*;

/**
 * Represents the controller that can configure screenings
 */
public class ScreeningController {
    static Scanner sc = new Scanner(System.in);

    /**
     * Asks you to select a cineplex, a cinema, a movie, a screening date and time
     * and adds the screening to movie DB
     * @throws IOException
     */
    public static void addScreening() throws IOException{
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(Initialise.cineplexes);
        if (cineplexChoice == -1){
            return;
        }
        Cineplex cineplexChosen = Initialise.cineplexes.get(cineplexChoice);
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

    /**
     * Asks you to select a cineplex, a movie, and a screening
     * then deletes the screening from movie DB
     * @throws IOException
     */
    public static void deleteScreening() throws IOException, ParseException {
        int movieChoice = DropDownMenu.initiateMovieChoice_CustomerMenu(1);
        if (movieChoice == -1){
            return;
        }
        Movie movieChosen = Initialise.movies.get(movieChoice);
        int screeningChoice = DropDownMenu.initiateScreeningChoice(Initialise.screenings, movieChosen);
        if (screeningChoice == -1){
            return;
        }
        Initialise.screenings.remove(screeningChoice);
        SerializeMovieDB.writeSerializedObject("Screening.dat", Initialise.screenings);
        System.out.println("Screening deleted successfully");
    }

    /**
     * Asks you to select a cineplex, a movie and a screening
     * and prints our the selected screening cinema, screening date and time
     * @param cineplexes cineplexes pre-initialised
     * @throws ParseException
     */
    public static void showScreening(ArrayList<Cineplex> cineplexes) throws ParseException {
        int cineplexChoice = DropDownMenu.initiateCineplexChoice(cineplexes);
        if (cineplexChoice == -1){
            return;
        }
        int movieChoice = DropDownMenu.initiateMovieChoice(cineplexes.get(cineplexChoice), 1);
        if (movieChoice == -1){
            return;
        }
        Movie movieChosen = cineplexes.get(cineplexChoice).getMovies().get(movieChoice);
        int screeningChoice = DropDownMenu.initiateScreeningChoice(Initialise.screenings, movieChosen, cineplexes.get(cineplexChoice));
        if (screeningChoice == -1){
            return;
        }
        System.out.println("Printing screening information for Movie: " + movieChosen.getMovieTitle() + " ...");
        System.out.println("Cinema: " + Initialise.screenings.get(screeningChoice).getCinema().getCinemaName());
        System.out.println("Show Date: " + DateTime.dateFormatter(Initialise.screenings.get(screeningChoice).getShowDate()));
        System.out.println("Show Time: " + DateTime.dateFormatter(Initialise.screenings.get(screeningChoice).getShowTime()));
        System.out.println();
    }
}
    
