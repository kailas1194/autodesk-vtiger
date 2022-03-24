package dataDriven.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.cj.jdbc.Driver;

public class JdbcWithoutTryAndCatch {
	public static void main(String[] args) throws SQLException {
		
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/testyantra";
			String username="root";
			String password="root";
			Connection con = DriverManager.getConnection(url,username, password);
			String sql="select * from students_info;";
			Statement stmt=con.createStatement();
		    ResultSet rs = stmt.executeQuery(sql);
		   
		    while (rs.next()) {
				
		    	System.out.println(rs.getString(1)+"\t"+rs.getString(2)+"   \t "+rs.getString(3));
			}
			   
			   con.close();
			
		}
		}
