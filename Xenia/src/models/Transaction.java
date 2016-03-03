package models;

public class Transaction {
	/**
	 * @param iD
	 * @param cardHolderNumber
	 * @param creditCardNumber
	 * @param balance
	 * @param cardNickname
	 * @param userID
	 * @param cVV
	 */
	public Transaction() {

	}
	private int ID;
	private String CardHolderNumber;
	private String CreditCardNumber;
	private double Balance;
	private String CardNickname;
	private int UserID;
	private String CVV;
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}
	/**
	 * @return the cardHolderNumber
	 */
	public String getCardHolderNumber() {
		return CardHolderNumber;
	}
	/**
	 * @param cardHolderNumber the cardHolderNumber to set
	 */
	public void setCardHolderNumber(String cardHolderNumber) {
		CardHolderNumber = cardHolderNumber;
	}
	/**
	 * @return the creditCardNumber
	 */
	public String getCreditCardNumber() {
		return CreditCardNumber;
	}
	/**
	 * @param creditCardNumber the creditCardNumber to set
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		CreditCardNumber = creditCardNumber;
	}
	/**
	 * @return the balance
	 */
	public double getBalance() {
		return Balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		Balance = balance;
	}
	/**
	 * @return the cardNickname
	 */
	public String getCardNickname() {
		return CardNickname;
	}
	/**
	 * @param cardNickname the cardNickname to set
	 */
	public void setCardNickname(String cardNickname) {
		CardNickname = cardNickname;
	}
	/**
	 * @return the userID
	 */
	public int getUserID() {
		return UserID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(int userID) {
		UserID = userID;
	}
	/**
	 * @return the cVV
	 */
	public String getCVV() {
		return CVV;
	}
	/**
	 * @param cVV the cVV to set
	 */
	public void setCVV(String cVV) {
		CVV = cVV;
	}

}
