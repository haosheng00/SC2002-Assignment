package classes;

import java.io.Serializable;

/**
 * Represents a ticket of the movie to be purchased/purchased
 */
public class Ticket implements Serializable{

    private Movie movie;
    private Cineplex cineplex;
    private Cinema cinema;
    private String showDate;
    private String showTime;
    private Seat seat;
    private double ticketPrice;


    /**
     * Represents a purchased ticket movie with its details
     * @param movie movie object the ticket was purchased for
     * @param cineplex cineplex the movie will be screening at for the particular ticket
     * @param cinema cinema number the movie will be screening in for the ticket purchased
     * @param showDate show date of the movie the ticket was purchased for
     * @param showTime show time of the movie the ticket was purchased for
     * @param seat seat the ticket was purchased for
     * @param ticketPrice cost of the ticket paid
     */
    public Ticket(Movie movie, Cineplex cineplex, Cinema cinema, String showDate, String showTime, Seat seat, double ticketPrice){
        this.movie = movie;
        this.cineplex = cineplex;
        this.cinema = cinema;
        this.showDate = showDate;
        this.showTime = showTime;
        this.seat = seat;
        this.ticketPrice = ticketPrice;
        
    } 

    /**
     * Sets/Updates the movie object the ticket was purchased for
     * @param movie movie object the ticket was purchased for
     */
    public void setMovie(Movie movie){
        this.movie = movie;
    }

    /**
     * Sets/Updates the cineplex the movie will be screening at for the particular ticket
     * @param cineplex cineplex of screening
     */
    public void setCineplex(Cineplex cineplex){
        this.cineplex = cineplex;
    }

    /**
     * Sets/Updates the cinema number the movie will be screening in for the ticket purchased
     * @param cinema cinema number of screening
     */
    public void setCinema(Cinema cinema){
        this.cinema = cinema;
    }

    /**
     * Sets/Updates the show date of the movie the ticket was purchased for
     * @param showDate show date of the movie
     */
    public void setShowDate(String showDate){
        this.showDate = showDate;
    }

    /**
     * Sets/Updates show time of the movie the ticket was purchased for
     * @param showTime show time of the movie
     */
    public void setShowTime(String showTime){
        this.showTime = showTime;
    }

    /**
     * Sets/Updates the seat the ticket was purchased for
     * @param seat seat of ticket
     */
    public void setSeat(Seat seat){
        this.seat = seat;
    }

    /**
     * Sets/Updates the cost of the ticket
     * @param ticketPrice cost of ticket
     */
    public void setTicketPrice(double ticketPrice){
        this.ticketPrice = ticketPrice;
    }

    /**
     * Returns the ticket object
     * @return ticket object
     */
    public Object getTicket(){
        Ticket ticket = new Ticket(movie, cineplex, cinema, showDate, showTime, seat, ticketPrice);
        return ticket;
    }

    /**
     * Returns the movie object the ticket was purchased for
     * @return movie object
     */
    public Movie getMovie(){
        return movie;
    }

    /**
     * Returns the cineplex the ticket was purchased for
     * @return cineplex class
     */
    public Cineplex getCineplex(){
        return cineplex;
    }

    /**
     * Returns the cinema the ticket was purchased for
     * @return cinema object
     */
    public Cinema getCinema(){
        return cinema;
    }

    /**
     * Returns the show date the ticket was purchased for
     * @return show date
     */
    public String getShowDate(){
        return showDate;
    }

    /**
     * Returns the show time the ticket was purchased for
     * @return show time
     */
    public String getShowTime(){
        return showTime;
    }

    /**
     * Returns the seat of the ticket
     * @return seat of ticket
     */
    public Seat getSeat(){
        return seat;
    }

    /**
     * Returns the cost of ticket
     * @return ticket cost
     */
    public double getTicketPrice(){
        return ticketPrice;
    }
}