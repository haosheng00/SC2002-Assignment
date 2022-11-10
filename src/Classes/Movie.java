package classes;

import java.io.Serializable;
import java.util.ArrayList;

import classes.Enum.MovieGenre;

/**
 * Represents a movie class with the movie details
 */
public class Movie implements Serializable{

    /**
     * Represents the screening status of the movie:<p>
     * Coming soon, Preview, Now showing or End of showing
     */
    private Enum.MovieStatus movieStatus;
    /**
     * Represents the title/name of the movie
     */
    private String movieTitle;
    /**
     * Represents the list of genres the movie is in, can include:<p>
     * Action, Horror, Thriller, Adventure, Comedy, Anime, Romance, Drama, True Story and Others
     */
    private ArrayList<Enum.MovieGenre> movieGenres;
    /**
     * Represents a short synopsis/description of the movie
     */
    private String synopsis;
    /**
     * Represents the main director of the movie
     */
    private String director;
    /**
     * Represents the list of casts featured in the movie
     */
    private ArrayList<String> casts;
    /**
     * Represents the duration of the movie in minutes
     */
    private int movieDuration;
    /**
     * Represents the total sales amount of the movie from our cinema (can be across the cineplexes)
     */
    private double sales;
    /**
     * Represents the movie's age rating/restriction:<p>
     * G, PG, PG13, NC16, M18 or R21
     */
    private Enum.AgeRestriction ageRestriction;
    /**
     * Represents whether the movie is 3D or not, <p>
     * true for 3D, false for 2D
     */
    private boolean is3D;
    /**
     * Represents the overall rating of the movie based on the individual rating given in reviews of customers
     */
    private double overallRating;
    /**
     * Represents the list of rating and written review from customers on the movie
     */
    private ArrayList<Review> reviews;
    /**
     * Represents the end of screening date of the movie in our cinema in the format YYYYMMDD
     */
    private String expiryDate;
    /**
     * Represents the start of screening date of the movie in our cinema in the format YYYYMMDD
     */
    private String startDate;


    /** Represents the movie with the specific movie title initialised with an empty review list and 0 sales amount
     * @param movieTitle title of the movie
     */
    public Movie(String movieTitle){
        this.movieTitle = movieTitle;
        this.reviews = new ArrayList<>();
        this.sales = 0;
    }

    /**
     * Set the status of the movie from the enumeration options
     * @param movieStatus
     */
    public void setMovieStatus(Enum.MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }

    /**
     * Set the title of the movie to the specified movieTitle
     * @param movieTitle
     */
    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    /**
     * Set the movie genres list
     * @param movieGenres
     */
    public void setMovieGenres(ArrayList<MovieGenre> movieGenres) {
        this.movieGenres = movieGenres;
    }

    /**
     * Set the synopsis of the movie
     * @param synopsis
     */
    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    /**
     * Set the main director of the movie
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * Set the list of casts featured in the movie
     * @param casts
     */
    public void setCasts(ArrayList<String> casts) {
        this.casts = casts;
    }

    /**
     * Set the duration of the movie in minutes
     * @param movieDuration
     */
    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    /**
     * Set the movie age rating/restriction from the enumeration options
     * @param ageRestriction
     */
    public void setAgeRestriction(Enum.AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    /**
     * Set whether the movie is 3D or not (i.e. 3D or 2D)
     * @param is3D
     */
    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    /**
     * Set the overall rating of the movie
     * @param overallRating
     */
    public void setOverallRating(double overallRating) {
        this.overallRating = overallRating;
    }

    /**
     * Set the sales amount (total cost of tickets sold) of the movie
     * @param sales
     */
    public void setSales(double sales) {
        this.sales = sales;
    }

    /**
     * Set the end of screening date of the movie
     * @param expiryDate
     */
    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    /**
     * Set the start of screening date of the movie
     * @param startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    /**
     * Returns the title of the movie
     * @return title of the movie
     */
    public String getMovieTitle() {
        return movieTitle;
    }

    /**
     * Returns the status of the movie from the following options:
     * Coming soon, Preview, Now showing or End of showing
     * @return screening status of the movie
     */
    public Enum.MovieStatus getMovieStatus() {
        return movieStatus;
    }

    /**
     * Returns the movie age rating/restriction
     * @return movie age rating/restrictions from the following options:
     * G, PG, PG13, NC16, M18 or R21
     */
    public Enum.AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    /**
     * Returns the array list of genres of the movie
     * @return list of movie genres from the following options: 
     * Action, Horror, Thriller, Adventure, Comedy, Anime, Romance, Drama, True Story and Others
     */
    public ArrayList<MovieGenre> getMovieGenres() {
        return movieGenres;
    }

    /**
     * Returns the movie synopsis
     * @return short description of the movie
     */
    public String getSynopsis(){
        return synopsis;
    }

    /**
     * Returns the main director of the movie
     * @return name of main director of the movie
     */
    public String getDirector(){
        return director;
    }

    /**
     * Returns the list of casts featured in the movie
     * @return list of casts
     */
    public ArrayList<String> getCasts(){
        return casts;
    }

    /**
     * Returns the movie duration in minutes
     * @return duration of movie (in minutes)
     */
    public int getMovieDuration(){
        return movieDuration;
    }

    /**
     * Returns the total sales amount of the movie
     * @return sales amount
     */
    public double getSales(){
        return sales;
    }

    /**
     * Returns if the movie is 3D or 2D
     * @return true if 3D, false if 2D
     */
    public boolean getIs3D(){
        return is3D;
    }

    /**
     * Returns the overall rating of the movie
     * @return overall rating
     */
    public double getOverallRating(){
        return overallRating;
    }

    /**
     * Returns the list of reviews (containing rating and written review)
     * @return reviews list
     */
    public ArrayList<Review> getReviews(){
        return reviews;
    }

    /**
     * Returns the end of screening date of the movie in the format YYYYMMDD
     * @return end of screening date
     */
    public String getExpiryDate() {
        return expiryDate;
    }

    /**
     * Returns the start of screening date of the movie in the format YYYYMMDD
     * @return start of screening date
     */
    public String getStartDate() {
        return startDate;
    }

}