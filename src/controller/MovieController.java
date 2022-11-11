package controller;

import java.util.*;
import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import classes.*;
import classes.Enum;
import classes.Enum.*;
import initialiser.Initialise;
import serialiser.SerializeMovieDB;
import serialiser.WriteMovieDB;
import ui.ReviewUI;

/**
 * Contains the methods related to the movies available
 */
public class MovieController implements Serializable{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<Movie> top5BySales = Initialise.top5BySales;
    static ArrayList<Movie> top5ByRatings = Initialise.top5ByRatings;
    //static ArrayList<Movie> movies = new ArrayList <Movie>(); 

    /**
     * Loops through the movies array list to check on the existence of the searched movie
     * @param movieTitle the title of the movie that user wants to search
     * @return index of the movie if it exists; -1 if it does not exists
     */
    public static int searchMovie(String movieTitle) {
        movieTitle = movieTitle.toUpperCase();
        for (int i = 0; i < Initialise.movies.size(); i++) {
            if (movieTitle.equals(Initialise.movies.get(i).getMovieTitle())) {
                return i;
            }
        }
        return -1;
    }

    /**
    * Adds a new movie to the movies list and specified cineplexes
    * @throws Exception
    */
    public static void addMovie() throws Exception {
        String movieTitle;
        ArrayList<String> casts = new ArrayList<>();
        ArrayList<classes.Enum.MovieGenre> movieGenres = new ArrayList<>();
        String s = null;

        int exists = -2;
        int i;
        System.out.println("Please enter new Movie Title:");
        movieTitle = sc.next();
        exists = searchMovie(movieTitle);
        while (!(exists == -1 || exists == -2)) {
            System.out.println("The movie already exists.");
            System.out.println("Please enter new Movie Title:");
            System.out.println("Or press 0 to go back");
            String input = sc.next();
            if (input == "0")
                return;
            else
                movieTitle = input;
            exists = searchMovie(movieTitle);
        }
        while (exists == -1) {
            Movie newMovie = new Movie(movieTitle.toUpperCase(),MovieStatus.END_OF_SHOWING, "Des","fdg",122,20,Enum.AgeRestriction.PG,true,5,"112233","112233");
            do{
                try{
                    System.out.println("Please select movie status:");
                    System.out.println("(1) Coming soon");
                    System.out.println("(2) Preview");
                    System.out.println("(3) Now showing");
                    i = sc.nextInt();
                    break;  
                }
                catch (Exception e){
                    System.out.println("Invalid input! Enter integer only!");
                    sc.next();         
                }
                } while(true);
            switch (i) {
            case 1:
            newMovie.setMovieStatus(MovieStatus.COMING_SOON);
            System.out.println("Please enter the start date of the movie screening (YYYYMMDD):");
            newMovie.setStartDate(sc.next());
            break;
            case 2:
            newMovie.setMovieStatus(MovieStatus.PREVIEW);
            System.out.println("Please enter the start date of the movie screening (YYYYMMDD):");
            newMovie.setStartDate(sc.next());
            break;
            case 3:
            newMovie.setMovieStatus(MovieStatus.NOW_SHOWING);
            break;
            }
            System.out.println("Please enter the date where the movie stops showing (YYYYMMDD): ");
            newMovie.setExpiryDate(sc.next());

            System.out.println("Please select movie genre: ");
            System.out.println("(1) Action");
            System.out.println("(2) Horror");
            System.out.println("(3) Thriller");
            System.out.println("(4) Adventure");
            System.out.println("(5) Comedy");
            System.out.println("(6) Anime");
            System.out.println("(7) Romance");
            System.out.println("(8) Drama");
            System.out.println("(9) True Story");
            System.out.println("(10) Others");
            System.out.println("(0) Go to Next Section");
            do {
                try {
                    i = sc.nextInt();
                    switch (i) {
                    case 1:
                    movieGenres.add(MovieGenre.ACTION);
                    break;
                    case 2:
                    movieGenres.add(MovieGenre.HORROR);
                    break;
                    case 3:
                    movieGenres.add(MovieGenre.THRILLER);
                    break;
                    case 4:
                    movieGenres.add(MovieGenre.ADVENTURE);
                    break;
                    case 5:
                    movieGenres.add(MovieGenre.COMEDY);
                    break;
                    case 6:
                    movieGenres.add(MovieGenre.ANIME);
                    break;
                    case 7:
                    movieGenres.add(MovieGenre.ROMANCE);
                    break;
                    case 8:
                    movieGenres.add(MovieGenre.DRAMA);
                    break;
                    case 9:
                    movieGenres.add(MovieGenre.TRUE_STORY);
                    break;
                    case 10:
                    movieGenres.add(MovieGenre.OTHERS);
                    break;
                    case 0:
                    break;
                    default:
                    System.out.println("Invalid input! Enter 1 to 10 only!");
                    sc.next();
                    continue;    
                    }
                } catch (Exception e){
                    System.out.println("Invalid input! Enter integer only!");
                    sc.next();         
                }
            } while (i != 0);
            newMovie.setMovieGenres(movieGenres);
            System.out.println("Please enter Movie Synopsis:");
            newMovie.setSynopsis(sc.next());
            do{
            try{
                System.out.println("Please enter movie duration in mins:");
                i = sc.nextInt(); 
                newMovie.setMovieDuration(i);
                break;  
            }
            catch (Exception e){
                System.out.println("Invalid input! Enter integer only!");
                sc.next();         
            }
            } while(true);

            System.out.println("Please set age rating/restriction:");
            System.out.println("(1) G");
            System.out.println("(2) PG");
            System.out.println("(3) PG13");
            System.out.println("(4) NC16");
            System.out.println("(5) M18");
            System.out.println("(6) R21");
            i = sc.nextInt();
            while (i < 1 || i > 6) {
            System.out.println("Invalid input!");
            System.out.println("Please set age rating/restriction:");
            System.out.println("(1) G");
            System.out.println("(2) PG");
            System.out.println("(3) PG13");
            System.out.println("(4) NC16");
            System.out.println("(5) M18");
            System.out.println("(6) R21");
            i = sc.nextInt();
            }
            switch (i) {
            case 1:
            newMovie.setAgeRestriction(AgeRestriction.G);
            break;
            case 2:
            newMovie.setAgeRestriction(AgeRestriction.PG);
            break;
            case 3:
            newMovie.setAgeRestriction(AgeRestriction.PG13);
            break;
            case 4:
            newMovie.setAgeRestriction(AgeRestriction.NC16);
            break;
            case 5:
            newMovie.setAgeRestriction(AgeRestriction.M18);
            break;
            case 6:
            newMovie.setAgeRestriction(AgeRestriction.R21);
            break;
            }
            System.out.println("Please enter Movie Director: ");
            newMovie.setDirector(sc.next());
            System.out.println("Please enter name of cast:");
            s = sc.next();
            do {
                casts.add(s);
                System.out.println("Please enter name of next cast or press 0 to go to next section");
                s = sc.next().toUpperCase();
            } while (!s.equals("0"));
            newMovie.setCasts(casts);
            while ((!s.equals("Y") && !s.equals("N"))) {
                System.out.println("Is the movie 3D? (Y/N)");
                s = sc.next().toUpperCase();
                switch (s) {
                    case "Y":
                        newMovie.setIs3D(true);
                        break;
                    case "N":
                        newMovie.setIs3D(false);
                        break;
                    default:
                        System.out.println("Invalid input!");
                        break;
                }
            }
            System.out.println("Please select the Cineplex(s) to screen the movie");
            DropDownMenu.initiateCineplexAddition(newMovie);
            Initialise.movies.add(newMovie);
            System.out.println("Movie added!");
            WriteMovieDB.writeMovieDB();
            break;
        }
    }

