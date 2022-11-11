package classes;

/**
 * Represents a LayoutPrinter class that can print layouts
 */
public class LayoutPrinter {
        public void printLayout(){}
        public static char setNewRow(char rowNumber){
            rowNumber++;
            System.out.println();
            System.out.print(rowNumber + " ");
            return rowNumber;
        }
        public static void printAisle(){
            System.out.print("     ");
        }

        public static int printEmptySeats(int columnNumber){
            System.out.print("     ");
            columnNumber++;
            return columnNumber;
        }

        public static void printLegend(){
            System.out.println();
            System.out.println("---: Reserved by you   xxx: Booked   [   ||   ]: Couple Seat");
        }
}
