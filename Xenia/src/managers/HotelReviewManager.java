package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import models.HotelReviews;

public class HotelReviewManager {

	public static List<HotelReviews> getHotelReviews(
			int Id, 
			String ReviewerName, 
			Date ReviewDate, 
			int Rating,
			String Review,
			int HotelId) {
		Connection con = DBConnectionManager.getConnection();
		List<HotelReviews> hotelReviews = new ArrayList<HotelReviews>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM HotelReviews";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (Id > 0) {
		    clauses.add("Id = ?");
		    parameters.add(Id);
		}
		if (HotelId > 0) {
		    clauses.add("HotelId = ?");
		    parameters.add(HotelId);
		} 
		if (ReviewerName != null) {
		    clauses.add("ReviewerName = ?");
		    parameters.add(ReviewerName);
		} 
		if (Rating > 0) {
		    clauses.add("Rating = ?");
		    parameters.add(Rating);
		} 
		if (Review != null) {
		    clauses.add("Review = ?");
		    parameters.add(Review);
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
				
				HotelReviews hotelReview = new HotelReviews();
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
