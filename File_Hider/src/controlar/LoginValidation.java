package controlar;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Model.SignUp;
import validation.UserValidation;
import view.FileService;

public class LoginValidation {
	public static boolean validateLogin() {
		if (UserValidation.validateUser(SignUp.getEmail(), SignUp.getPassword())) {
			new FileService().setVisible(true);
			new FileService().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			return true;
		} else {
			JOptionPane.showMessageDialog(null, "Invalid Email id Or Password", "Error", JOptionPane.ERROR_MESSAGE);
			return false;
		}
	}
}
