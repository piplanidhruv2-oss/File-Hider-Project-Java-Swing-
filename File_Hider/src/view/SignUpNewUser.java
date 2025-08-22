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
import controlar.AddUserInfoIntoDb;

public class SignUpNewUser extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField_1;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	public static JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7 ;

	public SignUpNewUser() {
		setResizable(false);
		setTitle("New User / Sign-up");

		setBounds(100, 100, 390, 522);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Sign Up");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 11, 354, 31);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
		lblNewLabel_2.setBounds(33, 53, 301, 31);
		contentPane.add(lblNewLabel_2);

		textField_1 = new JTextField();
		textField_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		textField_1.setBounds(33, 101, 301, 31);
		contentPane.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("Password");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(33, 143, 301, 31);
		contentPane.add(lblNewLabel_4);

		passwordField = new JPasswordField();
		passwordField.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblNewLabel_7.setVisible(false);
			}
		});
		passwordField.setBounds(33, 185, 301, 31);
		contentPane.add(passwordField);

		JLabel lblNewLabel_5 = new JLabel("Conform Password");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(33, 254, 301, 27);
		contentPane.add(lblNewLabel_5);

		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(33, 292, 296, 31);
		contentPane.add(passwordField_1);

		JButton btnNewButton = new JButton("Sign up");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textField_1.getText().trim().equals("") && !passwordField.getText().trim().equals("")
						&& !passwordField_1.getText().trim().equals("")) {

					if (passwordField.getText().trim().equals(passwordField_1.getText().trim())) {

						SignUp.setEmail(textField_1.getText().trim().toLowerCase());
						SignUp.setPassword(passwordField.getText().trim());
						if(new AddUserInfoIntoDb().addInfo()) {
							textField_1.setText("");
							passwordField.setText("");
							dispose();
						}
					} else {
						JOptionPane.showMessageDialog(null, "password miss match", "Warning",
								JOptionPane.WARNING_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Please fill all fields....", "alert",
							JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(33, 381, 301, 35);
		contentPane.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("login here");
		lblNewLabel_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				new UserLogin().setVisible(true);
				dispose();
			}
		});
		lblNewLabel_1.setForeground(new Color(0, 0, 255));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_1.setBounds(189, 427, 140, 25);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_3 = new JLabel("Already have an account ?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(33, 427, 155, 25);
		contentPane.add(lblNewLabel_3);

		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setForeground(new Color(255, 0, 0));
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 349, 354, 19);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel();
		lblNewLabel_7.setForeground(new Color(47, 47, 255));
		lblNewLabel_7.setText("enter your own created password");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(33, 227, 296, 14);
		contentPane.add(lblNewLabel_7);
		setVisible(true);
	}
}