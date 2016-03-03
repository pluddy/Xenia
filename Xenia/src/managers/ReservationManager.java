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
			int Id, 
			int HotelId, 
			Date CheckInDate, 
			Date CheckOutDate, 
			int NumberOfRooms, 
			String ReservationNumber,
			int UserId, 
			int Status, 
			String Notes, 
			int RoomTypeId) {
		Connection con = DBConnectionManager.getConnection();
		List<Reservation> reservations = new ArrayList<Reservation>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM HotelReservations";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (Id > 0) {
		    clauses.add("ID = ?");
		    parameters.add(Id);
		}
		if (HotelId > 0) {
		    clauses.add("HotelID = ?");
		    parameters.add(HotelId);
		} 
		if (CheckInDate != null) {
		    clauses.add("CheckInDate = ?");
		    parameters.add(CheckInDate);
		} 
		if (CheckOutDate != null) {
		    clauses.add("CheckOutDate = ?");
		    parameters.add(CheckOutDate);
		} 
		if (NumberOfRooms > 0) {
		    clauses.add("NumberOfRooms = ?");
		    parameters.add(NumberOfRooms);
		} 
		if (ReservationNumber != null) {
		    clauses.add("ReservationNumber = ?");
		    parameters.add(ReservationNumber);
		}
		 if (UserId > 0) {
		    clauses.add("UserID = ?");
		    parameters.add(UserId);
		}
		 if (Status > 0) {
			    clauses.add("Status = ?");
			    parameters.add(Status);
			}
		 if (Notes != null) {
			    clauses.add("Notes = ?");
			    parameters.add(Notes);
			}
		 if (RoomTypeId > 0) {
			    clauses.add("RoomTypeID = ?");
			    parameters.add(RoomTypeId);
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
				reservation.setHotelId(rs.getInt("HotelID"));
				reservation.setCheckInDate(rs.getDate("CheckInDate"));
				reservation.setCheckOutDate(rs.getDate("CheckOutDate"));
				reservation.setNumberOfRooms(rs.getInt("NumberOfRooms"));
				reservation.setReservationNumber(rs.getString("ReservationNumber"));
				reservation.setUserId(rs.getInt("UserID"));
				reservation.setStatus(rs.getInt("Status"));
				reservation.setNotes(rs.getString("Notes"));
				reservation.setRoomTypeId(rs.getInt("RoomTypeID"));
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

		String sql = "INSERT INTO CreditCards (HotelID, CheckInDate, CheckOutDate, NumberOfRooms, ReservationNumber, UserID, Status, Notes, RoomTypeID)" 
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
