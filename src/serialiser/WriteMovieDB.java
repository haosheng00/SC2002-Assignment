package Serialiser;

import Initialiser.*;

public class WriteMovieDB {
	public static void writeMovieDB() throws Exception{
			SerializeMovieDB.writeSerializedObject("Cineplex.dat", Initialise.cineplexes);
			SerializeMovieDB.writeSerializedObject("Payment.dat", Initialise.payments);
			SerializeMovieDB.writeSerializedObject("Review.dat", Initialise.reviews);
            //TODO: Combine Customer and Admin in Initialise
			SerializeMovieDB.writeSerializedObject("Account.dat", Initialise.customers);
	}
}
