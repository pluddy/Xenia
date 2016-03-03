package models;

public class Transaction {
	
	private int id;
	private String cardHolderNumber;
	private String creditCardNumber;
	private double balance;
	private String cardNickname;
	private int userId;
	private String cvv;
	
	/**
	 *
	 */
	public Transaction() {

	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the cardHolderNumber
	 */
	public String getCardHolderNumber() {
		return cardHolderNumber;
	}

	/**
	 * @param cardHolderNumber the cardHolderNumber to set
	 */
	public void setCardHolderNumber(String cardHolderNumber) {
		this.cardHolderNumber = cardHolderNumber;
	}

	/**
	 * @return the creditCardNumber
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	/**
	 * @param creditCardNumber the creditCardNumber to set
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.balance = balance;
	}

	/**
	 * @return the cardNickname
	 */
	public String getCardNickname() {
		return cardNickname;
	}

	/**
	 * @param cardNickname the cardNickname to set
	 */
	public void setCardNickname(String cardNickname) {
		this.cardNickname = cardNickname;
	}

	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * @return the cvv
	 */
	public String getCvv() {
		return cvv;
	}

	/**
	 * @param cvv the cvv to set
	 */
	public void setCvv(String cvv) {
		this.cvv = cvv;
	}

	
}
