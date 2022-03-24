package dataDriven.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.mysql.jdbc.Driver;

public class ReadTheData {
	public static void main(String[] args) throws SQLException {
		Connection con=null;
		try {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/testyantra";
			String username="root";
			String password="root";
			con = DriverManager.getConnection(url,username, password);
			String sql="select * from students_info;";
			Statement stmt=con.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		   while (rs.next()) {
			   System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"   \t "+rs.getString(3));
			
			
		}
		   } catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
		}
	
	    
		
		
	}

}
