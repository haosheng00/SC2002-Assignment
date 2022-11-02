package controller;
import java.util.ArrayList;
import java.util.Scanner;

import Classes.Admin; 
public class AdminController {
    Scanner sc = new Scanner(System.in);
    private  ArrayList<Admin> admins;

    public AdminController(ArrayList<Admin> adminList){
        this.admins = adminList;
    }

    public ArrayList<Admin> getAdminsList(){
        return admins;
    }

    public int searchAdmin(String username){
        for(int i=0; i<admins.size(); i++){
            if(admins.get(i).getUserName() == username){
                return i;
                
            }
        }
        return -1;
    }
}
