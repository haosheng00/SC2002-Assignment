package controller;

import java.util.ArrayList;
import java.util.Scanner;
import Initialiser.Initialise;
import Classes.*;

public class ReviewController {


    //DO WE NEED A ARRAYLIST OF REVIEWS? OR JUST ARRAYLIST OF EACH MOVIE WILL DO?
    private ArrayList<Review> Reviews;

    Scanner sc = new Scanner(System.in);

    public ReviewController (ArrayList <Review> Reviews) {
        this.Reviews = Reviews;
    }

    //returns the index of the movie in the Movie array 
    public int searchMovie() {
        String movieTitle;
        int exist;
        int choice;
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
    public void addReview(String userName) {
        
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

        //add review to the review array of each movie!!
        //get particular movie --> get review array --> add review 
        Movie movie = Initialise.Movies.get(movieIndex);
        movie.getReview().add(new Review(review,rating,userName,dateTime,movie));
        //how to get the DATETIME?
        //add review to all reviews array 
        Reviews.add(new Review(review,rating,userName,dateTime,movie));

        //update overallRating 
        double updatedRating = (rating+movie.getOverallRating())/(movie.getReview().size());
        movie.setOverallRating(updatedRating);
    }

    //iterate thru the reviews to find the particular username
    public void deleteReview(String userName) {
        int movieIndex = searchMovie();
        if (movieIndex == -1) {
            return;
        }

        Movie movie = Initialise.Movies.get(movieIndex);
        //iterate thru the reviews of each movie to find the particular username
        for (Review r: movie.getReview()) {
            if (r.getUserName() == userName) {
                r.remove(movieIndex);
            }
        }

        //NEED TO REMOVE FROM OVERALL REVIEWS LIST

        //update ratings 
        double updatedRating = (movie.getOverallRating())/(movie.getReview().size());
        movie.setOverallRating(updatedRating);
    }

    public void updateReview(String userName) {
        int movieIndex = searchMovie();
        if (movieIndex == -1) {
            return;
        }
        int ratingExist = 0;
        int reviewIndex;
        double oldRating;

        Movie movie = Initialise.Movies.get(movieIndex);
        ArrayList <Review> reviews = movie.getReview();
        int size = reviews.size();

        //search whether his rating exists
        for (int i=0; i<size; i++) {
            if (reviews.get(i).getUserName() == userName) {
                ratingExist = 1;
                reviewIndex = i;
                oldRating = reviews.get(i).getRating();
                break;
            }
        }
        //if rating don't exist 
        if (ratingExist == 0) {
            System.out.println("You have not entered a rating for this movie before.");
            return;
        }
        String review;
        Double rating;
        System.out.println("Please enter your new rating: ");
        rating = sc.nextDouble();
        System.out.println("Please enter your new review: ");
        review = sc.next();

        //Update reviews array for movie
        reviews.get(reviewIndex).setDescription(review);
        reviews.get(reviewIndex).setRating(rating);
        reviews.get(reviewIndex).setDateTime(dateTime);

        //NEED TO UPDATE FOR OVERALL REVIEWS ARRAY???
                
        //update overallRating 
        double updatedRating = (movie.getOverallRating()-oldRating+rating)/(reviews.size());
        movie.setOverallRating(updatedRating);
    }

    //print reviews of movie -- sort by dateTime
    public void printReview(Movie movie) {


        


    }

}
