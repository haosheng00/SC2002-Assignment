package Classes;
import java.util.ArrayList;
public class Customer extends Account{
    //ADD CLEAR CART TIX METHOD IN CUSTOMER CONTROLLER
    private ArrayList<Ticket> cartTix = new ArrayList<Ticket>();
    private ArrayList<Ticket> boughtTix = new ArrayList<Ticket>();
    private String emailAddress;
    private String mobileNumber;

    public Customer(String s, String p, String email, String phno){
        super(s, p); this.emailAddress = email; this.mobileNumber = phno;
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
        return cartTix;
    }

    public ArrayList<Ticket> getBoughtTix(){
        return boughtTix;
    }

}