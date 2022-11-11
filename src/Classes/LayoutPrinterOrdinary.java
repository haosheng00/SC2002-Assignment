package classes;

import initialiser.Initialise;

/**
 * Represents the subclass of LayoutPrinter that can print the seating layout of a cinema with cinema type of ORDINARY
 */
public class LayoutPrinterOrdinary extends LayoutPrinter {
    /**
     * Prints the ORDINARY layout of the specific screening
     * @param screening
     */
    public static void printLayout(Screening screening) {
        System.out.printf("%50s", "Screen");
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
            if (screening.getSeat(i).getSeatType() == Enum.SeatType.COUPLE_SEAT) {
                screening.getSeat(i).setEverything(rowNumber, columnNumber);
                i+=1;
                columnNumber+=1;
            }
            int rightSectionWidth = 2;
            if (columnNumber >= leftSectionWidth + midSectionWidth + rightSectionWidth + 1 && i < Initialise.Ordinary_Capacity - 1) {
                rowNumber = LayoutPrinter.setNewRow(rowNumber);
                columnNumber = 1;
            }
        }
        LayoutPrinter.printLegend();
        System.out.println();
    }
}
