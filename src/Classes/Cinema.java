package classes;

import java.io.Serializable;

/**
 * Represents a Cinema class with its details
 */
public class Cinema implements Serializable{
    /**
     * Represents the name of the cinema
     */
    private String cinemaName;
    /**
     * Represents the cinema code of the cinema,
     * in the form XXX, where XXX are Uppercase Alphabetic
     */
    private String cinemaCode;
    /**
     * Represents the cinema type of the cinema: <p>
     * ORDINARY or PLATINUMMOVIESUITES
     */
    private Enum.CinemaType cinemaType;
    private String cineplexName;

    /**
     * Represents the cinema initialised with a specific cinema name, cinema code and cinema type
     * @param cinemaName
     * @param cinemaCode
     * @param cinemaType
     * @param cineplexName
     */
    public Cinema(String cinemaName, String cinemaCode, Enum.CinemaType cinemaType, String cineplexName) {
        this.cinemaName = cinemaName;
        this.cinemaCode = cinemaCode;
        this.cinemaType = cinemaType;
        this.cineplexName = cineplexName;
    }

    /**
     * Returns the name of the cinema
     * @return cinema name
     */
    public String getCinemaName(){
        return this.cinemaName;
    }

    /**
     * Sets the name of the cinema to a specific name
     * @param cinemaName
     */
    public void setCinemaName(String cinemaName){
        this.cinemaName = cinemaName;
    }

    /**
     * Returns the cinema code of the cinema,
     * in the form of XXX, where XXX are Uppercase Alphabetic
     * @return cinema code, in XXX
     */
    public String getCinemaCode(){
        return this.cinemaCode;
    }

    /**
     * Sets the cinema code of the cinema,
     * in the form of XXX, where XXX are Uppercase Alphabetic
     * @param cinemaCode, in XXX
     */
    public void setCinemaCode(String cinemaCode){
        this.cinemaCode = cinemaCode;
    }

    /**
     * Returns the cinema type of the cinema
     * @return cinema type
     */
    public Enum.CinemaType getCinemaType(){
        return this.cinemaType;
    }

    /**
     * Sets the cinema type of the cinema to a specific cinema type:<p>
     *     ORDINARY or PLATINUMMOVIESUITES
     * @param cinemaType
     */
    public void setCinemaType(Enum.CinemaType cinemaType){
        this.cinemaType = cinemaType;
    }

    public String getCineplexName() {
        return cineplexName;
    }

    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }
}
