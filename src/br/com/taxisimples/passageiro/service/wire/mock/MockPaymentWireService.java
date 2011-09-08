package br.com.taxisimples.passageiro.service.wire.mock;

import br.com.taxisimples.passageiro.Payment;
import br.com.taxisimples.passageiro.service.PaymentService;
import br.com.taxisimples.passageiro.service.wire.PaymentWireService;

public class MockPaymentWireService implements PaymentWireService {

	private PaymentService service = PaymentService.getInstance();
	
	@Override
	public void makePayment(Payment payment) {
		try {
			Thread.sleep(1000);
			service.notifyPaymentDone(payment);
		} catch (InterruptedException e) {
			throw new RuntimeException(e);
		}
	}

}
