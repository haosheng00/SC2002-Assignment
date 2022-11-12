import initialiser.Initialise;
import ui.*;
import classes.*;
import controller.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;


public class Main {
    public static void main(String[] args) throws Exception {

        Initialise.initialiseMOBLIMA();
        // System.out.println(Initialise.movies.get(0).getMovieTitle());
        // for (int i=0; i<Initialise.movies.get(0).getReviews().size(); i++) {
        //     System.out.println(Initialise.movies.get(0).getReviews().get(i).getUserName());
        //     System.out.println(Initialise.movies.get(0).getReviews().get(i).getDateTime());
        //     System.out.println(Initialise.movies.get(0).getReviews().get(i).getRating());
        // }
        // System.out.println(Initialise.movies.get(0).getSales());

        // System.out.println(Initialise.movies.get(0).getMovieTitle());
        // System.out.println(Initialise.movies.get(0).getSales());
    
        AccountUI.WelcomePage();
        
        // // the Date and time at which you want to execute
        // DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        // Date date = dateFormatter.parse("2022-11-10 00:00:00");
        // Timer timer = new Timer();

        // timer.schedule(new MyTimeTask(), date, 1000 * 60 * 60 * 24);

    }

}