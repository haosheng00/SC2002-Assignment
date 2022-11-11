package classes;

import java.io.Serializable;

import initialiser.Initialise;

/**
 * Represents a Screening class with screening details
 */
public class Screening implements Serializable{
    /**
     * Represents the Cinema object which the screening is showing in
     */
    private Cinema cinema;
    /**
     * Represents the show date which the screening is shown, in the form of:
     * YYYYMMDD
     */
    private String showDate;
    /**
     * Represents the show time which the screening is shown, in the form of:
     * HHMMSS
     */
    private String showTime;
    /**
     * Represents the Movie object which the screening shows
     */
    private Movie movie;
    /**
     * Represents the list of seats in that respective screening
     */
    private Seat[] seats;

    /**
     * Represents the screening initialised with the specific Cinema object, Movie object and show date and time
     * array of seats is automatically created
     * @param cinema
     * @param showDate
     * @param showTime
     * @param movie
     */
    public Screening(Cinema cinema, String showDate, String showTime, Movie movie){
        this.cinema = cinema;
        this.showDate = showDate;
        this.showTime = showTime;
        this.movie = movie;
        initiateSeats();
    }

    /**
     * Creates an array of seats by finding the cinema type of the Cinema object where the screening is shown
     */
    private void initiateSeats(){
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

    /**
     * Returns the Cinema object where the screening is shown
     * @return Cinema object
     */
    public Cinema getCinema() {
        return cinema;
    }

    /**
     * Sets the cinema where the screening is shown to a specific Cinema object
     * @param cinema
     */
    public void setCinema(Cinema cinema) {
        this.cinema = cinema;
    }

    /**
     * Returns the Movie object which the screening shows
     * @return Movie object
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Sets the movie which the screening shows to a specific Movie object
     * @param movie
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    /**
     * Returns the array of seats which the screening has
     * @return array of seats
     */
    public Seat[] getSeats(){
        return seats;
    }

    /**
     * Sets the array of seats which the screening has to a specific array of seats
     * @param seats
     */
    public void setSeats(Seat[] seats){
        this.seats = seats;
    }

    /**
     * Returns the specific seat in the array of seats which the screening has
     * @param i, index of seat
     * @return the specific seat of given index
     */
    public Seat getSeat(int i){
        return this.seats[i];
    }

    /**
     * Returns the show time of the screening
     * @return show time, in HHMMSS format
     */
    public String getShowTime() {
        return showTime;
    }

    /**
     * Sets the show time of the screening
     * @param showTime, in HHMMSS format
     */
    public void setShowTime(String showTime) {
        this.showTime = showTime;
    }

    /**
     * Returns the show date of the screening
     * @return show date, in YYYYMMDD format
     */
    public String getShowDate() {
        return showDate;
    }

    /**
     * Sets the show date of the screening
     * @param showDate, in YYYYMMDD format
     */
    public void setShowDate(String showDate) {
        this.showDate = showDate;
    }

}
