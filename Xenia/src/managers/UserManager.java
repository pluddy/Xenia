package managers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.*;
import org.apache.log4j.Logger;

import models.User;

public final class UserManager {
	
	final static Logger log = Logger.getLogger(UserManager.class.getName());
	
	public static List<User> getUsers(
			Integer id,
			String username, 
			String firstName, 
			String lastName, 
			String addressLine1, 
			String addressLine2,
			String city,
			String state,
			String zip
			) {
		Connection con = DBConnectionManager.getConnection();
		List<User> users = new ArrayList<User>();
		Statement getUsers = null;
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Users u";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (id != null){
			clauses.add("u.Id = ?");
			parameters.add(username);
		}
		
		if (username != null){
			clauses.add("u.Username = ?");
			parameters.add(username);
		}
		
		if (firstName != null){
			clauses.add("u.FirstName = ?");
			parameters.add(firstName);
		}
		
		if (lastName != null){
			clauses.add("u.LastName = ?");
			parameters.add(lastName);
		}
		
		if (addressLine1 != null){
			clauses.add("u.AddressLine1 = ?");
			parameters.add(addressLine1);
		}
		
		if (addressLine2 != null){
			clauses.add("u.AddressLine2 = ?");
			parameters.add(addressLine2);
		}
		
		if (city != null){
			clauses.add("u.City = ?");
			parameters.add(city);
		}
		
		if (state != null){
			clauses.add("u.State = ?");
			parameters.add(state);
		}
		
		if (zip != null){
			clauses.add("u.Zip = ?");
			parameters.add(zip);
		}
		
		if (!clauses.isEmpty()) {
		    sql += " WHERE " + StringUtils.join(clauses, " AND ");
		}
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for (int i = 0; i < parameters.size(); i++) {
			    ps.setObject(i + 1, parameters.get(i));
			}
			
			rs = ps.executeQuery();
			
			while (rs.next()){
				User user = new User();
				user.setUsername(rs.getString("Username"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setAddress1(rs.getString("AddressLine1"));
				user.setAddress2(rs.getString("AddressLine2"));
				user.setCity(rs.getString("City"));
				user.setState(rs.getString("State"));
				user.setZip(rs.getString("PostalCode"));
				users.add(user);
			}
			log.info("Get Users Successful");
		} catch (SQLException e) {
			log.error("Get Users Failed", e);
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				getUsers.close();
				con.close();
			} catch (SQLException e) {
				log.error("Close connection failed", e);
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public static User validateUser(String username, String password) {
		Connection con = DBConnectionManager.getConnection();
		List<User> users = new ArrayList<User>();
		ResultSet rs = null;
		
		String sql = "SELECT * FROM Users u";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		clauses.add("u.Username = ?");
		parameters.add(username);
		
		clauses.add("u.Password = ?");
		parameters.add(password);
		
		sql += " WHERE " + StringUtils.join(clauses, " AND ");
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			for (int i = 0; i < parameters.size(); i++) {
			    ps.setObject(i + 1, parameters.get(i));
			}
			
			rs = ps.executeQuery();
			
			while (rs.next()){
				User user = new User();
				user.setId(rs.getInt("Id"));
				user.setUsername(rs.getString("Username"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setAddress1(rs.getString("AddressLine1"));
				user.setAddress2(rs.getString("AddressLine2"));
				user.setCity(rs.getString("City"));
				user.setState(rs.getString("State"));
				user.setZip(rs.getString("PostalCode"));
				users.add(user);
			}
			log.info("Get Users Successful");
		} catch (SQLException e) {
			log.error("Get Users Failed", e);
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
				log.error("Close connection failed", e);
				e.printStackTrace();
			}
		}
		if (users.size() > 0) {
			log.info("User " + users.get(0).getUsername() + " Validated");
			return users.get(0);
		} else {
			log.info("User Not Found");
			return null;
		}
	}
	
	public static void addUser(User user) {
		
		Connection con = DBConnectionManager.getConnection();
		Statement addUser = null;
		
		String sql = "INSERT INTO Users ( Username, FirstName, LastName, AddressLine1, AddressLine2, City, State, PostalCode, Password ) VALUES (\'"
				+ user.getUsername() + "\', \'"
				+ user.getFirstName() + "\', \'"
				+ user.getLastName() + "\', \'"
				+ user.getAddress1() + "\', \'"
				+ user.getAddress2() + "\', \'"
				+ user.getCity() + "\', \'"
				+ user.getState() + "\', \'"
				+ user.getZip() + "\', \'"
				+ user.getPassword() + "\' )";
		
		try {
			addUser = con.createStatement();
			
			addUser.executeUpdate(sql);
			
			log.info("User " + user.getUsername() + " Added");
		} catch (SQLException e) {
			log.error("Add User Failed",e);
			e.printStackTrace();
		} finally {
			try {
				addUser.close();
				con.close();
			} catch (SQLException e) {
				log.error("Close connection failed", e);
				e.printStackTrace();
			}
		}
	}
	
	public static void updateUser(User user) {
		Connection con = DBConnectionManager.getConnection();
		Statement updateUser = null;
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
		
		
		String sql = "UPDATE Users SET Username = " + user.getUsername() 
		+ " Password = " + user.getPassword()
		+ " FirstName = " + user.getFirstName()
		+ " LastName = " + user.getLastName()
		+ " AddressLine1 = " + user.getAddress1()
		+ " AddressLine2 = " + user.getAddress2() 
		+ " City = " + user.getCity()
		+ " State = " + user.getState()
		+ " PostalCode = " + user.getZip()
		+ " WHERE Id = " + user.getId(); 
		
		try {
			updateUser = con.createStatement();
			rs = updateUser.executeQuery(sql);
			
			
			log.info("User " + user.getId() + " updated.");
			
		} catch (SQLException e) {
			log.error("Update User Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				updateUser.close();
				con.close();
			} catch (SQLException e) {
				log.error("Close connection failed", e);
				e.printStackTrace();
			}
		}
	}
	
	public static void removeUser(Integer userId) {
		Connection con = DBConnectionManager.getConnection();
		Statement removeUser = null;
		ResultSet rs = null;
		
		String sql = "DELETE Users WHERE Id = "  + userId; 
		 
		try {
			removeUser = con.createStatement();
			rs = removeUser.executeQuery(sql);
			
			log.info("User " + userId + " removed.");
			
		} catch (SQLException e) {
			log.error("Remove User Failed", e);
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				removeUser.close();
				con.close();
			} catch (SQLException e) {
				log.error("Close connection failed", e);
				e.printStackTrace();
			}
		}
	}
}
