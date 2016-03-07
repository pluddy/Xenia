package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import models.HotelRoomType;

public class HotelRoomTypeManager {
	
	public static List<HotelRoomType> getHotelRoomType(
			int Id, 
			String RoomType, 
			String Description) {
		Connection con = DBConnectionManager.getConnection();
		List<HotelRoomType> hotelRoomsType = new ArrayList<HotelRoomType>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM HotelRoomType";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (Id > 0) {
		    clauses.add("Id = ?");
		    parameters.add(Id);
		}
		if (RoomType != null) {
		    clauses.add("RoomType = ?");
		    parameters.add(RoomType);
		} 
		if (Description != null) {
		    clauses.add("Description = ?");
		    parameters.add(Description);
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
			System.out.println("[HotelRoomsTypeManager] - Get HotelRoomsType Successful");
		} catch (SQLException e) {
			System.out.println("[HotelRoomsTypeManager] - Get HotelRoomsType Failed");
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
		return hotelRoomsType;
	}
	
}
