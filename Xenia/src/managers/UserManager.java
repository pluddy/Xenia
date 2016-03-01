package managers;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import javax.servlet.ServletContext;

import models.User;

public final class UserManager {
	
	public static List<User> getUsers() {
		Connection con = DBConnectionManager.getConnection();
		List<User> users = new ArrayList<User>();
		Statement getUsers = null;
		ResultSet rs = null;
		
	/*	String query = "select * from foo f";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();

		if (firstName != null) {
		    clauses.add("f.name = ?");
		    parameters.add(firstName);
		}
		// ...
		if (!clauses.isEmpty()) {
		    query += " where " + StringUtils.join(clauses, " and ");
		}

		PreparedStatement ps = connection.prepareStatement(query);
		for (int i = 0; i < parameters.size(); i++) {
		    ps.setObject(i + 1, paremeters.get(i));
		}
		*/
		
		String sql = "SELECT * FROM Users";
		try {
			getUsers = con.createStatement();
			rs = getUsers.executeQuery(sql);
			while (rs.next()){
				User user = new User();
				user.setUsername(rs.getString("Username"));
				user.setFirstName(rs.getString("FirstName"));
				user.setLastName(rs.getString("LastName"));
				user.setAddress1(rs.getString("AddressLine1"));
				user.setAddress2(rs.getString("AddressLine2"));
				user.setCity(rs.getString("City"));
				user.setState(rs.getString("State"));
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
	
	public static void addUser(User user, ServletContext sc) {
		String username = user.getUsername();
		String password = user.getPassword();
		
		String propFilePath = sc.getRealPath("/WEB-INF/users.properties");
		
		Properties p = new Properties();
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			
			p.load(fis);
			p.setProperty(username, password);
			System.out.println("[DBManager] - User " + username + " created.");
			
			p.store(new FileOutputStream(propFilePath), null);
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound");
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	public static boolean validateUser(User user, ServletContext sc) {
		String username = user.getUsername();
		String password = user.getPassword();
				
		String propFilePath = sc.getRealPath("/WEB-INF/users.properties");
		
		Properties p = new Properties();
		
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream(propFilePath);
			
			p.load(fis);
			String validatePassword = p.getProperty(username);
			if (validatePassword != null) {
				System.out.println("[DBManager] - User " + username + " found.");
				if (password.equals(validatePassword)) {
					System.out.println("[DBManager] - User " + username + " has valid password.");
					return true;
				} else {
					System.out.println("[DBManager] - User " + username + " has invalid password.");
					return false;
				}
			} else {
				System.out.println("[DBManager] - User " + username + " not found.");
				return false;
			}
		} catch (FileNotFoundException e) {
			System.out.println("FileNotFound");
		} catch (IOException e) {
			System.out.println("IOException");
		} finally {
			if (fis != null) {
				try {
					fis.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
	public static void removeUser(User user, ServletContext sc) {
		if (UserManager.validateUser(user, sc)) {
			String username = user.getUsername();
			
			String propFilePath = sc.getRealPath("/WEB-INF/users.properties");
			
			Properties p = new Properties();
			
			FileInputStream fis = null;
			
			try {
				fis = new FileInputStream(propFilePath);
				
				p.load(fis);
				String validatePassword = p.getProperty(username);
				if (validatePassword != null) {
					p.remove(username);
					System.out.println("[DBManager] - User " + username + " deleted.");
				} else {
					System.out.println("[DBManager] - User " + username + " not found.");
				}
			} catch (FileNotFoundException e) {
				System.out.println("[DBManager] - FileNotFound");
			} catch (IOException e) {
				System.out.println("[DBManager] - IOException");
			} finally {
				if (fis != null) {
					try {
						fis.close();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
}
