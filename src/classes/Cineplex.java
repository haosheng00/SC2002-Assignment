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
     * @param cineplexName the name of the cineplex
     * @param cinemas the array list of cinemas in the cineplex
     * @param movies the array list of movies shown in the cineplex
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
     * Sets the name of the cineplex to a specific cineplex name
     * @param cineplexName the name of the cineplex
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
     * Sets the list of cinemas in the cineplex to a specific list of cinemas
     * @param cinemas the array list of cinemas in the cineplex
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
     * Sets the list of movies in the cineplex to a specific list of movies
     * @param movies the array list of movies in the cineplex
     */
    public void setMovies(ArrayList<Movie> movies){
        this.movies = movies;
    }
}