    /**
     * Removes a movie from the existing movies array list
     * @return int 1 if movie is deleted/removed successfully
     * @throws Exception
     */
    public static int deleteMovie() throws Exception {
        int index = DropDownMenu.initiateAdminMovieChoice(Initialise.movies);
        if (index == -1){
            return -1;
        }
        //Initialise.movies.get(index).setMovieStatus(MovieStatus.END_OF_SHOWING);
        Initialise.movies.remove(Initialise.movies.get(index));
        SerializeMovieDB.writeSerializedObject("Movie.dat", Initialise.movies);
        System.out.println("Movie Deleted!");
        return 1;
    }

    /**
     * Allows user to update the following attributes of an existing movie in the movies array list:
     * Movie Title, Movie Status, Start Date of Screening & End Date of Screening
     * @return int 1 if update is successful
     */
    public static int updateMovie() {
        int index = DropDownMenu.initiateAdminMovieChoice(Initialise.movies);
        int choice = 0;

        System.out.println("Select one option:");
        System.out.println("(1) Update Movie Title");
        System.out.println("(2) Update Movie Status");
        System.out.println("(3) Update Start Date of Screening");
        System.out.println("(4) Update End Date of Screening");
        System.out.println("(5) Back to previous menu");

        choice = sc.nextInt();
        switch (choice) {
            case 1:
                System.out.println("Enter new movie title:");
                Initialise.movies.get(index).setMovieTitle(sc.next().toUpperCase());
                break;
            case 2:
                System.out.println("Update to:");
                System.out.println("(1) Coming soon");
                System.out.println("(2) Preview");
                System.out.println("(3) End of showing");
                System.out.println("(4) Now showing");
                int i = sc.nextInt();
                switch (i) {
                    case 1:
                        Initialise.movies.get(index).setMovieStatus(MovieStatus.COMING_SOON);
                        break;
                    case 2:
                        Initialise.movies.get(index).setMovieStatus(MovieStatus.PREVIEW);
                        break;
                    case 3:
                        Initialise.movies.get(index).setMovieStatus(MovieStatus.END_OF_SHOWING);
                        break;
                    case 4:
                        Initialise.movies.get(index).setMovieStatus(MovieStatus.NOW_SHOWING);
                        break;
                }
                break;
            case 3:
                System.out.println("Please update the date where the movie starts showing (YYYYMMDD): ");
                Initialise.movies.get(index).setStartDate(sc.next());
                break;
            case 4:
                System.out.println("Please update the date where the movie stops showing (YYYYMMDD): ");
                Initialise.movies.get(index).setExpiryDate(sc.next());
                break;
            case 5:
                break;
        }
        return 1;
    }

