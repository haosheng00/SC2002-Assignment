package ui;

import java.util.Scanner;
import java.util.Calendar;

import controller.*;
import Classes.*;

public class TicketUI {
    
    private static Scanner sc = new Scanner(System.in);
// TODO: INITIATE ADMINTICKET UI
    public static void initiateTicketUI(){

        int option;

        do{
            System.out.println("========================================");
            System.out.println("Select choice");
            System.out.println("(1) Create Booking");
            System.out.println("(2) Cancel Booking");
            System.out.println("(3) Go Back To Main Menu");
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
                TicketController.createBooking();
                break;

                case 2:
                TicketController.cancelBooking();
                break;

                case 3:
                break;

                default:
                System.out.println("Invalid Input!");

            }
        }
        while (option != 3);
    }
}
