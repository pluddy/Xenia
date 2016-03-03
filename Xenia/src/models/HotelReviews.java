package models;

import java.util.Date;

public class HotelReviews {
	/**
	 * @param iD
	 * @param reviewerName
	 * @param reviewDate
	 * @param rating
	 * @param review
	 * @param hotelID
	 */
	public HotelReviews() {

	}
	
	private int ID;
	private String ReviewerName;
	private Date ReviewDate;
	private int Rating;
	private String Review;
	private int HotelID;
	
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
	 * @return the reviewerName
	 */
	public String getReviewerName() {
		return ReviewerName;
	}
	/**
	 * @param reviewerName the reviewerName to set
	 */
	public void setReviewerName(String reviewerName) {
		ReviewerName = reviewerName;
	}
	/**
	 * @return the reviewDate
	 */
	public Date getReviewDate() {
		return ReviewDate;
	}
	/**
	 * @param reviewDate the reviewDate to set
	 */
	public void setReviewDate(Date reviewDate) {
		ReviewDate = reviewDate;
	}
	/**
	 * @return the rating
	 */
	public int getRating() {
		return Rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		Rating = rating;
	}
	/**
	 * @return the review
	 */
	public String getReview() {
		return Review;
	}
	/**
	 * @param review the review to set
	 */
	public void setReview(String review) {
		Review = review;
	}
	/**
	 * @return the hotelID
	 */
	public int getHotelID() {
		return HotelID;
	}
	/**
	 * @param hotelID the hotelID to set
	 */
	public void setHotelID(int hotelID) {
		HotelID = hotelID;
	}

}
