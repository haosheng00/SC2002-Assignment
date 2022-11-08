package classes;

import java.io.Serializable;

public class Admin extends Account implements Serializable{
    public Admin(String username, String password){
        super(username, password, true);
    } 
}
