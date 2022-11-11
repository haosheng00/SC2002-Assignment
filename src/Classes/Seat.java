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
     * ORDINARY or COUPLE_SEAT
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
     * SeatId is automatically formed, while seat is set to not booked and not reserved.
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


    /**
     * Returns the row letter of the specified seat
     * @return row letter
     */
    public char getRow() {
        return row;
    }

    /**
     * Sets/Updates the row letter of the specified seat
     * @param a
     */
    public void setRow(char a) {
        row = a;
    }

    /**
     * Returns the column number of the specified seat
     * @return column number (2 digits)
     */
    public int getColumn() {
        return column;
    }

    /**
     * Sets/Updates the column number of the specified seat
     * @param c column number (2 digits)
     */
    public void setColumn(int c) {
        column = c;
    }

    /**
     * Returns the seat ID of the specified seat, formed by 'Row Letter' + 'Column Number'
     * @return seat ID
     */
    public String getSeatId() {
        return seatId;
    }

    /**
     * Sets/Updates the seat ID of the specified seat, formed by 'Row Letter' + 'Column Number'
     */
    public void setSeatId() {
        seatId = String.valueOf(row) + String.valueOf(column);
    }

    /**
     * Sets/Updates the seat type of the specified seat, either ordinary seat or couple seats
     * @param seatType ordinary seat or couple seats
     */
    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    /**
     * Returns the seat type of the specified seat, either ordinary seat or couple seats
     * @return type of seat selected: ordinary seat or couple seats
     */
    public Enum.SeatType getSeatType() {
        return seatType;
    }

    /**
     * updates the booking status of the specified seat (booked or not booked)
     * @param status booking status of the specified seat
     */
    public void setIsBooked(boolean status) {
        isBooked = status;
    }

    /**
     * Returns the booking status of the specified seat (booked or not booked)
     * @return booking status of the specified seat
     */
    public boolean getIsBooked() {
        return isBooked;
    }

    /**
     * Sets/Updates the row letter and column number of the specified seat
     * @param rowNumber row letter
     * @param columnNumber column number
     */
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

    /**
     * Returns the reservation status of the specified seat (reserved or not)
     * A reserved seat is in pending payment state
     * @return reservation status
     */
    public boolean getIsReserved() {
        return isReserved;
    }

    /**
     * Sets/Updates the reservation status of the specified seat (reserved or not)
     * @param reserved reservation status
     */
    public void setIsReserved(boolean reserved) {
        isReserved = reserved;
    }
}
