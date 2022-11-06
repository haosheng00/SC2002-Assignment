package Classes;

import java.util.ArrayList;

import Classes.Enum.MovieGenre;
public class Movie {

    // TODO: Add javadocs
    // Weixian: I believe the movie should have an arraylist of screenings

    private Enum.MovieStatus movieStatus;
    private String movieTitle;
    private Enum.MovieGenre[] movieGenres;
    private String synopsis;
    private String director;
    private String[] casts;
    private int movieDuration;
    private double sales;
    private Enum.AgeRestriction ageRestriction;
    private boolean is3D;
    private double overallRating;
    private ArrayList<Review> reviews;

    public Movie(String movieTitle){
        this.movieTitle = movieTitle;
        this.sales = 0;
    }

    public void setMovieStatus(Enum.MovieStatus movieStatus) {
        this.movieStatus = movieStatus;
    }

    public void setMovieTitle(String movieTitle) {
        this.movieTitle = movieTitle;
    }

    public void setMovieGenres(MovieGenre[] movieGenres) {
        this.movieGenres = movieGenres;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setCasts(String[] casts) {
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
    
    public String getMovieTitle() {
        return movieTitle;
    }

    public Enum.MovieStatus getMovieStatus() {
        return movieStatus;
    }

    public Enum.AgeRestriction getAgeRestriction() {
        return ageRestriction;
    }

    public MovieGenre[] getMovieGenres() {
        return movieGenres;
    }

    public String getSynopsis(){
        return synopsis;
    }

    public String getDirector(){
        return director;
    }

    public String[] getCasts(){
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
    }