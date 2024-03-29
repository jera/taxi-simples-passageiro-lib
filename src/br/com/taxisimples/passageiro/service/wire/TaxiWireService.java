package br.com.taxisimples.passageiro.service.wire;

import java.util.Date;

import br.com.taxisimples.passageiro.Ride;
import br.com.taxisimples.passageiro.Route;
import br.com.taxisimples.passageiro.TaxiDriver;
import br.com.taxisimples.passageiro.service.PaymentService;
import br.com.taxisimples.passageiro.service.TaxiService;

public interface TaxiWireService {

	void requestTaxiFareCalculate(Route route);
	void requestTaxiRide(Ride ride);
	void requestScheduleTaxiRide(Ride ride, Date scheduledAt);
	void requestTaxiRideStatus(Ride ride);
	void rateTaxiDriver(Ride ride, int rate);
	void favoriteTaxiDriver(TaxiDriver driver);
	void setService(TaxiService service);
	void setPaymentService(PaymentService service);
	
}
