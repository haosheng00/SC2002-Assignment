package classes;

public class Enum {
    
    /* Movie */

    // MovieStatus
    public enum MovieStatus {
        COMING_SOON("Coming soon"),
        PREVIEW("Preview"),
        END_OF_SHOWING("End of showing"),
        NOW_SHOWING("Now showing");

        private String movieStatus;
        MovieStatus(String movieStatus) {
            this.movieStatus = movieStatus;
        }
    }

    // MovieGenre
    public enum MovieGenre {
        ACTION("Action"),
        HORROR("Horror"),
        THRILLER("Thriller"),
        ADVENTURE("Adventure"),
        COMEDY("Comedy"),
        ANIME("Anime"),
        ROMANCE("Romance"),
        DRAMA("Drama"),
        TRUE_STORY("True Story"),
        OTHERS("Others");

        private String movieGenre;
        MovieGenre(String movieGenre) {
            this.movieGenre = movieGenre;
        }
    }

    // AgeRestriction
    public enum AgeRestriction {
        G("G"), 
        PG("PG"), 
        PG13("PG13"), 
        NC16("NC16"), 
        M18("M18"), 
        R21("R21");

        private String ageRestriction;
        AgeRestriction(String ageRestriction) {
            this.ageRestriction = ageRestriction;
        }
    }

    // SeatType
    public enum SeatType {
        COUPLE_SEAT,
        ORDINARY
    }

    //TicketType
    public enum TicketType{
        STUDENT("STUDENT", 8),
        ADULT("ADULT", 12),
        SENIORCITIZEN("SENIORCITIZEN", 5);

        private String groupType;
        private double price;

        TicketType(String groupType, double price){
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

    //DayOfWeek
    public enum DayOfWeek{
        MONDAY(false, 0),
        TUESDAY(false, 0),
        WEDNESDAY(false, 0),
        THURSDAY(false, 0),
        FRIDAY(false, 0),
        SATURDAY(true, 15),
        SUNDAY(true, 15);

        private final Boolean weekend;
        private double price;

        DayOfWeek(Boolean weekend, double price){
            this.weekend = weekend;
            this.price = price;
        }

        public Boolean isWeekend(){
            return weekend;
        }

        public double getTicketPrice(){
            return price;
        }

        public void setTicketPrice(double price){
            this.price = price;
        }
    }
}
