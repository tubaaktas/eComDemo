package ETicaretBackend.business.concretes;

import ETicaretBackend.business.abstracts.GoogleAccountService;
import ETicaretBackend.business.constants.Messages;

public class GoogleAccountManager implements GoogleAccountService {

	Messages msg;

	@Override
	public void signUpWithGoogle(String eposta, String password) {
		System.out.println(" ----------- " + eposta + msg.LoginUser + "w/GoogleAccount" + " ----------- ");
	}

}
