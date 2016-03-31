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

import managers.HotelRoomManager;
import managers.ReservationManager;
import managers.TransactionManager;
import models.HotelRoom;
import models.Reservation;
import models.Transaction;
import models.User;

/**
 * Servlet implementation class CancelReservation
 */
public class CancelReservation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CancelReservation() {
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
		/*String reservationString = (String)request.getAttribute("reservationId");
		int reservationId = Integer.parseInt(reservationString);

		Reservation hotelReservation = ReservationManager.getReservations(reservationId, null, null, null, null, null, null, null, null, null).get(0);

		request.setAttribute("reservation", hotelReservation);
		request.getRequestDispatcher("CancelReservations.jsp").forward(request, response);
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("user");

		String paramater = request.getParameter("reservationId");
		int id = Integer.parseInt(paramater);
		List<Reservation> reservation = ReservationManager.getReservations(id, null, null, null, null, null, null, null, null, null);

		ReservationManager.updateReservationStatus(id, 0);


		int dayDiff = 1;
		long end = reservation.get(0).getCheckIn().getTimeInMillis();
		long start = reservation.get(0).getCheckOut().getTimeInMillis();
		dayDiff = (int) TimeUnit.MILLISECONDS.toDays(Math.abs(end - start));
		// System.out.println ("Days: " + TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));

		List<HotelRoom> hotelRoom =  HotelRoomManager.getHotelRooms(null, reservation.get(0).getRoomTypeId(), reservation.get(0).getHotelId(), null, null, null, null);

		double cost = hotelRoom.get(0).getPricePerNight() * dayDiff;

		List<Transaction> transaction =  TransactionManager.getTransactions(null, null, null, null, null, user.getId(), null);
		Transaction updatedTransaction = transaction.get(0);

		double balance = updatedTransaction.getBalance();
		balance = balance + cost;

		updatedTransaction.setBalance(balance);

		TransactionManager.updateTransaction(updatedTransaction);

		session.setAttribute("reservation", reservation);
		session.setAttribute("moneyBack", cost);

		request.getRequestDispatcher("ConfrimCancellation").forward(request, response);
	}

}
