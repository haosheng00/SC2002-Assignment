package controller;

import java.util.*;
import java.io.Serializable;

import classes.*;
import classes.Enum;
import classes.Enum.*;
import initialiser.Initialise;
import serialiser.SerializeMovieDB;
import serialiser.WriteMovieDB;
import ui.MovieUI;

/**
 * Contains the methods related to the movies available
 */
public class MovieController implements Serializable{
    private static Scanner sc = new Scanner(System.in);
    /**
     * Represents an arraylist containing the top 5 movies based on sales
     */
    private static ArrayList<Movie> top5BySales = Initialise.top5BySales;
    /**
     * Represents an arraylist containing the top 5 movies based on ratings
     */
    private static ArrayList<Movie> top5ByRatings = Initialise.top5ByRatings;
    /**
     * Represents an arraylist containing all the movies in MOBLIMA
     */
    private static ArrayList<Movie> movies = Initialise.movies;

    /**
     * Loops through the movies array list to check on the existence of the searched movie
     * @param movieTitle the title of the movie that user wants to search
     * @return index of the movie if it exists; -1 if it does not exists
     */
    public static int searchMovie(String movieTitle) {
        movieTitle = movieTitle.toUpperCase();
        for (int i = 0; i < Initialise.movies.size(); i++) {
            if (movieTitle.equals(Initialise.movies.get(i).getMovieTitle().toUpperCase())) {
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
        System.out.println("========================================");
        System.out.println("Please enter new Movie Title:");
        movieTitle = sc.nextLine();
        exists = searchMovie(movieTitle);
        while (!(exists == -1 || exists == -2)) {
            System.out.println("========================================");
            System.out.println("The movie already exists.");
            System.out.println("Please enter new Movie Title:");
            System.out.println("Or press 0 to go back");
            String input = sc.nextLine();
            if (input == "0")
                return;
            else
                movieTitle = input;
            exists = searchMovie(movieTitle);
        }
        while (exists == -1) {
            Movie newMovie = new Movie(movieTitle,MovieStatus.COMING_SOON, movieGenres,"Des","fdg",new ArrayList<String>() {{ add("Johnny"); add("Mary Kool"); add("Sarah Aga");}},122,0,Enum.AgeRestriction.PG,true,0,"112233","112233");
            System.out.println("========================================");
            System.out.println("Please select movie status:");
            System.out.println("(1) Coming soon");
            System.out.println("(2) Preview");
            System.out.println("(3) Now showing");
            do{
                try{
                    i = sc.nextInt();
                    if (i < 1 || i > 3) {
                        System.out.println("Invalid option. Please enter an integer (1-3):");
                        sc.next();
                        continue;
                    }
                    switch (i) {
                        case 1:
                            newMovie.setMovieStatus(MovieStatus.COMING_SOON);
                            System.out.println("========================================");
                            System.out.println("Please enter the start date of the movie screening (YYYY-MM-DD):");
                            newMovie.setStartDate(sc.next());
                            break;
                        case 2:
                            newMovie.setMovieStatus(MovieStatus.PREVIEW);
                            System.out.println("========================================");
                            System.out.println("Please enter the start date of the movie screening (YYYY-MM-DD):");
                            newMovie.setStartDate(sc.next());
                            break;
                        case 3:
                            newMovie.setMovieStatus(MovieStatus.NOW_SHOWING);
                            break;
                    }
                    break;  
                }
                catch (Exception e){
                    System.out.println("Invalid input. Please enter an integer:");
                    sc.next();         
                }
                } while(true);
            System.out.println("========================================");
            System.out.println("Please enter the date where the movie stops showing (YYYY-MM-DD): ");
            newMovie.setExpiryDate(sc.next());

            System.out.println("========================================");
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
                            System.out.println("Invalid option. Please enter an integer (0-10):");
                            continue;    
                    }
                } catch (Exception e){
                    System.out.println("Invalid input. Please enter an integer:");
                    sc.next();         
                }
            } while (i != 0);
            sc.nextLine();
            newMovie.setMovieGenres(movieGenres);
            System.out.println("========================================");
            System.out.println("Please enter Movie Synopsis:");
            newMovie.setSynopsis(sc.nextLine());
            System.out.println("========================================");
            System.out.println("Please enter movie duration in mins:");
            do{
                try{
                    i = sc.nextInt(); 
                    newMovie.setMovieDuration(i);
                    break;  
                }
                catch (Exception e){
                    System.out.println("Invalid input. Please enter an integer:");
                    sc.next();         
                }
            } while(true);

            System.out.println("========================================");
            System.out.println("Please set age rating/restriction:");
            System.out.println("(1) G");
            System.out.println("(2) PG");
            System.out.println("(3) PG13");
            System.out.println("(4) NC16");
            System.out.println("(5) M18");
            System.out.println("(6) R21");
            do {
                try {
                    i = sc.nextInt();
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
                        default:
                            System.out.println("Invalid option. Please enter an integer (1-6):");
                            sc.next();
                            continue;    
                    }
                    break;
                } catch (Exception e){
                    System.out.println("Invalid input. Please enter an integer:");
                    sc.next();         
                }
            } while (true);
            sc.nextLine();
            System.out.println("========================================");
            System.out.println("Please enter main movie director: ");
            newMovie.setDirector(sc.nextLine());
            System.out.println("========================================");
            System.out.println("Please enter name of cast:");
            s = sc.nextLine();
            do {
                casts.add(s);
                System.out.println("Please enter name of next cast or press 0 to go to next section");
                s = sc.nextLine();
            } while (!s.equals("0"));
            newMovie.setCasts(casts);
            while ((!s.equals("Y") && !s.equals("N"))) {
                System.out.println("========================================");
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
                        System.out.println("Invalid input.");
                        break;
                }
            }
            System.out.println("========================================");
            System.out.println("Please select the Cineplex(s) to screen the movie");
            DropDownMenu.initiateCineplexAddition(newMovie);
            Initialise.movies.add(newMovie);
            System.out.println("Movie added!");
            WriteMovieDB.writeMovieDB();
            MovieUI.initiateMovieUI();
        }
    }

    /**
     * Removes a movie from the existing movies array list
     * @throws Exception
     */
    public static void deleteMovie() throws Exception {
        int index = DropDownMenu.initiateAdminMovieChoice(Initialise.movies);
        for (int i = 0; i < Initialise.cineplexes.size(); i++){
            for(int j = 0; j < Initialise.cineplexes.get(i).getMovies().size(); j++){
                if (Initialise.movies.get(index).getMovieTitle().equals(Initialise.cineplexes.get(i).getMovies().get(i).getMovieTitle())){
                    Initialise.cineplexes.get(i).getMovies().remove(i);
                }
            }
        }
        Initialise.movies.remove(Initialise.movies.get(index));
        SerializeMovieDB.writeSerializedObject("Cineplex.dat", Initialise.cineplexes);
        SerializeMovieDB.writeSerializedObject("Movie.dat", Initialise.movies);
        System.out.println("Movie Deleted!");
        return;
    }

    /**
     * Allows user to update the following attributes of an existing movie in the movies array list:
     * Movie Title, Movie Status, Start Date of Screening and End Date of Screening
     * @return int 1 if update is successful
     * @throws Exception
     */
    public static void updateMovie() throws Exception {
        int index = DropDownMenu.initiateAdminMovieChoice(Initialise.movies);
        int choice = 0;
        do {

            System.out.println("========================================");
            System.out.println("Select one option:");
            System.out.println("(1) Update Movie Status");
            System.out.println("(2) Update Start Date of Screening");
            System.out.println("(3) Update End Date of Screening");
            System.out.println("(4) Back to previous menu");

            choice = sc.nextInt();
            sc.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("========================================");
                    System.out.println("Update to:");
                    System.out.println("(1) Coming soon");
                    System.out.println("(2) Preview");
                    System.out.println("(3) End of showing");
                    System.out.println("(4) Now showing");
                    int i = sc.nextInt();
                    switch (i) {
                        case 1:
                            Initialise.movies.get(index).setMovieStatus(MovieStatus.COMING_SOON);
                            updateCineplexMovieStatus(MovieStatus.COMING_SOON, Initialise.movies.get(index));
                            break;
                        case 2:
                            Initialise.movies.get(index).setMovieStatus(MovieStatus.PREVIEW);
                            updateCineplexMovieStatus(MovieStatus.PREVIEW, Initialise.movies.get(index));
                            break;
                        case 3:
                            Initialise.movies.get(index).setMovieStatus(MovieStatus.END_OF_SHOWING);
                            updateCineplexMovieStatus(MovieStatus.END_OF_SHOWING, Initialise.movies.get(index));
                            break;
                        case 4:
                            Initialise.movies.get(index).setMovieStatus(MovieStatus.NOW_SHOWING);
                            updateCineplexMovieStatus(MovieStatus.NOW_SHOWING, Initialise.movies.get(index));
                            break;
                        default:
                            break;
                    }
                    break;
                case 2:
                    System.out.println("========================================");
                    System.out.println("Please update the date where the movie starts showing (YYYY-MM-DD): ");
                    Initialise.movies.get(index).setStartDate(sc.next());
                    break;
                case 3:
                    System.out.println("========================================");
                    System.out.println("Please update the date where the movie stops showing (YYYY-MM-DD): ");
                    Initialise.movies.get(index).setExpiryDate(sc.next());
                    break;
                case 4:
                    break;
                default:
                    System.out.println("Invalid option. Please enter an integer (1-4):");
                    break;
            }
        }while(choice!=4);
        SerializeMovieDB.writeSerializedObject("Cineplex.dat", Initialise.cineplexes);
        SerializeMovieDB.writeSerializedObject("Movie.dat", Initialise.movies);
        System.out.println("Movie updated!");
    }

    /**
     * Prints out the details of the movie by the index of the movie in the movies array list
     * @param index the index of the movie in the movies array list
     * @throws Exception
     */
    public static void printMovie(int index) throws Exception {
        int i = 0;
        System.out.println("========================================");
        System.out.println("Movie Title: " + Initialise.movies.get(index).getMovieTitle());
        System.out.println("Movie Status: " + Initialise.movies.get(index).getMovieStatus());
        System.out.print("Movie Genre(s): ");
        for (MovieGenre movieGenre : Initialise.movies.get(index).getMovieGenres()){
            System.out.print(movieGenre);
            i++;
            if (i < Initialise.movies.get(index).getMovieGenres().size()) System.out.print(", ");
            }
        System.out.println();
        System.out.println("Director: " + Initialise.movies.get(index).getDirector());
        System.out.print("Casts: ");
        i = 0;
        for (String cast : Initialise.movies.get(index).getCasts()){
            System.out.print(cast);
            if (i < Initialise.movies.get(index).getMovieGenres().size()) System.out.print(", ");
            i++;
        }
        System.out.println();
        System.out.println("Synopsis: " + Initialise.movies.get(index).getSynopsis());
        System.out.println("Age Rating: " + Initialise.movies.get(index).getAgeRestriction());
        System.out.println(Initialise.movies.get(index).getIs3D() ? "3D" : "2D");
        System.out.println("Duration: " + Initialise.movies.get(index).getMovieDuration() + " minutes");
        System.out.println("Rating: " + Initialise.movies.get(index).getOverallRating());
        System.out.println("Start Screening Date: " + DateTime.dateFormatter(Initialise.movies.get(index).getStartDate()));
        System.out.println("End Screening Date: " + DateTime.dateFormatter(Initialise.movies.get(index).getExpiryDate()));
        System.out.println();

        if (!Initialise.movies.get(index).getReviews().isEmpty()) {
            System.out.println("(1) See Reviews");
            System.out.println("(0) Back");
        }
        else{
            System.out.println("No reviews yet");
            return;
        }

        int choice = 0;
        
        do {
            try {
                choice = sc.nextInt();
                if (choice != 1 && choice != 0){
                    System.out.println("Invalid option. Please enter 0 or 1:");
                    if (!Initialise.movies.get(index).getReviews().isEmpty()) {
                        System.out.println("(1) See Reviews");
                        System.out.println("(0) Back");
                    }
                }
                else if (choice == 1) {
                    ReviewController.printMovieReviews(Initialise.movies.get(index));
                    return;
                } 
                else return;
            } 
            catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer:");
                sc.next();
            }
        } while (choice != 0);
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
            System.out.println("(1) By Overall Rating");
            System.out.println("(2) By Sales");
            do {
                try {
                    choice = sc.nextInt();
    
                    if (choice != 1 && choice != 2) {
                        System.out.println("Invalid option. Please enter 1 or 2: ");
                    }
                    else if (choice == 1) {
                        System.out.println("Movies by Overall Rating: ");
                        System.out.println(" ");
                        if (top5ByRatings.isEmpty()) System.out.println("Sorry, no movies with rating at the moment");
                        for (int i = 0; i < top5ByRatings.size(); i++) {
                            System.out.println("Movie " + (i + 1) + ":");
                            System.out.println("Movie Title: " + top5ByRatings.get(i).getMovieTitle());
                            System.out.printf("Movie Rating: %.2f", top5ByRatings.get(i).getOverallRating());
                            System.out.println("\n");
                        }
                        break;
                    } else {
                        System.out.println("Movies by Sales: ");
                        System.out.println(" ");
                        for (int i = 0; i < top5BySales.size(); i++) {
                            System.out.println("Movie " + (i + 1) + ":");
                            System.out.println("Movie Title: " + top5BySales.get(i).getMovieTitle());
                            System.out.println("Movie Sales: " + top5BySales.get(i).getSales());
                            System.out.println(" ");
                        }
                        break;
                    }
                }
                catch (Exception e) {
                    System.out.println("Invalid input. Please enter an integer: ");
                    sc.next();
                }
            } while (true);
        } 
        
        else if (criteria == 1) {
            System.out.println("Movies by Overall Rating: ");
            System.out.println();
            for (int i = 0; i < top5ByRatings.size(); i++) {
                System.out.println("Movie " + (i + 1) + ":");
                System.out.println("Movie Title: " + top5ByRatings.get(i).getMovieTitle());
                System.out.printf("Movie Rating: %.2f", top5ByRatings.get(i).getOverallRating());
                System.out.println("\n");
            }
        } else if (criteria == 2) {
            System.out.println("Movies by Sales: ");
            System.out.println();
            for (int i = 0; i < top5BySales.size(); i++) {
                System.out.println("Movie " + (i + 1) + ":");
                System.out.println("Movie Title: " + top5BySales.get(i).getMovieTitle());
                System.out.println("Movie Sales: " + top5BySales.get(i).getSales());
                System.out.println(" ");
            }
        }
    }

    /**
     * Update movie status of the movie in the movie array list of cineplexes
     * @param movieStatus status of movie
     * @param movie movie object to compare
     */
    public static void updateCineplexMovieStatus(Enum.MovieStatus movieStatus, Movie movie){
        for (int k = 0; k < Initialise.cineplexes.size(); k++){
            for (int j = 0; j < Initialise.cineplexes.get(k).getMovies().size(); j++){
                if (Initialise.cineplexes.get(k).getMovies().get(j).getMovieTitle().equals(movie.getMovieTitle())){
                    Initialise.cineplexes.get(k).getMovies().get(j).setMovieStatus(movieStatus);
                }
            }
        }
    }
}