package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import models.HotelAmenity;

public class HotelAmenityManager {

	public static List<HotelAmenity> getHotelAmenities(
			Integer id, 
			Integer hotelId, 
			Integer amenityId, 
			Boolean value) {
		Connection con = DBConnectionManager.getConnection();
		List<HotelAmenity> hotelAmenities = new ArrayList<HotelAmenity>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM HotelAmenities";
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
		if (amenityId != null) {
		    clauses.add("AmenityId = ?");
		    parameters.add(amenityId);
		} 
		if (value != null) {
		    clauses.add("Value = ?");
		    parameters.add(value);
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
				
				HotelAmenity hotelAmenity = new HotelAmenity();
				hotelAmenity.setHotelId(rs.getInt("HotelId"));
				hotelAmenity.setId(rs.getInt("Id"));
				hotelAmenity.setAmenityId(rs.getInt("AmenityId"));
				hotelAmenity.setValue(rs.getBoolean("Value"));
				hotelAmenities.add(hotelAmenity);
			}
			System.out.println("[HotelAmenitiesManager] - Get HotelAmenities Successful");
		} catch (SQLException e) {
			System.out.println("[HotelAmenitiesManager] - Get HotelAmenities Failed");
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
		return hotelAmenities;
	}
	
}
