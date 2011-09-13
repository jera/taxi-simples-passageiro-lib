package br.com.taxisimples.passageiro.service.listeners;

import br.com.taxisimples.passageiro.TaxiFare;
import br.com.taxisimples.passageiro.Ride;
import br.com.taxisimples.passageiro.TaxiDriver;

public interface TaxiListener {
	void taxiRideCalculated(TaxiFare calculate);
	void taxiRideStatusReceived(Ride ride);
	void taxiRideScheduled(Ride ride);
	void taxiDriverReted(Ride ride);
	void taxiDriverFavorited(TaxiDriver driver);
	void taxiRideStatusChanged(Ride ride);

}
