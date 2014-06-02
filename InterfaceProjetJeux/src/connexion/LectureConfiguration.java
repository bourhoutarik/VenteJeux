package connexion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class LectureConfiguration {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String chemin= "Fichier/configurations.properties";

		File file= new File(chemin);
		Properties props = new Properties();
   
        FileReader fr=null;
        
        try {
        	
			fr = new FileReader(file);
			props.load(fr);
			fr.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        System.out.println(props.get("Driver"));
        System.out.println(props.get("URL"));
        System.out.println(props.get("Admin"));
        System.out.println(props.get("Password"));
        
	}

}
