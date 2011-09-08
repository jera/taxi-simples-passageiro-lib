package br.com.taxisimples.passageiro;

public class TaxiDriver {
	
	private String id;
	private String name;
	private int rate;
	private boolean favorited;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setRate(int rate) {
		this.rate = rate;
	}

	public int getRate() {
		return rate;
	}
	public void setFavorited(boolean favorited) {
		this.favorited = favorited;
	}
	
	public boolean isFavorited() {
		return favorited;
	}
}
