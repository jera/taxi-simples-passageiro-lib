package br.com.taxisimples.passageiro;

import java.util.List;

public class TaxiFare {

	private String id;
	private String json;
	private List<RidePrice> prices;
	private float distance;
	private boolean hasTaxiDriverAvaliable;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getJson() {
		return json;
	}
	public void setJson(String json) {
		this.json = json;
	}
	public List<RidePrice> getPrices() {
		return prices;
	}
	public void setPrices(List<RidePrice> prices) {
		this.prices = prices;
	}
	public float getDistance() {
		return distance;
	}
	public void setDistance(float distance) {
		this.distance = distance;
	}
	public boolean isHasTaxiDriverAvaliable() {
		return hasTaxiDriverAvaliable;
	}
	public void setHasTaxiDriverAvaliable(boolean hasTaxiDriverAvaliable) {
		this.hasTaxiDriverAvaliable = hasTaxiDriverAvaliable;
	}
	
	
}
