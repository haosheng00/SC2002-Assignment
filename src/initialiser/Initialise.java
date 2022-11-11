package initialiser;

import classes.*;
import classes.Enum;
import serialiser.ReadMovieDB;
import serialiser.WriteMovieDB;

import java.util.ArrayList;
import java.util.List;

public class Initialise {

    // attributes
    public static final int Ordinary_Capacity = 170;
    public static final int Plat_Capacity = 22;

    public static DateTime dt = new DateTime();

<<<<<<< HEAD
    public static double [] priceByAge = new double [] {}; 
    public static double [] priceByMovieType = new double [] {};
    public static double [] priceByCinemaType = new double [] {};
    public static double [] priceByDay = new double [] {}; 
=======
    public static int listingCriteria;
>>>>>>> 56a1d48a5ce690ef8a423b1df1bbb291032c1923

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


    public static void initialiseMOBLIMA() throws Exception {
        //preWriteMovieDB will set values in .dat to the pre-initialised + remove all previously stored
        //WriteMovieDB.preWriteMovieDB();
        ReadMovieDB.readMovieDB();
    }

    //     public static void initialiseWrite() throws Exception {
    //     WriteMovieDB.writeMovieDB();
    //     // ReadMovieDB.readMovieDB();
    // }
}
