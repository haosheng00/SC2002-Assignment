package classes;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Represents a cineplex class with its respective details
 */
public class Cineplex implements Serializable{
    /**
     * Represents the name of the cineplex
     */
    private String cineplexName;
    /**
     * Represents all the cinemas in the Cineplex
     */
    private ArrayList<Cinema> cinemas;
    /**
     * Represents all the movies shown in the Cineplex
     */
    private ArrayList<Movie> movies;

    /**
     * Represents the cineplex initialised with a specific name, cinemas, and movies given
     * @param cineplexName
     * @param cinemas
     * @param movies
     */
    public Cineplex(String cineplexName, ArrayList<Cinema> cinemas, ArrayList<Movie> movies){
        this.cineplexName = cineplexName;
        this.cinemas = cinemas;
        this.movies = movies;
    }

    /**
     * Returns the name of the cineplex
     * @return name of cineplex
     */
    public String getCineplexName() {
        return cineplexName;
    }

    /**
     * Set the name of the cineplex to a specific cineplex name
     * @param cineplexName
     */
    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    /**
     * Returns the list of cinemas in the cineplex
     * @return cinema list
     */
    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }

    /**
     * Set the list of cinemas in the cineplex to a specific list of cinemas
     * @param cinemas
     */
    public void setCinemas(ArrayList<Cinema> cinemas) {
        this.cinemas = cinemas;
    }

    /**
     * Returns the list of movies in the cineplex
     * @return movie list
     */
    public ArrayList<Movie> getMovies(){
        return movies;
    }

    /**
     * Set the list of movies in the cineplex to a specific list of movies
     * @param movies
     */
    public void setMovies(ArrayList<Movie> movies){
        this.movies = movies;
    }
}