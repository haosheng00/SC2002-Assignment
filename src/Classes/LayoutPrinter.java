package Classes;
public interface LayoutPrinter {
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
}
