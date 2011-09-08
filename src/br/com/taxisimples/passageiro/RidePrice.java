package br.com.taxisimples.passageiro;

import java.math.BigDecimal;

public class RidePrice {

	private CurrencyEnum currenry;
	private BigDecimal amount;
	public CurrencyEnum getCurrenry() {
		return currenry;
	}
	public void setCurrenry(CurrencyEnum currenry) {
		this.currenry = currenry;
	}
	public BigDecimal getAmount() {
		return amount;
	}
	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}
	
	
}
