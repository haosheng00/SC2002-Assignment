package classes;

import java.io.Serializable;
/**
 * Represents an admin account in MOBLIMA
 */
public class Admin extends Account implements Serializable{
    /**
     * Constructs an admin account with this username and password
     * @param username username of this account
     * @param password password of this account
     */
    public Admin(String username, String password){
        super(username, password, true);
    } 
}
