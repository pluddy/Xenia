package models;

import java.util.Date;

public class Reservation {
	public Reservation() {

	}
	
	private int ID;
	private int HotelID;
	private Date CheckInDate;
	private Date CheckOutDate;
	private int NumberOfRooms;
	private String ReservationNumber;
	private int UserID;
	private int Status;
	private String Notes;
	private int RoomTypeID;
	
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the hotelID
	 */
	public int getHotelID() {
		return HotelID;
	}
	/**
	 * @param hotelID the hotelID to set
	 */
	public void setHotelID(int hotelID) {
		HotelID = hotelID;
	}
	/**
	 * @return the checkInDate
	 */
	public Date getCheckInDate() {
		return CheckInDate;
	}
	/**
	 * @param checkInDate the checkInDate to set
	 */
	public void setCheckInDate(Date checkInDate) {
		CheckInDate = checkInDate;
	}
	/**
	 * @return the checkOutDate
	 */
	public Date getCheckOutDate() {
		return CheckOutDate;
	}
	/**
	 * @param checkOutDate the checkOutDate to set
	 */
	public void setCheckOutDate(Date checkOutDate) {
		CheckOutDate = checkOutDate;
	}
	/**
	 * @return the numberOfRooms
	 */
	public int getNumberOfRooms() {
		return NumberOfRooms;
	}
	/**
	 * @param numberOfRooms the numberOfRooms to set
	 */
	public void setNumberOfRooms(int numberOfRooms) {
		NumberOfRooms = numberOfRooms;
	}
	/**
	 * @return the reservationNumber
	 */
	public String getReservationNumber() {
		return ReservationNumber;
	}
	/**
	 * @param reservationNumber the reservationNumber to set
	 */
	public void setReservationNumber(String reservationNumber) {
		ReservationNumber = reservationNumber;
	}
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return UserID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		UserID = userID;
	}
	/**
	 * @return the status
	 */
	public int getStatus() {
		return Status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		Status = status;
	}
	/**
	 * @return the notes
	 */
	public String getNotes() {
		return Notes;
	}
	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		Notes = notes;
	}
	/**
	 * @return the roomTypeID
	 */
	public int getRoomTypeID() {
		return RoomTypeID;
	}
	/**
	 * @param roomTypeID the roomTypeID to set
	 */
	public void setRoomTypeID(int roomTypeID) {
		RoomTypeID = roomTypeID;
	}
}
