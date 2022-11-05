package serialiser;

import java.util.ArrayList;
import java.util.List;

import Classes.*;
import Initialiser.*;

public class ReadMovieDB {
	public static void readMovieDB() throws Exception{
		List list;
		// read from serialized file the list of professors
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
			list = (ArrayList)SerializeMovieDB.readSerializedObject("Account.dat");
			for (int i = 0 ; i < list.size() ; i++) {
				Customer customer = (Customer)list.get(i);
				Initialise.customers.add(customer);
			}
	}
}
