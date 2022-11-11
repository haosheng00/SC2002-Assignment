package controller;
import java.util.Scanner;

import initialiser.Initialise; 

/**
 * Includes the searchAdmin method to check if user is admin
 */
public class AdminController {
    static Scanner sc = new Scanner(System.in);

/**
 * Transverse through the admins array list check if entered username belongs to an existing admin
 * @param username username entered by user
 * @return index of admin in array list if username belongs to an admin; -1 if username not found in admins array list
 */
    public static int searchAdmin(String username){
        for(int i=0; i<Initialise.admins.size(); i++){
            if(username.equals(Initialise.admins.get(i).getUserName())){
                return i;
            }
        }
        return -1;
        
    }
}
