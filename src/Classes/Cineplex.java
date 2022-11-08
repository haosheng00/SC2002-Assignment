package classes;

import java.io.Serializable;
import java.util.ArrayList;

public class Cineplex implements Serializable{
    private String cineplexName;
    private ArrayList<Cinema> cinemas;
    private ArrayList<Movie> movies;

    public Cineplex(String cineplexName, ArrayList<Cinema> cinemas, ArrayList<Movie> movies){
        this.cineplexName = cineplexName;
        this.cinemas = cinemas;
        this.movies = movies;
    }

    public String getCineplexName() {
        return cineplexName;
    }
    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }    public void setCinemas(ArrayList<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
    
    public ArrayList<Movie> getMovies(){
        return movies;
    }
    public void setMovies(ArrayList<Movie> movies){
        this.movies = movies;
    }
}