package classes;
import java.io.Serializable;
import java.util.ArrayList;
public class Customer extends Account implements Serializable{
    private ArrayList<Ticket> cartTickets;
    private ArrayList<Ticket> boughtTickets;
    private ArrayList<Review> pastReviews;
    private String emailAddress;
    private String mobileNumber;

    public Customer(String username, String password, String email, String mobileno){
        super(username, password, false);
        this.emailAddress = email;
        this.mobileNumber = mobileno;
        this.cartTickets = new ArrayList<>();
        this.boughtTickets = new ArrayList<>();
        this.pastReviews = new ArrayList<>();
    }

    public void setEmailAddress(String email){
        this.emailAddress = email;
    }

    public void setMobileNumber(String phno){
        this.mobileNumber = phno;
    }

    public String getEmailAddress(){
        return emailAddress;
    }
    public String getMobileNumber(){
        return mobileNumber;
    }

    public ArrayList<Ticket> getCartTickets(){
        return cartTickets;
    }

    public ArrayList<Ticket> getBoughtTickets(){
        return boughtTickets;
    }

    public void setBoughtTickets(ArrayList<Ticket> boughtTickets){
        this.boughtTickets = boughtTickets;
    }

    public ArrayList<Review> getPastReviews (){
         return pastReviews;
    }
    

    }
