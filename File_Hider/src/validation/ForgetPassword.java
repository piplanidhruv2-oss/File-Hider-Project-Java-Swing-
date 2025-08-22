package validation;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import DataBaseDao.PropertyFile;
import service.GenerateOTP;
import service.SendOTPService;

public class ForgetPassword extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JLabel lblNewLabel_2;
	private JTextField textField_1;
	private JButton btnNewButton_4;

	public ForgetPassword() {
		setTitle("Forget");
		setResizable(false);
		setBounds(100, 100, 407, 412);
		setLocationRelativeTo(this);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Enter Email To Verify your Account");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(70, 65, 311, 23);
		contentPane.add(lblNewLabel);

		JButton btnNewButton_3 = new JButton("Verify OTP");
		btnNewButton_3.setBounds(212, 225, 100, 29);
		btnNewButton_3.setVisible(false);
		contentPane.add(btnNewButton_3);

		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				if (!textField.getText().trim().equals("")) {
					if (UserExist.isExixts(textField.getText().trim())) {
						String OTP = GenerateOTP.getOTP();
						if (SendOTPService.sendOTP(textField.getText().trim().toLowerCase(), OTP)) {
							btnNewButton.setVisible(false);
							textField.setEditable(false);
							lblNewLabel.setText("OTP Will send your registered mail id, check spam folder also.");
							lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 12));
							lblNewLabel_2.setVisible(true);
							textField_1.setVisible(true);
							btnNewButton_3.setVisible(true);
							btnNewButton_3.addActionListener(new ActionListener() {
								public void actionPerformed(ActionEvent e) {
									// String OTP = GenerateOTP.getOTP();
									if (!textField_1.getText().trim().equals("")) {
										if (textField_1.getText().trim().equals(OTP)) {

											JOptionPane.showMessageDialog(null, "Email Verification successfull.....",
													"Information", JOptionPane.INFORMATION_MESSAGE);
											String Email = textField.getText().trim().toLowerCase();
											textField.setVisible(false);

											lblNewLabel_2.setVisible(false);
											textField_1.setVisible(false);
											btnNewButton_3.setVisible(false);

											setTitle("Change Password");
											lblNewLabel.setForeground(Color.BLACK);
											lblNewLabel.setText("New Password");

											JPasswordField passwordField = new JPasswordField();
											passwordField.setBounds(66, 112, 242, 29);
											contentPane.add(passwordField);

											JLabel lblNewLabel_1 = new JLabel("Conform Password");
											lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
											lblNewLabel_1.setBounds(70, 179, 242, 29);
											contentPane.add(lblNewLabel_1);

											JPasswordField passwordField_1 = new JPasswordField();
											passwordField_1.setBounds(70, 233, 242, 29);
											contentPane.add(passwordField_1);

											btnNewButton_4 = new JButton("submit");
											btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
											btnNewButton_4.setBounds(70, 310, 242, 35);
											contentPane.add(btnNewButton_4);
											btnNewButton_4.addActionListener(new ActionListener() {
												public void actionPerformed(ActionEvent e) {
													if (!passwordField.getText().trim().equals("")
															&& !passwordField_1.getText().trim().equals("")) {
														if (passwordField.getText().trim()
																.equals(passwordField_1.getText().trim())) {
															if (PropertyFile.setCredentialToTheFile(
																	textField.getText().trim().toLowerCase(),
																	passwordField.getText().trim())) {
																JOptionPane.showMessageDialog(passwordField,
																		"password Update successfully ", "Information",
																		JOptionPane.INFORMATION_MESSAGE);
																passwordField.setText("");
																passwordField_1.setText("");
																dispose();
															} else {
																JOptionPane.showMessageDialog(passwordField,
																		"password Updation failed ", "Error",
																		JOptionPane.ERROR_MESSAGE);
															}
															SendOTPService.internetConnection = true;

														} else {
															JOptionPane.showMessageDialog(passwordField,
																	"Miss match password ", "Error",
																	JOptionPane.ERROR_MESSAGE);
														}
													} else {
														JOptionPane.showMessageDialog(passwordField,
																"Please fill all fields ", "Alert",
																JOptionPane.ERROR_MESSAGE);
													}
												}
											});

										} else {
											lblNewLabel.setText("Incorrect OTP");
											lblNewLabel.setForeground(new Color(255, 0, 0));
										}

									} else {
										JOptionPane.showMessageDialog(null, "enter otp", "Error",
												JOptionPane.ERROR_MESSAGE);
									}
								}
							});

						}

					} else {
						JOptionPane.showMessageDialog(textField, "Invalid email id ", "Error",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(textField, "please enter email Id", "alert",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(70, 310, 242, 35);
		contentPane.add(btnNewButton);
		textField = new JTextField();
		textField.setBounds(66, 112, 242, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		lblNewLabel_2 = new JLabel("Enter OTP");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setBounds(70, 180, 238, 23);
		lblNewLabel_2.setVisible(false);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setBounds(70, 225, 140, 29);
		contentPane.add(textField_1);
		textField_1.setVisible(false);
		textField_1.setColumns(10);

	}
}
