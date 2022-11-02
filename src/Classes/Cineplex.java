import java.util.ArrayList;

public class Cineplex {
    private String cineplexName;
    private ArrayList<Cinema> cinemas;

    public Cineplex(String cineplexName, ArrayList<Cinema> cinemas){
        this.cineplexName = cineplexName;
        this.cinemas = cinemas;
    }

    public String getCineplexName() {
        return cineplexName;
    }
    public void setCineplexName(String cineplexName) {
        this.cineplexName = cineplexName;
    }

    public ArrayList<Cinema> getCinemas() {
        return cinemas;
    }

    public void setCinemas(ArrayList<Cinema> cinemas) {
        this.cinemas = cinemas;
    }
}
