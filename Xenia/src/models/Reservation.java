package models;

import java.util.Date;

public class Reservation {
	public Reservation(Integer iD, Integer hotelID, Date checkInDate, Date checkOutDate, Integer numberOfRooms,
			String reservationNumber, Integer userID, Integer status, String notes, Integer roomTypeID) {
		super();
		ID = iD;
		HotelID = hotelID;
		CheckInDate = checkInDate;
		CheckOutDate = checkOutDate;
		NumberOfRooms = numberOfRooms;
		ReservationNumber = reservationNumber;
		UserID = userID;
		Status = status;
		Notes = notes;
		RoomTypeID = roomTypeID;
	}
	
	private Integer ID;
	private Integer HotelID;
	private Date CheckInDate;
	private Date CheckOutDate;
	private Integer NumberOfRooms;
	private String ReservationNumber;
	private Integer UserID;
	private Integer Status;
	private String Notes;
	private Integer RoomTypeID;
	
	
	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
		ID = iD;
	}
	/**
	 * @return the hotelID
	 */
	public Integer getHotelID() {
		return HotelID;
	}
	/**
	 * @param hotelID the hotelID to set
	 */
	public void setHotelID(Integer hotelID) {
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
	public Integer getNumberOfRooms() {
		return NumberOfRooms;
	}
	/**
	 * @param numberOfRooms the numberOfRooms to set
	 */
	public void setNumberOfRooms(Integer numberOfRooms) {
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
	public Integer getUserID() {
		return UserID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Integer userID) {
		UserID = userID;
	}
	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return Status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
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
	public Integer getRoomTypeID() {
		return RoomTypeID;
	}
	/**
	 * @param roomTypeID the roomTypeID to set
	 */
	public void setRoomTypeID(Integer roomTypeID) {
		RoomTypeID = roomTypeID;
	}
}
