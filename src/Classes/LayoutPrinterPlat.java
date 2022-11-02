public class LayoutPrinterPlat implements LayoutPrinter{
        public static void printLayout(Screening screening) {
            System.out.printf("%36s", "Screen");
            System.out.println();
            int columnNumber = 1;
            char rowNumber = LayoutPrinter.setNewRow('@');
            for (int i = 0; i < 22; i++) {
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

                screening.getSeat(i).setEverything(rowNumber, columnNumber);
                columnNumber++;
                screening.getSeat(i).printSeats();
                if (columnNumber >= leftSectionWidth + midSectionWidth + rightSectionWidth + 1 && i < 22 - 1) {
                    rowNumber = LayoutPrinter.setNewRow(rowNumber);
                    columnNumber = 1;
                }
            }
            System.out.println();
        }
    }