public class Cineplex {
    public enum Outlets {DEFAULT, JEM, CINELEISURE_ORCHARD, CAUSEWAY_POINT, PARKWAY_PARADE}
    protected String[] CinemaList; //get cinemalist for each cineplex //what to store in each index of cinemalist?
    protected Outlets outlet;

    //constructor
    public Cineplex(String[] CinemaList) {
        this.CinemaList = CinemaList;
        outlet = Outlets.DEFAULT;
    }

    //get CinemaList
    public String[] getCinemaList() {
        return CinemaList;
    }

    //get specific index of cinema in Cineplex
    public String getCinema(int i) {
        return CinemaList[i];
    }

    //set CinemaList
    public void setCinemaList(String[] CinemaList) {
        this.CinemaList = CinemaList;
    }

    //set specific index in CinemaList
    public void setCinema(String Cinema, int i) {
        this.CinemaList[i] = Cinema;
    }
}
