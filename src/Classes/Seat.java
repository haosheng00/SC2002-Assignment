package classes;
public class Seat {
    private char row;
    private int column;
    private SeatType seatType;
    private String seatId;
    private boolean isBooked;
    private boolean isReserved;


    public Seat(char r, int c, SeatType seatType) {
        this.row = r;
        this.column = c;
        this.seatType = seatType;
        this.seatId = String.valueOf(r) + String.valueOf(c);
        isBooked = false;
        isReserved = false;
    }
    public Seat() {
        row = 'Z';
        column = 99;
        seatType = SeatType.ORDINARY;
        seatId =  String.valueOf(row) + String.valueOf(column);
        isBooked = false;
        isReserved = false;
    }


    public char getRow() {
        return row;
    }
    public void setRow(char a) {
        row = a;
    }

    public int getColumn() {
        return column;
    }
    public void setColumn(int c) {
        column = c;
    }

    public String getSeatId() {
        return seatId;
    }
    public void setSeatId() {
        seatId = String.valueOf(row) + String.valueOf(column);
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }
    public SeatType getSeatType() {
        return seatType;
    }

    public void setIsBooked(boolean status) {
        isBooked = status;
    }
    public boolean getIsBooked() {
        return isBooked;
    }

    public void setEverything(char rowNumber, int columnNumber){
        setRow(rowNumber);
        setColumn(columnNumber);
        if (columnNumber < 10) {
            this.seatId = rowNumber + String.format("%02d", columnNumber);
        }
        else{
            this.seatId = rowNumber + String.valueOf(columnNumber);
        }
    }

    public boolean getIsReserved() {
        return isReserved;
    }
    public void setIsReserved(boolean reserved) {
        isReserved = reserved;
    }
}
