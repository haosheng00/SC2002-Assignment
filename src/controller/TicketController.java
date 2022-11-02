package controller;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.*;

//@Controller
public class TicketController {

    private static ArrayList<Ticket> tickets;
    private static ArrayList<Screening> screenings;
    private static ArrayList<DateTime> holidays;

    static Scanner sc = new Scanner(System.in);

    public TicketController (ArrayList<Ticket> tickets, ArrayList<Screening> screenings, ArrayList<DateTime> holidays){
        TicketController.tickets = tickets;
        TicketController.screenings = screenings;
        TicketController.holidays = holidays;
    }

    public static void createBooking(){
        
        System.out.println("Total Number of Tickets: ");
        int total = sc.nextInt();
        System.out.println("Number of Child Tickets: ");
        int child = sc.nextInt();
        System.out.println("Number of Adult Tickets: ");
        int adult = sc.nextInt();
        System.out.println("Number of Senior Citizen Tickets: ");
        int senior = sc.nextInt();




    }

    // public static void cancelBooking() {

    // }

    public static int ticketPrice(){


    }

    public Boolean searchTicket(){

    }

    public Boolean updateTicketPrice(){

    }

    public Boolean updateScreeningTime(){

    }

    public Boolean TicketBooked(){

    }

    public void printTicket(){
        
        System.out.println("   ");

    }




}
