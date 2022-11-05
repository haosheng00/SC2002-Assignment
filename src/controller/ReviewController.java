package controller;

import java.util.ArrayList;
import java.util.Scanner;
import Initialiser.Initialise;
import Classes.*;

public class ReviewController {
    //DO WE NEED A ARRAYLIST OF REVIEWS? OR JUST ARRAYLIST OF EACH MOVIE WILL DO?
    private ArrayList<Review> Reviews;

    public ReviewController (ArrayList <Review> Reviews) {
        this.Reviews = Reviews;
    }

    //TODO: UPDATE TOP5 REVIEWS 

    //returns the index of the movie in the Movie array 
    public static int searchMovie() {

        Scanner sc = new Scanner(System.in);
        String movieTitle;
        int exist;
        int choice;

        //TODO: DO DROPDOWN OF MOVIES

        //get movie name 
        System.out.println("Please enter the title of the movie:");
        movieTitle = sc.next();
        //search movie to see if it exists 
        //static method 
        exist = MovieController.searchMovie(movieTitle);
        //non-static method 
        //exist = Initialise.mc.searchMovie(movieTitle);
        while (exist == 0) {
            System.out.println("The movie does not exist!");
            System.out.println("Would you like to enter the movie title again? (Click 0 for No and 1 for Yes)");
            choice = sc.nextInt();
            if (choice == 0) {
                System.out.println("Returning...");
                return -1;
            }
            System.out.println("Please enter the title of the movie:");
            movieTitle = sc.next();
            exist = MovieController.searchMovie(movieTitle);
        }
        return exist;
    }    
    public static void addReview(Customer customer) {

        Scanner sc = new Scanner(System.in);
        
        int movieIndex = searchMovie();
        if (movieIndex == -1) {
            return;
        }
        
        String review;
        Double rating;
        System.out.println("Please enter your rating: ");
        rating = sc.nextDouble();
        System.out.println("Please enter your review: ");
        review = sc.next();

        //get current time
        String dateTime = Initialise.dt.reviewDateTime();

        //add review to the review array of each movie!!
        //get particular movie --> get review array --> add review 
        Movie movie = Initialise.Movies.get(movieIndex);
        movie.getReviews().add(new Review(review,rating,customer.getUserName(),dateTime,movie));

        //add review to all reviews array - NEED???
        //Reviews.add(new Review(review,rating,userName,dateTime,movie));

        //update overallRating 
        double updatedRating = (rating+movie.getOverallRating())/(movie.getReviews().size());
        movie.setOverallRating(updatedRating);

        System.out.println("Your review has been added.");
    }

    //iterate thru the reviews to find the particular username
    public static void deleteReview(Customer customer) {
        int movieIndex = searchMovie();
        if (movieIndex == -1) {
            return;
        }

        Movie movie = Initialise.Movies.get(movieIndex);
        ArrayList <Review> r = movie.getReviews();
        int size = movie.getReviews().size();
        double oldRating = 0;
        //iterate thru the reviews of each movie to find the particular username
        for (int i=0; i<size; i++) {
            if (r.get(i).getUserName() == customer.getUserName()) {
                oldRating = r.get(i).getRating();
                r.remove(i);
                break;
            }
        }

        //NEED TO REMOVE FROM OVERALL REVIEWS LIST???

        //update ratings 
        double updatedRating = (movie.getOverallRating()-oldRating)/(movie.getReviews().size());
        movie.setOverallRating(updatedRating);

        System.out.println("Your review has been deleted.");
    }

    public static void updateReview(Customer customer) {

        Scanner sc = new Scanner(System.in);

        //get movie index 
        int movieIndex = searchMovie();
        if (movieIndex == -1) {
            return;
        }
        
        int ratingExist = 0;
        int reviewIndex = 0;
        double oldRating = 0;

        Movie movie = Initialise.Movies.get(movieIndex);
        ArrayList <Review> reviews = movie.getReviews();
        int size = reviews.size();

        //search whether his rating exists
        for (int i=0; i<size; i++) {
            if (reviews.get(i).getUserName() == customer.getUserName()) {
                ratingExist = 1;
                reviewIndex = i;
                oldRating = reviews.get(i).getRating();
                break;
            }
        }

        //if rating doesn't exists
        if (ratingExist == 0) {
            System.out.println("You have not entered a rating for this movie before.");
            return;
        }

        //if rating exists
        String review;
        Double rating;
        System.out.println("Please enter your new rating: ");
        rating = sc.nextDouble();
        System.out.println("Please enter your new review: ");
        review = sc.next();
        String dateTime = Initialise.dt.reviewDateTime();

        //delete review from Reviews array 
        reviews.remove(reviewIndex);
        //add review to the end of Reviews array -- ensure that review array is updated by time
        reviews.add(new Review(review, rating, customer.getUserName(), dateTime, movie));
        
        // //Update reviews array for movie
        // reviews.get(reviewIndex).setDescription(review);
        // reviews.get(reviewIndex).setRating(rating);
        // reviews.get(reviewIndex).setDateTime(dateTime);

        //NEED TO UPDATE FOR OVERALL REVIEWS ARRAY???
                
        //update overallRating 
        double updatedRating = (movie.getOverallRating()-oldRating+rating)/(reviews.size());
        movie.setOverallRating(updatedRating);

        System.out.println("Your review has been updated.");
    }

    //print all reviews of movie -- sort by dateTime 
    public static void printReview(Movie movie) {
        
        int lastIndex = movie.getReviews().size()-1;

        System.out.println(movie.getMovieTitle() + " Reviews");

        for (int i=lastIndex; i>=0; i++) {
            Review r = movie.getReviews().get(i);
            System.out.println("Time of Review: " + r.getDateTime());
            System.out.println("Username: " + r.getUserName());
            System.out.println("Rating: " + r.getRating());
            System.out.println("Review: " + r.getDescription());
        }
    }
}
