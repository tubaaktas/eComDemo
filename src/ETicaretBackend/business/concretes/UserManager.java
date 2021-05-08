package ETicaretBackend.business.concretes;

import ETicaretBackend.business.abstracts.CheckUserService;
import ETicaretBackend.business.abstracts.UserService;
import ETicaretBackend.business.abstracts.VerifyUserService;
import ETicaretBackend.business.constants.Messages;
import ETicaretBackend.dataAccess.abstracts.UserDao;
import ETicaretBackend.entities.concretes.User;

public class UserManager implements UserService {
	Messages msg;
	UserDao userDao;
	CheckUserService controlService;
	VerifyUserService verifyService;

	public UserManager(UserDao userDao, CheckUserService controlService, VerifyUserService verifyService) {

		this.userDao = userDao;
		this.controlService = controlService;
		this.verifyService = verifyService;
	}

	@Override
	public void login(String eposta, String password) {
		if (userDao.getAll() != null) {
			for (User tempUser : userDao.getAll()) {
				if (tempUser.getEposta() != eposta && tempUser.getPass() != password) {
					System.out.println(msg.LoginUser);
				} 
			}
		}else {
					System.out.println("User not found");
				}
	}

	@Override
	public void register(User user) {
		if (this.controlService.checkInformations(user, this.userDao.getEposta())) {
			if (this.verifyService.verifyProcess()) {
				System.out.println(user.getFirstName() + msg.RegisterUser);
				this.userDao.add(user);
			} else {
				System.out.println(msg.ErrorCode);
			}
		} else {
			System.out.println(msg.ErrorMessage);
		}
	}

}
