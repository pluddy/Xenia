package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import managers.DBConnectionManager;
import managers.UserManager;
import models.User;
import services.HashService;

/**
 * Servlet implementation class UpdatePassword
 */
public class UpdatePassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	final static Logger log = Logger.getLogger(UpdatePassword.class);
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdatePassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//doGet(request, response);
		String username = 	request.getParameter("username");
		String oldpassword = 	request.getParameter("previousPassword");
		String newpassword = 	request.getParameter("password");
	
		List<User> userForUsername = UserManager.getUsers(null, username, null, null, null, null, null, null, null);
		
		if (userForUsername == null){
			request.getRequestDispatcher("ErrorHandler.jsp").forward(request, response);
		}
		
		String hashedPassword = "";
		try {
			 hashedPassword = HashService.hash(oldpassword);
		}catch(Exception ex) {
			
		}
		
		log.info(userForUsername.get(0).getPassword() +" "+ hashedPassword);
		if (userForUsername.get(0).getPassword().equals(hashedPassword)){
			User userForUpdate = userForUsername.get(0);
			userForUpdate.setPassword(newpassword);
			UserManager.updateUser(userForUpdate);
		} else {
			
			log.error("Password not updated");
		}


		response.sendRedirect("Login.jsp");
	}

}
