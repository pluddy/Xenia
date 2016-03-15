package beans;

import java.util.List;

public class ViewBookDisplayBean {
	private int hotelId;
	private String hotelName;
	private String hotelAddress;
	private String reservationDates;
	private int numRooms;
	private double pricePerNight;
	private String hotelDescription;
	private List<String> amenities;
	private double hotelRating;
	private List<String> reviews;
	
	/**
	 * @param hotelName
	 * @param hotelAddress
	 * @param reservationDates
	 * @param numRooms
	 * @param pricePerNight
	 * @param hotelDescription
	 * @param amenities
	 * @param hotelRating
	 * @param reviews
	 */
	public ViewBookDisplayBean(int hotelId, String hotelName, String hotelAddress, String reservationDates, int numRooms,
			double pricePerNight, String hotelDescription, List<String> amenities, double hotelRating,
			List<String> reviews) {
		super();
		this.hotelId = hotelId;
		this.hotelName = hotelName;
		this.hotelAddress = hotelAddress;
		this.reservationDates = reservationDates;
		this.numRooms = numRooms;
		this.pricePerNight = pricePerNight;
		this.hotelDescription = hotelDescription;
		this.amenities = amenities;
		this.hotelRating = hotelRating;
		this.reviews = reviews;
	}

	/**
	 * @return the hotelId
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
	 * @return the hotelName
	 */
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * @param hotelName the hotelName to set
	 */
	public void setHotelName(String hotelName) {
		this.hotelName = hotelName;
	}

	/**
	 * @return the hotelAddress
	 */
	public String getHotelAddress() {
		return hotelAddress;
	}

	/**
	 * @param hotelAddress the hotelAddress to set
	 */
	public void setHotelAddress(String hotelAddress) {
		this.hotelAddress = hotelAddress;
	}

	/**
	 * @return the reservationDates
	 */
	public String getReservationDates() {
		return reservationDates;
	}

	/**
	 * @param reservationDates the reservationDates to set
	 */
	public void setReservationDates(String reservationDates) {
		this.reservationDates = reservationDates;
	}

	/**
	 * @return the numRooms
	 */
	public int getNumRooms() {
		return numRooms;
	}

	/**
	 * @param numRooms the numRooms to set
	 */
	public void setNumRooms(int numRooms) {
		this.numRooms = numRooms;
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
	 * @return the hotelDescription
	 */
	public String getHotelDescription() {
		return hotelDescription;
	}

	/**
	 * @param hotelDescription the hotelDescription to set
	 */
	public void setHotelDescription(String hotelDescription) {
		this.hotelDescription = hotelDescription;
	}

	/**
	 * @return the amenities
	 */
	public List<String> getAmenities() {
		return amenities;
	}

	/**
	 * @param amenities the amenities to set
	 */
	public void setAmenities(List<String> amenities) {
		this.amenities = amenities;
	}

	/**
	 * @return the hotelRating
	 */
	public double getHotelRating() {
		return hotelRating;
	}

	/**
	 * @param hotelRating the hotelRating to set
	 */
	public void setHotelRating(double hotelRating) {
		this.hotelRating = hotelRating;
	}

	/**
	 * @return the reviews
	 */
	public List<String> getReviews() {
		return reviews;
	}

	/**
	 * @param reviews the reviews to set
	 */
	public void setReviews(List<String> reviews) {
		this.reviews = reviews;
	}
	
	

}
