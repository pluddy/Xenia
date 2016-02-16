package models;

public class Hotel {
	private String name;
	private String description;
	private String city;
	private String state;
	private String address;
	
	/**
	 * @param name
	 * @param description
	 * @param city
	 * @param state
	 * @param address
	 */
	public Hotel(String name, String description, String city, String state, String address) {
		super();
		this.name = name;
		this.description = description;
		this.city = city;
		this.state = state;
		this.address = address;
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
	
	
	
}
