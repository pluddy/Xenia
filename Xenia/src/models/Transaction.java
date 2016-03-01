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
	private Integer ID;
	private String CardHolderNumber;
	private String CreditCardNumber;
	private Float Balance;
	private String CardNickname;
	private Integer UserID;
	private String CVV;
	/**
	 * @return the iD
	 */
	public Integer getID() {
		return ID;
	}
	/**
	 * @param iD the iD to set
	 */
	public void setID(Integer iD) {
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
	public Float getBalance() {
		return Balance;
	}
	/**
	 * @param balance the balance to set
	 */
	public void setBalance(Float balance) {
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
	public Integer getUserID() {
		return UserID;
	}
	/**
	 * @param userID the userID to set
	 */
	public void setUserID(Integer userID) {
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
