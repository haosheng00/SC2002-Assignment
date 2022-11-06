package Classes;

import java.util.ArrayList;

public class DropDownMenu {
    public static int initiateCineplexChoice(ArrayList<Cineplex> cineplexes){
        int i;
        System.out.println("========================================");
        System.out.println("Select Cineplex: ");
        for (i = 0; i < cineplexes.size();i++){
            System.out.println("(" + i + 1 + ") " + cineplexes.get(i).getCineplexName());
        }
        return i;
    }

    public static int initiateCinemaChoice(ArrayList<Cinema> cinemas){
        int i;
        System.out.println("========================================");
        System.out.println("Select Cinema: ");
        for (i = 0; i < cinemas.size(); i++){
            System.out.println("(" + i + 1 + ")" + cinemas.get(i).getCinemaName());
        }
        return i;
    }

    public static int initiateScreeningChoice(ArrayList<Screening> screenings){
        int i;
        System.out.println("========================================");
        System.out.println("Select Screening: ");
        for (i = 0; i < screenings.size(); i++){
            System.out.println("(" + i + 1 + ")" + screenings.get(i).getShowDateTime());
        }
        return i;
    }

    public static int initiateMovieChoice(ArrayList<Movie> movies){
        int i;
        System.out.println("========================================");
        System.out.println("Select Movie: ");
        for (i = 0; i < movies.size(); i++){
            System.out.println("(" + i + 1 + ")" + movies.get(i).getMovieTitle());
        }
        return i;
    }
}
