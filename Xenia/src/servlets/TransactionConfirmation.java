package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.ReservationBean;
import managers.ReservationManager;
import managers.TransactionManager;
import managers.UserManager;
import models.Reservation;
import models.Transaction;
import models.User;

/**
 * Servlet implementation class TransactionConfirmation
 */
public class TransactionConfirmation extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TransactionConfirmation() {
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
		User user = (User)session.getAttribute("user");
		Transaction trans = new Transaction();
		Reservation res = new Reservation();

		String message = "";
		boolean success = false;
		
		String creditFirstName = request.getParameter("creditFirstName");
		String creditLastName = request.getParameter("creditLastName");
		String creditCardType = request.getParameter("creditCardType");
		String creditCardNumber = request.getParameter("creditCardNumber");
		String creditCardCVV = request.getParameter("creditCardCVV");
		String creditCardExpirationDate = request.getParameter("creditCardExpirationDate");
		
		String billingFirstName = request.getParameter("billingFirstName");
		String billingLastName = request.getParameter("billingLastName");
		String billingAddress1 = request.getParameter("billingAddress1");
		String billingAddress2 = request.getParameter("billingAddress2");
		String billingCity = request.getParameter("billingCity");
		String billingState = request.getParameter("billingState");
		String billingCountry = request.getParameter("billingCountry");
		String billingZip = request.getParameter("billingZip");
	/*	
		List<Transaction> creditCards = TransactionManager.getTransactions(null, null, creditCardNumber, null,null, null, creditCardCVV);
		Transaction creditCard = null;
		if (creditCards.isEmpty()) {
			trans.setBalance(25000.00);
			trans.setCreditCardNumber(creditCardNumber);
			trans.setCvv(creditCardCVV);
			trans.setCardHolderName(creditFirstName + " " + creditLastName);
			trans.setCardNickname(creditCardType);
			trans.setUserId(user.getId());
			TransactionManager.addTransaction(trans);
			creditCard = trans;
		} else {
			creditCard = creditCards.get(0);
		}
		if (reservation.getRoom().getPricePerNight() < creditCard.getBalance()){
			
			creditCard.setBalance(creditCard.getBalance() - reservation.getRoom().getPricePerNight() * reservation.getQuery().getDuration());
			TransactionManager.updateTransaction(creditCard);
			*/
			user.setAddress1(billingAddress1);
			user.setAddress2(billingAddress2);
			user.setCity(billingCity);
			user.setState(billingState);
			user.setZip(billingZip);
			session.setAttribute("user", user);
			
			res.setCheckInDate(reservation.getQuery().getCheckInString());
			res.setCheckOutDate(reservation.getQuery().getCheckOutString());
			res.setHotel(reservation.getHotel());
			res.setHotelId(reservation.getHotel().getId());
			res.setNumberOfRooms(reservation.getQuery().getNumRooms());
			res.setReservationNumber("" + (int)(Math.random() * 9999));
			switch (reservation.getQuery().getRoomType()) {
			case "Suite":
				res.setRoomTypeId(1);
				break;
			case "Standard":
				res.setRoomTypeId(2);
				break;
			case "Family":
				res.setRoomTypeId(3);
				break;
			}
			res.setUserId(user.getId());
			ReservationManager.addReservation(res);
			//session.setAttribute("transaction", creditCard);
			session.setAttribute("reservation", res);
			
			message = "Transaction successfully completed, your reservation number is: " + res.getReservationNumber();
			success = true;
		//} else {
		//	message = "Transaction failed, insufficient funds";
		//	success = false;
		//}
		
		session.setAttribute("message", message);
		session.setAttribute("success", success);
		request.getRequestDispatcher("CustomerHomepage.jsp").forward(request, response);
	}

}
