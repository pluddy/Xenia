package managers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import models.Reservation;


public final class ReservationManager {

	/*
	 * 	private Integer ID;
	private Integer HotelID;
	private Date CheckInDate;
	private Date CheckOutDate;
	private Integer NumberOfRooms;
	private String ReservationNumber;
	private Integer UserID;
	private Integer Status;
	private String Notes;
	private Integer RoomTypeID;
	 * 
	 */
	public static List<Reservation> getResrvations(
			Integer id, 
			Integer hotelId, 
			Date checkInDate, 
			Date checkOutDate, 
			Integer numberOfRooms, 
			String reservationNumber,
			Integer userId, 
			Integer status, 
			String notes, 
			Integer roomTypeId) {
		Connection con = DBConnectionManager.getConnection();
		List<Reservation> reservations = new ArrayList<Reservation>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM HotelReservations";
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
		if (checkInDate != null) {
		    clauses.add("CheckInDate = ?");
		    parameters.add(checkInDate);
		} 
		if (checkOutDate != null) {
		    clauses.add("CheckOutDate = ?");
		    parameters.add(checkOutDate);
		} 
		if (numberOfRooms != null) {
		    clauses.add("NumberOfRooms = ?");
		    parameters.add(numberOfRooms);
		} 
		if (reservationNumber != null) {
		    clauses.add("ReservationNumber = ?");
		    parameters.add(reservationNumber);
		}
		 if (userId != null) {
		    clauses.add("UserId = ?");
		    parameters.add(userId);
		}
		 if (status != null) {
			    clauses.add("Status = ?");
			    parameters.add(status);
			}
		 if (notes != null) {
			    clauses.add("Notes = ?");
			    parameters.add(notes);
			}
		 if (roomTypeId != null) {
			    clauses.add("RoomTypeId = ?");
			    parameters.add(roomTypeId);
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
				
				Reservation reservation = new Reservation();
				reservation.setHotelId(rs.getInt("HotelId"));
				reservation.setCheckInDate(rs.getDate("CheckInDate"));
				reservation.setCheckOutDate(rs.getDate("CheckOutDate"));
				reservation.setNumberOfRooms(rs.getInt("NumberOfRooms"));
				reservation.setReservationNumber(rs.getString("ReservationNumber"));
				reservation.setUserId(rs.getInt("UserId"));
				reservation.setStatus(rs.getInt("Status"));
				reservation.setNotes(rs.getString("Notes"));
				reservation.setRoomTypeId(rs.getInt("RoomTypeId"));
				reservations.add(reservation);
			}
			System.out.println("[ReservationManager] - Get Reservations Successful");
		} catch (SQLException e) {
			System.out.println("[ReservationManager] - Get Reservations Failed");
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
		return reservations;
	}
	
	public static void addReservation(Reservation reservation) {
		Connection con = DBConnectionManager.getConnection();
		Statement addReservation = null;
		ResultSet rs = null;
	
		/*
			private Integer ID;
			private Integer HotelID;
			private Date CheckInDate;
			private Date CheckOutDate;
			private Integer NumberOfRooms;
			private String ReservationNumber;
			private Integer UserID;
			private Integer Status;
			private String Notes;
			private Integer RoomTypeID;
		*/

		String sql = "INSERT INTO CreditCards (HotelId, CheckInDate, CheckOutDate, NumberOfRooms, ReservationNumber, UserId, Status, Notes, RoomTypeId)" 
		 + reservation.getHotelId() + ", " 
		 + reservation.getCheckInDate() + ", "
		 + reservation.getCheckOutDate() + ", "
		 + reservation.getNumberOfRooms() + ", "
		 + reservation.getReservationNumber() + ", "
		 + reservation.getUserId() + ", "
		 + reservation.getStatus() + ", "
		 + reservation.getNotes() + ", "
		 + reservation.getRoomTypeId() + ", ";
		
		try {
			addReservation = con.createStatement();
			rs = addReservation.executeQuery(sql);
		
			System.out.println("[ReservationManager] - Reservation " + reservation.getId() + " created.");
			
		} catch (SQLException e) {
			System.out.println("[ReservationManager] - Add Reservation Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				addReservation.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
}
