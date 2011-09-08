package br.com.taxisimples.passageiro.service.listeners;

import java.math.BigDecimal;

import br.com.taxisimples.passageiro.Payment;
import br.com.taxisimples.passageiro.Ride;

public interface PaymentListener {
	
	void paymentDone(Payment payment);
	void paymentRequested(Ride ride, BigDecimal amount);
	
}
