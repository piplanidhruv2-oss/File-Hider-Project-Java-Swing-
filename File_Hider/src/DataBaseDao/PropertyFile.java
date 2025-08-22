package DataBaseDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.swing.JOptionPane;

import controlar.EncryptDecryptPassword;

public class PropertyFile {

	private static String email;
	private static String password;
	
	public static void setAllProperty() {
		try {
			File f = new File("C:\\File_hider\\db.properties");
			FileInputStream fis = new FileInputStream(f);
			Properties property = new Properties();
			property.load(fis);
			email = property.getProperty("email");
			password = property.getProperty("password");
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	//set user credential to the file and it is overloaded method
	public static boolean setCredentialToTheFile(String email, String password) {
		try {
			File f = new File("C:\\File_hider\\db.properties");//C:\\File_hider
			FileOutputStream fos = new FileOutputStream(f);
			Properties property1 = new Properties();
			//String encEmail = EncryptDecryptPassword.encryptEmail(email);
			String encPass = EncryptDecryptPassword.encryptPassword(password);
			property1.setProperty("email", email);
			property1.setProperty("password",encPass);
			try {
				property1.store(fos, "data Update");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}catch(FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, e, "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		
		
		return true;
	}
	
	
	public static String getEmail() {
		setAllProperty();
		return email;
	}
	public static void setEmail(String email) {
		PropertyFile.email = email;
	}
	public static String getPassword() {
		setAllProperty();
		return password;
	}
	public static void setPassword(String password) {
		PropertyFile.password = password;
	}
//	public static void main(String[] args) {
//		PropertyFile.setAllProperty();
//		System.out.println(PropertyFile.getEmail());
//		
//		System.out.println(PropertyFile.getPassword());
//	}


}
