package models;

import java.util.Calendar;
import java.util.Date;

public class Reservation {
	private int id;
	private int hotelId;
	private Calendar checkInDate;
	private Calendar checkOutDate;
	private int numberOfRooms;
	private String reservationNumber;
	private int userId;
	private int status;
	private String notes;
	private int roomTypeId;
	
	public Reservation() {

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the hotelId
	 */
	public int getHotelId() {
		return hotelId;
	}

	/**
	 * @param hotelId the hotelId to set
	 */
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	/**
	 * @return the checkInDate
	 */
	public Calendar getCheckInDate() {
		return checkInDate;
	}

	/**
	 * @param checkInDate the checkInDate to set
	 */
	public void setCheckInDate(Calendar checkInDate) {
		this.checkInDate = checkInDate;
	}

	/**
	 * @return the checkOutDate
	 */
	public Calendar getCheckOutDate() {
		return checkOutDate;
	}

	/**
	 * @param checkOutDate the checkOutDate to set
	 */
	public void setCheckOutDate(Calendar checkOutDate) {
		this.checkOutDate = checkOutDate;
	}

	/**
	 * @return the numberOfRooms
	 */
	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	/**
	 * @param numberOfRooms the numberOfRooms to set
	 */
	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	/**
	 * @return the reservationNumber
	 */
	public String getReservationNumber() {
		return reservationNumber;
	}

	/**
	 * @param reservationNumber the reservationNumber to set
	 */
	public void setReservationNumber(String reservationNumber) {
		this.reservationNumber = reservationNumber;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the status
	 */
	public int getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(int status) {
		this.status = status;
	}

	/**
	 * @return the notes
	 */
	public String getNotes() {
		return notes;
	}

	/**
	 * @param notes the notes to set
	 */
	public void setNotes(String notes) {
		this.notes = notes;
	}

	/**
	 * @return the roomTypeId
	 */
	public int getRoomTypeId() {
		return roomTypeId;
	}

	/**
	 * @param roomTypeId the roomTypeId to set
	 */
	public void setRoomTypeId(int roomTypeId) {
		this.roomTypeId = roomTypeId;
	}

	
}
