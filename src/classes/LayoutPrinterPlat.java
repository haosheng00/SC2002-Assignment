package classes;

import initialiser.Initialise;

/**
 * Represents the subclass of LayoutPrinter that can print the seating layout of a cinema with cinema type of PLATINUMMOVIESUITES
 */
public class LayoutPrinterPlat extends LayoutPrinter {
    /**
     * Prints the PLATINUMMOVIESUITES layout of a specific screening
     * @param screening the screening which layout is to be printed
     */
    @Override
        public void printLayout(Screening screening) {
            System.out.printf("%26s", "Screen");
            System.out.println();
            int columnNumber = 1;
            char rowNumber = setNewRow('@');
            for (int i = 0; i < Initialise.Plat_Capacity; i++) {
                int leftSectionWidth = 2;
                int midSectionWidth = 2;
                int rightSectionWidth = 2;

                if (rowNumber == 'A') {
                    rowNumber = setNewRow('A');
                }
                if (columnNumber == leftSectionWidth + 1 || columnNumber == leftSectionWidth + midSectionWidth + 1) {
                    printAisle();
                }
                while (Character.getNumericValue(rowNumber) % 3 == 1 && (columnNumber > leftSectionWidth && columnNumber < leftSectionWidth + midSectionWidth + 1)){
                    columnNumber = printEmptySeats(columnNumber);
                    if (columnNumber == leftSectionWidth + midSectionWidth + 1) {
                        printAisle();
                    }
                }
                screening.getSeat(i).setEverything(rowNumber, columnNumber);
                columnNumber++;
                SeatFormatter.printSeat(screening.getSeat(i));
                if (columnNumber >= leftSectionWidth + midSectionWidth + rightSectionWidth + 1 && i < Initialise.Plat_Capacity - 1) {
                    rowNumber = setNewRow(rowNumber);
                    columnNumber = 1;
                }
            }
            printLegend();
            System.out.println();
        }


    /**
     * Prints out the legend of the seating layout
     */
    @Override
    public void printLegend(){
        System.out.println();
        System.out.println("---: Reserved by you   xxx: Booked");
    }
    }
