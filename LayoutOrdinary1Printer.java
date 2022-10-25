import MOBLIMA.SeatType;

public class LayoutOrdinary1Printer implements LayoutPrinter{
    public static void printLayout(Cinema cinema) {
        System.out.printf("%36s", "Screen");
        System.out.println();
        int columnNumber = 1;
        char rowNumber = LayoutPrinter.setNewRow('@');
        for (int i = 0; i < cinema.getMaxCap(); i++) {
            if (rowNumber >= 'I') {
                cinema.getSeats(i).setSeatType(SeatType.COUPLESEATS);
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
            cinema.getSeats(i).setEverything(rowNumber, columnNumber);
            columnNumber++;
            cinema.getSeats(i).printSeats();
            if (cinema.getSeats(i).getSeatType() == SeatType.COUPLESEATS) {
                cinema.getSeats(i).setEverything(rowNumber, columnNumber);
                i++;
                columnNumber++;
            }
            int rightSectionWidth = 2;
            if (columnNumber >= leftSectionWidth + midSectionWidth + rightSectionWidth + 1 && i < cinema.getMaxCap() - 1) {
                rowNumber = LayoutPrinter.setNewRow(rowNumber);
                columnNumber = 1;
            }
        }
    }
}
