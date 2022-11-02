package controller;

import java.util.ArrayList;
import java.util.Scanner;

import Classes.Ticket;
import Classes.Screening;
import Classes.DateTime;

//@Controller
public class TicketController {

    private static ArrayList<Ticket> tickets;
    private static ArrayList<Screening> screenings;
    private static ArrayList<DateTime> holidays;

    TicketController(ArrayList<Ticket> tickets, ArrayList<Screening> screenings, ArrayList<DateTime> holidays){
        TicketController.tickets = tickets;
        TicketController.screenings = screenings;
        TicketController.holidays = holidays;
    }

    public void createBookingUI(){

    }

    public Boolean bookTickets(){
        
    }

    public Boolean cancelTickets(){

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

    public void printScreenings(){

    }
}
