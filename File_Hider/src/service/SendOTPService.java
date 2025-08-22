package service;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

import view.SignUpNewUser;

import java.util.Properties;

public class SendOTPService {
	public static boolean internetConnection = true;

	public static boolean sendOTP(String email, String otp) {
		// Recipient's email ID needs to be mentioned.
		String to = email;

		// Sender's email ID needs to be mentioned
		String from = "circular.donotreply@gmail.com";

		// Assuming you are sending email from through gmails smtp
		String host = "smtp.gmail.com";

		// Get system properties
		Properties properties = new Properties();// System.getProperties();

		// Setup mail server
		properties.put("mail.smtp.starttls.required", true);
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		properties.put("mail.smtp.starttls.enabled", true);
		properties.put("mail.smtp.ssl.protocols", "TLSv1.2");
		properties.put("mail.smtp.auth", true);
		properties.put("mail.smtp.port", "587");
		properties.put("mail.smtp.host", host);

		// Get the Session object.// and pass username and password
		Session session = Session.getInstance(properties, new Authenticator() {

			protected PasswordAuthentication getPasswordAuthentication() {

				return new PasswordAuthentication(from, "skgr nqkv riei epsa");

			}

		});

		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));

			// Set To: header field of the header.
			message.setRecipient(Message.RecipientType.TO, new InternetAddress(to));

			// Set Subject: header field
			message.setSubject("Email Verification OTP");

			// Now set the actual message
			message.setText(" Dear User\n"
							+" \n your one time password (OTP) is "+ otp +"\n"
							+" \n please do not share this OTP with anyone to keep your account safe! \n" 
							+"\n\n\n\nif you did not get OTP Please connect to the admin " +"KISHAN BAJPAI"
							+"\nkishanbajpai0000@gmail.com");

			// System.out.println("sending...");
			// Send message
			Transport.send(message);
			// System.out.println("Sent message successfully....");

			return true;
		} catch (MessagingException mex) {
			// mex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Please connect to the Internet", "Alert", JOptionPane.ERROR_MESSAGE);
			internetConnection = false;

		}
		return internetConnection;
	}
}
