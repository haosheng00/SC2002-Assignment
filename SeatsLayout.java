import MOBLIMA.CinemaType;
import MOBLIMA.SeatType;

public class SeatsLayout {
    private static Cinema cinema;

    public static void main(String[] args) {

        cinema = new Cinema(CinemaType.ORDINARY, 170);
        LayoutOrdinary1Printer.printLayout(cinema);

        Cinema cinemaPlat = new Cinema(CinemaType.PLATINUMMOVIESUITES, 22);
        LayoutPlatinum1Printer.printLayout(cinemaPlat);
    }
}

