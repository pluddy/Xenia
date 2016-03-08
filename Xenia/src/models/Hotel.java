package models;

import java.util.List;

public class Hotel {
	
	private int id;
	private String name;
	private String description;
	private String city;
	private String state;
	private String address;
	
	private List<HotelAmenity> amenities;
	private List<HotelReview> reviews;
	private List<HotelRoom> rooms;
	
	/**
	 *
	 */
	public Hotel() {
		
	}

	/**
	 * @return
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the amenities
	 */
	public List<HotelAmenity> getAmenities() {
		return amenities;
	}

	/**
	 * @param amenities the amenities to set
	 */
	public void setAmenities(List<HotelAmenity> amenities) {
		this.amenities = amenities;
	}

	/**
	 * @return the reviews
	 */
	public List<HotelReview> getReviews() {
		return reviews;
	}

	/**
	 * @param reviews the reviews to set
	 */
	public void setReviews(List<HotelReview> reviews) {
		this.reviews = reviews;
	}

	/**
	 * @return the rooms
	 */
	public List<HotelRoom> getRooms() {
		return rooms;
	}

	/**
	 * @param rooms the rooms to set
	 */
	public void setRooms(List<HotelRoom> rooms) {
		this.rooms = rooms;
	}
	
	
	
}
