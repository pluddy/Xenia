package managers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

import models.Reservation;
import models.Transaction;


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
	public static List<Reservation> getResrvations(Integer ID, Integer HotelID, 
			Date CheckInDate, Date CheckOutDate, Integer NumberOfRooms, String ReservationNumber,
			Integer UserID, Integer Status, String Notes, Integer RoomTypeID) {
		Connection con = DBConnectionManager.getConnection();
		List<Reservation> reservations = new ArrayList<Reservation>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM HotelReservations";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (ID != null && ID > 0) {
		    clauses.add("ID = ?");
		    parameters.add(ID);
		}
		if (HotelID != null && HotelID > 0) {
		    clauses.add("HotelID = ?");
		    parameters.add(HotelID);
		} 
		if (CheckInDate != null) {
		    clauses.add("CheckInDate = ?");
		    parameters.add(CheckInDate);
		} 
		if (CheckOutDate != null) {
		    clauses.add("CheckOutDate = ?");
		    parameters.add(CheckOutDate);
		} 
		if (NumberOfRooms != null && NumberOfRooms > 0) {
		    clauses.add("NumberOfRooms = ?");
		    parameters.add(NumberOfRooms);
		} 
		if (ReservationNumber != null) {
		    clauses.add("ReservationNumber = ?");
		    parameters.add(ReservationNumber);
		}
		 if (UserID != null && UserID > 0) {
		    clauses.add("UserID = ?");
		    parameters.add(UserID);
		}
		 if (Status != null && Status > 0) {
			    clauses.add("Status = ?");
			    parameters.add(Status);
			}
		 if (Notes != null) {
			    clauses.add("Notes = ?");
			    parameters.add(Notes);
			}
		 if (RoomTypeID != null && RoomTypeID > 0) {
			    clauses.add("RoomTypeID = ?");
			    parameters.add(RoomTypeID);
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
				reservation.setHotelID(rs.getInt("HotelID"));
				reservation.setCheckInDate(rs.getDate("CheckInDate"));
				reservation.setCheckOutDate(rs.getDate("CheckOutDate"));
				reservation.setNumberOfRooms(rs.getInt("NumberOfRooms"));
				reservation.setReservationNumber(rs.getString("ReservationNumber"));
				reservation.setUserID(rs.getInt("UserID"));
				reservation.setStatus(rs.getInt("Status"));
				reservation.setNotes(rs.getString("Notes"));
				reservation.setRoomTypeID(rs.getInt("RoomTypeID"));
				reservations.add(reservation);
			}
			System.out.println("[TransactionManager] - Get Reservations Successful");
		} catch (SQLException e) {
			System.out.println("[TransactionManager] - Get Reservations Failed");
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
		List<Reservation> reservations = new ArrayList<Reservation>();
		Statement addReservation = null;
		ResultSet rs = null;
	
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
		 */

		String sql = "INSERT INTO CreditCards (HotelID, CheckInDate, CheckOutDate, NumberOfRooms, ReservationNumber, UserID, Status, Notes, RoomTypeID)" 
		 + reservation.getHotelID() + ", " 
		 + reservation.getCheckInDate() + ", "
		 + reservation.getCheckOutDate() + ", "
		 + reservation.getNumberOfRooms() + ", "
		 + reservation.getReservationNumber() + ", "
		 + reservation.getUserID() + ", "
		 + reservation.getStatus() + ", "
		 + reservation.getNotes() + ", "
		 + reservation.getRoomTypeID() + ", ";
		
		try {
			addReservation = con.createStatement();
			rs = addReservation.executeQuery(sql);
		
			System.out.println("[DBManager] - Reservation " + reservation.getID() + " created.");
			
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
