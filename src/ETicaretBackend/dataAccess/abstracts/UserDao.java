package ETicaretBackend.dataAccess.abstracts;

import java.util.List;

import ETicaretBackend.entities.concretes.User;

public interface UserDao {
	void add(User user);
	void update(User user);
	void deleteAccount(User user);
	User getUser(int id);
	List<String> getEposta();
	List<User> getAll();
}
