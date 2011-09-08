package br.com.taxisimples.passageiro.service;

import ioc.TaxiSimplesIoC;
import br.com.taxisimples.passageiro.Account;
import br.com.taxisimples.passageiro.service.exceptions.CreateAccountFailExceptions;
import br.com.taxisimples.passageiro.service.exceptions.LoginFailExceptions;
import br.com.taxisimples.passageiro.service.wire.UserWireService;

public class UserService {

	protected UserWireService wire;	
	protected static UserService instance;
	
	protected UserService(UserWireService wire){
		this.wire=wire;
	}

	public static synchronized UserService getInstance() {
		if (instance==null) {
			UserWireService wire = (UserWireService) TaxiSimplesIoC.lookup(UserWireService.class);
			instance = new UserService(wire);
		}
		return instance;
	}	
	
	public void login(String username, String password)
			throws LoginFailExceptions {
		wire.login(username, password);
	}
	
	public void createAccount(Account account) throws CreateAccountFailExceptions {
		wire.createAccount(account);
	}
}

