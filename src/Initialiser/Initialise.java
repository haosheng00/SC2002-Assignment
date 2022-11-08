package initialiser;

import serialiser.ReadMovieDB;
import serialiser.WriteMovieDB;

import java.util.ArrayList;
import java.util.List;

import classes.*;
import serialiser.*;

public class Initialise {

    // attributes
    public static final int Ordinary_Capacity = 170;
    public static final int Plat_Capacity = 22;

    public static DateTime dt = new DateTime();
    public static ArrayList<Cinema> cinemas = new ArrayList<>();
    public static ArrayList<Movie> movie1 = new ArrayList<Movie>();
//     public static ArrayList<Movie> movie1 = new ArrayList<Movie>(
//             List.of(new Movie("Joy"), new Movie("Sad"), new Movie("Fear"), new Movie("Movie1")));
    public static ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>(
            List.of(new Cineplex("Cineplex1", cinemas, movie1)));
    public static ArrayList<Payment> payments = new ArrayList<Payment>();
    public static ArrayList<Review> reviews = new ArrayList<Review>();
    public static ArrayList<Customer> customers = new ArrayList<Customer>(
            List.of(new Customer("guest", "guest", "123", "123"), new Customer("mary", "mary123", "hh", "123")));
    public static ArrayList<Admin> admins = new ArrayList<Admin>(
            List.of(new Admin("admin1", "admin1"), new Admin("admin2", "admin2")));
            public static ArrayList<Movie> movies = new ArrayList<Movie>();
//     public static ArrayList<Movie> movies = new ArrayList<Movie>(
//             List.of(new Movie("Joy"), new Movie("Sad"), new Movie("Fear")));
    public static ArrayList<Screening> screenings = new ArrayList<Screening>();
    public static ArrayList<Movie> top5BySales = new ArrayList<Movie>();
    public static ArrayList<Movie> top5ByRatings = new ArrayList<Movie>();
    public static ArrayList<PublicHoliday> holidays = new ArrayList<PublicHoliday>();

    public static void initialiseRead() throws Exception {
        //WriteMovieDB.writeMovieDB();
        ReadMovieDB.readMovieDB();
    }

        public static void initialiseWrite() throws Exception {
        WriteMovieDB.writeMovieDB();
        // ReadMovieDB.readMovieDB();
    }
}
