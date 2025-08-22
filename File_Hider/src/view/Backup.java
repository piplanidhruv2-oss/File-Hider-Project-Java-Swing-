package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;

import DataBaseDao.FileProperty;

public class Backup extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_4, lblNewLabel_5, lblNewLabel_6,
			lblNewLabel_7;
	private String destinationPath = "C:\\File_hider\\destination\\";//"C:\\File_hider\\destination\\"
	private JProgressBar progressBar;
	private JButton btnNewButton, btnNewButton_1;
	private JLabel lblNewLabel_8;
	private JFileChooser fileChooser;
	// File sourceDirectory = null;
	String sourceLocation = "C:\\File_hider\\destination\\";
	private JLabel lblNewLabel_9;
	private JLabel lblNewLabel_10;

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					Backup frame = new Backup();
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
	public Backup() {
		setTitle("Backup");
		setResizable(false);
		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(481, 466);
		setLocationRelativeTo(rootPane);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(10, 216, 445, 19);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(10, 235, 445, 19);
		contentPane.add(lblNewLabel_3);

		btnNewButton = new JButton("Single location Backup");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new BackupInSingleLocation()).start();
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel_2.setText("choose the location or directory where you want to done the backup");
				lblNewLabel_3.setText("After backup, the file will be deleted from the Hidden directory or location.");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel_2.setText("");
				lblNewLabel_3.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton.setBounds(96, 176, 271, 29);
		contentPane.add(btnNewButton);

		lblNewLabel = new JLabel("");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 330, 445, 19);
		contentPane.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(0, 347, 465, 19);
		contentPane.add(lblNewLabel_1);

		btnNewButton_1 = new JButton("Backup it's Own location where they hide");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new Thread(new BackupItsOwnLocation()).start();

			}
		});
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				lblNewLabel.setText("The backup will be done only at the location from which the file was hidden.");
				lblNewLabel_1.setText("This is applicable each and every file in hidden directory");
				lblNewLabel_8.setText("After backup, the file will deleted from Hidden directory or location.");
			}

			@Override
			public void mouseExited(MouseEvent e) {
				lblNewLabel.setText("");
				lblNewLabel_1.setText("");
				lblNewLabel_8.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		btnNewButton_1.setBounds(96, 290, 271, 29);
		contentPane.add(btnNewButton_1);

		progressBar = new JProgressBar();
		progressBar.setForeground(new Color(47, 47, 255));
		progressBar.setFont(new Font("Tahoma", Font.PLAIN, 13));
		progressBar.setBounds(0, 0, 465, 25);
		contentPane.add(progressBar);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setBounds(10, 36, 67, 19);
		contentPane.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(87, 36, 52, 19);
		contentPane.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(324, 36, 83, 19);
		contentPane.add(lblNewLabel_6);

		lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(414, 36, 29, 19);
		contentPane.add(lblNewLabel_7);

		lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_8.setBounds(10, 371, 445, 19);
		contentPane.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("");
		lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_9.setForeground(new Color(0, 0, 0));
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_9.setBounds(10, 402, 445, 25);
		contentPane.add(lblNewLabel_9);
		
		lblNewLabel_10 = new JLabel("");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_10.setBounds(10, 119, 445, 29);
		contentPane.add(lblNewLabel_10);
	}

	// class for backup files in single location
	public class BackupInSingleLocation implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			int count = 0;
			File f = new File("C:\\File_hider\\destination\\");
			String[] totalFiles = f.list();
			if (totalFiles.length == 0) {
				JOptionPane.showMessageDialog(rootPane, "No such file in hidden directory\n Directory is Empty");
			} else {
				File f2 = new File(".\\File.properties");
				Properties prop = new Properties();

				fileChooser = new JFileChooser();
				fileChooser.setMultiSelectionEnabled(false);
				fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);

				int option = fileChooser.showOpenDialog(Backup.this);
				if (option == JFileChooser.APPROVE_OPTION) {
					File sourceDirectory = fileChooser.getSelectedFile();
					//System.out.println("source directory: "+ sourceDirectory);

					lblNewLabel_4.setText("Total Files:");
					lblNewLabel_5.setText(String.valueOf(totalFiles.length));
					lblNewLabel_6.setText("Back up Files:");

					String destinationpath = String.valueOf(sourceDirectory) + "\\";
					// System.out.println(destinationpath);
					String destWithDoubleBackSlash = destinationpath.replace("\\", "\\\\");
					
					progressBar.setStringPainted(true);
					btnNewButton.setEnabled(false);
					btnNewButton_1.setEnabled(false);
					lblNewLabel_10.setText("your backup folder is "+String.valueOf(sourceDirectory));
					try {
						FileOutputStream fos1 = new FileOutputStream(f2);
						prop.store(fos1, "updated by kishan");
						fos1.close();
						for (String fileName : totalFiles) {
							String sourcePath = sourceLocation + fileName;
							// System.out.println(sourcePath);
							File file = new File(sourcePath);
							long totalBytes = file.length();
							////////////////
							long bytesCopied = 0;
							lblNewLabel_7.setText(String.valueOf(count));
							try (FileInputStream fis = new FileInputStream(file);
									FileOutputStream fos = new FileOutputStream(destWithDoubleBackSlash + fileName);
									FileChannel sourceChannel = fis.getChannel();
									FileChannel destinationChannel = fos.getChannel()) {

								long fileSize = sourceChannel.size();
								long transferred = 0;
								while (transferred < fileSize) {
									long chunkSize = 1024 * 1024; // 1 MB at a time
									long bytes = sourceChannel.transferTo(transferred, chunkSize, destinationChannel);
									transferred += bytes;

									// Update progress
									bytesCopied += bytes;
									int progress = (int) ((bytesCopied * 100) / totalBytes);
									progressBar.setValue(progress);
								}
								count++;
								fos.close();
								fis.close();

							}
							file.delete();
							progressBar.setStringPainted(true);
							btnNewButton.setEnabled(true);
							btnNewButton.setEnabled(true);
							btnNewButton_1.setEnabled(true);
						}
						lblNewLabel_9.setText("Backup completed!.");
						lblNewLabel_4.setText("");
						lblNewLabel_5.setText("");
						lblNewLabel_6.setText("");
						lblNewLabel_7.setText("");
					} catch (IOException e) {
						// JOptionPane.showMessageDialog(rootPane, e);
					} finally {
						progressBar.setValue(0);
						progressBar.setStringPainted(false);
						btnNewButton.setEnabled(true);
						btnNewButton.setEnabled(true);
						btnNewButton_1.setEnabled(true);
					}
				}

			}
		}
	}

	// class for backup files in distributed locations
	public class BackupItsOwnLocation implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub
			File f = new File("C:\\File_hider\\destination\\");
			String[] totalFiles = f.list();
			if (totalFiles.length != 0) {
				lblNewLabel_4.setText("Total Files:");
				lblNewLabel_5.setText(String.valueOf(totalFiles.length));
				lblNewLabel_6.setText("Back up Files:");
				// lblNewLabel_7.setText(String.valueOf(10));

				SortedSet<Integer> set = new TreeSet<Integer>();
				File f2 = new File("C:\\File_hider\\File.properties");
				Properties prop = new Properties();
				try {
					FileInputStream fis1 = new FileInputStream(f2);
					prop.load(fis1);

					prop.forEach((key, value) -> {
						set.add(Integer.valueOf(String.valueOf(key)));
					});
					fis1.close();
					if (set.isEmpty()) {
						JOptionPane.showMessageDialog(rootPane,
								"No such file in hidden directory\n Directory is Empty...");
					} else {
						List<Integer> lst = new ArrayList<Integer>(set);
						int count = 0;
						for (Integer id : lst) {
							String destinationpath = prop.getProperty(String.valueOf(id));
							if (!destinationpath.equalsIgnoreCase("Empty")) {
								File ifPathNotExists = new File(destinationpath);
								if (!ifPathNotExists.exists()) {
									String tempFile = ifPathNotExists.getName();
									destinationpath.replace(tempFile, "");
									String origPath = destinationpath.replace(tempFile, "");
									File f00 = new File(origPath);
									f00.mkdir();

									String destinationPathWithDoubleBackSlash = destinationpath.replace("\\", "\\\\");

									File file1 = new File(destinationPathWithDoubleBackSlash);
									String fileName = file1.getName();
									File file = new File(destinationPath + fileName);
									long totalBytes = file.length();
									long bytesCopied = 0;

									progressBar.setStringPainted(true);
									btnNewButton.setEnabled(false);
									btnNewButton_1.setEnabled(false);
									lblNewLabel_7.setText(String.valueOf(count));
									try (FileInputStream fis = new FileInputStream(file);
											FileOutputStream fos = new FileOutputStream(
													destinationPathWithDoubleBackSlash);
											FileChannel sourceChannel = fis.getChannel();
											FileChannel destinationChannel = fos.getChannel()) {
										// lblNewLabel_2.setText("please wait until process is done!");

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
										count++;
										fis.close();
										fos.close();
//									textField.setText("");
										new FileProperty().setInfo(String.valueOf(id), "Empty");
										
									}
									file.delete();
									progressBar.setStringPainted(true);
									btnNewButton.setEnabled(true);
									btnNewButton.setEnabled(true);
									btnNewButton_1.setEnabled(true);

								}
							}

						}

						set.clear();
						lblNewLabel_4.setText("");
						lblNewLabel_5.setText("");
						lblNewLabel_6.setText("");
						lblNewLabel_7.setText("");
						lblNewLabel_9.setText("Backup Completed!.");

					}

				} catch (IOException | NoSuchElementException e) {
					JOptionPane.showMessageDialog(rootPane, e);
				} finally {

					progressBar.setValue(0);
					progressBar.setStringPainted(false);
					btnNewButton.setEnabled(true);
					btnNewButton.setEnabled(true);
					btnNewButton_1.setEnabled(true);
				}

			} else {
				JOptionPane.showMessageDialog(rootPane, "No such file in hidden directory\n Directory is Empty");
			}

		}

	}
}
