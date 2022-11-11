package classes;

import java.io.Serializable;

import classes.Enum.SeatType;

/**
 * Represents a Seat class with its details
 */
public class Seat implements Serializable{
    /**
     * Represents the row character that the seat is located at
     */
    private char row;
    /**
     * Represents the column number that the seat is located at
     */
    private int column;
    /**
     * Represents the seat type of the seat: <p>
     *     ORDINARY or COUPLE_SEAT
     */
    private Enum.SeatType seatType;
    /**
     * Represents the seatId of the seat,
     * in the form of RCC, where R is the row character, while CC is the column number
     */
    private String seatId;
    /**
     * Represents the booking status of the seat
     */
    private boolean isBooked;
    /**
     * Represents the reservation status of the seat
     */
    private boolean isReserved;

    /**
     * Represents a specific seat initialised with a specific row, column, and seat type.
     * SeatId is automatically formed, while seat is set to not booked and not reserved
     * @param r, row character
     * @param c, column number
     * @param seatType, type of seat:  ORDINARY or COUPLE_SEAT
     */
    public Seat(char r, int c, SeatType seatType) {
        this.row = r;
        this.column = c;
        this.seatType = seatType;
        setEverything(row, column);
        isBooked = false;
        isReserved = false;
    }

    /**
     * Represents a seat initialised with default values
     */
    public Seat() {
        row = 'Z';
        column = 99;
        seatType = SeatType.ORDINARY;
        setEverything(row, column);
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
    public Enum.SeatType getSeatType() {
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
