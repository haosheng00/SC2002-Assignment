package controller;
import java.util.Scanner;

import initialiser.Initialise; 

/**
 * Includes the searchAdmin method to check if user is admin
 */
public class AdminController {
    static Scanner sc = new Scanner(System.in);
/**
 * Transverses through the admins array list check if entered username below to an existing admin
 * @param username username entered by user
 * @return index of admin in array list if username is an admin; -1 if username not found in admins array list
 */
    public static int searchAdmin(String username){
        //System.out.println("Commencing search in admins");
        for(int i=0; i<Initialise.admins.size(); i++){
            //System.out.println("iterating through for loop. Username: " + admins.get(i).getUserName());
            if(username.equals(Initialise.admins.get(i).getUserName())){
                //System.out.println("returning"+ i);
                return i;
            }
        }
        return -1;
        
    }
}
