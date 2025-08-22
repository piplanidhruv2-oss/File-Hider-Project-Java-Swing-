package controlar;

public class EncryptDecryptPassword {
	
	//mathod for encrypt email is
	public static String encryptEmail(String originalEmail) {
		StringBuffer encEmail = new StringBuffer();
		char[] ch = originalEmail.toCharArray();
		int originalEmailLen = originalEmail.length();
		int pStatus = -1, mStatus = -1;
		for (int i = 0; i < ch.length; i++) {
			int asciChar = ch[i];
			if (pStatus == -1 && mStatus == -1) {
				pStatus = 0;
				mStatus = 0;
				char asciUpdate = (char) (asciChar + originalEmailLen);
				encEmail.append(asciUpdate);
				pStatus = 1;
				mStatus = 0;
				originalEmailLen--;
			} else if (pStatus == 0) {
				char asciUpdate = (char) (asciChar + originalEmailLen);
				encEmail.append(asciUpdate);
				pStatus = 1;
				mStatus = 0;
				originalEmailLen--;
			} else {
				char asciUpdate = (char) (asciChar - originalEmailLen);
				encEmail.append(asciUpdate);
				mStatus = 1;
				pStatus = 0;
				originalEmailLen--;
			}

		}
		return new String(encEmail);
	}
	
	//method for encrypt password
	public static String encryptPassword(String originalPass) {
		StringBuffer encPass = new StringBuffer();
		char[] ch = originalPass.toCharArray();
		int originalPassLen = originalPass.length();
		int pStatus = -1, mStatus = -1;
		for (int i = 0; i < ch.length; i++) {
			int asciChar = ch[i];
			if (pStatus == -1 && mStatus == -1) {
				pStatus = 0;
				mStatus = 0;
				char asciUpdate = (char) (asciChar + originalPassLen);
				encPass.append(asciUpdate);
				pStatus = 1;
				mStatus = 0;
				originalPassLen--;
			} else if (pStatus == 0) {
				char asciUpdate = (char) (asciChar + originalPassLen);
				encPass.append(asciUpdate);
				pStatus = 1;
				mStatus = 0;
				originalPassLen--;
			} else {
				char asciUpdate = (char) (asciChar - originalPassLen);
				encPass.append(asciUpdate);
				mStatus = 1;
				pStatus = 0;
				originalPassLen--;
			}

		}
		return new String(encPass);

	}
	
	//method for decrypt email
	public static String decryptEmail(String encEmail) {
		StringBuffer decEmail = new StringBuffer();
		char[] ch = encEmail.toCharArray();
		int encEmailLen = encEmail.length();
		int pStatus = -1, mStatus = -1;
		for (int i = 0; i < ch.length; i++) {
			int asciChar = ch[i];
			if (pStatus == -1 && mStatus == -1) {
				pStatus = 0;
				mStatus = 0;
				char asciUpdate = (char) (asciChar - encEmailLen);
				decEmail.append(asciUpdate);
				pStatus = 1;
				mStatus = 0;
				encEmailLen--;
			} else if (pStatus == 0) {
				char asciUpdate = (char) (asciChar - encEmailLen);
				decEmail.append(asciUpdate);
				pStatus = 1;
				mStatus = 0;
				encEmailLen--;
			} else {
				char asciUpdate = (char) (asciChar + encEmailLen);
				decEmail.append(asciUpdate);
				mStatus = 1;
				pStatus = 0;
				encEmailLen--;
			}

		}
		return new String(decEmail);
	}

	//method for decrypt password
	public static String decryptPassword(String encPass) {
		StringBuffer decPass = new StringBuffer();
		char[] ch = encPass.toCharArray();
		int encPassLen = encPass.length();
		int pStatus = -1, mStatus = -1;
		for (int i = 0; i < ch.length; i++) {
			int asciChar = ch[i];
			if (pStatus == -1 && mStatus == -1) {
				pStatus = 0;
				mStatus = 0;
				char asciUpdate = (char) (asciChar - encPassLen);
				decPass.append(asciUpdate);
				pStatus = 1;
				mStatus = 0;
				encPassLen--;
			} else if (pStatus == 0) {
				char asciUpdate = (char) (asciChar - encPassLen);
				decPass.append(asciUpdate);
				pStatus = 1;
				mStatus = 0;
				encPassLen--;
			} else {
				char asciUpdate = (char) (asciChar + encPassLen);
				decPass.append(asciUpdate);
				mStatus = 1;
				pStatus = 0;
				encPassLen--;
			}

		}
		return new String(decPass);
	}
	
//	public static void main(String[] args) {
//		String email = "kishanbajpai0000@gmail.com";
//		String password = "Kish@n2003";
//		
//		System.out.println("before encryption email and password is");
//		System.out.println("email: "+email);
//		System.out.println("password: "+password);
//		
//		System.out.println("after encryption email and password is");
//		String encEmail =EncryptDecryptPassword.encryptEmail(email);
//		String encPass = EncryptDecryptPassword.encryptPassword(password);
//		System.out.println(encEmail);
//		System.out.println(encPass);
//		
//		System.out.println("after decryption email and password is");
//		String decEmail = EncryptDecryptPassword.decryptEmail(encEmail);
//		String decPass = EncryptDecryptPassword.decryptPassword(encPass);
//		System.out.println(decEmail);
//		System.out.println(decPass);
//	}

}
