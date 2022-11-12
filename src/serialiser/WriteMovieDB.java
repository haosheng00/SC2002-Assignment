package serialiser;

import classes.*;
import classes.Enum;
import classes.Enum.MovieStatus;
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
			List.of(new Movie("Rise of the Teenage Mutant Ninja Turtles",MovieStatus.NOW_SHOWING, "Rise of the Teenage Mutant Ninja Turtles: The Movie is a 2022 American animated superhero film based on the Teenage Mutant Ninja Turtles characters created by Kevin Eastman and Peter Laird.","Andy Suriano",82,20000,Enum.AgeRestriction.PG,false,0,"20220822","20221222"), 
					new Movie("Black Panther",MovieStatus.NOW_SHOWING, "Black Panther is a 2018 American superhero film based on the Marvel Comics character of the same name. Produced by Marvel Studios and distributed by Walt Disney Studios Motion Pictures, it is the 18th film in the Marvel Cinematic Universe (MCU).","Ryan Coogler",134,100000,Enum.AgeRestriction.PG13,true,0,"20221111","20221222"), 
					new Movie("Inside Out",MovieStatus.END_OF_SHOWING, "Inside Out is a 2015 American computer-animated film directed by Pete Docter from a screenplay he co-wrote with Meg LeFauve and Josh Cooley.","Pete Docter",95,20000000,Enum.AgeRestriction.PG,false,0,"20220801","20220809"),
					new Movie("Your Name",MovieStatus.COMING_SOON, "Your Name (Japanese: 君の名は。, Hepburn: Kimi no Na wa) is a 2016 Japanese animated romantic fantasy film produced by CoMix Wave Films.","Makoto Shinkai",107,0,Enum.AgeRestriction.PG13,false,0,"20221212","20221231"),
					new Movie("Kungfu Panda",MovieStatus.NOW_SHOWING, "Kung Fu Panda is an American media franchise that originally started in 2008 with the release of the animated feature film of the same name, produced by DreamWorks Animation.","Ethan Reiff",122,500,Enum.AgeRestriction.PG13,true,0,"20221113","20221213"),
					new Movie("My Love",MovieStatus.NOW_SHOWING, "My Love is a 2021 Chinese romantic comedy film directed and co-written by Han Tian. It is a remake of the 2018 South Korean film On Your Wedding Day.","Han Tian",115,200000,Enum.AgeRestriction.NC16,false,0,"20221111","20221211")));

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
			List.of(new Screening(cineplexes.get(0).getCinemas().get(0), "20220220", "143000", preMovies.get(0)),
					new Screening(cineplexes.get(0).getCinemas().get(2), "20220221", "143000", preMovies.get(1)),
					new Screening(cineplexes.get(0).getCinemas().get(4), "20220222", "143000", preMovies.get(2)),
					new Screening(cineplexes.get(1).getCinemas().get(0), "20220223", "143000", preMovies.get(0)),
					new Screening(cineplexes.get(1).getCinemas().get(2), "20220224", "143000", preMovies.get(1)),
					new Screening(cineplexes.get(1).getCinemas().get(4), "20220225", "143000", preMovies.get(2)),
					new Screening(cinemasOrchard.get(0), "20220226", "143000", preMovies.get(0)),
					new Screening(cinemasOrchard.get(2), "20220227", "143000", preMovies.get(1)),
					new Screening(cinemasOrchard.get(4), "20220228", "143000", preMovies.get(2)),
					new Screening(cineplexes.get(0).getCinemas().get(0), "20220229", "143000", preMovies.get(2)),
					new Screening(cineplexes.get(0).getCinemas().get(2), "20220230", "143000", preMovies.get(0)),
					new Screening(cineplexes.get(0).getCinemas().get(4), "20220301", "143000", preMovies.get(1)),
					new Screening(cineplexes.get(0).getCinemas().get(2), "20220302", "143000", preMovies.get(1))));

	/**
	 * Represents the admin accounts pre-initialised in the movie database
	 */
	public static ArrayList<Admin> admins = new ArrayList<Admin>(
			List.of(new Admin("admin1", "admin1"), new Admin("admin2", "admin2")));

	/**
	 * Represents the customer accounts pre-initialised in the movie database
	 */
	public static ArrayList<Customer> customers = new ArrayList<Customer>(
			List.of(new Customer("guest", "guest", "123", "123"), new Customer("mary", "mary123", "hh", "123")));

	/**
	 * Represents the public holidays recognized by Athay
	 */
	public static ArrayList<PublicHoliday> holidays = new ArrayList<PublicHoliday>(
		List.of(new PublicHoliday("NEW YEARS DAY", "20220101"), 
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
		SerializeMovieDB.writeSerializedObject("Top5BySales.dat", Initialise.top5BySales);
		SerializeMovieDB.writeSerializedObject("Top5ByRatings.dat", Initialise.top5ByRatings);
		SerializeMovieDB.writeSerializedObject("ListingCriteria.dat", listingCriteria);
		SerializeMovieDB.writeSerializedObject("Holiday.dat", Initialise.holidays);
		SerializeMovieDB.writeSerializedObject("PriceByAge.dat", priceByAge);
		SerializeMovieDB.writeSerializedObject("PriceByMovieType.dat", priceByMovieType);
		SerializeMovieDB.writeSerializedObject("PriceByCinemaType.dat", priceByCinemaType);
		SerializeMovieDB.writeSerializedObject("PriceByDay.dat", priceByDay);
	}
}
