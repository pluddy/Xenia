package models;

import java.util.Calendar;
import java.util.Date;

public class HotelRoom {
	
	private int id;
	private int roomTypeId;
	private int hotelId;
	private int availableNumber;
	private double pricePerNight;
	private Calendar startDate;
	private Calendar endDate;
	
	private HotelRoomType roomType;
	
	/**
	 *
	 */
	public HotelRoom() {

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
	 * @return the availableNumber
	 */
	public int getAvailableNumber() {
		return availableNumber;
	}

	/**
	 * @param availableNumber the availableNumber to set
	 */
	public void setAvailableNumber(int availableNumber) {
		this.availableNumber = availableNumber;
	}

	/**
	 * @return the pricePerNight
	 */
	public double getPricePerNight() {
		return pricePerNight;
	}

	/**
	 * @param pricePerNight the pricePerNight to set
	 */
	public void setPricePerNight(double pricePerNight) {
		this.pricePerNight = pricePerNight;
	}

	/**
	 * @return the startDate
	 */
	public Calendar getStartDate() {
		return startDate;
	}

	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	/**
	 * @return the endDate
	 */
	public Calendar getEndDate() {
		return endDate;
	}

	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	/**
	 * @return the roomType
	 */
	public HotelRoomType getRoomType() {
		return roomType;
	}

	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(HotelRoomType roomType) {
		this.roomType = roomType;
	}
	
	
}
