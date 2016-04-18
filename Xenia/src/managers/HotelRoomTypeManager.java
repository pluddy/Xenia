package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import models.HotelRoomType;

public class HotelRoomTypeManager {
	
	final static Logger log = Logger.getLogger(HotelRoomTypeManager.class.getName());
	
	public static List<HotelRoomType> getHotelRoomType(
			Integer id, 
			String roomType, 
			String description) {
		Connection con = DBConnectionManager.getConnection();
		List<HotelRoomType> hotelRoomsType = new ArrayList<HotelRoomType>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM HotelRoomType";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (id != null) {
		    clauses.add("Id = ?");
		    parameters.add(id);
		}
		if (roomType != null) {
		    clauses.add("RoomType = ?");
		    parameters.add(roomType);
		} 
		if (description != null) {
		    clauses.add("Description = ?");
		    parameters.add(description);
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
				
				HotelRoomType hotelRoomType = new HotelRoomType();
				hotelRoomType.setId(rs.getInt("Id"));
				hotelRoomType.setRoomType(rs.getString("RoomType"));
				hotelRoomType.setDescription(rs.getString("Description"));
				hotelRoomsType.add(hotelRoomType);
			}
			log.info("Get HotelRoomsType Successful");
		} catch (SQLException e) {
			log.error("Get HotelRoomsType Failed", e);
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				log.error("Close connection failed", e);
			}
		}
		return hotelRoomsType;
	}
	
}
