package managers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import models.Hotel;

public final class HotelManager {
	
	public static List<Hotel> getHotels(
			Integer id, 
			String name, 
			String city, 
			String state,
			Integer owneruserid,
			String description,
			String nearestpoints,
			String address) {
		Connection con = DBConnectionManager.getConnection();
		List<Hotel> hotels = new ArrayList<Hotel>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM Hotels";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (id != null) {
		    clauses.add("Id = ?");
		    parameters.add(id);
		}
		if (name != null) {
		    clauses.add("Name = ?");
		    parameters.add(name);
		} 
		if (city != null) {
		    clauses.add("City = ?");
		    parameters.add(city);
		} 
		if (state != null) {
		    clauses.add("State = ?");
		    parameters.add(state);
		} 
		if (description != null) {
		    clauses.add("Description = ?");
		    parameters.add(description);
		} 
		if (address != null) {
		    clauses.add("Address = ?");
		    parameters.add(address);
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
				
				Hotel hotel = new Hotel();
				hotel.setId(rs.getInt("Id"));
				hotel.setName(rs.getString("Name"));
				hotel.setCity(rs.getString("City"));
				hotel.setState(rs.getString("State"));
				hotel.setDescription(rs.getString("Description"));
				hotel.setAddress(rs.getString("Address"));
				hotels.add(hotel);
			}
			System.out.println("[HotelManager] - Get Hotel Successful");
		} catch (SQLException e) {
			System.out.println("[HotelManager] - Get Hotel Failed");
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
		return hotels;
	}
	
	public static void updateHotelRooms(Hotel hotel) {
		Connection con = DBConnectionManager.getConnection();
		Statement updateHotel = null;
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
		
		
		String sql = "UPDATE Hotels SET Name = " + hotel.getName() 
		+ " City = " + hotel.getCity()
		+ " State = " + hotel.getState()
		+ " Description = " + hotel.getDescription()
		+ " Address = " + hotel.getAddress() 
		+ " WHERE Id = " + hotel.getId(); 
		
		try {
			updateHotel = con.createStatement();
			rs = updateHotel.executeQuery(sql);
			
			
			System.out.println("[HotelManager] - Hotel " + hotel.getId() + " updated.");
			
		} catch (SQLException e) {
			System.out.println("[HotelManager] - Update Hotel Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				updateHotel.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
