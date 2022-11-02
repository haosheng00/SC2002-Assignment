package Classes;

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

    public enum SeatType {
        COUPLE_SEAT,
        ORDINARY
    }
}
