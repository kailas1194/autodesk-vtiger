package com.crm.autodeskSeleniumFramework.javaUtility;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.cj.jdbc.Driver;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
/**
 * its developed using MySQLConnector/J libraries,which used to handle data from database.
 * @author kailas
 *
 */
public class JDBCUtility {
	
	Connection con;
	
	/**
	 * this method is used to establish connection between java and mysql database.
	 */
	public void connectToDatabase() {
		try {
			Driver driver = new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(IPathConstants.DB_URL, IPathConstants.DB_USERNAME, IPathConstants.DB_PASSWORD);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * it is used to read data from database using MySQLConnector/J with the help of below arguments
	 * @return 
	 * 
	 * @return String
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws CsvValidationException 
	 */
	public  ResultSet readData(String query) throws SQLException {
		ResultSet rs= con.createStatement().executeQuery(query);
				return rs;
	}
	
	
	/**
	 * this method is used to insert data into database.
	 * @param querry
	 * @return
	 * @throws SQLException
	 */
	public  boolean updateData(String query) throws SQLException {
		int rs= con.createStatement().executeUpdate(query);
		boolean flag=false;
		if (rs==1) {
			System.out.println("data is added");
			flag=true;
			return flag;
			
		}else {
			System.out.println("data is not added");
		}
				return flag;
	}
	
	
	/**
	 * this method is used to insert data into database.
	 * @param querry
	 */
	    public void insertData(String query) {
		try {
			con=DriverManager.getConnection(IPathConstants.DB_URL, IPathConstants.DB_USERNAME, IPathConstants.DB_PASSWORD);
			Statement stmt = con.prepareStatement(query);
			stmt.execute(query);
			
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}
	
	    /**
	     * this method is used to close the database connection.
	     */
	    public void closeConnection() {
	    	try {
				con.close();
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
	    }
}
