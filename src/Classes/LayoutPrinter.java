package classes;

/**
 * Represents a LayoutPrinter class that can print layouts
 */
public class LayoutPrinter {

    /**
     * Prints out the next row with the next row letter
     * @param rowNumber, row letter of the current row
     * @return row letter of the next row
     */
    public static char setNewRow(char rowNumber){
        rowNumber++;
        System.out.println();
        System.out.print(rowNumber + " ");
        return rowNumber;
    }

    /**
     * Prints out an aisle
     */
    public static void printAisle(){
        System.out.print("     ");
    }

    /**
     * Prints out a blank when there should not be seats
     * @param columnNumber, current column number
     * @return the next column number
     */
    public static int printEmptySeats(int columnNumber){
        System.out.print("     ");
        columnNumber++;
        return columnNumber;
    }

    /**
     * Prints out the legend of the seating layout
     */
    public static void printLegend(){
        System.out.println();
        System.out.println("---: Reserved by you   xxx: Booked   [   ||   ]: Couple Seat");
    }
}
