package DataBaseDao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class FileProperty {
	private File file;
	private FileInputStream fis;
	private FileOutputStream fos;
	
	public void setInfo(String id, String filePath) {
		Map<String, String> map = new HashMap<String, String>();
		file = new File("C:\\File_hider\\File.properties");
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
			prop.forEach((key, value) -> {
              map.put(String.valueOf(key), String.valueOf(value));
            });
	        map.put(id, filePath);
	        fis.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		try {
			fos = new FileOutputStream(file);
			Set set = map.entrySet(); 
			Iterator itr = set.iterator(); 
	        while (itr.hasNext()) { 
	  
	            // print each property 
	            Map.Entry entry = (Map.Entry)itr.next(); 
	            prop.setProperty((String)entry.getKey(), (String)entry.getValue());
	        }
	        prop.store(fos, "file is updated...");
	        fos.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int getLastKey() {
		SortedSet<Integer> set = new TreeSet<Integer>();
		file = new File("C:\\File_hider\\File.properties");//C:\\File_hider\\File.properties
		Properties prop = new Properties();
		try {
			fis = new FileInputStream(file);
			prop.load(fis);
//			Set<Object> set = prop.keySet(); 
			prop.forEach((key, value) -> {  
	              set.add(Integer.valueOf(String.valueOf(key)));
	        });
			fis.close();
			for( int s1: set) {
				if(prop.getProperty(String.valueOf(s1)).equalsIgnoreCase("empty")) {
					return --s1;
	              }
				//System.out.println(prop.getProperty(String.valueOf(s1)));
				
			}
			int lastElement = set.last();
			if(-1==lastElement) {
				return 0;
			}else{
				return lastElement;
			}
			
		}catch(IOException | NoSuchElementException e) {
			return 0;
		}
		
		
	}
//	public static void main(String[] args) {
//		FileProperty f = new FileProperty();
//		//f.setInfo("1", "empty");
//		System.out.println(f.getLastKey());
//		
//	}

}
