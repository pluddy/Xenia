package beans;

public class ReservationSearchResultBean {
	private String name;
	private String address;
	private String description;
	private String roomType;
	private double rating;
	private double pricePerNight;
	private String amenities;
	
	
	/**
	 * 
	 */
	public ReservationSearchResultBean() {
		
	}
	
	/**
	 * @param name
	 * @param address
	 * @param description
	 * @param roomType
	 * @param rating
	 * @param pricePerNight
	 * @param amenities
	 */
	public ReservationSearchResultBean(String name, String address, String description, String roomType, double rating,
			double pricePerNight, String amenities) {
		super();
		this.name = name;
		this.address = address;
		this.description = description;
		this.roomType = roomType;
		this.rating = rating;
		this.pricePerNight = pricePerNight;
		this.amenities = amenities;
	}



	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * @return the roomType
	 */
	public String getRoomType() {
		return roomType;
	}
	/**
	 * @param roomType the roomType to set
	 */
	public void setRoomType(String roomType) {
		this.roomType = roomType;
	}
	/**
	 * @return the rating
	 */
	public double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(double rating) {
		this.rating = rating;
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
	 * @return the amenities
	 */
	public String getAmenities() {
		return amenities;
	}
	/**
	 * @param amenities the amenities to set
	 */
	public void setAmenities(String amenities) {
		this.amenities = amenities;
	}
}
