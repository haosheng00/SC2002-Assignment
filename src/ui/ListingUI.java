package ui;

import java.io.IOException;
import java.util.*;

import initialiser.Initialise;
import serialiser.SerializeMovieDB;

/**
 * Contains the initiation method for listing control UI
 */
public class ListingUI {
/**
 * Represents the criteria for filtering top 5 movies 
 */
    private static int criteria;
    /**
     * Prints the movie sorting controls available to admin
     * @throws IOException
     */
    public static void initiateListingUI() throws IOException {
        
        Scanner sc = new Scanner(System.in);
        criteria = 0;
        
        System.out.println("========================================");
        System.out.println("Please select listing control");
        System.out.println("(1) Rating");
        System.out.println("(2) Sales");
        System.out.println("(3) Rating & Sales");
        System.out.println("(4) Back");
        System.out.println("========================================");

        do {
            try {
                ArrayList <Integer> listingCriteria = Initialise.listingCriteria;
                criteria = sc.nextInt();
                if (criteria == 4){
                    return;
                }
                else if (criteria <= 0 || criteria >= 5) {
                    System.out.println("Invalid option. Please enter an integer (1-4): ");
                }
                else {
                    listingCriteria.set(0, criteria);
                    SerializeMovieDB.writeSerializedObject("ListingCriteria.dat", Initialise.listingCriteria);
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
        } while(true);

        System.out.println("Listing controls have been updated.");
    }
}    