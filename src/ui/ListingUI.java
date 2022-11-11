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
     * Prints the movie sorting controls available to admin
     * @throws IOException
     */
    public static void initiateListingUI() throws IOException {
        
        Scanner sc = new Scanner(System.in);
        
        System.out.println("========================================");
        System.out.println("Please select listing control");
        System.out.println("(1) - Sales");
        System.out.println("(2) - Rating");
        System.out.println("(3) - Sales & Rating");
        System.out.println("========================================");

        do {
            try {
                ArrayList <Integer> listingCriteria = Initialise.listingCriteria;
                int choice = sc.nextInt();
                if (choice <= 0 || choice >= 4) {
                    System.out.println("Invalid option. Please enter an integer (1-3): ");
                }
                else {
                    listingCriteria.set(0, choice);
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