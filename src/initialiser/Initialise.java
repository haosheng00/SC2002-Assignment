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
   public static ArrayList<Cinema> cinemasAMK = new ArrayList<>(
           List.of(new Cinema("AMK Hub Screen 1", "AMA", Enum.CinemaType.ORDINARY),
                   new Cinema("AMK Hub Screen 2", "AMB", Enum.CinemaType.ORDINARY),
                   new Cinema("AMK Hub Screen 3", "AMC", Enum.CinemaType.ORDINARY),
                   new Cinema("AMK Hub Screen 4", "AMD", Enum.CinemaType.ORDINARY),
                   new Cinema("AMK Hub Screen 5", "AME", Enum.CinemaType.ORDINARY),
                   new Cinema("AMK Hub Screen 6", "AMF", Enum.CinemaType.ORDINARY)));

   public static ArrayList<Cinema> cinemasJEM = new ArrayList<>(
           List.of(new Cinema("JEM Screen 1", "JEA", Enum.CinemaType.ORDINARY),
                   new Cinema("JEM Screen 2", "JEB", Enum.CinemaType.ORDINARY),
                   new Cinema("JEM Screen 3", "JEC", Enum.CinemaType.ORDINARY),
                   new Cinema("JEM Screen 4", "JED", Enum.CinemaType.ORDINARY),
                   new Cinema("JEM Screen 5", "JEE", Enum.CinemaType.ORDINARY),
                   new Cinema("JEM Screen 6", "JEF", Enum.CinemaType.PLATINUMMOVIESUITES)));

   public static ArrayList<Cinema> cinemasOrchard = new ArrayList<>(
           List.of(new Cinema("Orchard Screen 1", "ORA", Enum.CinemaType.ORDINARY),
                   new Cinema("Orchard Screen 2", "ORB", Enum.CinemaType.ORDINARY),
                   new Cinema("Orchard Screen 3", "ORC", Enum.CinemaType.ORDINARY),
                   new Cinema("Orchard Screen 4", "ORD", Enum.CinemaType.PLATINUMMOVIESUITES),
                   new Cinema("Orchard Screen 5", "ORE", Enum.CinemaType.PLATINUMMOVIESUITES),
                   new Cinema("Orchard Screen 6", "ORF", Enum.CinemaType.PLATINUMMOVIESUITES)));



   public static ArrayList<Movie> preMovies = new ArrayList<Movie>(
           List.of(new Movie("Joy"), new Movie("Sad"), new Movie("Fear")));
   public static ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>(
           List.of(new Cineplex("Cathay Cineplex AMK Hub", cinemasAMK, preMovies),
                   new Cineplex("Cathay Cineplex JEM", cinemasJEM, preMovies),
                   new Cineplex("Cathay Cineleisure Orchard", cinemasOrchard, preMovies)));

                   public static ArrayList<Screening> screenings = new ArrayList<Screening>(
                    List.of(new Screening(cinemasAMK.get(1), "20221212", "1111", preMovies.get(1)))
                   );

    // public static ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>();
    public static ArrayList<Payment> payments = new ArrayList<Payment>();
    public static ArrayList<Review> reviews = new ArrayList<Review>();
    public static ArrayList<Customer> customers = new ArrayList<Customer>(
            List.of(new Customer("guest", "guest", "123", "123"), new Customer("mary", "mary123", "hh", "123")));
    public static ArrayList<Admin> admins = new ArrayList<Admin>(
            List.of(new Admin("admin1", "admin1"), new Admin("admin2", "admin2")));
        //public static ArrayList<Movie> movies = new ArrayList<Movie>();
     public static ArrayList<Movie> movies = new ArrayList<Movie>(
            List.of(new Movie("Joy"), new Movie("Sad"), new Movie("Fear")));
    // public static ArrayList<Screening> screenings = new ArrayList<Screening>();
    public static ArrayList<Movie> top5BySales = new ArrayList<Movie>();
    public static ArrayList<Movie> top5ByRatings = new ArrayList<Movie>();
    public static ArrayList<PublicHoliday> holidays = new ArrayList<PublicHoliday>();

    //public static int listingCriteria; //Need to serialize


    public static void initialiseMOBLIMA() throws Exception {
        WriteMovieDB.writeMovieDB();
        ReadMovieDB.readMovieDB();
    }

    //     public static void initialiseWrite() throws Exception {
    //     WriteMovieDB.writeMovieDB();
    //     // ReadMovieDB.readMovieDB();
    // }
}
