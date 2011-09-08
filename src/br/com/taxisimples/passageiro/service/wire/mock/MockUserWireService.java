package br.com.taxisimples.passageiro.service.wire.mock;

import br.com.taxisimples.passageiro.Account;
import br.com.taxisimples.passageiro.service.exceptions.CreateAccountFailExceptions;
import br.com.taxisimples.passageiro.service.exceptions.LoginFailExceptions;
import br.com.taxisimples.passageiro.service.wire.UserWireService;

public class MockUserWireService implements UserWireService {

	@Override
	public void login(String username, String password) throws LoginFailExceptions {
		int logou = (int) Math.round(Math.random());
		switch (logou) {
		case 0:
			throw new LoginFailExceptions();
		}
	}

	@Override
	public void createAccount(Account account)
			throws CreateAccountFailExceptions {
		int criou = (int) Math.round(Math.random());
		switch (criou) {
		case 0:
			throw new CreateAccountFailExceptions();
		}
	}

}
