package Classes;

public class Review {
    private String description;
    private double rating;
    private String userName;
    private String dateTime;
    private Movie movie;

    //constructor
    public Review(String description, double rating, String userName, String dateTime, Movie movie) {
        this.description = description;
        this.rating = rating;
        this.userName = userName;
        this.dateTime = dateTime;
        this.movie = movie;
    }

    //get & set variables
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description;}

    public double getRating() { return rating; }
    public void setRating(double rating) { this.rating = rating;}

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName;}

    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime;}

    public Movie getMovie() { return movie; }
    public void setMovie(Movie movie) { this.movie = movie;}
}
