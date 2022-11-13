package classes;

import java.io.Serializable;

/**
 * Represents a review class of movie
 */
public class Review implements Serializable{
    /**
     * Represents the short written review given by customer for the movie
     */
    private String description;

    /**
     * Represents the number rating given by customer for the movie, out of 5
     */
    private double rating;

    /**
     * Represents the username of the customer who gave the review
     */
    private String userName;

    /**
     * Represents the date and time the review was given
     */
    private String dateTime;

    /**
     * Represents the movie the review was given for
     */
    private Movie movie;

    /**
     * Represents a review of movie with the following details:
     * @param description written description of review
     * @param rating number rating of movie given by reviewer
     * @param userName username of customer who gave the review
     * @param dateTime date and time of review creation
     * @param movie name of movie reviewed
     */
    public Review(String description, double rating, String userName, String dateTime, Movie movie) {
        this.description = description;
        this.rating = rating;
        this.userName = userName;
        this.dateTime = dateTime;
        this.movie = movie;
    }

    /**
     * Returns the written review of the movie of the specified review
     * @return written review 
     */
    public String getDescription() { return description; }

    /**
     * Sets/Updates the written review of the movie of the specified review
     * @param description written review 
     */
    public void setDescription(String description) { this.description = description;}

    /**
     * Returns the number rating of movie given by reviewer
     * @return number rating out of 5
     */
    public double getRating() { return rating; }

    /**
     * Sets/Updates the number rating of movie given by reviewer
     * @param rating number rating out of 5
     */
    public void setRating(double rating) { this.rating = rating;}

    /**
     * Returns the username of customer who gave the review
     * @return username of reviewer
     */
    public String getUserName() { return userName; }

    /**
     * Sets/Updates the username of customer who gave the review
     * @param userName username of reviewer
     */
    public void setUserName(String userName) { this.userName = userName;}

    /**
     * Returns the date and time of review creation
     * @return date and time of review creation
     */
    public String getDateTime() { return dateTime; }

    /**
     * Sets/Updates the date and time of review creation
     * @param dateTime date and time of review creation
     */
    public void setDateTime(String dateTime) { this.dateTime = dateTime;}

    /**
     * Returns the movie class of the movie being reviewed
     * @return reviewed movie class
     */
    public Movie getMovie() { return movie; }

    /**
     * Sets/Updates the movie class of the movie being reviewed
     * @param movie reviewed movie class
     */
    public void setMovie(Movie movie) { this.movie = movie;}
}
