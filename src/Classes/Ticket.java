package Classes;

import java.util.Scanner; 

public class Ticket{

    private Movie movie;
    private Cineplex cineplex;
    private Cinema cinema;
    private String showDateTime;
    private Seat seat;
    private double ticketPrice;
    private String showDate;


    public Ticket(Movie movie, Cineplex cineplex, Cinema cinema, String showDateTime, Seat seat, double ticketPrice){
        this.movie = movie;
        this.cineplex = cineplex;
        this.cinema = cinema;
        this.showDateTime = showDateTime;
        this.seat = seat;
        this.ticketPrice = ticketPrice;
        
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

    public void setShowTime(){
        Ticket.showTime = showTime;
    }

    public void setSeat(){
        return seat;
    }

    public void setTicketPrice(){
        return ticketPrice;
    }

    public  void setShowDate(){
        return showDate;

    public Object getTicket(){
        Ticket ticket = new Ticket(movie, cineplex, cinema, showTime, seat, ticketPrice, showDate);
        return ticket;
    }

    public Movie getMovie(){
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