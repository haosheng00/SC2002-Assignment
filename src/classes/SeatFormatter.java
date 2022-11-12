package classes;

import java.io.Serializable;
import java.util.Scanner;

import initialiser.Initialise;

/**
 * Represents the seat formatter class that will help edit the seats
 */
public class SeatFormatter implements Serializable{
    static Scanner sc = new Scanner(System.in);

    /**
     * Formats the seatID of the seat given row letter and column number
     * @param rowChoice, the row letter of the seat
     * @param columnChoice, the column number of the seat
     * @return the seatID of the seat
     */
    public static String seatIdFormat(char rowChoice, int columnChoice) {
        String seatID;
        if (columnChoice < 10) {
            seatID = rowChoice + String.format("%02d", columnChoice);
        } else {
            seatID = rowChoice + String.valueOf(columnChoice);
        }
        return seatID;
    }

    /**
     * Asks the user to select a particular seat in the screening and checks if the seat is valid
     * @param screening, which has the seats to be checked
     * @return the valid seat object chosen
     */
    public static Seat checkIfValidSeat(Screening screening) {
        char rowChoice = 'Z';
        int columnChoice = 99;
        do{
        System.out.println("Enter Row Letter:");
        do {
            rowChoice = sc.next().charAt(0);
            if ((rowChoice >= 'A' && rowChoice <= 'Z') || (rowChoice >= 'a' && rowChoice <= 'z')) {
                rowChoice = Character.toUpperCase(rowChoice);
                break;
            }
            System.out.println("Invalid input. Please enter a Character: ");
        } while (true);
        System.out.println("Enter Column Number:");
        do {
            try {
                columnChoice = sc.nextInt();
                break;
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter an integer: ");
                sc.next();
            }
        } while (true);

        String seatIdChoice = SeatFormatter.seatIdFormat(rowChoice, columnChoice);
        System.out.print(seatIdChoice);
        System.out.println(" successfully added to cart");
        if (screening.getCinema().getCinemaType() == Enum.CinemaType.ORDINARY) {
            for (int i = 0; i < Initialise.Ordinary_Capacity; i++) {
                if (seatIdChoice.equals(screening.getSeat(i).getSeatId())) {
                    if (!screening.getSeat(i).getIsBooked() && !screening.getSeat(i).getIsReserved()) {
                        screening.getSeat(i).setIsReserved(true);
                        return screening.getSeat(i);
                    }
                }
            }
        } else if (screening.getCinema().getCinemaType() == Enum.CinemaType.PLATINUMMOVIESUITES) {
            for (int i = 0; i < Initialise.Plat_Capacity; i++) {
                if (seatIdChoice.equals(screening.getSeat(i).getSeatId())) {
                    if (!screening.getSeat(i).getIsBooked() && !screening.getSeat(i).getIsReserved()) {
                        screening.getSeat(i).setIsReserved(true);
                        return screening.getSeat(i);
                    }
                }
            }
        }
        System.out.println("Unsuccessful...");
    }while(true);
    }

    /**
     * Prints out the seat after checking if the seat type, booking and reservation status
     * @param seat, the seat object to be printed
     */
    public static void printSeat(Seat seat) {
        if (seat.getIsBooked()) {
            if (seat.getSeatType() == Enum.SeatType.COUPLE_SEAT) {
                System.out.print("[xxx||xxx]");
            } else {
                System.out.print("[xxx]");
            }
        }
        else if (seat.getIsReserved()) {
            if (seat.getSeatType() == Enum.SeatType.COUPLE_SEAT) {
                System.out.print("[---||---]");
            } else {
                System.out.print("[---]");
            }
        }
        else{
            if (seat.getSeatType() == Enum.SeatType.COUPLE_SEAT) {
                String column;
                int columnNumber = seat.getColumn()+1;
                if (columnNumber < 10) {
                    column = String.format("%02d", columnNumber);
                    System.out.print("[" + seat.getRow() + column + "||" + seat.getRow() + column + "]");
                }
                else {
                    System.out.print("[" + seat.getRow() + (seat.getColumn() + 1) + "||" + seat.getRow() + (seat.getColumn() + 1) + "]");
                }
            }
            else {
                System.out.print("[" + seat.getSeatId() + "]");
            }
        }
    }

    /**
     * Choose which layout printer to use by checking the cinema type of the screening
     * @param screeningChosen, screening which you want to print the layout of
     */
    public static void seatDisplay(Screening screeningChosen){
        if (screeningChosen.getCinema().getCinemaType().equals(Enum.CinemaType.PLATINUMMOVIESUITES)){
            LayoutPrinterPlat lpPlat = new LayoutPrinterPlat();
            lpPlat.printPlatLayout(screeningChosen);
        }
        else if (screeningChosen.getCinema().getCinemaType().equals(Enum.CinemaType.ORDINARY)) {
            LayoutPrinterOrdinary lpOrdi = new LayoutPrinterOrdinary();
            lpOrdi.printLayout(screeningChosen);
        }
    }
}
