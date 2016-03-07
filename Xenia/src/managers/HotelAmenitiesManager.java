package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import models.HotelAmenities;

public class HotelAmenitiesManager {

	public static List<HotelAmenities> getHotelAmenities(
			int Id, 
			int HotelId, 
			int AmenityId, 
			Boolean Value) {
		Connection con = DBConnectionManager.getConnection();
		List<HotelAmenities> hotelAmenities = new ArrayList<HotelAmenities>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM HotelAmenities";
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
		if (AmenityId > 0) {
		    clauses.add("AmenityId = ?");
		    parameters.add(AmenityId);
		} 
		if (Value != null) {
		    clauses.add("Value = ?");
		    parameters.add(Value);
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
				
				HotelAmenities hotelAmenity = new HotelAmenities();
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
