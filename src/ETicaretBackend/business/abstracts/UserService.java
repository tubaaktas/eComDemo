package ETicaretBackend.business.abstracts;

import java.util.List;

import ETicaretBackend.entities.concretes.User;

public interface UserService {
	public void login(String email,String password);
	public void register (User user);
}
