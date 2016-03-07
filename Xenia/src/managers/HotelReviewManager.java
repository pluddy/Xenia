package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import models.HotelReview;

public class HotelReviewManager {

	public static List<HotelReview> getHotelReviews(
			int id, 
			String reviewerName, 
			Date reviewDate, 
			int rating,
			String review,
			int hotelId) {
		Connection con = DBConnectionManager.getConnection();
		List<HotelReview> hotelReviews = new ArrayList<HotelReview>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM HotelReviews";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (id > 0) {
		    clauses.add("Id = ?");
		    parameters.add(id);
		}
		if (hotelId > 0) {
		    clauses.add("HotelId = ?");
		    parameters.add(hotelId);
		} 
		if (reviewerName != null) {
		    clauses.add("ReviewerName = ?");
		    parameters.add(reviewerName);
		} 
		if (rating > 0) {
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
				hotelReview.setReviewDate(rs.getDate("ReviewDate"));
				hotelReview.setRating(rs.getInt("Rating"));
				hotelReview.setReview(rs.getString("Review"));
				hotelReviews.add(hotelReview);
			}
			System.out.println("[HotelReviewsManager] - Get HotelReviews Successful");
		} catch (SQLException e) {
			System.out.println("[HotelReviewsManager] - Get HotelReviews Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return hotelReviews;
	}
	
}
