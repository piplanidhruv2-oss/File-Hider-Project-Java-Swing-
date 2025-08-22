package DataBaseDao;

import java.io.IOException;

import javax.swing.JFrame;

import view.UserLogin;

public class Main {
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Main m = new Main();
		new UserLogin().setVisible(true);
		new UserLogin().setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
