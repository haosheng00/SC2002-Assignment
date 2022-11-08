package controller;
import java.util.ArrayList;
import java.util.Scanner;

import classes.Admin;
import initialiser.Initialise; 
public class AdminController {
    static Scanner sc = new Scanner(System.in);
    //private static ArrayList<Admin> admins = Initialise.admins;

//    public static ArrayList<Admin> getAdminsList(){
//        return admins;
//    }

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
