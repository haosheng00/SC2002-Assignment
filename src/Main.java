import initialiser.Initialise;
import ui.ScreeningUI;
import ui.AccountUI;
import ui.ReviewUI;
import ui.MovieUI;
import ui.PaymentUI;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import classes.*;
import controller.PaymentController;

public class Main {
    public static void main(String[] args) throws Exception {
        Initialise.initialiseMOBLIMA();
        
        // AdminMenuUI.adminMenuOptions();

         AccountUI.WelcomePage();
        //ReviewUI.initiateReviewUI(Initialise.customers.get(1));
        // FOR MOVIE TESTING
        // MovieUI.initiateMovieUI();

        // Customer customer = new Customer(null, null, null, null);
        // CustomerMenuUI.customerMenuOptions(customer);

        // FOR REVIEW TESTING
        
        // Movie movie = new Movie("Joy");
        // Initialise.movies.get(0).getReviews().add(new Review("amazing",
        // 2.0, null, null, movie));
        //ReviewUI.initiateReviewUI(Initialise.customers.get(0));

        // FOR PAYMENT TESTING
        // CustomerController.getCustomersList().get(0).getCartTickets().add(new
        // Ticket(null, null, null, null, null, new Seat(), 0));
        // PaymentUI.initiatePaymentUI(Initialise.customers.get(0));

        // FOR SCREENING TESTING
        //ScreeningUI.initiateScreeningUI();

        // the Date and time at which you want to execute
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormatter.parse("2022-11-10 00:00:00");
        Timer timer = new Timer();

        timer.schedule(new MyTimeTask(), date, 1000 * 60 * 60 * 24);

    }

}