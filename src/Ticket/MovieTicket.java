import java.util.Scanner;

public class MovieTicket{


    private MovieTitle movietitle;
    private Cineplex cineplex;
    private CinemaType cinematype;
    private ShowTime showtime;
    private Seat seat;
    private double price;


    public MovieTicket(MovieTitle movietitle, Cineplex cineplex, CinemaType cinematype, ShowTime showtime, Seat seat, double price){
        this.movietitle = movietitle;
        this.cineplex = cineplex;
        this.cinematype = cinematype;
        this.showtime = showtime;
        this.seat = seat;
        this.price = price;
    }

    public String getMovieTicket(){
        return movietitle.getMovieTitle() + cineplex.getCineplex() + cinematype.getCinemaType() + showtime.getShowTime() + seat.getSeat() + price.getPrice();
    }
}