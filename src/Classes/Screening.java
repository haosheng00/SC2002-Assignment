package classes;

import initialiser.Initialise;

public class Screening {
    private Cinema cinema;
    private String showDate;
    private String showTime;
    private Movie movie;
    private Seat[] seats;

    public Screening(Cinema cinema, String showDate, String showTime, Movie movie){
        this.cinema = cinema;
        this.showDate = showDate;
        this.showTime = showTime;
        this.movie = movie;
        initiateSeats();
    }
    
    public void initiateSeats(){
        if (cinema.getCinemaType() == Enum.CinemaType.ORDINARY){
            this.seats = new Seat[Initialise.Ordinary_Capacity];
            for (int i = 0; i < seats.length;i++){
                seats[i] = new Seat();
            }
        }
        else if (cinema.getCinemaType() == Enum.CinemaType.PLATINUMMOVIESUITES){
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

    public String getShowTime() {
        return showTime;
    }
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    public String getShowDate() {
        return showDate;
    }

    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

}
