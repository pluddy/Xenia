package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import models.Amenities;

public class AmenitiesManager {

	public static List<Amenities> getAmenities(
			int Id, 
			String Name) {
		Connection con = DBConnectionManager.getConnection();
		List<Amenities> amenities = new ArrayList<Amenities>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM Amenities";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (Id > 0) {
		    clauses.add("Id = ?");
		    parameters.add(Id);
		}
		if (Name != null) {
		    clauses.add("Name = ?");
		    parameters.add(Name);
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
				
				Amenities amenity = new Amenities();
				amenity.setId(rs.getInt("Id"));
				amenity.setName(rs.getString("Name"));
				amenities.add(amenity);
			}
			System.out.println("[AmenitiesManager] - Get Amenities Successful");
		} catch (SQLException e) {
			System.out.println("[AmenitiesManager] - Get Amenities Failed");
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
		return amenities;
	}
	
	
}
