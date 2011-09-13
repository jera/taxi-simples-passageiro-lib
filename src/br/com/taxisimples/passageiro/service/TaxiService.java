package br.com.taxisimples.passageiro.service;

import ioc.TaxiSimplesIoC;

import java.util.Date;
import java.util.List;

import br.com.taxisimples.passageiro.Ride;
import br.com.taxisimples.passageiro.Route;
import br.com.taxisimples.passageiro.TaxiDriver;
import br.com.taxisimples.passageiro.TaxiFare;
import br.com.taxisimples.passageiro.service.listeners.TaxiListener;
import br.com.taxisimples.passageiro.service.wire.TaxiWireService;

public class TaxiService {
	
	protected List<TaxiListener> listeners;
	protected TaxiWireService wire;	
	protected static TaxiService instance;
	
	protected TaxiService(TaxiWireService wire){
		this.wire=wire;
	}

	public static synchronized TaxiService getInstance() {
		if (instance==null) {
			TaxiWireService wire = (TaxiWireService) TaxiSimplesIoC.lookup(TaxiWireService.class);
			instance = new TaxiService(wire);
			wire.setService(instance);
		}
		return instance;
	}

	public void addListener(TaxiListener listener) {
		listeners.add(listener);
	}
	
	public void removeListener(TaxiListener listener) {
		listeners.remove(listener);
	}
	
	public void requestTaxiFareCalculate(Route route){
		wire.requestTaxiFareCalculate(route);
	}

	public void requestTaxiRide(Ride ride){
		wire.requestTaxiRide(ride);
	}
	
	public void requestScheduleTaxiRide(Ride ride, Date scheduledAt){
		wire.requestScheduleTaxiRide(ride, scheduledAt);
	}
	
	public void requestTaxiRideStatus(Ride ride){
		wire.requestTaxiRideStatus(ride);
	}
	
	public void rateTaxiDriver(Ride ride, int rate) {
		wire.rateTaxiDriver(ride, rate);
	}
	
	public void favoriteTaxiDriver(TaxiDriver driver){
		wire.favoriteTaxiDriver(driver);
	}

	public void notifyTaxiFareCalculated(TaxiFare fareCalculate) {
		for (TaxiListener listener : listeners) {
			listener.taxiRideCalculated(fareCalculate);
		}
	}
	

	public void notifyTaxiStatusReceived(Ride ride) {
		for (TaxiListener listener : listeners) {
			listener.taxiRideStatusReceived(ride);
		}
	}

	public void notifyTaxiRideScheduled(Ride ride) {
		for (TaxiListener listener : listeners) {
			listener.taxiRideScheduled(ride);
		}
	}

	public void notifyTaxiRideStatusReceived(Ride ride) {
		for (TaxiListener listener : listeners) {
			listener.taxiRideStatusReceived(ride);
		}
	}

	public void notifyTaxiDriverRated(Ride ride) {
		for (TaxiListener listener : listeners) {
			listener.taxiDriverReted(ride);
		}
	}

	public void notifyTaxiDriverFavorited(TaxiDriver driver) {
		for (TaxiListener listener : listeners) {
			listener.taxiDriverFavorited(driver);
		}		
	}
	
}
