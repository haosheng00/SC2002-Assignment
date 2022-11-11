package classes;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * Represents a customer account in MOBLIMA
 */
public class Customer extends Account implements Serializable{
/**
 * Represents tickets in this customer's cart
 * Cart empties after each use 
 */
    private ArrayList<Ticket> cartTickets;
/**
 * Represents tickets this customer purchased in the past
 */
    private ArrayList<Ticket> boughtTickets;
/**
 * Represent the past movie reviews of this customer
 */
    private ArrayList<Review> pastReviews;
/**
 * Represents the email address of this customer
 */
    private String emailAddress;
/**
 * Represents the mobile number of this customer
 */
    private String mobileNumber;

    /**
     * Creates a customer account with this username, password, email address and mobile number
     * Account is created with an empty cart, ticket history and review history
     * @param username this customer's username
     * @param password this customer's password
     * @param email this customer's email address 
     * @param mobileno this customer's mobile number 
     */
    public Customer(String username, String password, String email, String mobileno){
        super(username, password, false);
        this.emailAddress = email;
        this.mobileNumber = mobileno;
        this.cartTickets = new ArrayList<>();
        this.boughtTickets = new ArrayList<>();
        this.pastReviews = new ArrayList<>();
    }
/**
 * To set a new email address for this customer 
 * @param email this customer's email
 */
    public void setEmailAddress(String email){
        this.emailAddress = email;
    }
/**
 * To set a new mobile number for this customer
 * @param phno this customer's mobile number
 */
    public void setMobileNumber(String phno){
        this.mobileNumber = phno;
    }
/**
 * To set a new email address for this customer
 * @return this customer's email address
 */
    public String getEmailAddress(){
        return emailAddress;
    }
    /**
     * To get a new mobile number for this customer 
     * @return this customer's email address
     */
    public String getMobileNumber(){
        return mobileNumber;
    }
/**
 * To get the tickets in the cart of this customer's account
 * @return an array of this customer's cart tickets 
 */
    public ArrayList<Ticket> getCartTickets(){
        return cartTickets;
    }
/**
 * To get all the tickets the customer ever purchased 
 * @return an array of this customer's past ticket purchases 
 */
    public ArrayList<Ticket> getBoughtTickets(){
        return boughtTickets;
    }
/**
 * To set the purchase history of this customer 
 * @param boughtTickets an array of customer's past ticket purchases 
 */
    public void setBoughtTickets(ArrayList<Ticket> boughtTickets){
        this.boughtTickets = boughtTickets;
    }
/**
 * To get the past reviews of this customer 
 * @return an array of past reviews of this customer 
 */
    public ArrayList<Review> getPastReviews (){
         return pastReviews;
    }
    

    }
