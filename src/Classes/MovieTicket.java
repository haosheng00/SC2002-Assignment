package Classes;
import java.util.Scanner; 

public class MovieTicket{

    private String movieTitle;
    private Cineplex cineplex;
    private CinemaType cinemaType;
    private String showTime;
    private Seat seat;
    private double price;


    public MovieTicket(String movieTitle, Cineplex cineplex, CinemaType cinemaType, String showTime, Seat seat, double price){
        this.movieTitle = movieTitle;
        this.cineplex = cineplex;
        this.cinemaType = cinemaType;
        this.showTime = showTime;
        this.seat = seat;
        this.price = price;
    } 
 
    //Movie m = new Movie();
    

    //TODO: use a MovieTicket printer instead of get func

    public String getMovieTicket(){
        return m.getMovieTitle() + cineplex.getCineplex() + cinemaType.getCinemaType() + showTime.getShowTime() + seat.getSeatId() + price.getPrice();
    }
}