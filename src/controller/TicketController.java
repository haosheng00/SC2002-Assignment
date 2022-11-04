package controller;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.*;

public class TicketController {

    private static ArrayList<Ticket> tickets;
    private static ArrayList<Screening> screenings;
    private static ArrayList<DateTime> holidays;
    private static ArrayList<Cineplex> cineplexes;

    static Scanner sc = new Scanner(System.in);

    public TicketController (ArrayList<Ticket> tickets, ArrayList<Screening> screenings, ArrayList<DateTime> holidays){
        TicketController.tickets = tickets;
        TicketController.screenings = screenings;
        TicketController.holidays = holidays;
    }


    public static void createBooking(){

        int i = 0;

        System.out.println("Select Cineplex: ");
        for (i=0; i<cineplexes.size(); i++){
            System.out.println((i+1) + ": " + cineplexes.get(i).getCineplexName());
        }

        int selection1 = sc.nextInt();
        while (selection1 < 0 && selection1 > i ){
            System.out.println("Inavlid Input! Try Again!");
            selection1 = sc.nextInt();
        }

        System.out.println("Select Movie: ");
        for (i=0; i<screenings.size(); i++){
            System.out.println((i+1) + ": " + screenings.get(i).getCinema());
        }

        int selection2 = sc.nextInt();
        while (selection2 < 0 && selection2 > i ){
            System.out.println("Inavlid Input! Try Again!");
            selection2 = sc.nextInt();
        }
        
        // INCLUDE DATE TOO??
        System.out.println("Select Date and Time: ");
        for (i=0; i<screenings.size(); i++){
            System.out.println((i+1) + ": " + screenings.get(i).getShowTime());
        }

        int selection3 = sc.nextInt();
        while (selection3 < 0 && selection3 > i ){
            System.out.println("Inavlid Input! Try Again!");
            selection3 = sc.nextInt();
        }
        
        System.out.println("Number of Child Tickets: ");
        int child = sc.nextInt();
        Seat seat = new Seat();
        Seat.printSeats(seat);
       
        String childseat = sc.next();



        System.out.println("Number of Adult Tickets: ");
        int adult = sc.nextInt();
        System.out.println("Number of Senior Citizen Tickets: ");
        int senior = sc.nextInt();




    }

    // public static void cancelBooking() {

    // }


    public static int ticketPrice(int child, int adult, int senior){
        

    }

    public Boolean searchTicket(ArrayList<Ticket> tickets){
        
        for(int i=0; i<tickets.size(); i++){
            if(tickets.contains(tickets.get(i).getTicket())){
                return true;
            }
        }
        return false;
    }


    public Boolean updateTicketPrice(){

    }


    public Boolean updateScreeningTime(){

    }


    public Boolean updateTicketBooked(){
        if 
    }


    public void printTicket(){
        
        System.out.println("Your ticket details are as follows: ");
        System.out.println("Movie: " + Ticket.getMovie());
        System.out.println("Cineplex: " + Ticket.getCineplex());
        System.out.println("Cinema: " + Ticket.getCinema());
        System.out.println("Show Time: " + Ticket.getShowTime());
        System.out.println("Show Date: " + Ticket.getShowDate());
        System.out.println("Seat: " + Ticket.getSeat());
        System.out.println("Price: " + Ticket.getPrice());

    }

}
