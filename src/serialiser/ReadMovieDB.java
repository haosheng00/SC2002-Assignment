package serialiser;

import initialiser.Initialise;

import java.util.ArrayList;
import java.util.List;

import classes.*;

public class ReadMovieDB {
	public static void readMovieDB() throws Exception{
		List list;
		// read from serialized file the list of professors

			//listingCriteria = SerializeMovieDB.readSerializedObject(".dat");

			list = (ArrayList)SerializeMovieDB.readSerializedObject("Cineplex.dat");
			for (int i = 0 ; i < list.size() ; i++) {
				Cineplex cineplex = (Cineplex)list.get(i);
				Initialise.cineplexes.add(cineplex);
			}
			
			list = (ArrayList)SerializeMovieDB.readSerializedObject("Payment.dat");
			for (int i = 0 ; i < list.size() ; i++) {
				Payment payment = (Payment)list.get(i);
				Initialise.payments.add(payment);
			}
			
			list = (ArrayList)SerializeMovieDB.readSerializedObject("Review.dat");
			for (int i = 0 ; i < list.size() ; i++) {
				Review review = (Review)list.get(i);
				Initialise.reviews.add(review);
			}
			
			//TODO: customer -> account
			list = (ArrayList)SerializeMovieDB.readSerializedObject("Customer.dat");
			for (int i = 0 ; i < list.size() ; i++) {
				Customer customer = (Customer)list.get(i);
				Initialise.customers.add(customer);
			}

			list = (ArrayList)SerializeMovieDB.readSerializedObject("Admin.dat");
			for (int i = 0 ; i < list.size() ; i++) {
				Admin admin = (Admin) list.get(i);
				Initialise.admins.add(admin);
			}

			list = (ArrayList)SerializeMovieDB.readSerializedObject("Movie.dat");
			for (int i = 0 ; i < list.size() ; i++) {
				Movie movie = (Movie) list.get(i);
				Initialise.movies.add(movie);
			}

			list = (ArrayList)SerializeMovieDB.readSerializedObject("Screening.dat");
			for (int i = 0 ; i < list.size() ; i++) {
				Screening screening = (Screening) list.get(i);
				Initialise.screenings.add(screening);
			}

			list = (ArrayList)SerializeMovieDB.readSerializedObject("Top5BySales.dat");
			for (int i = 0 ; i < list.size() ; i++) {
				Movie movie = (Movie) list.get(i);
				Initialise.top5BySales.add(movie);
			}

			list = (ArrayList)SerializeMovieDB.readSerializedObject("Top5ByRatings.dat");
			for (int i = 0 ; i < list.size() ; i++) {
				Movie movie = (Movie) list.get(i);
				Initialise.top5ByRatings.add(movie);
			}

			list = (ArrayList)SerializeMovieDB.readSerializedObject("Holiday.dat");
			for (int i = 0 ; i < list.size() ; i++) {
				PublicHoliday publicHoliday = (PublicHoliday) list.get(i);
				Initialise.holidays.add(publicHoliday);
			}

	}
}
