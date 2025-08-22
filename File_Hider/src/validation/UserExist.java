package validation;

import DataBaseDao.PropertyFile;
import controlar.EncryptDecryptPassword;

public class UserExist {
	public static boolean isExixts(String email) {
			String pemail = (String)PropertyFile.getEmail();
			if (email.equalsIgnoreCase(pemail)) {
				return true;
			}else {
				return false;
			}
	}
	
	public static boolean checkAnyUserExixts() {
		String pemail = (String)PropertyFile.getEmail();
		if ("".equalsIgnoreCase(pemail)) {
			return true;
		}else {
			return false;
		}
}
}
