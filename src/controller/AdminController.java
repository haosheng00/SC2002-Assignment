package controller;
import java.util.ArrayList;
import java.util.Scanner;

import classes.Admin;
import initialiser.Initialise; 
public class AdminController {
    static Scanner sc = new Scanner(System.in);
    private static ArrayList<Admin> admins = Initialise.admins;

    public static ArrayList<Admin> getAdminsList(){
        return admins;
    }

    public static int searchAdmin(String username){
        for(int i=0; i<admins.size(); i++){
            if(admins.get(i).getUserName() == username){
                return i;
            }
        }
        return -1;
    }
}
