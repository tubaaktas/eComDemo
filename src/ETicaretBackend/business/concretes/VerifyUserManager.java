package ETicaretBackend.business.concretes;

import java.util.Random;
import java.util.Scanner;

import ETicaretBackend.business.abstracts.VerifyUserService;

public class VerifyUserManager implements VerifyUserService {

	Scanner scanner = new Scanner(System.in);
	Random random = new Random();
	String verifyCode = "";
	String inputVerifyCode;

	@Override
	public boolean verifyProcess() {

		this.generateVerifyCode();
		this.sendVerifyCode();

		if (this.checkVerifyCode()) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void generateVerifyCode() {
		Random random = new Random();
		int code = random.nextInt(9999);
		String mycode = String.format("%04d", code);
		this.verifyCode = mycode;

	}

	@Override
	public void sendVerifyCode() {
		System.out.println("Verification code :" + verifyCode);
		System.out.print("Enter verification code : ");
		this.inputVerifyCode = scanner.next();

	}

	@Override
	public boolean checkVerifyCode() {
		
		if(this.verifyCode.equals(inputVerifyCode)) {		
			this.inputVerifyCode = "";
			this.verifyCode = "";
			return true;
		}else {
			return false;
		}
	}


	@Override
	public String verifyCodeGenerator() {
		Random random = new Random();
		int code = random.nextInt(9999);
		
		return String.format("%04d", code);
	}

}
