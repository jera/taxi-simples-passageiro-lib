package br.com.taxisimples.passageiro.service.wire;

import br.com.taxisimples.passageiro.Account;
import br.com.taxisimples.passageiro.service.exceptions.CreateAccountFailExceptions;
import br.com.taxisimples.passageiro.service.exceptions.LoginFailExceptions;

public interface UserWireService {

	void login(String username, String password) throws LoginFailExceptions;
	void createAccount(Account account) throws CreateAccountFailExceptions;
	
}
