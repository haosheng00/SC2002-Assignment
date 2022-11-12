package ui;

import java.util.ArrayList;
import java.util.Scanner;

import classes.*;
import controller.*;
import initialiser.Initialise;

/**
 * Contains the initialisation of UI for admin to make changes to price system of tickets
 */
public class TicketUI {
    
    private static Scanner sc = new Scanner(System.in);
    static ArrayList<PublicHoliday> holidays = Initialise.holidays;

    /**
     * Prints the available options to admin to update ticket price/holidays for price adjustment
     * @throws Exception
     */
    public static void initiateAdminTicketUI() throws Exception{

        int option;

        do{
            System.out.println("========================================");
            System.out.println("Select choice:");
            System.out.println("(1) Update Ticket Price");
            System.out.println("(2) Update Holidays");
            System.out.println("(3) Go Back To Main Menu");
            System.out.println("========================================");

            option  = 0;
            do {
                try {
                    option = sc.nextInt();
                    break;
                } catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer: ");
                    sc.next();
                }
            }while(true);

            switch(option){

                case 1:
                TicketUI.updateTicketUI();
                break;

                case 2:
                TicketController.addHolidays(holidays);
                break;

                case 3:
                AdminMenuUI.adminMenuOptions();;

                default:
                System.out.println("Invalid Input!");

            }
        }
        while (option != 2);
    }

    /**
     * Prints the available customisable options for admin to make changes to price system and call the respective function
     * @throws Exception
     */
    public static void updateTicketUI() throws Exception{

        int option = 0;

        do{
            System.out.println("========================================");
            System.out.println("Which Pricing Category would you like to update?:");
            System.out.println("(1) Age Group");
            System.out.println("(2) Cinema Type");
            System.out.println("(3) Day of Week");
            System.out.println("(4) Back");
            System.out.println("========================================");
            try {
                option = sc.nextInt();

                switch (option) {
                    case 1:
                        TicketController.updateTicketPriceByAge();
                        break;
                    case 2:
                        TicketController.updateTicketPriceByCinemaType();
                        break;
                    case 3:
                        TicketController.updateTicketPriceByDayOfWeek();
                        break;
                    case 4:
                        break;
                    default:
                        System.out.println("Invalid Input!");
                        break;
                }
        }
            catch(Exception e){
            System.out.println("Invalid input. Please enter an integer. ");
            sc.next();
        }
    }while (option != 4);
    }

}
