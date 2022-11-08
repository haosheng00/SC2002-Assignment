package classes;

import java.io.Serializable;

public class Payment implements Serializable{
    //only method of payment is thru credit card - online purchase

    //transaction ID
    // XXXYYYYMMDDhhmm (Y : year, M : month, D : day, h : hour,
    // m :minutes, XXX : cinema code in letters)
    private int TID;
    //sum of all the charges
    private double totalCharges;
    //customer's credit card name
    private String CreditCardName;
    //customer's card expiration date
    private String CardExpirationDate;
    //customer's billing address
    private String billingAddress;
    //customer's billing card number
    private String billingCardNumber;
    

    //constructor
    public Payment (int TID, double totalCharges, String CreditCardName, String CardExpirationDate, String billingAddress, String billingCardNumber) {
        this.TID = TID;
        this.totalCharges = totalCharges;
        this.CreditCardName = CreditCardName;
        this.CardExpirationDate = CardExpirationDate;
        this.billingAddress = billingAddress;
        this.billingCardNumber = billingCardNumber;
    }

    //get set for all variables
    public int getTID() { return TID; }
    public void setTID(int TID) { this.TID = TID;}

    public double getTotalCharges() { return totalCharges; }
    public void setTotalCharges(double totalCharges) { this.totalCharges = totalCharges;}

    public String getCardExpirationDate() { return CardExpirationDate; }
    public void setCardExpirationDate(String CardExpirationDate) { this.CardExpirationDate = CardExpirationDate;}

    public String getCreditCardName() { return CreditCardName; }
    public void setCreditCardName(String CreditCardName) { this.CreditCardName = CreditCardName;}

    public String getBillingAddress() { return billingAddress; }
    public void setBillingAddress(String billingAddress) { this.billingAddress = billingAddress;}

    public String getBillingCardNumber() { return billingCardNumber; }
    public void setBillingCardNumber(String billingCardNumber) { this.billingCardNumber = billingCardNumber;}

}
