package ui;

import java.util.Scanner;

import controller.*;
import Classes.*;

public class TicketUI {
    
    private static Scanner sc = new Scanner(System.in);

    public static void initiateAdminTicketUI(){

        int option;

        do{
            System.out.println("========================================");
            System.out.println("Select choice");
            System.out.println("(1) Update Ticket Price");
            System.out.println("(2) Update Holidays");
            System.out.println("(2) Go Back To Main Menu");
            System.out.println("========================================");

            option  = 0;
            try{
                option = sc.nextInt();   
            }
            catch (Exception e){

            }
            sc.nextLine();

            switch(option){

                case 1:
                TicketController.updateTicketPrice();
                break;

                case 2:
                TicketController.updateHolidays();
                break;

                case 3:
                break;

                default:
                System.out.println("Invalid Input!");

            }
        }
        while (option != 2);
    }




    // public static void initiateTicketUI(){

    //     int option;

    //     do{
    //         System.out.println("========================================");
    //         System.out.println("Select choice");
    //         System.out.println("(1) Create Booking");
    //         System.out.println("(2) Go Back To Main Menu");
    //         System.out.println("========================================");

    //         option  = 0;
    //         try{
    //             option = sc.nextInt();
    //         }
    //         catch (Exception e){

    //         }
    //         sc.nextLine();

    //         switch(option){

    //             case 1:
    //             TicketController.createBooking();
    //             break;

    //             case 2:
    //             break;

    //             default:
    //             System.out.println("Invalid Input!");

    //         }
    //     }
    //     while (option != 2);
    // }
}
