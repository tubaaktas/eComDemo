package ETicaretBackend.business.abstracts;

public interface VerifyUserService {
	public boolean verifyProcess();
	public void generateVerifyCode();
	public void sendVerifyCode();
	public boolean checkVerifyCode();
	public String verifyCodeGenerator();
}
