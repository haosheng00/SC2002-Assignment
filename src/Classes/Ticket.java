package classes;

public class Ticket{

    private Movie movie;
    private Cineplex cineplex;
    private Cinema cinema;
    private String showDate;
    private String showTime;
    private Seat seat;
    private double ticketPrice;


    public Ticket(Movie movie, Cineplex cineplex, Cinema cinema, String showDate, String showTime, Seat seat, double ticketPrice){
        this.movie = movie;
        this.cineplex = cineplex;
        this.cinema = cinema;
        this.showDate = showDate;
        this.showTime = showTime;
        this.seat = seat;
        this.ticketPrice = ticketPrice;
        
    } 

    public void setMovie(Movie movie){
        this.movie = movie;
    }

    public void setCineplex(Cineplex cineplex){
        this.cineplex = cineplex;
    }

    public void setCinema(Cinema cinema){
        this.cinema = cinema;
    }

    public void setShowDate(String showDate){
        this.showDate = showDate;
    }

    public void setShowTime(String showTime){
        this.showTime = showTime;
    }

    public void setSeat(Seat seat){
        this.seat = seat;
    }

    public void setTicketPrice(double ticketPrice){
        this.ticketPrice = ticketPrice;
    }

    public Object getTicket(){
        Ticket ticket = new Ticket(movie, cineplex, cinema, showDate, showTime, seat, ticketPrice);
        return ticket;
    }

    public Movie getMovie(){
        return movie;
    }

    public Cineplex getCineplex(){
        return cineplex;
    }

    public Cinema getCinema(){
        return cinema;
    }

    public String getShowDate(){
        return showDate;
    }

    public String getShowTime(){
        return showTime;
    }

    public Seat getSeat(){
        return seat;
    }

    public double getTicketPrice(){
        return ticketPrice;
    }
}