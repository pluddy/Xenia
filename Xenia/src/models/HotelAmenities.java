package models;

public class HotelAmenities {

	/**
	 * @param iD
	 * @param hotelID
	 * @param amenityID
	 * @param value
	 */
	public HotelAmenities() {

	}
	private int ID;
	private int HotelID;
	private int AmenityID;
	private boolean Value;
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
	 * @return the amenityID
	 */
	public int getAmenityID() {
		return AmenityID;
	}
	/**
	 * @param amenityID the amenityID to set
	 */
	public void setAmenityID(int amenityID) {
		AmenityID = amenityID;
	}
	/**
	 * @return the value
	 */
	public boolean isValue() {
		return Value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(boolean value) {
		Value = value;
	}
	
	
}
