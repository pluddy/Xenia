package beans;

import java.util.Calendar;
import java.util.List;

public class ReservationSearchQueryBean {
	Calendar checkIn;
	Calendar checkOut;
	String city;
	int numRooms;
	String roomType;
	List<String> amenities;
	
	/**
	 * 
	 */
	public ReservationSearchQueryBean() {
		
	}
	
	/**
	 * @param checkIn
	 * @param checkOut
	 * @param city
	 * @param numRooms
	 * @param roomType
	 * @param amenities
	 */
	public ReservationSearchQueryBean(Calendar checkIn, Calendar checkOut, String city, int numRooms, String roomType,
			List<String> amenities) {
		super();
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.city = city;
		this.numRooms = numRooms;
		this.roomType = roomType;
		this.amenities = amenities;
	}

	/**
	 * @return
	 */
	public int getDuration() {
		int test = this.daysBetween(this.checkIn, this.checkOut);
		return test;
	}
	
	public int daysBetween(Calendar day1, Calendar day2){
	    Calendar dayOne = (Calendar) day1.clone(),
	            dayTwo = (Calendar) day2.clone();

	    if (dayOne.get(Calendar.YEAR) == dayTwo.get(Calendar.YEAR)) {
	        return Math.abs(dayOne.get(Calendar.DAY_OF_YEAR) - dayTwo.get(Calendar.DAY_OF_YEAR));
	    } else {
	        if (dayTwo.get(Calendar.YEAR) > dayOne.get(Calendar.YEAR)) {
	            //swap them
	            Calendar temp = dayOne;
	            dayOne = dayTwo;
	            dayTwo = temp;
	        }
	        int extraDays = 0;

	        int dayOneOriginalYearDays = dayOne.get(Calendar.DAY_OF_YEAR);

	        while (dayOne.get(Calendar.YEAR) > dayTwo.get(Calendar.YEAR)) {
	            dayOne.add(Calendar.YEAR, -1);
	            // getActualMaximum() important for leap years
	            extraDays += dayOne.getActualMaximum(Calendar.DAY_OF_YEAR);
	        }

	        return extraDays - dayTwo.get(Calendar.DAY_OF_YEAR) + dayOneOriginalYearDays ;
	    }
	}
	
	/**
	 * @return the checkIn
	 */
	public Calendar getCheckIn() {
		return checkIn;
	}
	
	public String getCheckInString() {
		return this.checkIn.MONTH + "/" + this.checkIn.DATE + "/" + this.checkIn.YEAR;
	}
	/**
	 * @param checkIn the checkIn to set
	 */
	public void setCheckIn(Calendar checkIn) {
		this.checkIn = checkIn;
	}
	/**
	 * @return the checkOut
	 */
	public Calendar getCheckOut() {
		return checkOut;
	}
	
	public String getCheckOutString() {
		return this.checkOut.MONTH + "/" + this.checkOut.DATE + "/" + this.checkOut.YEAR;
	}
	/**
	 * @param checkOut the checkOut to set
	 */
	public void setCheckOut(Calendar checkOut) {
		this.checkOut = checkOut;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
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
	
	

}
