package Classes;
public class Seat {
    private char row;
    private int column;
    private static SeatType seatType;
    private String seatId;
    private boolean isBooked;


    public Seat(char r, int c, SeatType seatType) {
        this.row = r;
        this.column = c;
        this.seatType = seatType;
        this.seatId = String.valueOf(r) + String.valueOf(c);
        isBooked = false;
    }
    public Seat() {
        row = 'Z';
        column = 99;
        seatType = SeatType.ORDINARY;
        seatId =  String.valueOf(row) + String.valueOf(column);
        isBooked = false;
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
        seatType = seatType;
    }
    public static SeatType getSeatType() {
        return seatType;
    }

    public void setBookingStatus(boolean status) {
        isBooked = status;
    }
    public boolean getBookingStatus() {
        return isBooked;
    }

    public void setEverything(char rowNumber, int columnNumber){
        if (columnNumber < 10) {
            this.seatId = rowNumber + String.format("%02d", columnNumber);
        }
        else{
            this.seatId = rowNumber + String.valueOf(columnNumber);
        }
    }

    public void printSeats(){
        if (this.isBooked && Seat.getSeatType() == SeatType.COUPLE_SEAT){
            System.out.print("[x||x]");
        }
        else if (Seat.getSeatType() == SeatType.COUPLE_SEAT){
            System.out.print("[ || ]");
        }
        else if (this.isBooked){
            System.out.print("[x]");
        }
        else{
            System.out.print("[ ]");
        }
    }
}
