package Classes;

import java.util.TimeZone;

public class Screening {
    private Cinema cinema;
    private TimeZone showTime;
    private Movie movie;
    private Seat[] seats;

    public Screening(Cinema cinema, TimeZone showTime, Movie movie){
        this.cinema = cinema;
        this.showTime = showTime;
        this.movie = movie;
        initiateSeats();
    }
    public void initiateSeats(){
        if (cinema.getCinemaType() == CinemaType.ORDINARY){
            this.seats = new Seat[Initialise.Ordinary_Capacity];
            for (int i = 0; i < seats.length;i++){
                seats[i] = new Seat();
            }
        }
        else if (cinema.getCinemaType() == CinemaType.PLATINUMMOVIESUITES){
            this.seats = new Seat[Initialise.Plat_Capacity];
            for (int i = 0; i < seats.length;i++){
                seats[i] = new Seat();
            }
        }
    }

    public Cinema getCinema() {
        return cinema;
    }
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    public TimeZone getShowTime() {
        return showTime;
    }

    public void setShowTime(TimeZone showTime) {
        this.showTime = showTime;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public Seat[] getSeats(){
        return seats;
    }
    public void setSeats(Seat[] seats){
        this.seats = seats;
    }
    public Seat getSeat(int i){
        return this.seats[i];
    }
    public void setSeat(Seat seat, int i){
        this.seats[i] = seat;
    }
}
