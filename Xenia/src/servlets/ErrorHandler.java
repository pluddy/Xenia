package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import managers.DBConnectionManager;

/**
 * Servlet implementation class ErrorHandler
 */
public class ErrorHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	final static Logger log = Logger.getLogger(ErrorHandler.class);

    /**
     * @see HttpServlet#HttpServlet()
     */
    public ErrorHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String error = request.getAttribute("error").toString();
		String stackTrace = request.getAttribute("stackTrace").toString();
		//Need to add error logging here
		log.error(error +" "+ stackTrace);
		
		request.setAttribute("reservationId", request.getParameter("reservationId"));
		request.getRequestDispatcher("ErrorHandler.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
