package Classes;

import Initialiser.Initialise;

public class SeatFormatter {
    public static String seatIdFormat(char rowChoice, int columnChoice) {
        String seatID;
        if (columnChoice < 10) {
            seatID = rowChoice + String.format("%02d", columnChoice);
        }
        else {
            seatID = rowChoice + String.valueOf(columnChoice);
        }
        return seatID;
    }

    public static boolean checkIfValidSeat(Screening screening, String seatIdChoice){
        boolean validSeatId = false;
        if (screening.getCinema().getCinemaType() == CinemaType.ORDINARY) {
            for (int i = 0; i < Initialise.Ordinary_Capacity; i++) {
                if (seatIdChoice.equals(screening.getSeat(i).getSeatId())) {
                    if (!screening.getSeat(i).getIsBooked()) {
                        validSeatId = true;
                    }
                }
            }
        }
        else if (screening.getCinema().getCinemaType() == CinemaType.PLATINUMMOVIESUITES) {
            for (int i = 0; i < Initialise.Plat_Capacity; i++) {
                if (seatIdChoice.equals(screening.getSeat(i).getSeatId())) {
                    if (!screening.getSeat(i).getIsBooked()) {
                        validSeatId = true;
                    }
                }
            }
        }
        return validSeatId;
    }
}
