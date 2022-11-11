package initialiser;

import classes.*;
import serialiser.ReadMovieDB;
import serialiser.WriteMovieDB;

import java.util.ArrayList;

public class Initialise {

    // attributes
    public static final int Ordinary_Capacity = 170;
    public static final int Plat_Capacity = 22;

    public static DateTime dt = new DateTime();

    public static int listingCriteria;

    public static ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>();
    public static ArrayList<Payment> payments = new ArrayList<Payment>();
    public static ArrayList<Review> reviews = new ArrayList<Review>();
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    public static ArrayList<Admin> admins = new ArrayList<Admin>();
    public static ArrayList<Movie> movies = new ArrayList<Movie>();
    public static ArrayList<Screening> screenings = new ArrayList<Screening>();
    public static ArrayList<Movie> top5BySales = new ArrayList<Movie>();
    public static ArrayList<Movie> top5ByRatings = new ArrayList<Movie>();
    public static ArrayList<PublicHoliday> holidays = new ArrayList<PublicHoliday>();

    public static ArrayList<Double> priceByAge = new ArrayList<Double>();
    public static ArrayList<Double> priceByMovieType = new ArrayList<Double>();
    public static ArrayList<Double> priceByCinemaType = new ArrayList<Double>();
    public static ArrayList<Double> priceByDay = new ArrayList<Double>();

    public static void initialiseMOBLIMA() throws Exception {
        //preWriteMovieDB will set values in .dat to the pre-initialised + remove all previously stored
        WriteMovieDB.preWriteMovieDB();
        ReadMovieDB.readMovieDB();
    }

    //     public static void initialiseWrite() throws Exception {
    //     WriteMovieDB.writeMovieDB();
    //     // ReadMovieDB.readMovieDB();
    // }
}
