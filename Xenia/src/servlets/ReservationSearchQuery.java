package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import models.Hotel;
import services.SearchService;

/**
 * Servlet implementation class ReservationSearch
 */
public class ReservationSearchQuery extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReservationSearchQuery() {
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
		
		
		String checkInDate = request.getParameter("checkInDate");
		String[] arr = checkInDate.split("/");
		Calendar checkIn = Calendar.getInstance();
		checkIn.set(Calendar.YEAR, Integer.parseInt(arr[2]));
		checkIn.set(Calendar.MONTH, Integer.parseInt(arr[1]));
		checkIn.set(Calendar.DATE, Integer.parseInt(arr[0]));
		
		String checkOutDate = request.getParameter("checkOutDate");
		arr = checkOutDate.split("/");
		Calendar checkOut = Calendar.getInstance();
		checkIn.set(Calendar.YEAR, Integer.parseInt(arr[2]));
		checkIn.set(Calendar.MONTH, Integer.parseInt(arr[1]));
		checkIn.set(Calendar.DATE, Integer.parseInt(arr[0]));
		
		String locationCity = request.getParameter("locationCity");
		String numberOfRooms = request.getParameter("numberOfRooms");
		String roomType = request.getParameter("roomType");
		List<String> amenities = Arrays.asList(request.getParameterValues("amenities"));
		
		
		List<Hotel> hotels = SearchService.searchHotels(checkIn, checkOut, locationCity, Integer.parseInt(numberOfRooms), roomType, amenities);
		
		session.setAttribute("hotels", hotels);
		
		request.getRequestDispatcher("ReservationSearch.jsp").forward(request, response);
		
	}

}
