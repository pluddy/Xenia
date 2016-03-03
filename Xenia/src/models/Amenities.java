package models;

public class Amenities {

	private int id;
	private String name;
	
	/**
	 * @param amenityId
	 * @param name
	 */
	public Amenities() {

	}
	
	/**
	 * @return the amenityId
	 */
	public int getId() {
		return id;
	}
	
	/**
	 * @param amenityId the amenityId to set
	 */
	public void setId(int amenityId) {
		id = amenityId;
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
	
}
