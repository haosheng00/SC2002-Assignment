package Classes;

public class Cinema{
    private CinemaType cinemaType;
    private int maxCap;
    private Seats[] seats;

    public Cinema(CinemaType cinemaType, int maxCap) {
        this.cinemaType = cinemaType;
        this.maxCap = maxCap;
        seats = new Seats[maxCap];
        for (int i = 0; i < maxCap; i++){
            seats[i] = new Seats();
        }
    }

    public CinemaType getCinemaType(){
        return this.cinemaType;
    }
    public void setCinemaType(CinemaType cinemaType) {
        this.cinemaType = cinemaType;
    }

    public int getMaxCap(){
        return maxCap;
    }
    public void setMaxCap(int maxCap){
        this.maxCap = maxCap;
    }

    public Seats getSeats(int i){
        return this.seats[i];
    }
}
