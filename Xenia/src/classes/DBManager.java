package classes;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.servlet.ServletContext;

public final class DBManager {
	
	public static void addUser(User user, ServletContext sc) {
		String username = user.username;
		String password = user.password;
		
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
	
	public static Boolean validateUser(User user, ServletContext sc) {
		String username = user.username;
		String password = user.password;
		
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
		if (DBManager.validateUser(user, sc)) {
			String username = user.username;
			
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
