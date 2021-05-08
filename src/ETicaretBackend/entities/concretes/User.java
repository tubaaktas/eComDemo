package ETicaretBackend.entities.concretes;

import ETicaretBackend.core.abstracts.AccountService;
import ETicaretBackend.entities.abstracts.Entity;

public class User implements Entity {
	private int id;
	private boolean status;
	private String firstName;
	private String lastName;
	private String eposta;
	private String pass;

	AccountService accountService;

	public User(String eposta, String password, AccountService accountService) {
		this.eposta = eposta;
		this.pass = password;
		this.accountService = accountService;
		this.status = false;
		this.accountService.registerSocialAccounts(eposta, password);
	}

	public User(int id, boolean status, String firstName, String lastName, String eposta, String pass) {
		this.id = id;
		this.status = false;
		this.firstName = firstName;
		this.lastName = lastName;
		this.eposta = eposta;
		this.pass = pass;
	}

	public User() {
		
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEposta() {
		return eposta;
	}

	public void setEposta(String eposta) {
		this.eposta = eposta;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

}
