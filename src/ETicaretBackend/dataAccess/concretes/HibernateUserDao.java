package ETicaretBackend.dataAccess.concretes;

import java.util.ArrayList;
import java.util.List;

import ETicaretBackend.business.constants.Messages;
import ETicaretBackend.dataAccess.abstracts.UserDao;
import ETicaretBackend.entities.concretes.User;

public class HibernateUserDao implements UserDao {

	Messages msg;
	List<String> epostaList = new ArrayList<String>();
	List<User> userList = new ArrayList<User>();

	@Override
	public void add(User user) {

		this.userList.add(user);
		this.epostaList.add(user.getEposta());
		System.out.println(user.getFirstName() + " " + user.getLastName() + msg.AddUser);

	}

	@Override
	public void update(User user) {

		User updatedUser = getUser(user.getId());
		updatedUser.setFirstName(user.getFirstName());
		updatedUser.setLastName(user.getLastName());
		updatedUser.setPass(user.getPass());
		System.out.println(user.getFirstName() + " " + user.getLastName() + msg.UpdateUser);

	}

	@Override
	public void deleteAccount(User user) {
		userList.remove(user);
		System.out.println(user.getFirstName() + " " + user.getLastName() + msg.DeleteUser);
	}

	@Override
	public List<String> getEposta() {

		return this.epostaList;
	}

	@Override
	public List<User> getAll() {

		return this.userList;
	}

	@Override
	public User getUser(int id) {
		for (User user : userList) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}

}
