package models;

import java.util.Date;

public class HotelRooms {
	/**
	 * @param iD
	 * @param roomTypeID
	 * @param hotelID
	 * @param availableNumber
	 * @param pricePerNight
	 * @param startDate
	 * @param endDate
	 */
	public HotelRooms() {

	}
	
	private int ID;
	private int RoomTypeID;
	private int HotelID;
	private int AvailableNumber;
	private double PricePerNight;
	private Date StartDate;
	private Date EndDate;
	
	
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
	 * @return the availableNumber
	 */
	public int getAvailableNumber() {
		return AvailableNumber;
	}
	/**
	 * @param availableNumber the availableNumber to set
	 */
	public void setAvailableNumber(int availableNumber) {
		AvailableNumber = availableNumber;
	}
	/**
	 * @return the pricePerNight
	 */
	public double getPricePerNight() {
		return PricePerNight;
	}
	/**
	 * @param pricePerNight the pricePerNight to set
	 */
	public void setPricePerNight(double pricePerNight) {
		PricePerNight = pricePerNight;
	}
	/**
	 * @return the startDate
	 */
	public Date getStartDate() {
		return StartDate;
	}
	/**
	 * @param startDate the startDate to set
	 */
	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}
	/**
	 * @return the endDate
	 */
	public Date getEndDate() {
		return EndDate;
	}
	/**
	 * @param endDate the endDate to set
	 */
	public void setEndDate(Date endDate) {
		EndDate = endDate;
	}
}
