package serialiser;

import initialiser.*;

public class WriteMovieDB {
	public static void writeMovieDB() throws Exception{
			SerializeMovieDB.writeSerializedObject("Cineplex.dat", Initialise.cineplexes);
			SerializeMovieDB.writeSerializedObject("Payment.dat", Initialise.payments);
			SerializeMovieDB.writeSerializedObject("Review.dat", Initialise.reviews);
			SerializeMovieDB.writeSerializedObject("Screening.dat", Initialise.screenings);
            //TODO: Combine Customer and Admin in Initialise
			SerializeMovieDB.writeSerializedObject("Account.dat", Initialise.customers);

	}
}
