package models;

public class Amenity {

	private int id;
	private String name;
	private String description;
	
	/**
	 * @param amenityId
	 * @param name
	 */
	public Amenity() {

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
	
	
	
}
