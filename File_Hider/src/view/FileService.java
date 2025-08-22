package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.Properties;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DataBaseDao.FileProperty;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class FileService extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel_2;
	private JProgressBar progressBar;
	private String destinationPath = "C:\\File_hider\\destination\\";
	private File[] sourceFile;
	private JFileChooser fileChooser;
	private JLabel lblNewLabel_3, lblNewLabel_4, lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	
	int fileCount = 0;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FileService frame = new FileService();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public FileService() {
		setTitle("File Service");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(513, 648);
		setLocationRelativeTo(rootPane);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		progressBar = new JProgressBar();
		progressBar.setFont(new Font("Tahoma", Font.BOLD, 11));
		progressBar.setForeground(new Color(34, 34, 255));
		// progressBar.setStringPainted(true);
		progressBar.setBounds(0, 0, 497, 20);
		contentPane.add(progressBar);

		JLabel lblNewLabel = new JLabel("Welcome To File Hider");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(10, 96, 467, 27);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Enter File Id (To Un Hide File)");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(93, 177, 309, 34);
		contentPane.add(lblNewLabel_1);

		textField = new JTextField();
		textField.setBounds(93, 222, 319, 34);
		contentPane.add(textField);
		textField.setColumns(10);

		btnNewButton = new JButton("Select file for Hide");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(93, 344, 319, 34);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new Thread(new SelectFileForHide()).start();

			}
		});
		contentPane.add(btnNewButton);

		btnNewButton_1 = new JButton("Un Hide ");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new UnHideFile()).start();
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(93, 401, 319, 34);
		contentPane.add(btnNewButton_1);

		btnNewButton_2 = new JButton("Show All Hiden File");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_2.setText("");
				new FileInformationTable().setVisible(true);
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(93, 454, 319, 34);
		contentPane.add(btnNewButton_2);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_2.setBounds(0, 565, 497, 33);
		contentPane.add(lblNewLabel_2);
		
		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_4.setBounds(180, 517, 297, 16);
		contentPane.add(lblNewLabel_4);
		
		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(180, 472, 297, 16);
		contentPane.add(lblNewLabel_5);
		
		lblNewLabel_3 = new JLabel("Backup ?");
		lblNewLabel_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
				lblNewLabel_4.setText("click here to back up your hide files.");
				lblNewLabel_5.setText("In Case If You'r Un-Install the software");
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
				lblNewLabel_4.setText("");
				lblNewLabel_5.setText("");
			}
			@Override
			public void mouseClicked(MouseEvent e) {
				new Backup().setVisible(true);
			}
		});
		lblNewLabel_3.setForeground(new Color(55, 55, 255));
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(99, 513, 67, 20);
		contentPane.add(lblNewLabel_3);
		
		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(10, 20, 118, 20);
		contentPane.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(138, 20, 46, 20);
		contentPane.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_8.setBounds(378, 20, 60, 20);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_9.setBounds(442, 20, 41, 20);
		contentPane.add(lblNewLabel_9);
		
		
	}

	private class SelectFileForHide implements Runnable {
		@Override
		public void run() {
			lblNewLabel_2.setText("");
			try {
				fileChooser = new JFileChooser();
				fileChooser.setMultiSelectionEnabled(true);
				fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
				int selected = fileChooser.showOpenDialog(FileService.this);
				sourceFile = fileChooser.getSelectedFiles();
				int totalSelectedFiles = sourceFile.length;
				
				if (selected == 0) {
					for (File file : sourceFile) {
						String fileName = file.getName();
						String path = file.getPath();
						long totalBytes = file.length();

						long bytesCopied = 0;
						try (FileInputStream fis = new FileInputStream(file);
								FileOutputStream fos = new FileOutputStream(destinationPath + fileName);
								FileChannel sourceChannel = fis.getChannel();
								FileChannel destinationChannel = fos.getChannel()) {
							lblNewLabel_2.setText("please wait until process is done!");
							lblNewLabel_6.setText("Total Selected Files:");
							lblNewLabel_7.setText(String.valueOf(totalSelectedFiles));
							lblNewLabel_8.setText("File Hide:");
							lblNewLabel_9.setText(String.valueOf(fileCount));
							long fileSize = sourceChannel.size();
							long transferred = 0;
							progressBar.setStringPainted(true);
							btnNewButton.setEnabled(false);
							btnNewButton_1.setEnabled(false);
							btnNewButton_2.setEnabled(false);
							lblNewLabel_3.setVisible(false);
							int s1 = new FileProperty().getLastKey();
//							System.out.println("s1: "+s1);
							if (s1 != 0) {
								int lastKey = new FileProperty().getLastKey();
								lastKey = lastKey + 1;
								String incLastKey = String.valueOf(lastKey);
								while (transferred < fileSize) {
									long chunkSize = 1024 * 1024; // 1 MB at a time
									long bytes = sourceChannel.transferTo(transferred, chunkSize, destinationChannel);
									transferred += bytes;

									// Update progress
									bytesCopied += bytes;
									int progress = (int) ((bytesCopied * 100) / totalBytes);
									
									progressBar.setValue(progress);
								}
								fileCount++;
								fos.close();
								fis.close();
								new FileProperty().setInfo(incLastKey, path);
								//System.out.println(incLastKey+"--------"+path);
							} else {
								while (transferred < fileSize) {
									long chunkSize = 1024 * 1024; // 1 MB at a time
									long bytes = sourceChannel.transferTo(transferred, chunkSize, destinationChannel);
									transferred += bytes;

									// Update progress
									bytesCopied += bytes;
									int progress = (int) ((bytesCopied * 100) / totalBytes);
									
									progressBar.setValue(progress);
								}
								fileCount++;
								new FileProperty().setInfo("1", path);
								//System.out.println("1"+"--------"+path);
								fos.close();
								fis.close();
							}
							
						}
						file.delete();
						lblNewLabel_2.setText("Hide Successfully.");
						
					}
					lblNewLabel_6.setText("");
					lblNewLabel_7.setText("");
					lblNewLabel_8.setText("");
					lblNewLabel_9.setText("");
				} // else {
//					
//				}
			} catch (IOException e) {
				JOptionPane.showMessageDialog(rootPane, e, "Error", JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
				lblNewLabel_2.setText("Error during file hiding.");
			} finally {
				progressBar.setValue(0);
				progressBar.setStringPainted(false);
				btnNewButton.setEnabled(true);
				btnNewButton_1.setEnabled(true);
				btnNewButton_2.setEnabled(true);
				lblNewLabel_3.setVisible(true);
			}
		}

	}

	private class UnHideFile implements Runnable {
		@Override
		public void run() {
			// TODO Auto-generated method stub
			lblNewLabel_2.setText("");
			String id = textField.getText().trim();
			if (!id.trim().toLowerCase().equals("")) {
				File f = new File("C:\\File_hider\\File.properties");
				try {
					FileInputStream fis1 = new FileInputStream(f);
					Properties p = new Properties();
					p.load(fis1);

					String destinationpath = p.getProperty(id);
					if (destinationpath != null) {
						File ifPathNotExists = new File(destinationpath);
						if (!ifPathNotExists.exists()) {
							String tempFile = ifPathNotExists.getName();
							destinationpath.replace(tempFile, "");
							String origPath = destinationpath.replace(tempFile, "");
							File f00 = new File(origPath);
							f00.mkdir();

							if (!"empty".equalsIgnoreCase(p.getProperty(id))) {

								String destinationPathWithDoubleBackSlash = destinationpath.replace("\\", "\\\\");

								File file1 = new File(destinationPathWithDoubleBackSlash);
								String fileName = file1.getName();

								File file = new File(destinationPath + fileName);
								long totalBytes = file.length();
								long bytesCopied = 0;

								progressBar.setStringPainted(true);
								btnNewButton.setEnabled(false);
								btnNewButton_1.setEnabled(false);
								btnNewButton_2.setEnabled(false);
								lblNewLabel_3.setVisible(false);
								try (FileInputStream fis = new FileInputStream(file);
										FileOutputStream fos = new FileOutputStream(destinationPathWithDoubleBackSlash);
										FileChannel sourceChannel = fis.getChannel();
										FileChannel destinationChannel = fos.getChannel()) {
									lblNewLabel_2.setText("please wait until process is done!");

									long fileSize = sourceChannel.size();
									long transferred = 0;
									while (transferred < fileSize) {
										long chunkSize = 1024 * 1024; // 1 MB at a time
										long bytes = sourceChannel.transferTo(transferred, chunkSize,
												destinationChannel);
										transferred += bytes;

										// Update progress
										bytesCopied += bytes;
										int progress = (int) ((bytesCopied * 100) / totalBytes);
										progressBar.setValue(progress);
									}
									fis.close();
									fos.close();
									textField.setText("");
									lblNewLabel_2.setText("Un-Hide Successfully.");
									new FileProperty().setInfo(id, "empty");
								}
								file.delete();
								
								progressBar.setStringPainted(false);
								btnNewButton.setEnabled(true);
								btnNewButton_1.setEnabled(true);
								btnNewButton_2.setEnabled(true);
								lblNewLabel_3.setVisible(true);
							} else {
								JOptionPane.showMessageDialog(rootPane,
										"file is not associated with this id\n or \n may be file is not there\n"
												+ destinationpath,
										"Error", JOptionPane.ERROR_MESSAGE);
								textField.setText("");
							}

						}
					} else {
						JOptionPane.showMessageDialog(rootPane, "Invalid File Id", "Error", JOptionPane.ERROR_MESSAGE);
						textField.setText("");

					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(rootPane, e, "Error", JOptionPane.ERROR_MESSAGE);
					e.printStackTrace();
				} finally {
					progressBar.setValue(0);
					progressBar.setStringPainted(false);
					btnNewButton.setEnabled(true);
					btnNewButton_1.setEnabled(true);
					btnNewButton_2.setEnabled(true);
				}
			} else {
				JOptionPane.showMessageDialog(rootPane, "please enter file Id\n TO UN-HIDE FILE", "Error",
						JOptionPane.ERROR_MESSAGE);
			}

		}
	}
}
