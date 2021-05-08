package ETicaretBackend.core.concretes;

import ETicaretBackend.business.concretes.GoogleAccountManager;
import ETicaretBackend.core.abstracts.AccountService;

public class GoogleAccountAdapter implements AccountService{

	@Override
	public void registerSocialAccounts(String eposta, String password) {
		GoogleAccountManager googleAccount = new GoogleAccountManager();
		googleAccount.signUpWithGoogle(eposta, password);		
	}

}
