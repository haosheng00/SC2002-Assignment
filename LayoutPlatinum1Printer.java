public class LayoutPlatinum1Printer implements LayoutPrinter {
    public static void printLayout(Cinema cinema) {
        System.out.printf("%36s", "Screen");
        System.out.println();
        int columnNumber = 1;
        char rowNumber = LayoutPrinter.setNewRow('@');
        for (int i = 0; i < cinema.getMaxCap(); i++) {
            int leftSectionWidth = 2;
            int midSectionWidth = 2;
            int rightSectionWidth = 2;

            if (rowNumber == 'A') {
                rowNumber = LayoutPrinter.setNewRow('A');
            }
            if (columnNumber == leftSectionWidth + 1 || columnNumber == leftSectionWidth + midSectionWidth + 1) {
                LayoutPrinter.printAisle();
            }

            while (Character.getNumericValue(rowNumber) % 3 == 1 && (columnNumber > leftSectionWidth && columnNumber < leftSectionWidth + midSectionWidth + 1)){
                columnNumber = LayoutPrinter.printEmptySeats(columnNumber);
                if (columnNumber == leftSectionWidth + midSectionWidth + 1) {
                    LayoutPrinter.printAisle();
                }
            }


            cinema.getSeats(i).setEverything(rowNumber, columnNumber);
            columnNumber++;
            cinema.getSeats(i).printSeats();
            if (columnNumber >= leftSectionWidth + midSectionWidth + rightSectionWidth + 1 && i < cinema.getMaxCap() - 1) {
                rowNumber = LayoutPrinter.setNewRow(rowNumber);
                columnNumber = 1;
            }
        }
    }
}
