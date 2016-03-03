package models;

public class HotelRoomType {

	/**
	 * @param iD
	 * @param roomType
	 * @param description
	 */
	public HotelRoomType() {

	}
	
	private int ID;
	private String RoomType;
	private String Description;
	
	
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
	 * @return the roomType
	 */
	public String getRoomType() {
		return RoomType;
	}
	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		RoomType = roomType;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return Description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		Description = description;
	}

	
}
