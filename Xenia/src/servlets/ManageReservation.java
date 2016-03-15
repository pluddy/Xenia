package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managers.ReservationManager;
import models.Reservation;
import models.User;

/**
 * Servlet implementation class ManageReservation
 */
public class ManageReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ManageReservation() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		
		User user = (User)session.getAttribute("user");
		if (user == null) {
			request.getRequestDispatcher("Login.jsp").forward(request, response);
		}
		
		//HttpSession session = request.getSession();
		
		//User user = (User)session.getAttribute("user");
		List<Reservation> reservations = ReservationManager.getReservations(null, null, null, null, null, null, user.getId(), null, null, null);
		
		request.setAttribute("reservations", reservations);
		request.getRequestDispatcher("ManageReservations.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String paramater = request.getParameter("reservationId");
		request.setAttribute("reservationId", request.getParameter("reservationId"));
		request.getRequestDispatcher("CancelConfirm").forward(request, response);
	}

}
