import java.util.Scanner;
import java.util.TimeZone;

public class ScreeningUI {
    public static void screeningOptions(Cineplex cineplex) {
        String movieTitle;
        int option = 0;
        boolean exit = false;
        do {
            System.out.println("========================================");
            System.out.println("Welcome to MOBLIMA ScreeningController for " + cineplex.getCineplexName() + " cineplex");
            System.out.println("Please select an option:");
            System.out.println("(1) Add Screening");
            System.out.println("(2) Delete Screening");
            System.out.println("(3) Update Screening");
            System.out.println("(4) Show Screening");
            System.out.println("(5) Go Back To Previous Page");
            System.out.println("========================================");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            //TODO: Screening Manager to be created at Initialise
            switch (option) {
                case 1:
                    ScreeningController.addScreening(cineplex);
                    break;
                case 2:
                    ScreeningController.deleteScreening(cineplex);
                    break;
                case 3:
                    ScreeningController.updateScreening(cineplex);
                    break;
                case 4:
                    ScreeningController.showScreening(cineplex);
                    break;
                case 5:
                    break;
                default:
                    System.out.println("Invalid Input");
            }
    }while (option != 5);
    }}

