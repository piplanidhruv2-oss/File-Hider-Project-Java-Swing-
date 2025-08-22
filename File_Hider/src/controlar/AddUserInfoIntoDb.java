package controlar;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import DataBaseDao.PropertyFile;
import Model.SignUp;
import service.GenerateOTP;
import service.SendOTPService;
import validation.UserExist;
import view.FileService;
import view.SignUpNewUser;
import view.UserLogin;

//method for store sign up info into the database after validating data 
public class AddUserInfoIntoDb {

	// method add info
	/**
	 * @wbp.parser.entryPoint
	 */
	public boolean addInfo() {
		boolean status = UserExist.isExixts(SignUp.getEmail());

		if (status) {
			JOptionPane.showInternalMessageDialog(null, "User Is Already Exist with this email id \n Please Login",
					"Alert", JOptionPane.WARNING_MESSAGE);
			new UserLogin().setVisible(true);
			return true;
		} else {
			if (UserExist.checkAnyUserExixts()) {
				String generateOTP = GenerateOTP.getOTP();
				if (SendOTPService.sendOTP(SignUp.getEmail(), generateOTP)) {
					SignUpNewUser.lblNewLabel_6.setText("OTP Will Send your register mail id, check in spam folder also");
					SignUpNewUser.lblNewLabel_6.setForeground(Color.RED);
					String OneTimePassword = JOptionPane.showInputDialog(null, "Enter OTP", "Alert",
							JOptionPane.OK_CANCEL_OPTION);
					if (generateOTP.equals(OneTimePassword)) {
						boolean isSet = PropertyFile.setCredentialToTheFile(SignUp.getEmail(), SignUp.getPassword());
						if (isSet) {
							JOptionPane.showMessageDialog(null, "sign up successfully...", "information",
									JOptionPane.INFORMATION_MESSAGE);
							new FileService().setVisible(true);
							new FileService().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
							SendOTPService.internetConnection = true;
							return true;

						}
					} else {
						JOptionPane.showMessageDialog(null, "Invalid OTP / Wrong OTP", "Error",
								JOptionPane.ERROR_MESSAGE);
					}

				}
			} else {
				JOptionPane.showMessageDialog(null,
						"Already One User is there\n you can't update your email address \n please login with registered email id\n  if you have any query \n please contact to the ADMIN \n admin email: [kishanbajpai0000@gmail.com]\n contact: 63XX68XX918",
						"Error", JOptionPane.ERROR_MESSAGE);
			}

		}

		return false;
	}
}
