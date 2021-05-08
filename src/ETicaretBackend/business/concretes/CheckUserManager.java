package ETicaretBackend.business.concretes;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ETicaretBackend.business.abstracts.CheckUserService;
import ETicaretBackend.business.constants.Messages;
import ETicaretBackend.entities.concretes.User;

public class CheckUserManager implements CheckUserService {

	Messages msg;

	public static final Pattern VALID_EMAIL_ADDRESS_REGEX = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$",
			Pattern.CASE_INSENSITIVE);

	public static boolean validate(String emailStr) {
		Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(emailStr);
		return matcher.find();
	}

	@Override
	public boolean checkInformations(User user, List<String> epostaList) {
		if (this.checkEmail(user, epostaList) & this.checkName(user.getFirstName(), user.getLastName())
				&& this.checkPass(user.getPass().length())) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean checkEmail(User user, List<String> epostaList) {

		for (String item : epostaList) {
			if (item == user.getEposta()) {
				System.out.println(msg.ErrorMessageSameMail);
				return false;
			}
		}

		if (!validate(user.getEposta())) {
			System.out.println(msg.ErrorMessage);
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean checkName(String firstName, String lastName) {

		if (firstName.length() < 2 && lastName.length() < 2) {
			System.out.println(msg.ErrorMessage + " Character length must be min 2 ! ");
			return false;
		} else {
			return true;
		}
	}

	@Override
	public boolean checkPass(int passLength) {
		
		if (passLength < 6) {
			System.out.println( msg.ErrorMessage + " Password lenght must be min 6 !");
			return false;
		} else {
			return true;
		}

	}
}
