package Classes;

import java.util.ArrayList;

public class DropDownMenu {
    public static void initiateCineplexChoice(ArrayList<Cineplex> cineplexes){
        System.out.println("========================================");
        System.out.println("Select Cineplex: ");
        for (int i = 0; i < cineplexes.size();i++){
            System.out.println("(" + i + 1 + ") " + cineplexes.get(i).getCineplexName());
        }
    }

    public static void initiateCinemaChoice(ArrayList<Cinema> cinemas){
        System.out.println("========================================");
        System.out.println("Select Cinema: ");
        for (int i = 0; i < cinemas.size(); i++){
            System.out.println("(" + i + 1 + ")" + cinemas.get(i).getCinemaName());
        }
    }

    public static void initiateMovieChoice(ArrayList<Movie> movies){
        System.out.println("========================================");
        System.out.println("Select Movie: ");
        for (int i = 0; i < movies.size(); i++){
            System.out.println("(" i + 1 + ")" + movies.get(i).getMovieTitle());
        }
    }
}
