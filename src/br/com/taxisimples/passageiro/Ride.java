package br.com.taxisimples.passageiro;

import java.util.Date;


public class Ride {

	private TaxiFare calculate;
	private PaymentEnum paymentMode;//(cash, visa, mastercard or diner)
	private boolean wheelchair; //(cadeirante, sim ou não)
	private CapacityEnuym capacityNeed; //Number of people (pessoas q vão usar o taxi, 4, 5 ou 6)
	private boolean englishLanguage; //english language (sim ou não)
	private boolean spanishLanguage;//spanish language (sim ou não)
	private boolean scheduled;
	private Date scheduledAt;
	private RideStatusEnum status;
	
	
	
	public boolean isScheduled() {
		return scheduled;
	}
	public void setScheduled(boolean scheduled) {
		this.scheduled = scheduled;
	}
	public Date getScheduledAt() {
		return scheduledAt;
	}
	public void setScheduledAt(Date scheduledAt) {
		this.scheduledAt = scheduledAt;
	}
	public TaxiFare getCalculate() {
		return calculate;
	}
	public void setCalculate(TaxiFare calculate) {
		this.calculate = calculate;
	}
	public PaymentEnum getPaymentMode() {
		return paymentMode;
	}
	public void setPaymentMode(PaymentEnum paymentMode) {
		this.paymentMode = paymentMode;
	}
	public boolean isWheelchair() {
		return wheelchair;
	}
	public void setWheelchair(boolean wheelchair) {
		this.wheelchair = wheelchair;
	}
	public CapacityEnuym getCapacityNeed() {
		return capacityNeed;
	}
	public void setCapacityNeed(CapacityEnuym capacityNeed) {
		this.capacityNeed = capacityNeed;
	}
	public boolean isEnglishLanguage() {
		return englishLanguage;
	}
	public void setEnglishLanguage(boolean englishLanguage) {
		this.englishLanguage = englishLanguage;
	}
	public boolean isSpanishLanguage() {
		return spanishLanguage;
	}
	public void setSpanishLanguage(boolean spanishLanguage) {
		this.spanishLanguage = spanishLanguage;
	}
	public void setStatus(RideStatusEnum status) {
		this.status = status;
	}
	
	public RideStatusEnum getStatus() {
		return status;
	}
	public void setDriver(TaxiDriver driver) {
		this.setDriver(driver);
	}
	
}
