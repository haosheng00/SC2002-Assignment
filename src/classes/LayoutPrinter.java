package classes;

/**
 * Represents a LayoutPrinter class that can print layouts
 */
public abstract class LayoutPrinter {
    /**
     * Prints layout of the particular screening
     * @param screening the screening to show the layout
     */

    abstract public void printLayout(Screening screening);

    /**
     * Prints out the next row with the next row letter
     * @param rowNumber row letter of the current row
     * @return row letter of the next row
     */
    public char setNewRow(char rowNumber){
        rowNumber++;
        System.out.println();
        System.out.print(rowNumber + " ");
        return rowNumber;
    }

    /**
     * Prints out an aisle
     */
    public void printAisle(){
        System.out.print("     ");
    }

    /**
     * Prints out a blank when there should not be seats
     * @param columnNumber current column number
     * @return the next column number
     */
    public int printEmptySeats(int columnNumber){
        System.out.print("     ");
        columnNumber++;
        return columnNumber;
    }

    /**
     * Prints out the legend of the seating layout
     */
    public void printLegend(){
        System.out.println();
        System.out.println("---: Reserved by you   xxx: Booked   [   ||   ]: Couple Seat");
    }
}
