package br.com.taxisimples.passageiro;

import java.math.BigDecimal;

public class Payment {

	private Ride ride;
	private CredCardFlag flag;
	private BigDecimal amount;
	private String cardNumber;
	private String ownerFullName;
	private int secureCode;
	private String validUntil;
	private String billingAddress;
	public Ride getRide() {
		return ride;
	}
	public void setRide(Ride ride) {
		this.ride = ride;
	}
	public CredCardFlag getFlag() {
		return flag;
	}
	public void setFlag(CredCardFlag flag) {
		this.flag = flag;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	public String getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getOwnerFullName() {
		return ownerFullName;
	}
	public void setOwnerFullName(String ownerFullName) {
		this.ownerFullName = ownerFullName;
	}
	public int getSecureCode() {
		return secureCode;
	}
	public void setSecureCode(int secureCode) {
		this.secureCode = secureCode;
	}
	public String getValidUntil() {
		return validUntil;
	}
	public void setValidUntil(String validUntil) {
		this.validUntil = validUntil;
	}
	public String getBillingAddress() {
		return billingAddress;
	}
	public void setBillingAddress(String billingAddress) {
		this.billingAddress = billingAddress;
	}
	
}
