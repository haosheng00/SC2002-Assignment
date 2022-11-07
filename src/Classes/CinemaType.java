package classes;

public enum CinemaType {
    PLATINUMMOVIESUITES("PLATINUMMOVIESUITES", 10),
    ORDINARY("ORDINARY", 0);

    private String groupType;
    private double price;

    CinemaType(String groupType, double price){
        this.groupType = groupType;
        this.price = price;
    }

    public String getGroupType(){
        return groupType;
    }

    public double getTicketPrice(){
        return price;
    }

    public void setTicketPrice(double price){
        this.price = price;
    }
}
