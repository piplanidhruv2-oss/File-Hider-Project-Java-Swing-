package view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import Model.SignUp;
import controlar.LoginValidation;
import validation.ForgetPassword;
import validation.UserExist;
import DataBaseDao.PropertyFile;

public class UserLogin extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	public static String e100;
	private JPasswordField passwordField;

	public UserLogin() {
		// setType(Type.UTILITY);
		setResizable(false);
		setTitle("Login");
		setBounds(100, 100, 408, 515);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 372, 33);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Email");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_1.setBounds(66, 70, 266, 29);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField.setBounds(66, 110, 266, 29);
		contentPane.add(textField);
		textField.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNewLabel_3.setBounds(66, 198, 266, 29);
		contentPane.add(lblNewLabel_3);

		passwordField = new JPasswordField();
		passwordField.setBounds(66, 238, 266, 29);
		contentPane.add(passwordField);

		JButton btnNewButton = new JButton("Login");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(66, 376, 266, 35);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_2 = new JLabel(" forget password ?");
		lblNewLabel_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new ForgetPassword().setVisible(true);
				new ForgetPassword().setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));

			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));

			}
		});
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setBounds(66, 279, 258, 29);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_4 = new JLabel(" Sign up");
		lblNewLabel_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new SignUpNewUser().setVisible(true);
				dispose();
			}

			@Override
			public void mouseEntered(MouseEvent e) {

				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
			}
		});
		lblNewLabel_4.setForeground(new Color(0, 0, 255));
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(202, 422, 109, 22);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Don't have an account ?");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(66, 425, 147, 17);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("click here to check who is registerd ?");
		lblNewLabel_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));			
				}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
			}
			@Override
			public void mousePressed(MouseEvent e) {
				String getRegistredEmail = (String)PropertyFile.getEmail();
				if("".equalsIgnoreCase(getRegistredEmail)) {
					textField.setText("No Such Email is Registred.");
					textField.setEditable(false);
				}else {
					textField.setText(getRegistredEmail);
					textField.setEditable(false);
				}
				
			}
			@Override
			public void mouseReleased(MouseEvent e) {
				textField.setText("");
				textField.setEditable(true);
			}
		});
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setForeground(new Color(0, 0, 251));
		lblNewLabel_6.setBounds(66, 137, 266, 22);
		contentPane.add(lblNewLabel_6);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				e100 = textField.getText().trim();
				if (!textField.getText().trim().equals("") && !passwordField.getText().trim().equals("")) {
					boolean status = UserExist.isExixts(textField.getText().trim().toLowerCase());

					if (status) {
						SignUp.setEmail(textField.getText().trim().toLowerCase());
						SignUp.setPassword(passwordField.getText().trim());
						if (LoginValidation.validateLogin()) {
							textField.setText("");
							passwordField.setText("");
							dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null,
								"In-valid email id or User is not exist\n with this email id\n", "Error",
								JOptionPane.ERROR_MESSAGE);
						textField.setText("");
						passwordField.setText("");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please fill all fields", "alert", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
	}
}