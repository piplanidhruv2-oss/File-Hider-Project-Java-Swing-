package view;

import java.awt.Font;
import java.awt.GridLayout;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.ScrollPaneConstants;
import java.awt.FlowLayout;

public class FileInformationTable extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private String File_id, File_Path;
	private File f;
	private FileInputStream fis;
	private JTable table;
	public FileInformationTable() {
		setBounds(100, 100, 911, 507);
		setResizable(true);
		setLocationRelativeTo(this);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(0, 1, 0, 0));

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(scrollPane);

		table = new JTable();
		table.setRowHeight(20);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		scrollPane.setViewportView(table);

		try {
			DefaultTableModel tblModel = (DefaultTableModel) table.getModel();
//			String[] columnName = {"File Id", "File Path"};
//			tblModel.setColumnIdentifiers(columnName);
			String[] columnName = {"File Id", "File Name", "File Path"};
			tblModel.setColumnIdentifiers(columnName);
			f = new File("C:\\File_hider\\File.properties");
			Properties p = new Properties();
			fis = new FileInputStream(f);
			
			p.load(fis);
			p.forEach((key, value) -> {
//                System.out.println(key + " = " + value);
				File_id = (String)key;
	            File_Path = (String)value;
	            File f = new File(File_Path);
	            String File_Name = f.getName();
	            Object[] row = { File_id, File_Name, File_Path};
	            tblModel.addRow(row);
            });
//			Map<String, String> map = new HashMap<String, String>();
//			Set set = p.entrySet(); 
//			Iterator itr = set.iterator(); 
//	        while (itr.hasNext()) { 
//	            Map.Entry entry = (Map.Entry)itr.next(); 
//	            //System.out.println((String)entry.getKey());
//	            //System.out.println((String)entry.getValue());
//	            File_id = (String)entry.getKey();
//	            File_Path = (String)entry.getValue();
//	            Object[] row = { File_id, File_Path};
//	            tblModel.addRow(row);
//	        }
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, e, "Error",
					JOptionPane.ERROR_MESSAGE);
			e.printStackTrace();
		} finally {
			try {
				fis.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				JOptionPane.showMessageDialog(null, e, "Error",
						JOptionPane.ERROR_MESSAGE);
				e.printStackTrace();
			}
		}
	}
}
