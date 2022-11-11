package classes;

import java.io.Serializable;
/**
 * Represents an account in MOBLIMA
 * An account can be either a customer or admin account
 */
public class Account implements Serializable{
    /**
     * The username of this account
     */
    private String userName;
    /**
     * The password of this account
     */
    private String password;
    /**
     * Represents the account type (Customer/Admin) 
     * check whether this account is a customer account or admin account
     */
    private boolean isAdmin;

    /**
     * Constructs an account object with the given username or password
     * Customer account - isAdmin is false 
     * Addmin account - isAdmin will be true
     * @param username username of this account
     * @param password password of this account
     * @param isAdmin what type of account this is(admin/customer)
     */
    public Account(String username, String password, boolean isAdmin){
        this.userName = username;
        this.password = password;
        this.isAdmin = isAdmin;
    }
    /**
     * To get the username of this account
     * @return this account's username
     */
    public String getUserName(){
        return this.userName;
    }

    /**
     * To get the password of this account
     * @return this account's password 
     */
    public String getPassword(){
        return this.password;
    }

    /**
     * To get this account's type (Customer or account)
     * @return isAdmin attribute 
     */

    public boolean getIsAdmin(){
        return this.isAdmin;
    }

    /**
     * To set a new username for this account 
     * @param s represents the new username of this acount
     */
    public void setUserName(String s){
        this.userName = s;
    } 

    /**
     * To set a new password of this account
     * @param p represents the new password of this account 
     */
    public void setPassword(String p){
        this.password = p;
    }
    /**
     * To set the account type of this account(Customer/Admin)
     * @param isAdmin represents the account type of this account
     */
    public void setIsAdmin(boolean isAdmin){
        this.isAdmin = isAdmin;
    }


}
