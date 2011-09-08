package br.com.taxisimples.passageiro.service;

import ioc.TaxiSimplesIoC;

import java.math.BigDecimal;
import java.util.List;

import br.com.taxisimples.passageiro.Payment;
import br.com.taxisimples.passageiro.Ride;
import br.com.taxisimples.passageiro.service.listeners.PaymentListener;
import br.com.taxisimples.passageiro.service.wire.PaymentWireService;

public class PaymentService {

	protected List<PaymentListener> listeners;

	protected PaymentWireService wire;	
	protected static PaymentService instance;
	
	protected PaymentService(PaymentWireService wire){
		this.wire=wire;
	}

	public static synchronized PaymentService getInstance() {
		if (instance==null) {
			PaymentWireService  wire = (PaymentWireService ) TaxiSimplesIoC.lookup(PaymentWireService .class);
			instance = new PaymentService(wire);
		}
		return instance;
	}

	public void makePayment(final Payment payment) {
		wire.makePayment(payment);
	}

	public void addListener(PaymentListener paymentListeners) {
		listeners.add(paymentListeners);
	}

	public void removeListener(PaymentListener paymentListeners) {
		listeners.remove(paymentListeners);
	}

	public void notifyPaymentDone(Payment payment) {
		for (PaymentListener listener : listeners) {
			listener.paymentDone(payment);
		}
	}

	public void notifyPaymentRequested(Ride ride, BigDecimal amount) {
		for (PaymentListener listener : listeners) {
			listener.paymentRequested(ride, amount);
		}
	}

}
