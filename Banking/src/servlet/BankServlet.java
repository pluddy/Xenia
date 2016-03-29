package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import managers.TransactionManager;
import models.Bank;
import models.Transaction;

/**
 * Servlet implementation class Bank
 */
@WebServlet("/Bank")
public class BankServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BankServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		String creditCardNumber = request.getParameter("creditCardNumber");
		String CVV = request.getParameter("creditCardCVV");
		double totalCost = Double.parseDouble(request.getParameter("totalCost"));
		
		
		Bank bank = new Bank();

		List<Transaction> creditCard = TransactionManager.getTransactions(null, null, creditCardNumber, null, null, null, CVV);
		if (creditCard.size() == 0){
		if (creditCard.get(0).getBalance() <= totalCost) {
			//balance is not enough
			bank.setStatus("Failure");
			bank.setMessage("Insufficient Funds! Can't afford these reservations!"); 

		} else {
			//update balance to take out reservation total
			Transaction updatedCC = creditCard.get(0);
			double newBalance = updatedCC.getBalance() - totalCost;
			updatedCC.setBalance(newBalance);
			TransactionManager.updateTransaction(updatedCC);
			
			bank.setStatus("Success");
			bank.setMessage("Reservation successfully paid for!");
			
		} 
	} else {
			bank.setStatus("Failure");
			bank.setMessage("No credit card found for that number.");
					}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	
	public Bank checkBalance(String creditCardNumber, String CVV, double totalCost){
		Bank bank = new Bank();

		List<Transaction> creditCard = TransactionManager.getTransactions(null, null, creditCardNumber, null, null, null, CVV);
		if (creditCard.size() == 0){
		if (creditCard.get(0).getBalance() <= totalCost) {
			//balance is not enough
			bank.setStatus("Failure");
			bank.setMessage("Insufficient Funds! Can't afford these reservations!"); 
			return bank;
		} else {
			//update balance to take out reservation total
			Transaction updatedCC = creditCard.get(0);
			double newBalance = updatedCC.getBalance() - totalCost;
			updatedCC.setBalance(newBalance);
			TransactionManager.updateTransaction(updatedCC);
			
			bank.setStatus("Success");
			bank.setMessage("Reservation successfully paid for!");
			
			return bank;
		} 
	} else {
			bank.setStatus("Failure");
			bank.setMessage("No credit card found for that number.");
			
			return bank;
		}
}
}
