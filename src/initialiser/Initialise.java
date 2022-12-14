package initialiser;

import classes.*;
import serialiser.ReadMovieDB;
import serialiser.WriteMovieDB;

import java.util.ArrayList;

/**
 * Initialise the different attributes and array lists required for the whole booking system
 */
public class Initialise {

    // attributes
    public static final int Ordinary_Capacity = 170;
    public static final int Plat_Capacity = 22;

    public static DateTime dt = new DateTime();

    public static ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>();
    public static ArrayList<Payment> payments = new ArrayList<Payment>();
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    public static ArrayList<Admin> admins = new ArrayList<Admin>();
    public static ArrayList<Movie> movies = new ArrayList<Movie>();
    public static ArrayList<Screening> screenings = new ArrayList<Screening>();
    public static ArrayList<Movie> top5BySales = new ArrayList<Movie>();
    public static ArrayList<Movie> top5ByRatings = new ArrayList<Movie>();
    public static ArrayList<PublicHoliday> holidays = new ArrayList<PublicHoliday>();
    public static ArrayList<Integer> listingCriteria = new ArrayList<Integer>();

    public static ArrayList<Double> priceByAge = new ArrayList<Double>();
    public static ArrayList<Double> priceByMovieType = new ArrayList<Double>();
    public static ArrayList<Double> priceByCinemaType = new ArrayList<Double>();
    public static ArrayList<Double> priceByDay = new ArrayList<Double>();

    /**
     * Initialise the movie booking system with the pre-loaded data
     * @throws Exception
     */
    public static void initialiseMOBLIMA() throws Exception {
        //preWriteMovieDB will set values in .dat to the pre-initialised + remove all previously stored
        //WriteMovieDB.preWriteMovieDB();
        ReadMovieDB.readMovieDB();
    }
}
