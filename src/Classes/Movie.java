package classes;

import java.io.Serializable;
import java.util.ArrayList;

import classes.Enum.MovieGenre;
public class Movie implements Serializable{

    // TODO: Add javadocs

    private Enum.MovieStatus movieStatus;
    private String movieTitle;
    private ArrayList<Enum.MovieGenre> movieGenres;
    private String synopsis;
    private String director;
    private ArrayList<String> casts;
    private int movieDuration;
    private double sales;
    private Enum.AgeRestriction ageRestriction;
    private boolean is3D;
    private double overallRating;
    private ArrayList<Review> reviews;
    private String expiryDate;
    private String startDate;


    public Movie(String movieTitle){
        this.movieTitle = movieTitle;
        this.reviews = new ArrayList<>();
        this.sales = 0;
    }

    public void setMovieStatus(Enum.MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setMovieGenres(ArrayList<MovieGenre> movieGenres) {
        this.movieGenres = movieGenres;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCasts(ArrayList<String> casts) {
        this.casts = casts;
    }

    public void setMovieDuration(int movieDuration) {
        this.movieDuration = movieDuration;
    }

    public void setAgeRestriction(Enum.AgeRestriction ageRestriction) {
        this.ageRestriction = ageRestriction;
    }

    public void setIs3D(boolean is3D) {
        this.is3D = is3D;
    }

    public void setOverallRating(double overallRating) {
        this.overallRating = overallRating;
    }

    public void setSales(double sales) {
        this.sales = sales;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    
    public String getMovieTitle() {
        return movieTitle;
    }

    public Enum.MovieStatus getMovieStatus() {
        return movieStatus;
    }

    public Enum.AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public ArrayList<MovieGenre> getMovieGenres() {
        return movieGenres;
    }

    public String getSynopsis(){
        return synopsis;
    }

    public String getDirector(){
        return director;
    }

    public ArrayList<String> getCasts(){
        return casts;
    }

    public int getMovieDuration(){
        return movieDuration;
    }

    public double getSales(){
        return sales;
    }

    public boolean getIs3D(){
        return is3D;
    }

    public double getOverallRating(){
        return overallRating;
    }

    public ArrayList<Review> getReviews(){
        return reviews;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public String getStartDate() {
        return startDate;
    }

}