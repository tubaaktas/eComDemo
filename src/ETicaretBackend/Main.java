package ETicaretBackend;

import ETicaretBackend.business.abstracts.UserService;
import ETicaretBackend.business.concretes.CheckUserManager;
import ETicaretBackend.business.concretes.UserManager;
import ETicaretBackend.business.concretes.VerifyUserManager;
import ETicaretBackend.core.concretes.GoogleAccountAdapter;
import ETicaretBackend.dataAccess.concretes.HibernateUserDao;
import ETicaretBackend.entities.concretes.User;

public class Main {

	public static void main(String[] args) {

		User user1 = new User(); // Tüm bilgiler dogru
		user1.setId(1);
		user1.setFirstName("Tugba");
		user1.setLastName("Aktas");
		user1.setEposta("tugbaaktas83@gmail.com");
		user1.setPass("147852");

		User user2 = new User(); // Hatali mail adresi
		user2.setId(2);
		user2.setFirstName("Deniz");
		user2.setLastName("Cicek");
		user2.setEposta("cicekdenizgmail.com");
		user2.setPass("321098321");

		User user3 = new User(); // Kisa isim ve soyisim
		user3.setId(3);
		user3.setFirstName("T");
		user3.setLastName("A");
		user3.setEposta("abc@gmail.com");
		user3.setPass("2345432");

		User user4 = new User(); // Kisa parola
		user4.setId(4);
		user4.setFirstName("Deniz");
		user4.setLastName("Cicek");
		user4.setEposta("chartugba61@gmail.com");
		user4.setPass("test");

		User user5 = new User();// ayni bilgiler ile
		user5.setId(5);
		user5.setFirstName("Tugba");
		user5.setLastName("Aktas");
		user5.setEposta("tugbaaktas83@gmail.com");
		user5.setPass("awsedrf");

		User user6 = new User("birkanglmz@gmail.com", "baron4536", new GoogleAccountAdapter());// googleaccountadapter ile
		user6.setId(6);
		user6.setFirstName("Birkan");
		user6.setLastName("Gülmez");

		User user7 = new User();
		user7.setId(7);
		user7.setFirstName("Betül");
		user7.setLastName("Sahin");
		user7.setEposta("bett56789@gmail.com");
		user7.setPass("aabbss22");

		UserService userManager = new UserManager(new HibernateUserDao(), new CheckUserManager(), new VerifyUserManager());

		userManager.register(user1);
		System.out.println("---------------------------------------------");

		userManager.register(user2);
		System.out.println("---------------------------------------------");

		userManager.register(user3);
		System.out.println("---------------------------------------------");

		userManager.register(user4);
		System.out.println("---------------------------------------------");

		userManager.register(user5);
		System.out.println("---------------------------------------------");

		userManager.register(user6);
		System.out.println("---------------------------------------------");

		userManager.register(user7);
		System.out.println("---------------------------------------------");

		userManager.login("tubaaktas83@gmail.com", "147852"); // Basarili login
		System.out.println("\n");
	


	}
}
