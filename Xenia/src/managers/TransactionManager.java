package managers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import models.Transaction;

public final class TransactionManager {
	
	public static List<Transaction> getTransactions(
			int Id, 
			String CardHolderNumber, 
			String CreditCardNumber, 
			double Balance, 
			String CardNickname, 
			int userId, 
			String CVV) {
		Connection con = DBConnectionManager.getConnection();
		List<Transaction> transactions = new ArrayList<Transaction>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM CreditCards";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		if (Id > 0) {
		    clauses.add("ID = ?");
		    parameters.add(Id);
		}
		if (CardHolderNumber != null) {
		    clauses.add("CardHolderNumber = ?");
		    parameters.add(CardHolderNumber);
		} 
		if (CreditCardNumber != null) {
		    clauses.add("CreditCardNumber = ?");
		    parameters.add(CreditCardNumber);
		} 
		if (Balance > 0) {
		    clauses.add("Balance = ?");
		    parameters.add(Balance);
		} 
		if (CardNickname != null) {
		    clauses.add("CardNickname = ?");
		    parameters.add(CardNickname);
		} 
		if (userId > 0) {
		    clauses.add("UserID = ?");
		    parameters.add(userId);
		}
		 if (CVV != null) {
		    clauses.add("CVV = ?");
		    parameters.add(CVV);
		}
		
		try {
			
			if (!clauses.isEmpty()) {
			    sql += " where " + StringUtils.join(clauses, " and ");
			}

			ps = con.prepareStatement(sql);
			for (int i = 0; i < parameters.size(); i++) {
			    ps.setObject(i + 1, parameters.get(i));
			}
			
			rs = ps.executeQuery();
			
			while (rs.next()){

				Transaction transaction = new Transaction();
				transaction.setId(rs.getInt("ID"));
				transaction.setCardHolderNumber(rs.getString("CardHolderNumber"));
				transaction.setCreditCardNumber(rs.getString("CreditCardNumber"));
				transaction.setBalance(rs.getFloat("Balance"));
				transaction.setCardNickname(rs.getString("CardNickname"));
				transaction.setUserId(rs.getInt("UserID"));
				transaction.setCvv(rs.getString("CVV"));
				transactions.add(transaction);
			}
			System.out.println("[TransactionManager] - Get Transactions Successful");
		} catch (SQLException e) {
			System.out.println("[TransactionManager] - Get Transactions Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return transactions;
	}
	
	public static void addTransaction(Transaction transaction) {
		Connection con = DBConnectionManager.getConnection();
		Statement addTransaction = null;
		ResultSet rs = null;
	
		/*
		 * 	private Integer ID;
	private String CardHolderNumber;
	private String CreditCardNumber;
	private Float Balance;
	private String CardNickname;
	private Integer UserID;
	private String CVV;
		 */
		String sql = "INSERT INTO CreditCards (CardHolderNumber, CreditCardNumber, Balance, CardNickname, UserID, CVV)" 
		 + transaction.getCardHolderNumber() + ", " 
		 + transaction.getCreditCardNumber() + ", "
		 + transaction.getBalance() + ", "
		 + transaction.getCardNickname() + ", "
		 + transaction.getUserId() + ", "
		 + transaction.getCvv();
		
		try {
			addTransaction = con.createStatement();
			rs = addTransaction.executeQuery(sql);

			System.out.println("[TransactionManager] - Transaction " + transaction.getId() + " created.");
		} catch (SQLException e) {
			System.out.println("[TransactionManager] - Get Transactions Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				addTransaction.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void updateTransaction(Transaction transaction) {
		Connection con = DBConnectionManager.getConnection();
		Statement updateTransaction = null;
		ResultSet rs = null;
	
		/*
		 * 	private Integer ID;
	private String CardHolderNumber;
	private String CreditCardNumber;
	private Float Balance;
	private String CardNickname;
	private Integer UserID;
	private String CVV;
		 */
		
		String sql = "UPDATE CreditCards SET CardHolderNumber = " + transaction.getCardHolderNumber() 
		+ " CreditCardNumber = " + transaction.getCreditCardNumber()
		+ " Balance = " + transaction.getBalance()
		+ " CardNickname = " + transaction.getCardNickname() 
		+ " UserID = " + transaction.getUserId()
		+ " CVV = " + transaction.getCvv() 
		+ " WHERE ID = " + transaction.getId(); 
		
		try {
			updateTransaction = con.createStatement();
			rs = updateTransaction.executeQuery(sql);
			
			System.out.println("[TransactionManager] - Transaction " + transaction.getId() + " updated.");
			
		} catch (SQLException e) {
			System.out.println("[TransactionManager] - Update Transactions Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				updateTransaction.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static boolean validateTransaction(Transaction transaction) {
	
		List<Transaction> trans = getTransactions(transaction.getId(), transaction.getCardHolderNumber(), transaction.getCreditCardNumber(),
				transaction.getBalance(), transaction.getCardNickname(), transaction.getUserId(), transaction.getCvv());

		if(!trans.isEmpty()){
			System.out.println("[TransactionManager] - Transaction " + transaction.getCardNickname() + " validated.");
			return true;
		} else {
			System.out.println("[TransactionManager] - Transaction " + transaction.getCardNickname() + " not found.");
			return false;
		}
	}
	
	public static void removeTransaction(Integer transactionID) {
		Connection con = DBConnectionManager.getConnection();
		Statement removeTransaction = null;
		ResultSet rs = null;
		
		String sql = "DELETE CreditCards WHERE ID = "  + transactionID; 
		 
		try {
			removeTransaction = con.createStatement();
			rs = removeTransaction.executeQuery(sql);

			System.out.println("[TransactionManager] - Transaction " + transactionID + " removed.");
		} catch (SQLException e) {
			System.out.println("[TransactionManager] - Remove Transaction Failed");
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				removeTransaction.close();
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
