package validation;

import DataBaseDao.PropertyFile;
import controlar.EncryptDecryptPassword;

public class UserValidation {
	public static boolean validateUser(String email, String password) {
		String pemail = (String)PropertyFile.getEmail();
		String pPassword = EncryptDecryptPassword.decryptPassword((String)PropertyFile.getPassword());
				if("".equalsIgnoreCase(pemail) && "".equalsIgnoreCase(pPassword)) {
					return false;
				}
				else if (email.equals(pemail) && password.equals(pPassword)) {
					return true;
				}else {
					return false;
				}
		
	}
}
