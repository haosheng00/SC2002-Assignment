package controller;

import java.util.*;

public class ListingController {

    private static int listingCriteria = 3;

    private static void setListingCriteria(int listingCriteria) {
        ListingController.listingCriteria = listingCriteria;
    }

    public static int getListingCriteria() {
        return listingCriteria;
    }

    public static void initiateListingUI() {

        Scanner sc = new Scanner(System.in);
        System.out.println("========================================");
        System.out.println("Please select listing control");
        System.out.println("(1) - Sales");
        System.out.println("(2) - Rating");
        System.out.println("(3) - Sales & Rating");
        int listingChoice = sc.nextInt();

        ListingController.setListingCriteria(listingChoice);
        sc.close();
    }
}    