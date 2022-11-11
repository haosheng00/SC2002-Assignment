package ui;

import java.io.IOException;
import java.util.*;

import initialiser.Initialise;
import serialiser.SerializeMovieDB;

public class ListingUI {

    public static void initiateListingUI() throws IOException {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("Please select listing control");
        System.out.println("(1) - Sales");
        System.out.println("(2) - Rating");
        System.out.println("(3) - Sales & Rating");
        System.out.println("========================================");
        ArrayList <Integer> listingCriteria = Initialise.listingCriteria;
        listingCriteria.set(0, sc.nextInt());
        SerializeMovieDB.writeSerializedObject("ListingCriteria.dat", Initialise.listingCriteria);
    }
}    