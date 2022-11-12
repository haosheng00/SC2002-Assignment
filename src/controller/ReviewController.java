package controller;

import java.io.IOException;
import java.util.*;

import classes.*;
import initialiser.Initialise;
import serialiser.SerializeMovieDB;

/**
 * Represents the controller that can make changes to the reviews of the movies
 */
public class ReviewController {

    /*
     * Constructor of Review Controller
     */
    public ReviewController () {
    }

    /**
     * Adds review for a movie 
     * @param customer customer object 
     * @throws Exception
     */
    public static void addReview(Customer customer) throws Exception {

        Scanner sc = new Scanner(System.in);
        
        int movieIndex = DropDownMenu.initiateMovieChoice_CustomerMenu(0);
        if (movieIndex == -1) {
            //sc.close();
            return;
        }
        
        Movie movie = Initialise.movies.get(movieIndex);
        //check if user alr input review 
        for (int i=0; i<movie.getReviews().size(); i++) {
            if (movie.getReviews().get(i).getUserName().equals(customer.getUserName())) {
                System.out.println("You have previously added a rating for this movie.");
                return;
            }
        }
        String review;
        Double rating;
        System.out.println("Please enter your rating (out of 5): ");
        do {
            try {
                rating = sc.nextDouble();
                if (rating < 0 || rating > 5) {
                    System.out.println("Please enter a positive rating which is less than 5:");
                }
                else {
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a number: ");
                sc.next();
            }
        } while (true);
        System.out.println("Please enter your review: ");
        review = sc.next();

        //get current time
        String dateTime = Initialise.dt.reviewDateTime();

        //add review to the review array of each movie!!
        //get particular movie --> get review array --> add review 
        movie.getReviews().add(new Review(review,rating,customer.getUserName(),dateTime,movie));

         //update the customer past reviews array
        customer.getPastReviews().add(new Review(review,rating,customer.getUserName(),dateTime,movie));
         //write to customer 
        SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);

        //update overallRating 
        double updatedRating = (rating+movie.getOverallRating())/(movie.getReviews().size());
        movie.setOverallRating(updatedRating);

        SerializeMovieDB.writeSerializedObject("Movie.dat", Initialise.movies);
        
        //update top5Rating
        updateTop5Rating(movie);

        System.out.println("Your review has been added.");
    }

    /**
     * Deletes review of customer from a movie 
     * @param customer customer object 
     * @throws IOException
     */
    public static void deleteReview(Customer customer) throws IOException {
        
        int i = 0;
        
        int movieIndex = DropDownMenu.initiateMovieChoice_CustomerMenu(0);
        if (movieIndex == -1) {
            return;
        }

        Movie movie = Initialise.movies.get(movieIndex);
        ArrayList <Review> r = movie.getReviews();
        int size = movie.getReviews().size();
        double oldRating = 0;
        int exist = 0;

        //iterate thru the reviews of each movie to find the particular username
        for (i=0; i<size; i++) {
            if (r.get(i).getUserName().equals(customer.getUserName())) {
                oldRating = r.get(i).getRating();
                r.remove(i);
                exist = 1;
                break;
            }
        }

        if (exist == 0) {
            System.out.println("You have not entered a review for this movie before");
            return;
        }

        ArrayList <Review> reviews = customer.getPastReviews();
        //iterate thru the customers' past reviews array to find review to be deleted (check movie name)
        for (i=0; i<reviews.size(); i++) {
            if (reviews.get(i).getMovie().getMovieTitle().equals(movie.getMovieTitle())) {
                reviews.remove(i);
                break;
            }
        }

        SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);

        //update ratings 
        if (movie.getReviews().size() == 0) {
            movie.setOverallRating(0);
        }
        else {
            double updatedRating = (movie.getOverallRating()-oldRating)/(movie.getReviews().size());
            movie.setOverallRating(updatedRating);
        }

        SerializeMovieDB.writeSerializedObject("Movie.dat", Initialise.movies);

        //update top5Rating
        updateTop5Rating(movie);

