package classes;

import java.io.Serializable;
import java.util.Scanner;

import initialiser.Initialise;

public class SeatFormatter implements Serializable{
    static Scanner sc = new Scanner(System.in);
    public static String seatIdFormat(char rowChoice, int columnChoice) {
        String seatID;
        if (columnChoice < 10) {
            seatID = rowChoice + String.format("%02d", columnChoice);
        } else {
            seatID = rowChoice + String.valueOf(columnChoice);
        }
        return seatID;
    }

    public static Seat checkIfValidSeat(Screening screening) {
        System.out.println("Enter Row Letter:");
        char rowChoice = Character.toUpperCase(sc.next().charAt(0));
        System.out.println("Enter Column Number:");
        int columnChoice = sc.nextInt();

        String seatIdChoice = SeatFormatter.seatIdFormat(rowChoice, columnChoice);
        if (screening.getCinema().getCinemaType() == Enum.CinemaType.ORDINARY) {
            for (int i = 0; i < Initialise.Ordinary_Capacity; i++) {
                if (seatIdChoice.equals(screening.getSeat(i).getSeatId())) {
                    if (!screening.getSeat(i).getIsBooked()&&!screening.getSeat(i).getIsReserved()) {
                        System.out.println("Adding to cart...");
                        return screening.getSeat(i);
                    }
                }
            }
        } else if (screening.getCinema().getCinemaType() == Enum.CinemaType.PLATINUMMOVIESUITES) {
            for (int i = 0; i < Initialise.Plat_Capacity; i++) {
                if (seatIdChoice.equals(screening.getSeat(i).getSeatId())) {
                    if (!screening.getSeat(i).getIsBooked()&&!screening.getSeat(i).getIsReserved()) {
                        System.out.println("Adding to cart...");
                        return screening.getSeat(i);
                    }
                }
            }
        }
        System.out.println("Unsuccessful...");
        return null;
    }

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

    public static void seatDisplay(Screening screeningChosen){
        if (screeningChosen.getCinema().getCinemaType().equals(Enum.CinemaType.PLATINUMMOVIESUITES)){
            LayoutPrinterPlat.printPlatLayout(screeningChosen);
        }
        else if (screeningChosen.getCinema().getCinemaType().equals(Enum.CinemaType.ORDINARY)) {
            LayoutPrinterOrdinary.printLayout(screeningChosen);
        }
    }
}
