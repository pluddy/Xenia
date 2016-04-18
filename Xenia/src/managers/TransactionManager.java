package managers;

import java.security.NoSuchAlgorithmException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import models.Transaction;
import services.HashService;

public final class TransactionManager {
	
	final static Logger log = Logger.getLogger(TransactionManager.class.getName());
	
	public static List<Transaction> getTransactions(
			Integer id, 
			String cardHolderName,
			String creditCardNumber,
			Double balance, 
			String cardNickname, 
			Integer userId, 
			String cvv) {
		Connection con = DBConnectionManager.getConnection();
		List<Transaction> transactions = new ArrayList<Transaction>();
		PreparedStatement ps = null;
		ResultSet rs = null;
	
		
		String sql = "SELECT * FROM CreditCards";
		List<String> clauses = new ArrayList<String>();
		List<Object> parameters = new ArrayList<Object>();
		
		
		
		try {
			if (id != null) {
			    clauses.add("Id = ?");
			    parameters.add(id);
			}
			if (cardHolderName != null) {
			    clauses.add("CardHolderName = ?");

			    parameters.add(cardHolderName);
			} 
			if (creditCardNumber != null) {
			    clauses.add("CreditCardNumber = ?");
			    parameters.add(HashService.hash(creditCardNumber));
			}
			if (balance != null) {
			    clauses.add("Balance = ?");
			    parameters.add(balance);
			} 
			if (cardNickname != null) {
			    clauses.add("CardNickname = ?");
			    parameters.add(cardNickname);
			} 
			if (userId != null) {
			    clauses.add("UserId = ?");
			    parameters.add(userId);
			}
			 if (cvv != null) {
			    clauses.add("CVV = ?");
			    parameters.add(cvv);
			}
			
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
				transaction.setId(rs.getInt("Id"));
				transaction.setCardHolderName(rs.getString("CardHolderName"));
				transaction.setCreditCardNumber(rs.getString("CreditCardNumber"));
				transaction.setBalance(rs.getFloat("Balance"));
				transaction.setCardNickname(rs.getString("CardNickname"));
				transaction.setUserId(rs.getInt("UserId"));
				transaction.setCvv(rs.getString("CVV"));
				transactions.add(transaction);
			}
			log.info("Get Transactions Successful");
		} catch (SQLException e) {
			log.error("Get Transactions Failed",e);
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			log.error("Message Digest could not be instantiated",e);
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				ps.close();
				con.close();
			} catch (SQLException e) {
				log.error("Close connection failed", e);
				e.printStackTrace();
			}
		}
		return transactions;
	}
	
	public static void addTransaction(Transaction transaction) {
		Connection con = DBConnectionManager.getConnection();
		Statement addTransaction = null;
	
		/*
		 * 	private Integer ID;
	private String CardHolderNumber;
	private String CreditCardNumber;
	private Float Balance;
	private String CardNickname;
	private Integer UserID;
	private String CVV;
		 */
		
		
		try {
			String sql = "INSERT INTO CreditCards (CardHolderName, CreditCardNumber, Balance, CardNickname, UserId, CVV) VALUES (\'" 
					 + transaction.getCardHolderName() + "\', \'"
					 + HashService.hash(transaction.getCreditCardNumber()) + "\', \'"
					 + transaction.getBalance() + "\', \'"
					 + transaction.getCardNickname() + "\', \'"
					 + transaction.getUserId() + "\', \'"
					 + transaction.getCvv() + "\' )";
			addTransaction = con.createStatement();
			addTransaction.executeUpdate(sql);

			log.info("Transaction " + transaction.getId() + " created.");
		} catch (SQLException e) {
			log.error("Get Transactions Failed", e);
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			log.error("Message Digest could not be instantiated",e);
			e.printStackTrace();
		} finally {
			try {
				addTransaction.close();
				con.close();
			} catch (SQLException e) {
				log.error("Close connection failed", e);
				e.printStackTrace();
			}
		}
	}
	
	public static void updateTransaction(Transaction transaction) {
		Connection con = DBConnectionManager.getConnection();
		Statement updateTransaction = null;
		int rs;
	
		/*
		 * 	private Integer ID;
	private String CardHolderNumber;
	private String CreditCardNumber;
	private Float Balance;
	private String CardNickname;
	private Integer UserID;
	private String CVV;
		 */

		try {
			String sql = "UPDATE CreditCards SET CardHolderName = " + transaction.getCardHolderName() 
			+ " CreditCardNumber = " + HashService.hash(transaction.getCreditCardNumber())
			+ " Balance = " + transaction.getBalance()
			+ " CardNickname = " + transaction.getCardNickname() 
			+ " UserId = " + transaction.getUserId()
			+ " CVV = " + transaction.getCvv() 
			+ " WHERE Id = " + transaction.getId();
			
			updateTransaction = con.createStatement();
			updateTransaction.executeUpdate(sql);
			
			log.info("Transaction " + transaction.getId() + " updated.");
			
		} catch (SQLException e) {
			log.error("Update Transactions Failed",e);
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			log.error("Message Digest could not be instantiated",e);
			e.printStackTrace();
		} finally {
			try {
				//rs.close();
				updateTransaction.close();
				con.close();
			} catch (SQLException e) {
				log.error("Close connection failed", e);
				e.printStackTrace();
			}
		}
	}
	
	public static boolean validateTransaction(Transaction transaction) {
	
		List<Transaction> trans;
		try {
			trans = getTransactions(transaction.getId(), transaction.getCardHolderName(), HashService.hash(transaction.getCreditCardNumber()),
					transaction.getBalance(), transaction.getCardNickname(), transaction.getUserId(), transaction.getCvv());
			if(!trans.isEmpty()){
				log.info("Transaction " + transaction.getCardNickname() + " validated.");
				return true;
			} else {
				log.info("Transaction " + transaction.getCardNickname() + " not found.");
				return false;
			}
		} catch (NoSuchAlgorithmException e) {
			log.error("Message Digest could not be instantiated",e);
			e.printStackTrace();
			return false;
		}

		
	}
	
	public static void removeTransaction(Integer transactionID) {
		Connection con = DBConnectionManager.getConnection();
		Statement removeTransaction = null;
		ResultSet rs = null;
		
		String sql = "DELETE CreditCards WHERE Id = "  + transactionID; 
		 
		try {
			removeTransaction = con.createStatement();
			rs = removeTransaction.executeQuery(sql);

			log.info("Transaction " + transactionID + " removed.");
		} catch (SQLException e) {
			log.error("Remove Transaction Failed",e);
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