        System.out.println("Your review has been deleted.");
    }

    /**
     * Updates the review of a customer
     * @param customer customer object
     * @throws IOException
     */
    public static void updateReview(Customer customer) throws IOException {

        Scanner sc = new Scanner(System.in);

        int i = 0;

        //get movie index 
        int movieIndex = DropDownMenu.initiateMovieChoice_CustomerMenu(0);
        if (movieIndex == -1) {
            return;
        }
        
        int ratingExist = 0;
        int reviewIndex = 0;
        double oldRating = 0;

        Movie movie = Initialise.movies.get(movieIndex);
        ArrayList <Review> reviews = movie.getReviews();
        int size = reviews.size();

        //search whether his rating exists
        for (i=0; i<size; i++) {
            if (reviews.get(i).getUserName().equals(customer.getUserName())) {
                ratingExist = 1;
                reviewIndex = i;
                oldRating = reviews.get(i).getRating();
                break;
            }
        }

        //if rating doesn't exists
        if (ratingExist == 0) {
            System.out.println("You have not entered a review for this movie before.");
            return;
        }

        //if rating exists
        System.out.println("Old Review: ");
        System.out.println();
        System.out.println("Time of Review: " + reviews.get(i).getDateTime());
        System.out.println("Rating: " + reviews.get(i).getRating());
        System.out.println("Review: " + reviews.get(i).getDescription());
        System.out.println();
        String review;
        Double rating;

        System.out.println("Please enter your new rating (out of 5): ");
        do {
            try {
                rating = sc.nextDouble();
                if (rating < 0 || rating > 5) {
                    System.out.println("Please enter a positive rating which is less than 5:");
                }
                else {
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Invalid input. Please enter a number: ");
                sc.next();
            }
        } while (true);
        System.out.println("Please enter your new review: ");
        review = sc.next();
        String dateTime = Initialise.dt.reviewDateTime();

        //delete review from Reviews array 
        reviews.remove(reviewIndex);
        //add review to the end of Reviews array -- ensure that review array is updated by time
        reviews.add(new Review(review, rating, customer.getUserName(), dateTime, movie));

        ArrayList <Review> cusReviews = customer.getPastReviews();
        //update customer array 
        //iterate thru the customers' past reviews array to find review to be deleted (check movie name)
        for (i=0; i<cusReviews.size(); i++) {
            if (cusReviews.get(i).getMovie().getMovieTitle() == movie.getMovieTitle()) {
                cusReviews.remove(i);
                break;
            }
        }

        cusReviews.add(new Review(review, rating, customer.getUserName(), dateTime, movie));
        
        SerializeMovieDB.writeSerializedObject("Customer.dat", Initialise.customers);       
                
        //update overallRating 
        double updatedRating = (movie.getOverallRating()-oldRating+rating)/(movie.getReviews().size());
        movie.setOverallRating(updatedRating);

        SerializeMovieDB.writeSerializedObject("Movie.dat", Initialise.movies);

        //update top5Rating
        updateTop5Rating(movie);

        System.out.println("Your review has been updated.");
    }

    /**
     * Updates the array which contains the movies with the top 5 ratings 
     * @param movie movie object
     * @throws IOException
     */
    public static void updateTop5Rating(Movie movie) throws IOException {

        //System.out.println("Updated Rating" + movie.getOverallRating());

        int exist = 0;

        //update top5 sales array 
        ArrayList <Movie> top5Ratings = Initialise.top5ByRatings;
        //check if movie is alr in the top5ratings 
        for (int i=0; i< top5Ratings.size(); i++) {
            if (movie.getMovieTitle().equals(top5Ratings.get(i).getMovieTitle())) {
                exist = 1;
                top5Ratings.set(i,movie);
                //if movie's reviews size is 0, remove from top 5 ratings
                if (movie.getReviews().size() == 0) {
                    top5Ratings.remove(i);
                }
                break;
            }
        }
        //add movie into the top5ratings array (if it isn't alr in the top5array)
        if (exist == 0) {
            top5Ratings.add(movie);
        }
        //sort the array 
        Collections.sort(top5Ratings, new CompareByRating());
        //remove last index if (size > 5)
        if (top5Ratings.size() > 5) {
            //remove the sixth movie 
            top5Ratings.remove(5);
        }

        SerializeMovieDB.writeSerializedObject("Top5ByRatings.dat", Initialise.top5ByRatings);
    }

    /**
     * Compares two movies by their overall ratings
     */
    static class CompareByRating implements Comparator<Movie> {
        public int compare(Movie a, Movie b) {
                    return (int)(b.getOverallRating() - a.getOverallRating());
        }   
    }

    /**
     * Prints the reviews of a customer 
     * @param customer customer object 
     */
    public static void printCustomerReviews(Customer customer) {
        ArrayList <Review> reviews = customer.getPastReviews();
        System.out.println("Reviews of " + customer.getUserName());
        for (int i=0; i<reviews.size(); i++) {
            System.out.println("Time of Review: " + reviews.get(i).getDateTime());
            System.out.println("Movie: " + reviews.get(i).getMovie().getMovieTitle());
            System.out.println("Rating: " + reviews.get(i).getRating());
            System.out.println("Review: " + reviews.get(i).getDescription());
            System.out.println();
        }
    }

    /**
     * Prints all the reviews of a movie 
     * @param movie movie object 
     */
    public static void printMovieReviews(Movie movie) {
        
        int lastIndex = movie.getReviews().size()-1;

        System.out.println(movie.getMovieTitle() + " Reviews:");

        for (int i=lastIndex; i>=0; i--) {
            Review r = movie.getReviews().get(i);
            System.out.println("Time of Review: " + r.getDateTime());
            System.out.println("Username: " + r.getUserName());
            System.out.println("Rating: " + r.getRating());
            System.out.println("Review: " + r.getDescription());
        }
    }
}
