package servlets;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
		for (int i=0; i< reservations.size(); i++){
			if (reservations.get(i).getStatus() != 0){
			checkDate(reservations.get(i).getCheckInDate(), reservations.get(i).getId());
			}
		}
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
	
	private void checkDate(String startDate, int reservationId){
		
		 
		 SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Date dateobj = new Date();
		 
		 try {
			    Date startDay = myFormat.parse(startDate);
			   // Date currentDate = myFormat.parse(dateobj.toString());
			    //long diff = date2.getTime() - date1.getTime();
			    if (dateobj.after(startDay)){
			    	
			    	ReservationManager.updateReservationStatus(reservationId, 0);
			    	
			    }
			   // System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
			} catch (ParseException e) {
			    e.printStackTrace();
			}
	
	}

}
