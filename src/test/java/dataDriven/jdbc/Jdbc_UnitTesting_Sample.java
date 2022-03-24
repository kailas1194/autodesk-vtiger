package dataDriven.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;

public class Jdbc_UnitTesting_Sample {
	public static void main(String[] args) throws SQLException {
		String projectname="kailas";
		Connection con=null;
		try {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/testyantra";
			String username="root";
			String password="root";
			con = DriverManager.getConnection(url,username, password);
			String sql="select * from student_info;";
			Statement stmt=con.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		    while (rs.next()) {
		    	String actProjectName=rs.getString(1);
				
		    }
		
		  
		} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
		}
	
	    
		
		
	}

}
