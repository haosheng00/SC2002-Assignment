import java.util.ArrayList;

public class Cinema {
    private CinemaType cinemaType;
    private String cinemaCode;
    private String cinemaName;
    private ArrayList<Screening> screenings;

    public Cinema(){
        CinemaType cinemaType = CinemaType.ORDINARY;
        String cinemaCode = "Z99";
        ArrayList<Screening> screenings = new ArrayList<Screening>();
    }
    public Cinema(CinemaType cinemaType, String cinemaCode, String cinemaName, ArrayList<Screening> screenings) {
        this.cinemaType = cinemaType;
        this.cinemaCode = cinemaCode;
        this.cinemaName = cinemaName;
        this.screenings = screenings;
    }

    public CinemaType getCinemaType(){
        return this.cinemaType;
    }
    public void setCinemaType(CinemaType cinemaType){
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

    public ArrayList<Screening> getScreenings(){
        return this.screenings;
    }
    public void setScreenings(ArrayList<Screening> screenings){
        this.screenings = screenings;
    }
}
