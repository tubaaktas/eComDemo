package ETicaretBackend.business.abstracts;

import java.util.List;

import ETicaretBackend.entities.concretes.User;

public interface CheckUserService {
	public boolean checkInformations(User user, List<String> epostaList);
	public boolean checkEmail(User user, List<String> epostaList);
	public boolean checkName(String firstName,String lastName);
	public boolean checkPass(int passLength);
	
}
