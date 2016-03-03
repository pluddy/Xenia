package models;

public class User {

	private int id;
	private String username;
	private String password;
	private String firstName;
	private String lastName;
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String zip;
	
	/**
	 * 
	 */
	public User() {
		
	}
	
	/**
	 * @return the iD
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setId(int userId) {
		id = userId;
	}

	/**
	 * @return
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * @param username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * @return
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	
	/**
	 * @return
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * @param address1
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * @return
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * @param address2
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
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
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	
}
