package Classes;

import java.util.ArrayList;

public class DropDownMenu {
    public static void initiateCineplexChoice(ArrayList<Cineplex> cineplexes){
        for (int i = 0; i < cineplexes.size();i++){
            System.out.println("(" + i + 1 + ") " + cineplexes.get(i).getCineplexName());
        }
    }

    public static void initiateCinemaChoice(ArrayList<Cinema> cinemas){
        for (int i = 0; i < cinemas.size(); i++){
            System.out.println("(" + i + 1 + ")" + cinemas.get(i).getCinemaName());
        }
    }

    public static void initiateMovieChoice(ArrayList<Movie> movies){
        for (int i = 0; i < movies.size(); i++){
            System.out.println("(" i + 1 + ")" + movies.get(i).getMovieTitle());
        }
    }
}
