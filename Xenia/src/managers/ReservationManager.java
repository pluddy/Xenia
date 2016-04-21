package managers;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import models.Reservation;


public final class ReservationManager {
	
	final static Logger log = Logger.getLogger(ReservationManager.class.getName());

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
	public static List<Reservation> getReservations(
			Integer id, 
			Integer hotelId, 
			Calendar checkInDate, 
			Calendar checkOutDate, 
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
				reservation.setId(rs.getInt("Id"));
				reservation.setHotelId(rs.getInt("HotelId"));
				
				java.sql.Date date = java.sql.Date.valueOf(rs.getDate("CheckInDate").toString());

		        Calendar cal = new GregorianCalendar();
		        cal.setTime(date);
		        reservation.setCheckIn(cal);
		        
		        java.sql.Date date2 = java.sql.Date.valueOf(rs.getDate("CheckOutDate").toString());

		        Calendar cal2 = new GregorianCalendar();
		        cal2.setTime(date2);
		        reservation.setCheckOut(cal2);
				reservation.setNumberOfRooms(rs.getInt("NumberOfRooms"));
				reservation.setReservationNumber(rs.getString("ReservationNumber"));
				reservation.setUserId(rs.getInt("UserId"));
				reservation.setStatus(rs.getInt("Status"));
				reservation.setNotes(rs.getString("Notes"));
				reservation.setRoomTypeId(rs.getInt("RoomTypeId"));
				reservation.setHotel(HotelManager.getHotels(rs.getInt("HotelId"), null, null, null, null, null, null, null).get(0));
				reservations.add(reservation);
			}
			log.info("Get Reservations Successful");
		} catch (SQLException e) {
			log.error("Get Reservations Failed", e);
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
		return reservations;
	}
	
	public static void addReservation(Reservation reservation) {
		Connection con = DBConnectionManager.getConnection();
		Statement addReservation = null;
	
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

		String sql = "INSERT INTO HotelReservations (HotelId, CheckInDate, CheckOutDate, NumberOfRooms, ReservationNumber, UserId, Status, Notes, RoomTypeId) VALUES (\'" 
		 + reservation.getHotelId() + "\', \'"
		 + reservation.getCheckIn().get(Calendar.YEAR) + "-" + reservation.getCheckIn().get(Calendar.MONTH) + "-" + reservation.getCheckIn().get(Calendar.DAY_OF_MONTH) + "\', \'"
		 + reservation.getCheckOut().get(Calendar.YEAR) + "-" + reservation.getCheckOut().get(Calendar.MONTH) + "-" + reservation.getCheckOut().get(Calendar.DAY_OF_MONTH) + "\', \'"
		 + reservation.getNumberOfRooms() + "\', \'"
		 + reservation.getReservationNumber() + "\', \'"
		 + reservation.getUserId() + "\', \'"
		 + reservation.getStatus() + "\', \'"
		 + reservation.getNotes() + "\', \'"
		 + reservation.getRoomTypeId() + "\' )";
		
		try {
			addReservation = con.createStatement();
			addReservation.executeUpdate(sql);
		
			log.info("Reservation " + reservation.getId() + " created.");
			
		} catch (SQLException e) {
			log.error("Add Reservation Failed", e);
		} finally {
			try {
				addReservation.close();
				con.close();
			} catch (SQLException e) {
				log.error("Close connection failed", e);
				e.printStackTrace();
			}
		}
	}
	
	public static void updateReservationStatus(int reservationId, int status) {
		Connection con = DBConnectionManager.getConnection();
		Statement updateReservation = null;
		int rs;
	
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

		String sql = "UPDATE HotelReservations SET Status = " 
		 + status
		 + " WHERE Id = " + reservationId;
		
		try {
			updateReservation = con.createStatement();
			rs = updateReservation.executeUpdate(sql);
		
			log.info("Updated Reservation Status " + reservationId +" "+ status + " created.");
			
		} catch (SQLException e) {
			log.info("Update Reservation Status Failed");
			e.printStackTrace();
		} finally {
			try {
				updateReservation.close();
				con.close();
			} catch (SQLException e) {
				log.error("Close connection failed", e);
				e.printStackTrace();
			}
		}
	}
	
}
