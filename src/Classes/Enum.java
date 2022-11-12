package classes;

public class Enum {
    
    /* Movie */

    /**
     * Represents the screening status of the movie, with available options:
     * Coming Soon, Preview, End of Showing and Now Showing
     */
    public enum MovieStatus {
        COMING_SOON,
        PREVIEW,
        END_OF_SHOWING,
        NOW_SHOWING
    }

    /**
     * Represent the genre the movie belongs to, with available options:
     * Action, Horror, Thriller, Adventure, Comedy, Anime, Romance, Drama, True Story and Others
     */
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

    /**
     * Represents the movie age rating restriction, with available options:
     * G, PG, PG13, NC16, M18 and R21 
     */
    public enum AgeRestriction {
        G, 
        PG, 
        PG13, 
        NC16, 
        M18, 
        R21
    }

    /**
     * Represents the type of seat in the cinema, with available options:
     * Ordinary and Couple Seat
     */
    public enum SeatType {
        COUPLE_SEAT,
        ORDINARY
    }

    /**
     * Represents the type of ticket (age group), with available options:
     * Student, Adult and Senior Citizen
     */
    public enum TicketType{
        STUDENT,
        ADULT,
        SENIORCITIZEN
    }

    /**
     * Represents the day of the week, with available options:
     * Monday, Tuesday, Wednesday, Thursday, Friday, Saturday, and Sunday
     */
    public enum DayOfWeek{
        MONDAY,
        TUESDAY,
        WEDNESDAY,
        THURSDAY,
        FRIDAY,
        SATURDAY,
        SUNDAY
    }

    /**
     * Represents the type of cinema the movie is screening in, with available options:
     * Platinum Movie Suites and Ordinary
     */
    public enum CinemaType {
        PLATINUMMOVIESUITES,
        ORDINARY;
    }
    
}
