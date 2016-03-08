package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import models.HotelRoom;

public class HotelRoomManager {
	
	public static List<HotelRoom> getHotelRooms(
			Integer id, 
			Integer roomTypeId, 
			Integer hotelId, 
			Integer availableNumber,
			Double pricePerNight,
			Date startDate,
			Date endDate) {
		Connection con = DBConnectionManager.getConnection();
		List<HotelRoom> hotelRooms = new ArrayList<HotelRoom>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM HotelRooms";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (id != null) {
		    clauses.add("Id = ?");
		    parameters.add(id);
		}
		if (roomTypeId != null) {
		    clauses.add("RoomTypeId = ?");
		    parameters.add(roomTypeId);
		} 
		if (hotelId != null) {
		    clauses.add("HotelId = ?");
		    parameters.add(hotelId);
		} 
		if (availableNumber != null) {
		    clauses.add("AvailableNumber = ?");
		    parameters.add(availableNumber);
		} 
		if (pricePerNight != null) {
		    clauses.add("PricePerNight = ?");
		    parameters.add(pricePerNight);
		} 
		if (startDate != null) {
		    clauses.add("StartDate = ?");
		    parameters.add(startDate);
		} 
		if (endDate != null) {
		    clauses.add("EndDate = ?");
		    parameters.add(endDate);
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
				
				HotelRoom hotelRoom = new HotelRoom();
				hotelRoom.setId(rs.getInt("Id"));
				hotelRoom.setRoomTypeId(rs.getInt("RoomTypeId"));
				hotelRoom.setHotelId(rs.getInt("HotelId"));
				hotelRoom.setAvailableNumber(rs.getInt("AvailableNumber"));
				hotelRoom.setPricePerNight(rs.getDouble("PricePerNight"));
				hotelRoom.setStartDate(rs.getDate("StartDate"));
				hotelRoom.setEndDate(rs.getDate("EndDate"));
				hotelRooms.add(hotelRoom);
			}
			System.out.println("[HotelRoomsManager] - Get HotelRooms Successful");
		} catch (SQLException e) {
			System.out.println("[HotelRoomsManager] - Get HotelRooms Failed");
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
		return hotelRooms;
	}
	
	public static void updateHotelRooms(HotelRoom hotelRoom) {
		Connection con = DBConnectionManager.getConnection();
		Statement updateHotelRoom = null;
		ResultSet rs = null;
	
		/*
			private String username;
			private String password;
			private String firstName;
			private String lastName;
			private String address1;
			private String address2;
			private String city;
			private String state;
			private String zip;
		*/
		
		
		String sql = "UPDATE HotelRooms SET RoomTypeId = " + hotelRoom.getRoomTypeId() 
		+ " HotelId = " + hotelRoom.getHotelId()
		+ " AvailableNumber = " + hotelRoom.getAvailableNumber()
		+ " PricePerNight = " + hotelRoom.getPricePerNight()
		+ " StartDate = " + hotelRoom.getStartDate()
		+ " EndDate = " + hotelRoom.getEndDate() 
		+ " WHERE Id = " + hotelRoom.getId(); 
		
		try {
			updateHotelRoom = con.createStatement();
			rs = updateHotelRoom.executeQuery(sql);
			
			
			System.out.println("[HotelRoomsManager] - HotelRoom " + hotelRoom.getId() + " updated.");
			
		} catch (SQLException e) {
			System.out.println("[HotelRoomsManager] - Update HotelRooms Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				updateHotelRoom.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
