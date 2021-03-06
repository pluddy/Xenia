package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import models.HotelRoom;
import models.HotelRoomType;

public class HotelRoomManager {
	
	final static Logger log = Logger.getLogger(HotelRoomManager.class.getName());
	
	public static List<HotelRoom> getHotelRooms(
			Integer id, 
			Integer roomTypeId, 
			Integer hotelId, 
			Integer availableNumber,
			Double pricePerNight,
			Calendar startDate,
			Calendar endDate) {
		Connection con = DBConnectionManager.getConnection();
		List<HotelRoom> hotelRooms = new ArrayList<HotelRoom>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT HR.Id, HR.RoomTypeId, HR.HotelId, HR.AvailableNumber, HR.PricePerNight, HR.StartDate, HR.EndDate, HRT.RoomType, HRT.Description FROM HotelRooms HR JOIN HotelRoomType HRT ON HR.RoomTypeId = HRT.Id";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (id != null) {
		    clauses.add("HR.Id = ?");
		    parameters.add(id);
		}
		if (roomTypeId != null) {
		    clauses.add("HR.RoomTypeId = ?");
		    parameters.add(roomTypeId);
		} 
		if (hotelId != null) {
		    clauses.add("HR.HotelId = ?");
		    parameters.add(hotelId);
		} 
		if (availableNumber != null) {
		    clauses.add("HR.AvailableNumber = ?");
		    parameters.add(availableNumber);
		} 
		if (pricePerNight != null) {
		    clauses.add("HR.PricePerNight = ?");
		    parameters.add(pricePerNight);
		} 
		if (startDate != null) {
		    clauses.add("HR.StartDate = ?");
		    parameters.add(startDate);
		} 
		if (endDate != null) {
		    clauses.add("HR.EndDate = ?");
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
				Calendar cal = new GregorianCalendar();
		        cal.setTime(rs.getDate("StartDate"));
				hotelRoom.setStartDate(cal);
				cal = new GregorianCalendar();
		        cal.setTime(rs.getDate("EndDate"));
				hotelRoom.setEndDate(cal);
				
				HotelRoomType roomType = new HotelRoomType();
				roomType.setId(rs.getInt("RoomTypeId"));
				roomType.setRoomType(rs.getString("RoomType"));
				roomType.setDescription(rs.getString("Description"));
				
				hotelRoom.setRoomType(roomType);
				
				hotelRooms.add(hotelRoom);
			}
			log.info("Get HotelRooms Successful");
		} catch (SQLException e) {
			log.error("Get HotelRooms Failed", e);
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
