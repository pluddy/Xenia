package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import models.HotelReview;

public class HotelReviewManager {
	
	final static Logger log = Logger.getLogger(HotelReviewManager.class.getName());

	public static List<HotelReview> getHotelReviews(
			Integer id, 
			String reviewerName, 
			Calendar reviewDate, 
			Integer rating,
			String review,
			Integer hotelId) {
		Connection con = DBConnectionManager.getConnection();
		List<HotelReview> hotelReviews = new ArrayList<HotelReview>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM HotelReviews";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (id != null) {
		    clauses.add("Id = ?");
		    parameters.add(id);
		}
		if (hotelId != null) {
		    clauses.add("HotelId = ?");
		    parameters.add(hotelId);
		} 
		if (reviewerName != null) {
		    clauses.add("ReviewerName = ?");
		    parameters.add(reviewerName);
		} 
		if (rating != null) {
		    clauses.add("Rating = ?");
		    parameters.add(rating);
		} 
		if (review != null) {
		    clauses.add("Review = ?");
		    parameters.add(review);
		} 
		
		try {
			
			if (!clauses.isEmpty()) {
			    sql += " where " + StringUtils.join(clauses, " and ");
			}

			ps = con.prepareStatement(sql);
			for (int i = 0; i < parameters.size(); i++) {
			    ps.setObject(i + 1, parameters.get(i));
			}
			
			rs = ps.executeQuery();

			while (rs.next()){
				
				HotelReview hotelReview = new HotelReview();
				hotelReview.setHotelId(rs.getInt("HotelId"));
				hotelReview.setId(rs.getInt("Id"));
				hotelReview.setReviewerName(rs.getString("ReviewerName"));
				Calendar cal = new GregorianCalendar();
		        cal.setTime(rs.getDate("ReviewDate"));
				hotelReview.setReviewDate(cal);
				hotelReview.setRating(rs.getInt("Rating"));
				hotelReview.setReview(rs.getString("Review"));
				hotelReviews.add(hotelReview);
			}
			log.info("Get HotelReviews Successful");
		} catch (SQLException e) {
			log.error("Get HotelReviews Failed", e);
			return null;
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				log.error("Close connection failed", e);
				return null;
			}
		}
		return hotelReviews;
	}
	
}
