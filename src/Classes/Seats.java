package Classes;

public class Seats {
    private static SeatType seatType;
    private String seatID;
    private boolean isBooked;

    public Seats(){
        this.seatType = SeatType.ORDINARY;
        this.isBooked = false;
    }
    public Seats(String seatID, SeatType seatType, boolean isBooked){
        this.seatType = seatType;
        this.seatID = seatID;
        this.isBooked = isBooked;
    }

    public static SeatType getSeatType(){
        return seatType;
    }
    public void setSeatType(SeatType seatType){
        this.seatType = seatType;
    }

    public void setEverything(char rowNumber, int columnNumber){
        if (columnNumber < 10) {
            this.seatID = rowNumber + String.format("%02d", columnNumber);
        }
        else{
            this.seatID = rowNumber + String.valueOf(columnNumber);
        }
    }
    public String getSeatID(){
        return seatID;
    }

    public void printSeats(){
        if (this.isBooked && Seats.getSeatType() == SeatType.COUPLESEAT){
            System.out.print("[x||x]");
        }
        else if (Seats.getSeatType() == SeatType.COUPLESEAT){
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
