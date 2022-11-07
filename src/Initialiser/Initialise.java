package initialiser;

import serialiser.ReadMovieDB;

import java.util.ArrayList;

import classes.*;

public class Initialise {

    //attributes
    public static final int Ordinary_Capacity = 170;
    public static final int Plat_Capacity = 22;

    public static DateTime dt = new DateTime();
    public static ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>();
    //cineplexes.add(new Cineplex(null, null,null));
    public static ArrayList<Payment> payments = new ArrayList<Payment>();
    public static ArrayList<Review> reviews = new ArrayList<Review>();
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    public static ArrayList<Admin> admins = new ArrayList<Admin>();
    public static ArrayList<Movie> movies = new ArrayList<Movie>();
    public static ArrayList<Screening> screenings = new ArrayList<Screening>();
    public static ArrayList<Movie> top5BySales = new ArrayList<Movie>();
    public static ArrayList<Movie> top5ByRatings = new ArrayList<Movie>();
    public static ArrayList<PublicHoliday> holidays = new ArrayList<PublicHoliday>();

    //public static ArrayList<Screening> screenings = new ArrayList<Screening>();
    //public static ArrayList<DateTime> holidays = new ArrayList<DateTime>();
    //public static TicketController tc = new TicketController(tickets, screenings, holidays);

    public static void initialiseEverything() throws Exception {
        ReadMovieDB.readMovieDB();
    }
}
