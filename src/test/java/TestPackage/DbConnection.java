package TestPackage;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConnection {

	public static void main(String[] args) throws SQLException, ClassNotFoundException {
		
		String dbUrl = "jdbc:mysql://localhost:3036/emptest";
		String username = "root";		
		String password = "123456";				

 	    //Load MYSQL JDBC driver		
   	    Class.forName("com.mysql.jdbc.Driver");			
   
   		//Create a Connection to the DB		
    	Connection connection = DriverManager.getConnection(dbUrl,username,password);
    	
    	//Closing DB Connection		
		connection.close();	

	}

}
