package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import managers.ReservationManager;
import models.Reservation;
import models.User;

/**
 * Servlet implementation class CancelConfirm
 */
public class CancelConfirm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CancelConfirm() {
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
		
		String reservationString = (String)request.getAttribute("reservationId");
		int reservationId = Integer.parseInt(reservationString);
		
		Reservation hotelReservation = ReservationManager.getReservations(reservationId, null, null, null, null, null, null, null, null, null).get(0);
		
		if (hotelReservation == null){
			request.getRequestDispatcher("ErrorHandler.jsp").forward(request, response);
		}
		
		request.setAttribute("reservation", hotelReservation);
		request.getRequestDispatcher("CancelReservations.jsp").forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		
	}

}
