package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ReservationSearchQueryBean;
import beans.ViewBookDisplayBean;
import managers.HotelManager;
import models.Hotel;
import models.HotelAmenity;
import models.HotelRoom;

/**
 * Servlet implementation class ReservationSearchResults
 */
public class ReservationSearchResults extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationSearchResults() {
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
		int hotelId = Integer.parseInt(request.getParameter("hotelId"));
		
		List<Hotel> hotelsList = HotelManager.getHotels(hotelId, null, null, null, null, null, null, null);
		Hotel hotel = hotelsList.get(0);
		
		ReservationSearchQueryBean query = (ReservationSearchQueryBean)session.getAttribute("query");
		
		List<HotelRoom> rooms = hotel.getRooms();
		HotelRoom room = null;
		for (HotelRoom hr : rooms) {
			if (hr.getRoomType().getRoomType().equals(query.getRoomType())) {
				room = hr;
			}
		}
		if (room == null) {
			response.sendError(500);
		}		
		
		ViewBookDisplayBean viewBookBean = new ViewBookDisplayBean(hotel.getName(), 
				hotel.getAddress(), 
				query.getCheckInString() + "-" + query.getCheckOutString(), 
				query.getNumRooms(), 
				room.getPricePerNight(), 
				hotel.getDescription(), 
				hotel.getAmenitiesList(), 
				4.0, 
				hotel.getReviewsList());
		
		session.setAttribute("hotel", viewBookBean);
		
		request.getRequestDispatcher("ViewAndBookReservations.jsp").forward(request, response);
				
	}

}
