package classes;

import java.io.Serializable;

public class Cinema implements Serializable{

    private String cinemaName;
    private String cinemaCode;
    private Enum.CinemaType cinemaType;
    public Cinema(String cinemaName, String cinemaCode, Enum.CinemaType cinemaType) {
        this.cinemaName = cinemaName;
        this.cinemaCode = cinemaCode;
        this.cinemaType = cinemaType;
    }

    public String getCinemaName(){
        return this.cinemaName;
    }
    public void setCinemaName(String cinemaName){
        this.cinemaName = cinemaName;
    }
    public String getCinemaCode(){
        return this.cinemaCode;
    }
    public void setCinemaCode(String cinemaCode){
        this.cinemaCode = cinemaCode;
    }
    public Enum.CinemaType getCinemaType(){
        return this.cinemaType;
    }
    public void setCinemaType(Enum.CinemaType cinemaType){
        this.cinemaType = cinemaType;
    }
}
