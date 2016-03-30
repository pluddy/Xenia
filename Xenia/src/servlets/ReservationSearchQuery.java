package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ReservationSearchQueryBean;
import beans.ReservationSearchResultBean;
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
		Calendar checkIn = GregorianCalendar.getInstance();
		checkIn.set(Integer.parseInt(arr[2]), Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
		System.out.println(checkIn.get(Calendar.DAY_OF_MONTH));
		
		String checkOutDate = request.getParameter("checkOutDate");
		arr = checkOutDate.split("/");
		Calendar checkOut = GregorianCalendar.getInstance();
		checkOut.set(Integer.parseInt(arr[2]), Integer.parseInt(arr[0]), Integer.parseInt(arr[1]));
		System.out.println(checkOut.get(Calendar.DAY_OF_MONTH));
		
		String locationCity = request.getParameter("locationCity");
		String numberOfRooms = request.getParameter("numberOfRooms");
		String roomType = request.getParameter("roomType");
		List<String> amenities = Arrays.asList(request.getParameterValues("amenities"));
		
		ReservationSearchQueryBean queryBean = new ReservationSearchQueryBean(checkIn, checkOut, locationCity, Integer.parseInt(numberOfRooms), roomType, amenities);
		session.setAttribute("query", queryBean);
		
		List<ReservationSearchResultBean> hotelBeans = SearchService.searchHotels(queryBean);
		
		session.setAttribute("hotels", hotelBeans);
		
		request.getRequestDispatcher("ReservationSearch.jsp").forward(request, response);
		
	}

}
