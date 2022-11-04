package ui;

import java.util.ArrayList;
import java.util.Scanner;

public class CineplexUI {
    public static void cineplexOptions(ArrayList<Cineplex> cineplexes){
        Scanner sc = new Scanner(System.in);
        int option = 0;
        int i = 0;
        boolean exit = false;

        do{
            System.out.println("========================================");
            System.out.println("Which Cineplex would you like to visit?");
            for (i = 1; i <= cineplexes.size(); i++) {
                System.out.println("(" + i + ")" + cineplexes.get(i - 1).getCineplexName());
            }
            option = sc.nextInt();
            if ((option > 0 && option < i)){
                ScreeningUI.screeningOptions(cineplexes.get(option-1));
            }
            else {
                System.out.println("Do you want to exit? (y/n)");
                char response = sc.next().charAt(0);
                if (response == 'y' || response == 'Y') {
                    System.out.println("Exit successful");
                    exit = true;
                }
            }
        }while(!exit);
    }
}
