package Model;

public class SignUp {
	private static String email = null;
	private static String password = null;

	public static String getEmail() {
		return email;
	}

	public static String getPassword() {
		return password;
	}

	public static void setEmail(String email) {
		SignUp.email = email;
	}

	public static void setPassword(String password) {
		SignUp.password = password;
	}

}
