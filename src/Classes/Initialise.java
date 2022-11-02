import java.util.ArrayList;
import java.util.TimeZone;

public class Initialise {
    public static ArrayList<Cineplex> cineplex = new ArrayList<Cineplex>();
    //public static ArrayList<Cinema> cinemas = new ArrayList<Cinema>();
    //public static ArrayList<Screening> screenings = new ArrayList<Screening>();

    public static void initialiseEverything(){
        ArrayList<Cinema> cinemaJEM = new ArrayList<Cinema>();
        ArrayList<Screening> screeningJEM = new ArrayList<Screening>();
        cinemaJEM.add(new Cinema(CinemaType.ORDINARY, "JE1", "JEM1",screeningJEM));
        cinemaJEM.add(new Cinema(CinemaType.ORDINARY, "JE2", "JEM2",screeningJEM));
        cinemaJEM.add(new Cinema(CinemaType.PLATINUMMOVIESUITES, "JE3", "JEM3",screeningJEM));
        cineplex.add(new Cineplex("Jem", cinemaJEM));
        screeningJEM.add(new Screening(cinemaJEM.get(1), TimeZone.getDefault(), new Movie("Cars4")));
        screeningJEM.add(new Screening(cinemaJEM.get(1), TimeZone.getDefault(), new Movie("Cars3")));
        ArrayList<Cinema> cinemaOrchard = new ArrayList<Cinema>();
        ArrayList<Screening> screeningOC = new ArrayList<Screening>();
        cinemaOrchard.add(new Cinema(CinemaType.ORDINARY, "OC1", "Orchard Cineleisure 1", screeningOC));
        cinemaOrchard.add(new Cinema(CinemaType.ORDINARY, "OC2", "Orchard Cineleisure 2", screeningOC));
        cinemaOrchard.add(new Cinema(CinemaType.PLATINUMMOVIESUITES, "OC3", "Orchard Cineleisure 3", screeningOC));
        cineplex.add(new Cineplex("Orchard Cineleisure", cinemaOrchard));
    }
}
