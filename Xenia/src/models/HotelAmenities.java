package models;

public class HotelAmenities {

	private int id;
	private int hotelId;
	private int amenityId;
	private boolean value;
	
	/**
	 *
	 */
	public HotelAmenities() {

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
	 * @return the hotelID
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
	 * @return the amenityID
	 */
	public int getAmenityId() {
		return amenityId;
	}
	/**
	 * @param amenityId the amenityId to set
	 */
	public void setAmenityId(int amenityId) {
		this.amenityId = amenityId;
	}
	/**
	 * @return the value
	 */
	public boolean isValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(boolean value) {
		this.value = value;
	}
	
	
}
