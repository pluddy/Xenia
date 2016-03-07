package models;

import java.util.Date;

public class HotelReview {
	
	private int 	id;
	private String 	reviewerName;
	private Date 	reviewDate;
	private int 	rating;
	private String 	review;
	private int 	hotelId;
	
	/**
	 *
	 */
	public HotelReview() {

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the reviewerName
	 */
	public String getReviewerName() {
		return reviewerName;
	}

	/**
	 * @param reviewerName the reviewerName to set
	 */
	public void setReviewerName(String reviewerName) {
		this.reviewerName = reviewerName;
	}

	/**
	 * @return the reviewDate
	 */
	public Date getReviewDate() {
		return reviewDate;
	}

	/**
	 * @param reviewDate the reviewDate to set
	 */
	public void setReviewDate(Date reviewDate) {
		this.reviewDate = reviewDate;
	}

	/**
	 * @return the rating
	 */
	public int getRating() {
		return rating;
	}

	/**
	 * @param rating the rating to set
	 */
	public void setRating(int rating) {
		this.rating = rating;
	}

	/**
	 * @return the review
	 */
	public String getReview() {
		return review;
	}

	/**
	 * @param review the review to set
	 */
	public void setReview(String review) {
		this.review = review;
	}

	/**
	 * @return the hotelID
	 */
	public int getHotelId() {
		return hotelId;
	}

	/**
	 * @param hotelID the hotelID to set
	 */
	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}
	
	
}
