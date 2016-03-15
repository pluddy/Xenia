package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.ReservationManager;
import models.Reservation;

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
		//HttpSession session = request.getSession();
		String reservationString = (String)request.getAttribute("reservationId");
		int reservationId = Integer.parseInt(reservationString);
		
		Reservation hotelReservation = ReservationManager.getResrvations(reservationId, null, null, null, null, null, null, null, null, null).get(0);
		
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
