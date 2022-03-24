package dataDriven.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import com.mysql.jdbc.Driver;

public class NoSqlSelect_sample {
	public static void main(String[] args) throws SQLException {
		int rs=0;
		Connection con=null;
		try {
			Driver driver= new Driver();
			DriverManager.registerDriver(driver);
			String url="jdbc:mysql://localhost:3306/testyantra";
			String username="root";
			String password="root";
			con = DriverManager.getConnection(url,username, password);
			String sql="insert into students_info values('1','pravin','v','rathod');";
			Statement stmt=con.createStatement();
		     rs = stmt.executeUpdate(sql);
		   if(rs==1) {
			   System.out.println("=========inserted successfully========");
			
			
		}
		   else {
			   {
				   System.out.println("=========not inserted successfully========");
				
				
			}
		}} catch (Exception e) {
			// TODO: handle exception
		}
		finally {
			con.close();
		}
	
	    
		
		
	}

}
