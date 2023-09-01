import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class MemeberDB {
	private static Connection con;

	public static void main(String[] args) {
		fineAll();
		fineOne("baramee");
	}
	
	public static void fineAll() {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost/blueshop?characterEncoding=utf-8";
			
			con = DriverManager.getConnection(dbURL, "root", "");
			
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM member"); 
	        
	        ResultSet resultSet = pStatement.executeQuery();
	        
	        while (resultSet.next()) {
	        System.out.println(resultSet.getString("username") + "\t" + resultSet.getString("password") + "\t" + resultSet.getString("name")+ "\t" + resultSet.getString("address")+ "\t" + resultSet.getString("mobile")+ "\t" + resultSet.getString("email"));
	        }

		
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
	        System.err.println("Error database connection: " + e);
	    }
		
	}
	public static void fineOne(String username) {
		try {
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			String dbURL = "jdbc:mysql://localhost/blueshop?characterEncoding=utf-8";
			
			con = DriverManager.getConnection(dbURL, "root", "");
			
			PreparedStatement pStatement = con.prepareStatement("SELECT * FROM member WHERE username = ?"); 
	        pStatement.setString(1, username);
			
	        ResultSet resultSet = pStatement.executeQuery();
	        
	       resultSet.next(); {
	        System.out.println(resultSet.getString("username") + "\t" + resultSet.getString("password") + "\t" + resultSet.getString("name")+ "\t" + resultSet.getString("address")+ "\t" + resultSet.getString("mobile")+ "\t" + resultSet.getString("email"));
	        }
	        con.close();

		
		
		
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
	        System.err.println("Error database connection: " + e);
	    }
		
	}

}
