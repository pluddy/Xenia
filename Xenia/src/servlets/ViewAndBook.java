package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ReservationBean;
import managers.HotelManager;
import models.Hotel;
import models.HotelRoom;

/**
 * Servlet implementation class ViewAndBook
 */
public class ViewAndBook extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAndBook() {
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
		HttpSession session = request.getSession();
		ReservationBean reservation = (ReservationBean)session.getAttribute("hotel");
		
		int finalRooms = Integer.parseInt(request.getParameter("numRooms"));
		if (reservation.getRoom().getAvailableNumber() < finalRooms) {
			response.sendError(400, "Not enough rooms to satisfy number chosen");;
		} else {
			reservation.getQuery().setNumRooms(finalRooms);
		}
		
		session.setAttribute("hotel", reservation);
		
		request.getRequestDispatcher("ReservationTransaction.jsp").forward(request, response);
	}

}
