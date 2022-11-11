package serialiser;

import classes.*;
import classes.Enum;
import classes.Enum.MovieStatus;
import initialiser.Initialise;

import java.util.ArrayList;
import java.util.List;

public class WriteMovieDB {
	public static ArrayList<Cinema> cinemasAMK = new ArrayList<>(
			List.of(new Cinema("AMK Hub Screen 1", "AMA", Enum.CinemaType.ORDINARY, "Athay Cineplex AMK Hub"),
					new Cinema("AMK Hub Screen 2", "AMB", Enum.CinemaType.ORDINARY, "Athay Cineplex AMK Hub"),
					new Cinema("AMK Hub Screen 3", "AMC", Enum.CinemaType.ORDINARY, "Athay Cineplex AMK Hub"),
					new Cinema("AMK Hub Screen 4", "AMD", Enum.CinemaType.ORDINARY, "Athay Cineplex AMK Hub"),
					new Cinema("AMK Hub Screen 5", "AME", Enum.CinemaType.ORDINARY, "Athay Cineplex AMK Hub"),
					new Cinema("AMK Hub Screen 6", "AMF", Enum.CinemaType.ORDINARY, "Athay Cineplex AMK Hub")));

	public static ArrayList<Cinema> cinemasJEM = new ArrayList<>(
			List.of(new Cinema("JEM Screen 1", "JEA", Enum.CinemaType.ORDINARY, "Athay Cineplex JEM"),
					new Cinema("JEM Screen 2", "JEB", Enum.CinemaType.ORDINARY, "Athay Cineplex JEM"),
					new Cinema("JEM Screen 3", "JEC", Enum.CinemaType.ORDINARY, "Athay Cineplex JEM"),
					new Cinema("JEM Screen 4", "JED", Enum.CinemaType.ORDINARY, "Athay Cineplex JEM"),
					new Cinema("JEM Screen 5", "JEE", Enum.CinemaType.ORDINARY, "Athay Cineplex JEM"),
					new Cinema("JEM Screen 6", "JEF", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineplex JEM")));

	public static ArrayList<Cinema> cinemasOrchard = new ArrayList<>(
			List.of(new Cinema("Orchard Screen 1", "ORA", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineleisure Orchard"),
					new Cinema("Orchard Screen 2", "ORB", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineleisure Orchard"),
					new Cinema("Orchard Screen 3", "ORC", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineleisure Orchard"),
					new Cinema("Orchard Screen 4", "ORD", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineleisure Orchard"),
					new Cinema("Orchard Screen 5", "ORE", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineleisure Orchard"),
					new Cinema("Orchard Screen 6", "ORF", Enum.CinemaType.PLATINUMMOVIESUITES, "Athay Cineleisure Orchard")));

	public static ArrayList<Movie> preMovies = new ArrayList<Movie>(
			List.of(new Movie("Joy",MovieStatus.NOW_SHOWING, "Des","fdg",122,20,Enum.AgeRestriction.PG,true,5,"112233","113233"), 
					new Movie("Sad",MovieStatus.NOW_SHOWING, "Des","fdg",122,20,Enum.AgeRestriction.PG,true,5,"112233","112233"), 
					new Movie("Fear",MovieStatus.END_OF_SHOWING, "Des","fdg",122,20,Enum.AgeRestriction.PG,true,4.5,"112233","113233"),
					new Movie("Four",MovieStatus.COMING_SOON, "Des","fdg",122,40,Enum.AgeRestriction.PG,true,3,"112233","112233"),
					new Movie("NJN",MovieStatus.COMING_SOON, "Des","fdg",122,50,Enum.AgeRestriction.PG,true,3,"112533","112243"),
					new Movie("jdfdn",MovieStatus.NOW_SHOWING, "Des","fdg",122,20,Enum.AgeRestriction.PG,true,4,"112233","115233")));

	public static ArrayList<Cineplex> cineplexes = new ArrayList<Cineplex>(
			List.of(new Cineplex("Athay Cineplex AMK Hub", cinemasAMK, (ArrayList)preMovies.clone()),
					new Cineplex("Athay Cineplex JEM", cinemasJEM, (ArrayList)preMovies.clone()),
					new Cineplex("Athay Cineleisure Orchard", cinemasOrchard, (ArrayList)preMovies.clone())));

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

	public static ArrayList<Admin> admins = new ArrayList<Admin>(
			List.of(new Admin("admin1", "admin1"), new Admin("admin2", "admin2")));

	public static ArrayList<Customer> customers = new ArrayList<Customer>(
			List.of(new Customer("guest", "guest", "123", "123"), new Customer("mary", "mary123", "hh", "123")));

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

	public static double [] priceByAge = new double [] {7.0, 8.5, 4.0}; //student, adult, senior
	public static double [] priceByMovieType = new double [] {0.0, 2.0}; //2d, 3d
	public static double [] priceByCinemaType = new double [] {0.0, 5.0}; //ordinary, premium
	public static double [] priceByDay = new double [] {0.0, 3.0, 5.0}; //weekday, weekend, holiday
	public static ArrayList<Integer> listingCriteria = new ArrayList<Integer>(List.of(3));

	public static void writeMovieDB() throws Exception {
		SerializeMovieDB.writeSerializedObject("Cineplex.dat", Initialise.cineplexes);
		SerializeMovieDB.writeSerializedObject("Payment.dat", Initialise.payments);
		SerializeMovieDB.writeSerializedObject("Review.dat", Initialise.reviews);
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

	public static void preWriteMovieDB() throws Exception{
		SerializeMovieDB.writeSerializedObject("Cineplex.dat", cineplexes);
		SerializeMovieDB.writeSerializedObject("Payment.dat", Initialise.payments);
		SerializeMovieDB.writeSerializedObject("Review.dat", Initialise.reviews);
		SerializeMovieDB.writeSerializedObject("Screening.dat", screenings);
		SerializeMovieDB.writeSerializedObject("Customer.dat", customers);
		SerializeMovieDB.writeSerializedObject("Admin.dat", admins);
		SerializeMovieDB.writeSerializedObject("Movie.dat", preMovies);
		SerializeMovieDB.writeSerializedObject("Top5BySales.dat", Initialise.top5BySales);
		SerializeMovieDB.writeSerializedObject("Top5ByRatings.dat", Initialise.top5ByRatings);
		SerializeMovieDB.writeSerializedObject("ListingCriteria.dat", listingCriteria);
		SerializeMovieDB.writeSerializedObject("Holiday.dat", Initialise.holidays);
		SerializeMovieDB.writeSerializedObject("PriceByAge.dat", priceByAge);
		SerializeMovieDB.writeSerializedObject("PriceByMovieType.dat", Initialise.priceByMovieType);
		SerializeMovieDB.writeSerializedObject("PriceByCinemaType.dat", Initialise.priceByCinemaType);
		SerializeMovieDB.writeSerializedObject("PriceByDay.dat", Initialise.priceByDay);
	}
}