    /**
     * Prints out the details of the movie by the index of the movie in the movies array list
     * @param index the index of the movie in the movies array list
     * @throws Exception
     */
    public static void printMovie(int index) throws Exception {
            System.out.println("Movie Title: " + Initialise.movies.get(index).getMovieTitle());
            System.out.println("Movie Status: " + Initialise.movies.get(index).getMovieStatus());
            System.out.println("Movie Genre(s): " + Initialise.movies.get(index).getMovieGenres());
            System.out.println("Director: " + Initialise.movies.get(index).getDirector());
            System.out.println("Casts: " + Initialise.movies.get(index).getCasts());
            System.out.println("Synopsis: " + Initialise.movies.get(index).getSynopsis());
            System.out.println("Age Rating: " + Initialise.movies.get(index).getAgeRestriction());
            System.out.println(Initialise.movies.get(index).getIs3D() ? "3D" : "2D");
            System.out.println("Duration: " + Initialise.movies.get(index).getMovieDuration());
            System.out.println("Rating: " + Initialise.movies.get(index).getOverallRating());
            System.out.println("Start Screening Date: " + Initialise.movies.get(index).getStartDate());
            System.out.println("End Screening Date: " + Initialise.movies.get(index).getExpiryDate());
            System.out.println();
            if (!Initialise.movies.get(index).getReviews().isEmpty()) System.out.println("(1) - See Reviews");
            System.out.println("(0) - Back");
            int choice = sc.nextInt();
            
            while (choice != 1 && choice != 0){
                System.out.println("Invalid option, try again:");
                if (!Initialise.movies.get(index).getReviews().isEmpty()) System.out.println("(1) - See Reviews");
                System.out.println("(0) - Back");
                choice = sc.nextInt();
            }
            if (choice == 1) {
                ReviewController.printMovieReviews(Initialise.movies.get(index));
            } else return;
                
        }

    /**
     * Returns the movies array list
     * @return movies array list stored in database
     */
    public static ArrayList<Movie> getMovieList() {
        return Initialise.movies;
    }

    /**
     * Returns the top 5 movies sorted according to the overall rating of the movie
     * @return movies array list with the top 5 rated movies
     */
    public static ArrayList<Movie> getTop5ByRatings() {
        return top5ByRatings;
    }

    /**
     * Returns the top 5 movies sorted according to the overall sales of the movie
     * @return movies array list with the top 5 movies with highest sales amount
     */
    public static ArrayList<Movie> getTop5BySales() {
        return top5BySales;
    }

