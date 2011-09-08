package br.com.taxisimples.passageiro;

public enum CurrencyEnum {
	BrazilianReal("BRL","R$");
	
	private String isoDisplay;
	private String currencyDisplay;
	
	
	public String getIsoDisplay() {
		return isoDisplay;
	}


	public void setIsoDisplay(String isoDisplay) {
		this.isoDisplay = isoDisplay;
	}


	public String getCurrencyDisplay() {
		return currencyDisplay;
	}


	public void setCurrencyDisplay(String currencyDisplay) {
		this.currencyDisplay = currencyDisplay;
	}


	CurrencyEnum(String isoDisplay, String currencyDisplay) {
		this.currencyDisplay=currencyDisplay;
		this.isoDisplay=isoDisplay;
	}
}
