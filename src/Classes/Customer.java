package classes;
import java.util.ArrayList;
public class Customer extends Account{
    private ArrayList<Ticket> cartTickets = new ArrayList<Ticket>();
    private ArrayList<Ticket> boughtTickets = new ArrayList<Ticket>();
    private String emailAddress;
    private String mobileNumber;

    public Customer(String username, String password, String email, String mobileno){
        super(username, password, false ); this.emailAddress = email; this.mobileNumber = mobileno;
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
}