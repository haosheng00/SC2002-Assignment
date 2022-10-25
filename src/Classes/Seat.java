package Classes;

public class Seat {
	private char row;
	private int column;
	private SeatType seatCat;
	private String seatId;
	private boolean isBooked;
	
	
	public Seat(char r, int c, SeatType st) {
		this.row = r;
		this.column = c;
		this.seatCat = st;
		this.seatId = String.valueOf(r) + String.valueOf(c);
		isBooked = false;
	}
	public Seat() {
		row = 'a';
		column = -1;
		seatCat = SeatType.ORDINARY;
		seatId =  String.valueOf(row) + String.valueOf(column);
		isBooked = false;
	}
	
	
	public char getRow() {
		return row;
	}
	
	public int getColumn() {
		return column;
	}
	
	public String getSeatId() {
		return seatId;
	}
	public SeatType getSeattype() {
		return seatCat;
	}
	
	public boolean getBookingStatus() {
		return isBooked;
		
	}
	
	public void setRow(char a) {
		row = a;
	}
	
	public void setColumn(int c) {
		column = c;
	}
	
	public void setSeatId() {
		seatId = String.valueOf(row) + String.valueOf(column);
	}
	public void setSeatCat(SeatType st) {
		seatCat = st;
	}
	public void setBookingStatus(boolean status) {
		isBooked = status;
	}
	
	 
}
