package Classes;

import java.util.Scanner; 

public class Ticket{

    private Movie movie;
    private Cineplex cineplex;
    private Cinema cinema;
    private String showTime;
    private Seat seat;
    private double ticketPrice;
    private String showDate;



    public Ticket(Movie movie, Cineplex cineplex, Cinema cinema, String showTime, Seat seat, double ticketPrice, String showDate){
        this.movie = movie;
        this.cineplex = cineplex;
        this.cinema = cinema;
        this.showTime = showTime;
        this.seat = seat;
        this.ticketPrice = ticketPrice;
        this.showDate = showDate;
    } 



}