package serialiser;

import classes.*;
import classes.Enum;
import initialiser.Initialise;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a class that write objects from their array list to their respective byte file in the database
 */
public class WriteMovieDB {
	/**
	 * Represents the cinemas in AMK Hub Cineplex
	 */
	public static ArrayList<Cinema> cinemasAMK = new ArrayList<>(
			List.of(new Cinema("AMK Hub Screen 1", "AMA", Enum.CinemaType.ORDINARY, "Athay Cineplex AMK Hub"),
					new Cinema("AMK Hub Screen 2", "AMB", Enum.CinemaType.ORDINARY, "Athay Cineplex AMK Hub"),
					new Cinema("AMK Hub Screen 3", "AMC", Enum.CinemaType.ORDINARY, "Athay Cineplex AMK Hub"),
					new Cinema("AMK Hub Screen 4", "AMD", Enum.CinemaType.ORDINARY, "Athay Cineplex AMK Hub"),
					new Cinema("AMK Hub Screen 5", "AME", Enum.CinemaType.ORDINARY, "Athay Cineplex AMK Hub"),
					new Cinema("AMK Hub Screen 6", "AMF", Enum.CinemaType.ORDINARY, "Athay Cineplex AMK Hub")));

	/**
	 * Represents the cinemas in JEM Cineplex
	 */
	public static ArrayList<Cinema> cinemasJEM = new ArrayList<>(
			List.of(new Cinema("JEM Screen 1", "JEA", Enum.CinemaType.ORDINARY, "Athay Cineplex JEM"),
					new Cinema("JEM Screen 2", "JEB", Enum.CinemaType.ORDINARY, "Athay Cineplex JEM"),
					new Cinema("JEM Screen 3", "JEC", Enum.CinemaType.ORDINARY, "Athay Cineplex JEM"),
					new Cinema("JEM Screen 4", "JED", Enum.CinemaType.ORDINARY, "Athay Cineplex JEM"),
					new Cinema("JEM Screen 5", "JEE", Enum.CinemaType.ORDINARY, "Athay Cineplex JEM"),
					new Cinema("JEM Screen 6", "JEF", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineplex JEM")));

	/**
	 * Represents the cinemas in Cineleisure Orchard Cineplex
	 */
	public static ArrayList<Cinema> cinemasOrchard = new ArrayList<>(
			List.of(new Cinema("Orchard Screen 1", "ORA", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineleisure Orchard"),
					new Cinema("Orchard Screen 2", "ORB", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineleisure Orchard"),
					new Cinema("Orchard Screen 3", "ORC", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineleisure Orchard"),
					new Cinema("Orchard Screen 4", "ORD", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineleisure Orchard"),
					new Cinema("Orchard Screen 5", "ORE", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineleisure Orchard"),
					new Cinema("Orchard Screen 6", "ORF", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineleisure Orchard")));

	/**
	 * Represents the movies pre-initialised in the movie database
	 */
	public static ArrayList<Movie> preMovies = new ArrayList<Movie>(
		List.of(new Movie("Rise of the Teenage Mutant Ninja Turtles"), 
				new Movie("Black Panther"), 
				new Movie("Inside Out"),
				new Movie("Your Name"),
				new Movie("Kungfu Panda"),
				new Movie("My Love")));

	/**
	 * Represents the Cineplexes that the Group Athay currently operates
	 */
	public static ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>(
			List.of(new Cineplex("Athay Cineplex AMK Hub", cinemasAMK, (ArrayList)preMovies.clone()),
					new Cineplex("Athay Cineplex JEM", cinemasJEM, (ArrayList)preMovies.clone()),
					new Cineplex("Athay Cineleisure Orchard", cinemasOrchard, (ArrayList)preMovies.clone())));

	/**
	 * Represents the screenings pre-initialised in the movie database
	 */
	public static ArrayList<Screening> screenings = new ArrayList<>(
			List.of(new Screening(cinemasAMK.get(0), "20221209", "143000", preMovies.get(0)),
					new Screening(cinemasAMK.get(0), "20221210", "153000", preMovies.get(0)),
					new Screening(cinemasAMK.get(0), "20221211", "203000", preMovies.get(0)),
					new Screening(cinemasAMK.get(0), "20221212", "223000", preMovies.get(5)),
					new Screening(cinemasAMK.get(0), "20221217", "140000", preMovies.get(4)),
					new Screening(cinemasAMK.get(2), "20221218", "153000", preMovies.get(1)),
					new Screening(cinemasAMK.get(4), "20221219", "163000", preMovies.get(2)),
					new Screening(cinemasAMK.get(0), "20221220", "143000", preMovies.get(0)),
					new Screening(cinemasJEM.get(2), "20221221", "090000", preMovies.get(4)),
					new Screening(cinemasJEM.get(4), "20221222", "103000", preMovies.get(4)),
					new Screening(cinemasOrchard.get(0), "20221209", "143000", preMovies.get(0)),
					new Screening(cinemasOrchard.get(2), "20221212", "133000", preMovies.get(1)),
					new Screening(cinemasOrchard.get(4), "20221215", "143000", preMovies.get(2)),
					new Screening(cinemasJEM.get(2), "20230101", "160000", preMovies.get(4)),
					new Screening(cinemasJEM.get(2), "20230102", "140000", preMovies.get(4)),
					new Screening(cinemasOrchard.get(0), "20221224", "200000", preMovies.get(1)),
					new Screening(cinemasOrchard.get(0), "20221225", "220000", preMovies.get(1))));

	/**
	 * Represents the admin accounts pre-initialised in the movie database
	 */
	public static ArrayList<Admin> admins = new ArrayList<Admin>(
			List.of(new Admin("admin1", "admin1"), new Admin("admin2", "admin2")));

	/**
	 * Represents the customer accounts pre-initialised in the movie database
	 */
	public static ArrayList<Customer> customers = new ArrayList<Customer>(
			List.of(new Customer("guest", "guest", "123", "123"), new Customer("mary", "mary123", "hh", "123"), new Customer("sean", "sean123", "hh", "123"), new Customer("joy", "joy123", "hh", "123")));

	/**
	 * Represents the public holidays recognized by Athay
	 */
	public static ArrayList<PublicHoliday> holidays = new ArrayList<PublicHoliday>(
		List.of(new PublicHoliday("NEW YEARS DAY", "20230101"),
				new PublicHoliday("CHINESE NEW YEAR", "20220201"),
				new PublicHoliday("CHINESE NEW YEAR", "20220202"),
				new PublicHoliday("GOOD FRIDAY", "20220415"),
				new PublicHoliday("LABOUR DAY", "20220501"),
				new PublicHoliday("HARI RAYA PUASA", "20220503"),
				new PublicHoliday("VESAK DAY", "20220515"),
				new PublicHoliday("HARI RAYA HAJI", "20220710"),
				new PublicHoliday("NATIONAL DAY", "20220809"),
				new PublicHoliday("DEEPAVALI", "20221024"),
				new PublicHoliday("CHRISTMAS", "20221225")));

	public static ArrayList<Double> priceByAge = new ArrayList<Double> (List.of(7.00, 8.50, 4.00)); //student, adult, senior
	public static ArrayList<Double> priceByMovieType = new ArrayList<Double> (List.of(0.00, 2.00)); //2d, 3d
	public static ArrayList<Double> priceByCinemaType = new ArrayList<Double> (List.of(0.00, 5.00)); //ordinary, premium
	public static ArrayList<Double> priceByDay = new ArrayList<Double>(List.of(0.00, 3.00, 5.00)); //weekday, weekend, holiday
	public static ArrayList<Integer> listingCriteria = new ArrayList<Integer>(List.of(3));


	public static ArrayList<Movie> top5ByRatings = new ArrayList<Movie>(
		List.of(new Movie("Rise of the Teenage Mutant Ninja Turtles"), 
					new Movie("Black Panther"), 
					new Movie("Inside Out"),
					new Movie("Your Name"),
					new Movie("Kungfu Panda")));

	public static ArrayList<Movie> top5BySales = new ArrayList<Movie>(
		List.of(new Movie("Rise of the Teenage Mutant Ninja Turtles"), 
					new Movie("Black Panther"), 
					new Movie("Inside Out"),
					new Movie("Your Name"),
					new Movie("Kungfu Panda")));

	/**
	 * Clears all the arrays in the database
	 * @throws Exception
	 */
	public static void writeMovieDB() throws Exception {
		SerializeMovieDB.writeSerializedObject("Cineplex.dat", Initialise.cineplexes);
		SerializeMovieDB.writeSerializedObject("Payment.dat", Initialise.payments);
		SerializeMovieDB.writeSerializedObject("Screening.dat", Initialise.screenings);
		SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);
		SerializeMovieDB.writeSerializedObject("Admin.dat", Initialise.admins);
		SerializeMovieDB.writeSerializedObject("Movie.dat", Initialise.movies);
		SerializeMovieDB.writeSerializedObject("Screening.dat", Initialise.screenings);
		SerializeMovieDB.writeSerializedObject("Top5BySales.dat", Initialise.top5BySales);
		SerializeMovieDB.writeSerializedObject("Top5ByRatings.dat", Initialise.top5ByRatings);
		SerializeMovieDB.writeSerializedObject("ListingCriteria.dat", Initialise.listingCriteria);
		SerializeMovieDB.writeSerializedObject("Holiday.dat", Initialise.holidays);
		SerializeMovieDB.writeSerializedObject("PriceByAge.dat", Initialise.priceByAge);
		SerializeMovieDB.writeSerializedObject("PriceByMovieType.dat", Initialise.priceByMovieType);
		SerializeMovieDB.writeSerializedObject("PriceByCinemaType.dat", Initialise.priceByCinemaType);
		SerializeMovieDB.writeSerializedObject("PriceByDay.dat", Initialise.priceByDay);
	}

	/**
	 * Pre-initialises some objects into the movie database
	 * @throws Exception
	 */
	public static void preWriteMovieDB() throws Exception{
		SerializeMovieDB.writeSerializedObject("Cineplex.dat", cineplexes);
		SerializeMovieDB.writeSerializedObject("Payment.dat", Initialise.payments);
		SerializeMovieDB.writeSerializedObject("Screening.dat", screenings);
		SerializeMovieDB.writeSerializedObject("Customer.dat", customers);
		SerializeMovieDB.writeSerializedObject("Admin.dat", admins);
		SerializeMovieDB.writeSerializedObject("Movie.dat", preMovies);
		SerializeMovieDB.writeSerializedObject("Top5BySales.dat", top5BySales);
		SerializeMovieDB.writeSerializedObject("Top5ByRatings.dat", top5ByRatings);
		SerializeMovieDB.writeSerializedObject("ListingCriteria.dat", listingCriteria);
		SerializeMovieDB.writeSerializedObject("Holiday.dat",holidays);
		SerializeMovieDB.writeSerializedObject("PriceByAge.dat", priceByAge);
		SerializeMovieDB.writeSerializedObject("PriceByMovieType.dat", priceByMovieType);
		SerializeMovieDB.writeSerializedObject("PriceByCinemaType.dat", priceByCinemaType);
		SerializeMovieDB.writeSerializedObject("PriceByDay.dat", priceByDay);
	}
}
