package Classes;
import Initialiser.Initialise;
import ui.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;

import Classes.*;

public class Main {
    public static void main(String[] args) throws Exception {
        Initialise.initialiseEverything();
        AccountUI.WelcomePage();

        //the Date and time at which you want to execute
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = dateFormatter .parse("2022-11-10 00:00:00");
        Timer timer = new Timer();

        //timer.schedule(new )


        


        }
    }