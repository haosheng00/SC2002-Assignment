import java.text.ParseException;
import java.text.SimpleDateFormat;
import classes.*;
import classes.Enum.MovieStatus;
import java.util.*;
import controller.*;

/**
 * Automatically updates the movie status to "Now Showing" and "End of Showing" when current date passes "Start of Screening Date" and "End of Screening Date" respectively
 */
public class MyTimeTask extends TimerTask {
    
    //update the moviestatus 

    public void run() {
        int i = 0;

        //SimpleDateFormat class obj
        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
        //get current date 
        Date today = new Date();
        //format the current date 
        dateFormatter.format(today);

        ArrayList <Movie> movies = MovieController.getMovieList();
        //for all movies in the Movies Array 
        for (i=0; i<movies.size(); i++) {

            //CHANGE FROM COMING_SOON/PREVIEW TO NOW_SHOWING
            if (movies.get(i).getMovieStatus() == MovieStatus.PREVIEW || movies.get(i).getMovieStatus() == MovieStatus.COMING_SOON)  {
                //parse the start date  
                try {
                    Date startDate = dateFormatter.parse(movies.get(i).getStartDate());
                    int difference = startDate.compareTo(today);
                    //expiry date comes after the today date 
                    if (difference >= 0) {
                        movies.get(i).setMovieStatus(MovieStatus.NOW_SHOWING);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }
        
            //CHANGE FROM NOW_SHOWING TO END_OF_SHOWING
            else if (movies.get(i).getMovieStatus() == MovieStatus.NOW_SHOWING) {
                //parse the expiry date 
                try {
                    //get expiry date only if it is now_showing
                    Date expiryDate = dateFormatter.parse(movies.get(i).getExpiryDate());
                    int difference = expiryDate.compareTo(today);
                    //expiry date comes after the today date 
                    if (difference >= 0) {
                        movies.get(i).setMovieStatus(MovieStatus.END_OF_SHOWING);
                    }
                } catch (ParseException e) {
                    e.printStackTrace();
                }
            }   
        }
    }
}


