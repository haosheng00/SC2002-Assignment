package classes;

public class Cinema {
    private Enum.CinemaType cinemaType;
    private String cinemaCode;
    private String cinemaName;

    public Cinema(Enum.CinemaType cinemaType, String cinemaCode, String cinemaName) {
        this.cinemaType = cinemaType;
        this.cinemaCode = cinemaCode;
        this.cinemaName = cinemaName;
    }

    public Enum.CinemaType getCinemaType(){
        return this.cinemaType;
    }
    public void setCinemaType(Enum.CinemaType cinemaType){
        this.cinemaType = cinemaType;
    }

    public String getCinemaCode(){
        return this.cinemaCode;
    }
    public void setCinemaCode(String cinemaCode){
        this.cinemaCode = cinemaCode;
    }

    public String getCinemaName(){
        return this.cinemaName;
    }
    public void setCinemaName(String cinemaName){
        this.cinemaName = cinemaName;
    }
}