    /**
     * Prints out the top 5 movies in the movies array list sorted according to either overall rating or sales set by the admin
     * @param criteria 1: By overall rating; 2: By sales; 3: Provides a choice to pick from overall rating or sales
     */
    public static void getTop5Movies(int criteria) {

        int choice = 0;
        ArrayList <Movie> top5ByRatings = Initialise.top5ByRatings;
        ArrayList <Movie> top5BySales = Initialise.top5BySales;

        if (criteria == 3) {
            System.out.println("Sort by:");
            System.out.println("(1) - By Overall Rating");
            System.out.println("(2) - By Sales");
            choice = sc.nextInt();

            while (choice != 1 && choice != 2) {
                System.out.println("Invalid option, try again: ");
                choice = sc.nextInt();
            }
            if (choice == 1) {
                System.out.println("Movies by Overall Rating: ");
                for (int i = 0; i < top5ByRatings.size(); i++) {
                    System.out.println("Movie " + (i + 1) + ":");
                    System.out.println("Movie Title: " + top5ByRatings.get(i).getMovieTitle());
                    System.out.println("Movie Rating: " + top5ByRatings.get(i).getOverallRating());
                    System.out.println();
                }
            } else {
                System.out.println("Movies by Sales: ");
                for (int i = 0; i < top5BySales.size(); i++) {
                    System.out.println("Movie " + (i + 1) + ":");
                    System.out.println("Movie Title: " + top5BySales.get(i).getMovieTitle());
                    System.out.println("Movie Sales: " + top5BySales.get(i).getSales());
                    System.out.println();
                }
            }
        } else if (criteria == 1) {
            System.out.println("Movies by Overall Rating: ");
            for (int i = 0; i < top5ByRatings.size(); i++) {
                System.out.println("Movie " + (i + 1) + ":");
                System.out.println("Movie Title: " + top5ByRatings.get(i).getMovieTitle());
                System.out.println("Movie Rating: " + top5ByRatings.get(i).getOverallRating());
                System.out.println();
            }
        } else if (criteria == 2) {
            System.out.println("Movies by Sales: ");
            for (int i = 0; i < top5BySales.size(); i++) {
                System.out.println("Movie " + (i + 1) + ":");
                System.out.println("Movie Title: " + top5BySales.get(i).getMovieTitle());
                System.out.println("Movie Sales: " + top5BySales.get(i).getSales());
                System.out.println();
            }
        }
    }

    /**
     * Automatically updates the movie status to "Now Showing" and "End of Showing" when current date passes "Start of Screening Date" and "End of Screening Date" respectively
     */
    public static class MyTimeTask extends TimerTask {
        // update the moviestatus

        public void run() {
            int i = 0;

            // SimpleDateFormat class obj
            SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyyMMdd");
            // get current date
            Date today = new Date();
            // format the current date
            dateFormatter.format(today);

            ArrayList<Movie> movies = MovieController.getMovieList();
            // for all movies in the Movies Array
            for (i = 0; i < movies.size(); i++) {

                // CHANGE FROM COMING_SOON/PREVIEW TO NOW_SHOWING
                if (movies.get(i).getMovieStatus() == MovieStatus.PREVIEW
                        || movies.get(i).getMovieStatus() == MovieStatus.COMING_SOON) {
                    // parse the start date
                    try {
                        Date startDate = dateFormatter.parse(movies.get(i).getStartDate());
                        int difference = startDate.compareTo(today);
                        // expiry date comes after the today date
                        if (difference >= 0) {
                            movies.get(i).setMovieStatus(MovieStatus.NOW_SHOWING);
                        }
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }

                // CHANGE FROM NOW_SHOWING TO END_OF_SHOWING
                else if (movies.get(i).getMovieStatus() == MovieStatus.NOW_SHOWING) {
                    // parse the expiry date
                    try {
                        // get expiry date only if it is now_showing
                        Date expiryDate = dateFormatter.parse(movies.get(i).getExpiryDate());
                        int difference = expiryDate.compareTo(today);
                        // expiry date comes after the today date
                        if (difference >= 0) {
                            movies.get(i).setMovieStatus(MovieStatus.END_OF_SHOWING);
                        }
                    } catch (ParseException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}