package managers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.*;
import models.User;

public final class UserManager {
	
	public static List<User> getUsers(
			int Id,
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
			System.out.println("[UserManager] - Get Users Successful");
		} catch (SQLException e) {
			System.out.println("[UserManager] - Get Users Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				getUsers.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return users;
	}
	
	public static void addUser(User user) {
		
		Connection con = DBConnectionManager.getConnection();
		Statement addUser = null;
		ResultSet rs = null;
		
		String sql = "INSERT INTO Users ( Username, FirstName, LastName, AddressLine1, AddressLine2, City, State, PostalCode ) VALUES ("
				+ user.getUsername() + ", "
				+ user.getFirstName() + ", "
				+ user.getLastName() + ", "
				+ user.getAddress1() + ", "
				+ user.getAddress2() + ", "
				+ user.getCity() + ", "
				+ user.getState() + ", "
				+ user.getZip() + " )";
		
		try {
			addUser = con.createStatement();
			
			rs = addUser.executeQuery(sql);
			
			System.out.println("[UserManager] - User " + user.getUsername() + " Added");
		} catch (SQLException e) {
			System.out.println("[UserManager] - Add User Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				con.close();
			} catch (SQLException e) {
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
		+ " WHERE ID = " + user.getId(); 
		
		try {
			updateUser = con.createStatement();
			rs = updateUser.executeQuery(sql);
			
			
			System.out.println("[DBManager] - User " + user.getId() + " updated.");
			
		} catch (SQLException e) {
			System.out.println("[TransactionManager] - Update User Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				updateUser.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean validateUser(User user) {
		
		/* int Id,
		 * String username, 
			String firstName, 
			String lastName, 
			String addressLine1, 
			String addressLine2,
			String city,
			String state,
			String zip */
	
		List<User> users = getUsers(user.getId(), user.getUsername(), user.getFirstName(), user.getLastName(), user.getAddress1(), user.getAddress2(),
				user.getCity(), user.getState(), user.getZip());

		if(!users.isEmpty()){
			System.out.println("[DBManager] - User " + user.getUsername() + " validated.");
			return true;
		} else {
			System.out.println("[DBManager] - Transaction " + user.getUsername() + " not found.");
			return false;
		}
	}
	
	public static void removeTransaction(Integer userId) {
		Connection con = DBConnectionManager.getConnection();
		Statement removeUser = null;
		ResultSet rs = null;
		
		String sql = "DELETE Users WHERE ID = "  + userId; 
		 
		try {
			removeUser = con.createStatement();
			rs = removeUser.executeQuery(sql);
			
			System.out.println("[DBManager] - User " + userId + " removed.");
			
			//p.store(new FileOutputStream(propFilePath), null);
		} catch (SQLException e) {
			System.out.println("[TransactionManager] - Remove User Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				removeUser.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
