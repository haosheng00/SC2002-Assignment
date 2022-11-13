package classes;

import java.io.Serializable;

/**
 * Includes the get and set methods for payment related details
 */
public class Payment implements Serializable{

    /**
     * Represents the transaction ID in the format XXXYYYYMMDDhhmm (Y : year, M : month, D : day, h : hour,
     * m : minutes, XXX : cinema code in letters)
     */
    private String TID;
    /** 
      Represents the sum of all the ticket charges
     */
    private double totalCharges;
    /** 
     * Represents the customer's name on the credit card to be utilised
     */
    private String CreditCardName;
    /**
     * Represents the expiry date of the customer's credit card in the format MMYY
     */
    private String CardExpirationDate;
    /**
     * Represents the customer's billing address registered to the credit card used
     */
    private String billingAddress;
    /**
     * Represents the customer's billing credit card number
     */
    private String billingCardNumber;
    
    /**
     * Represents the details of the particular payment made with the following details:
     * transaction ID, total ticket charges, cardholder's name, card expiry date, billing address and card number
     * @param TID transaction ID
     * @param totalCharges total ticket charges to be paid
     * @param CreditCardName cardholder's name
     * @param CardExpirationDate expiry date of card used in format MMYY
     * @param billingAddress billing address registered to card used
     * @param billingCardNumber credit card number
     */
    public Payment (String TID, double totalCharges, String CreditCardName, String CardExpirationDate, String billingAddress, String billingCardNumber) {
        this.TID = TID;
        this.totalCharges = totalCharges;
        this.CreditCardName = CreditCardName;
        this.CardExpirationDate = CardExpirationDate;
        this.billingAddress = billingAddress;
        this.billingCardNumber = billingCardNumber;
    }

    /**
     * Returns the transaction ID of the payment
     * @return transaction ID
     */
    public String getTID() { return TID; }

    /**
     * Sets/Updates the transaction ID of the payment
     * @param TID transaction ID
     */
    public void setTID(String TID) { this.TID = TID;}

    /**
     * Returns the total ticket cost to be charged to payment
     * @return total ticket charges
     */
    public double getTotalCharges() { return totalCharges; }

    /**
     * Sets/Updates the total ticket cost to be charged to payment
     * @param totalCharges total ticket charges
     */
    public void setTotalCharges(double totalCharges) { this.totalCharges = totalCharges;}

    /**
     * Returns the expiry date of the credit card used for payment
     * @return expiry date of card in format MMYY
     */
    public String getCardExpirationDate() { return CardExpirationDate; }

    /**
     * Sets/Updates the expiry date of the credit card used for payment
     * @param CardExpirationDate expiry date of card in format MMYY
     */
    public void setCardExpirationDate(String CardExpirationDate) { this.CardExpirationDate = CardExpirationDate;}

    /**
     * Returns the cardholder's name on the credit card used
     * @return cardholder's name
     */
    public String getCreditCardName() { return CreditCardName; }

    /**
     * Sets/Updates the cardholder's name on the credit card used
     * @param CreditCardName cardholder's name
     */
    public void setCreditCardName(String CreditCardName) { this.CreditCardName = CreditCardName;}

    /**
     * Returns the billing address registered to the credit card used
     * @return billing address
     */
    public String getBillingAddress() { return billingAddress; }

    /**
     * Sets/Updates the billing address registered to the credit card used
     * @param billingAddress billing address
     */
    public void setBillingAddress(String billingAddress) { this.billingAddress = billingAddress;}

    /**
     * Returns the number of the card used for payment
     * @return credit card number
     */
    public String getBillingCardNumber() { return billingCardNumber; }

    /**
     * Sets/Updates the number of the card used for payment
     * @param billingCardNumber credit card number
     */
    public void setBillingCardNumber(String billingCardNumber) { this.billingCardNumber = billingCardNumber;}

}
