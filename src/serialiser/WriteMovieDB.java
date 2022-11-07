package serialiser;

import initialiser.*;

public class WriteMovieDB {
	public static void writeMovieDB() throws Exception{
			SerializeMovieDB.writeSerializedObject("Cineplex.dat", Initialise.cineplexes);
			SerializeMovieDB.writeSerializedObject("Payment.dat", Initialise.payments);
			SerializeMovieDB.writeSerializedObject("Review.dat", Initialise.reviews);
			SerializeMovieDB.writeSerializedObject("Screening.dat", Initialise.screenings);
            //TODO: Combine Customer and Admin in Initialise
			SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);
			SerializeMovieDB.writeSerializedObject("Admin.dat", Initialise.admins);
			SerializeMovieDB.writeSerializedObject("Movie.dat", Initialise.movies);
			SerializeMovieDB.writeSerializedObject("Screening.dat", Initialise.screenings);
			SerializeMovieDB.writeSerializedObject("Top5BySales.dat", Initialise.top5BySales);
			SerializeMovieDB.writeSerializedObject("Top5ByRatings.dat", Initialise.top5ByRatings);
			SerializeMovieDB.writeSerializedObject("Holiday.dat", Initialise.holidays);

	}
}