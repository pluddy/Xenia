package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import models.Amenity;

public class AmenityManager {
	
	final static Logger log = Logger.getLogger(AmenityManager.class.getName());

	public static List<Amenity> getAmenities(
			Integer id, 
			String name) {
		Connection con = DBConnectionManager.getConnection();
		List<Amenity> amenities = new ArrayList<Amenity>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM Amenities";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (id > 0) {
		    clauses.add("Id = ?");
		    parameters.add(id);
		}
		if (name != null) {
		    clauses.add("Name = ?");
		    parameters.add(name);
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
				
				Amenity amenity = new Amenity();
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
