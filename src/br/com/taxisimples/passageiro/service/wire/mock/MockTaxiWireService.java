package br.com.taxisimples.passageiro.service.wire.mock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import br.com.taxisimples.passageiro.CurrencyEnum;
import br.com.taxisimples.passageiro.Ride;
import br.com.taxisimples.passageiro.RidePrice;
import br.com.taxisimples.passageiro.RideStatusEnum;
import br.com.taxisimples.passageiro.Route;
import br.com.taxisimples.passageiro.TaxiDriver;
import br.com.taxisimples.passageiro.TaxiFare;
import br.com.taxisimples.passageiro.service.PaymentService;
import br.com.taxisimples.passageiro.service.TaxiService;
import br.com.taxisimples.passageiro.service.wire.TaxiWireService;

public class MockTaxiWireService implements TaxiWireService {

	private TaxiService service = TaxiService.getInstance();
	private PaymentService paymentService = PaymentService.getInstance();
	
	@Override
	public void requestTaxiFareCalculate(Route route) {
		TaxiFare fareCalculate = createTaxiFare(route);
		service.notifyTaxiFareCalculated(fareCalculate);
	}

	private TaxiFare createTaxiFare(Route route) {
		TaxiFare fareCalculate = new TaxiFare();
		fareCalculate.setId(UUID.randomUUID().toString());
		fareCalculate.setDistance((float) (Math.random()*10));
		fareCalculate.setJson(route.getJson());
		
		RidePrice bandeira1 = new RidePrice();
		bandeira1.setCurrenry(CurrencyEnum.BrazilianReal);
		bandeira1.setAmount(new BigDecimal((fareCalculate.getDistance()*3)+3));
		
		RidePrice bandeira2 = new RidePrice();
		bandeira2.setCurrenry(CurrencyEnum.BrazilianReal);
		bandeira2.setAmount(new BigDecimal((fareCalculate.getDistance()*3.4)+3));
		
		List<RidePrice> prices = new ArrayList<RidePrice>(); 
		prices.add(bandeira1);
		prices.add(bandeira2);
		
		fareCalculate.setPrices(prices);
		return fareCalculate;
	}

	@Override
	public void requestTaxiRide(final Ride ride) {
		ride.setStatus(RideStatusEnum.WHAIT_FOR_A_CAB);
		service.notifyTaxiStatusReceived(ride);
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(15000);
					paymentService.notifyPaymentRequested(ride,ride.getCalculate().getPrices().get(0).getAmount());
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
				
			}
		}).start();
	}

	@Override
	public void requestScheduleTaxiRide(Ride ride, Date scheduledAt) {
		ride.setStatus(RideStatusEnum.WHAIT_FOR_A_CAB);
		service.notifyTaxiRideScheduled(ride);
		try {
			Thread.sleep(2000);
			TaxiDriver driver = createDriver(ride);
			ride.setStatus(RideStatusEnum.WHAIT_FOR_SCHEDULE_TIME);
			ride.setDriver(driver);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

	private TaxiDriver createDriver(Ride ride) {
		TaxiDriver driver = new TaxiDriver();
		driver.setId(UUID.randomUUID().toString());
		driver.setName("Nome..."+Math.random());
		driver.setRate(3);
		driver.setFavorited(false);
		return driver;
	}

	@Override
	public void requestTaxiRideStatus(Ride ride) {
		TaxiDriver driver = createDriver(ride);
		ride.setDriver(driver);
		ride.setStatus(RideStatusEnum.DRIVER_ON_THE_WAY);
		service.notifyTaxiRideStatusReceived(ride);
	}

	@Override
	public void rateTaxiDriver(Ride ride, int rate) {
		service.notifyTaxiDriverRated(ride);
	}

	@Override
	public void favoriteTaxiDriver(TaxiDriver driver) {
		service.notifyTaxiDriverFavorited(driver);
	}

}
