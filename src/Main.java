
import initialiser.Initialise;
import ui.*;

import java.util.*;
import java.text.*;
import classes.*;
import controller.CustomerController;
import controller.MovieController;

public class Main {
    public static void main(String[] args) throws Exception {
        //Initialise.initialiseEverything();
        //AdminMenuUI.adminMenuOptions();
        
        //AccountUI.WelcomePage();
        //MovieUI.initiateMovieUI();
        // Customer customer = new Customer(null, null, null, null);
        // CustomerMenuUI.customerMenuOptions(customer);


        //FOR REVIEW TESTING
        // ReviewUI.initiateReviewUI(CustomerController.getCustomersList().get(0));
        // Movie movie = new Movie("Joy");
        // MovieController.getMovieList().get(0).getReviews().add(new Review("amazing", 2.0, null, null, movie));

        //FOR PAYMENT TESTING
        // CustomerController.getCustomersList().get(0).getCartTickets().add(new Ticket(null, null, null, null, null, null, 0));
        // PaymentUI.initiatePaymentUI(CustomerController.getCustomersList().get(0));

        //the Date and time at which you want to execute
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormatter.parse("2022-11-10 00:00:00");
        Timer timer = new Timer();

        timer.schedule(new MyTimeTask(), date, 1000*60*60*24);




    }

}