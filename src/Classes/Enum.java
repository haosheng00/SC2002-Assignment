package classes;

public class Enum {
    
    /* Movie */

    // MovieStatus
    public enum MovieStatus {
        COMING_SOON,
        PREVIEW,
        END_OF_SHOWING,
        NOW_SHOWING
    }

    // MovieGenre
    public enum MovieGenre {
        ACTION,
        HORROR,
        THRILLER,
        ADVENTURE,
        COMEDY,
        ANIME,
        ROMANCE,
        DRAMA,
        TRUE_STORY,
        OTHERS
    }

    // AgeRestriction
    public enum AgeRestriction {
        G, 
        PG, 
        PG13, 
        NC16, 
        M18, 
        R21
    }

    // SeatType
    public enum SeatType {
        COUPLE_SEAT,
        ORDINARY
    }

    //TicketType
    public enum TicketType{
        STUDENT,
        ADULT,
        SENIORCITIZEN
    }

    //DayOfWeek
    public enum DayOfWeek{
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    //CinemaType
    public enum CinemaType {
        PLATINUMMOVIESUITES,
        ORDINARY;
    }
    
}
