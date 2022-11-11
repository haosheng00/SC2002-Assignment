package controller;

import java.util.*;

public class ListingController {

    private static int listingCriteria;

    private static void setListingCriteria(int listingCriteria) {
        ListingController.listingCriteria = listingCriteria;
    }

    public static int getListingCriteria() {
        return 3;
        //return listingCriteria;
    }

    public static void initiateListingUI() {
        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("Please select listing control");
        System.out.println("(1) - Sales");
        System.out.println("(2) - Rating");
        System.out.println("(3) - Sales & Rating");
        System.out.println("========================================");
        int listingChoice = sc.nextInt();
        listingCriteria = listingChoice;
        ListingController.setListingCriteria(listingChoice);
    }
}    