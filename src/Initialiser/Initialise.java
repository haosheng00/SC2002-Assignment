package Initialiser;

import Classes.*;
import Serialiser.ReadMovieDB;


import java.util.ArrayList;

public class Initialise {

    //attributes
    public static final int Ordinary_Capacity = 170;
    public static final int Plat_Capacity = 22;

    public static DateTime dt = new DateTime();

    public static ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>();
    //public static ScreeningController screeningController = new ScreeningController();
    
    public static ArrayList<Payment> payments = new ArrayList<Payment>();
    //public static PaymentController pc = new PaymentController(payments);

    public static ArrayList<Review> reviews = new ArrayList<Review>();
    //public static ReviewController rc = new ReviewController(reviews);
    
    public static ArrayList<Customer> customers = new ArrayList<Customer>();
    //public static CustomerController cc = new CustomerController(customers);
    
    public static ArrayList<Admin> admins = new ArrayList<Admin>();
    //public static AdminController ac = new AdminController(admins);
    
    /* Initialise MovieController */
    public static ArrayList<Movie> movies = new ArrayList<Movie>();
    //public static MovieController mc = new MovieController();
    public static ArrayList<Movie> top5BySales = new ArrayList<Movie>();
    public static ArrayList<Movie> top5ByRatings = new ArrayList<Movie>();



    

    //public static ArrayList<Ticket> tickets = new ArrayList<Ticket>();
    //public static ArrayList<Screening> screenings = new ArrayList<Screening>();
    //public static ArrayList<DateTime> holidays = new ArrayList<DateTime>();
    //public static TicketController tc = new TicketController(tickets, screenings, holidays);


    public static void initialiseEverything() throws Exception {
        ReadMovieDB.readMovieDB();
    }

    // public static void initialiseEverything(){
    //     /* Initialise Cinema  */
    //     ArrayList<Cinema> cinemaJEM = new ArrayList<Cinema>();
    //     ArrayList<Screening> screeningJEM = new ArrayList<Screening>();
    //     cinemaJEM.add(new Cinema(CinemaType.ORDINARY, "JE1", "JEM1",screeningJEM));
    //     cinemaJEM.add(new Cinema(CinemaType.ORDINARY, "JE2", "JEM2",screeningJEM));
    //     cinemaJEM.add(new Cinema(CinemaType.PLATINUMMOVIESUITES, "JE3", "JEM3",screeningJEM));
    //     cineplexes.add(new Cineplex("Jem", cinemaJEM));
    //     screeningJEM.add(new Screening(cinemaJEM.get(1), TimeZone.getDefault(), new Movie("Cars4")));
    //     screeningJEM.add(new Screening(cinemaJEM.get(1), TimeZone.getDefault(), new Movie("Cars3")));
    //     ArrayList<Cinema> cinemaOrchard = new ArrayList<Cinema>();
    //     ArrayList<Screening> screeningOC = new ArrayList<Screening>();
    //     cinemaOrchard.add(new Cinema(CinemaType.ORDINARY, "OC1", "Orchard Cineleisure 1", screeningOC));
    //     cinemaOrchard.add(new Cinema(CinemaType.ORDINARY, "OC2", "Orchard Cineleisure 2", screeningOC));
    //     cinemaOrchard.add(new Cinema(CinemaType.PLATINUMMOVIESUITES, "OC3", "Orchard Cineleisure 3", screeningOC));
    //     cineplexes.add(new Cineplex("Orchard Cineleisure", cinemaOrchard));
    // }
}
