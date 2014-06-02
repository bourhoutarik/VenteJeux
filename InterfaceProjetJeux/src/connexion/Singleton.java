package connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Singleton {
	private static Connection connection=null;
	private static Properties props=null;
	
	private Singleton(){
		try {
			connection= DriverManager.getConnection(props.getProperty("URL"),props.getProperty("Admin"),props.getProperty("Password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static synchronized Connection getInstance(Properties propriétés){
		
		props= propriétés;
		if (connection==null){
			new Singleton();
		}
		return connection;
		
	}
	
	public static void shutDown(){
		if(connection!=null){
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	} 

}
