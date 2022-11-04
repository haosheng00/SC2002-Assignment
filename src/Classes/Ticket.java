package Classes;

import java.util.Scanner; 

public class Ticket{

    private static Movie movie;
    private static Cineplex cineplex;
    private static Cinema cinema;
    private static String showTime;
    private static Seat seat;
    private static double ticketPrice;
    private static String showDate;


    public Ticket(Movie movie, Cineplex cineplex, Cinema cinema, String showTime, Seat seat, double ticketPrice, String showDate){
        // this.movie = movie;
        // this.cineplex = cineplex;
        // this.cinema = cinema;
        // this.showTime = showTime;
        // this.seat = seat;
        // this.ticketPrice = ticketPrice;
        // this.showDate = showDate;
    } 

    public void setTicket(Movie movie, Cineplex cineplex, Cinema cinema, String showTime, Seat seat, double ticketPrice, String showDate){
        Ticket.movie = movie;
        Ticket.cineplex = cineplex;
        Ticket.cinema = cinema;
        Ticket.showTime = showTime;
        Ticket.seat = seat;
        Ticket.ticketPrice = ticketPrice;
        Ticket.showDate = showDate;
    } 

    public void setMovie(Movie movie){
        Ticket.movie = movie;
    }

    public void setCineplex(Cineplex cineplex){
        Ticket.cineplex = cineplex;
    }

    public void setCinema(Cinema cinema){
        Ticket.cinema = cinema;
    }

    public static void setShowTime(){
        return showTime;
    }

    public static void setSeat(){
        return seat;
    }

    public static void setTicketPrice(){
        return ticketPrice;
    }

    public static void setShowDate(){
        return showDate;

    public Object getTicket(){
        Ticket ticket = new Ticket(movie, cineplex, cinema, showTime, seat, ticketPrice, showDate);
        return ticket;
    }

    public static Movie getMovie(){
        return movie;
    }

    public static Cineplex getCineplex(){
        return cineplex;
    }

    public static Cinema getCinema(){
        return cinema;
    }

    public static String getShowTime(){
        return showTime;
    }

    public static Seat getSeat(){
        return seat;
    }

    public static double getTicketPrice(){
        return ticketPrice;
    }

    public static String getShowDate(){
        return showDate;
    }

}