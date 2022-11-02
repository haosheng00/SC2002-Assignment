import java.util.ArrayList;
import java.util.Scanner;
import java.util.Iterator;

public class ReviewController {

    private ArrayList<Review> Reviews;

    Scanner sc = new Scanner(System.in);
    public void addReview(String userName, Movie movie) {
        String review;
        Double rating;
        System.out.println("Please enter your rating: ");
        rating = sc.nextDouble();
        //need to account for if they dw enter review?
        System.out.println("Please enter your review: ");
        review = sc.next();
        //how to get the DATETIME?
        Reviews.add(new Review(review,rating,userName, dateTime,movie));
    }


    //iterate thru the reviews to find the particular username

    public void deleteReview(String userName, Movie movie) {
        int size = Reviews.size();
        for (int i=0; i<size; i++) {
            if (Reviews[i].getUserName() == userName) {
                //delete review
            }
        }
    }

    public void updateReview(String userName, Movie movie) {
        String review;
        Double rating;
        System.out.println("Please enter your rating: ");
        rating = sc.nextDouble();
        //need to account for if they dw enter review?
        System.out.println("Please enter your review: ");
        review = sc.next();
        int size = Reviews.size();
        for (int i=0; i<size; i++) {
            if (Reviews[i].getUserName() == userName) {
                Reviews.add(i, new Review(review,rating,userName, dateTime,movie));
            }
        }
    }

    //print what review - of each customer - of all reviews of a movie?
    public void printReview(Movie movie) {


    }

    public void listTop5Rating (Movie movie) {

//        i.Ticket sales (display the movie title and total sales)
//        ii. Overall reviewers’ rating (display the movie title and overall
//                rating)

    }













}
