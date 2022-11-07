package classes;

import initialiser.Initialise;
import classes.Enum;
import classes.Enum.SeatType;

public class LayoutPrinterOrdinary extends LayoutPrinter{
    public static void printLayout(Screening screening) {
        System.out.printf("%36s", "Screen");
        System.out.println();
        int columnNumber = 1;
        char rowNumber = LayoutPrinter.setNewRow('@');
        for (int i = 0; i < Initialise.Ordinary_Capacity; i++) {
            if (rowNumber >= 'I') {
                screening.getSeat(i).setSeatType(Enum.SeatType.COUPLE_SEAT);
            }
            int leftSectionWidth = 4;
            while (rowNumber == 'A' && (columnNumber <= leftSectionWidth)) {
                columnNumber = LayoutPrinter.printEmptySeats(columnNumber);
            }
            int midSectionWidth = 10;
            if (columnNumber == leftSectionWidth + 1 || columnNumber == leftSectionWidth + midSectionWidth + 1) {
                LayoutPrinter.printAisle();
            }
            if (rowNumber == 'A' && (columnNumber >= leftSectionWidth + midSectionWidth + 1)) {
                rowNumber = LayoutPrinter.setNewRow(rowNumber);
                columnNumber = 1;
            }
            screening.getSeat(i).setEverything(rowNumber, columnNumber);
            columnNumber++;
            SeatFormatter.printSeat(screening.getSeat(i));
            if (screening.getSeat(i).getSeatType() == SeatType.COUPLE_SEAT) {
                screening.getSeat(i).setEverything(rowNumber, columnNumber);
                i++;
                columnNumber++;
            }
            int rightSectionWidth = 2;
            if (columnNumber >= leftSectionWidth + midSectionWidth + rightSectionWidth + 1 && i < Initialise.Ordinary_Capacity - 1) {
                rowNumber = LayoutPrinter.setNewRow(rowNumber);
                columnNumber = 1;
            }
        }
        System.out.println();
    }
}
