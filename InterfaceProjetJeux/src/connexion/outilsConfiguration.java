package connexion;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Properties;

public class outilsConfiguration {

	public static  void sauverProperties(Properties props, String path) throws IOException{
	   File file= new File(path);
		//fw est un objet pour ecrire dans le fichier
	   FileWriter fw=null;
	   fw=new FileWriter(file);
       props.store(fw,"Configuration Donnees Database");
	   fw.close();
			
		}
	
	public static Properties recupererPropoerties(String chemin) throws FileNotFoundException,IOException{
		File file= new File(chemin);
		Properties props = new Properties();
        FileReader fr=null;
       	fr = new FileReader(file);
	    props.load(fr);
	    fr.close();
		return props;
	}
}
