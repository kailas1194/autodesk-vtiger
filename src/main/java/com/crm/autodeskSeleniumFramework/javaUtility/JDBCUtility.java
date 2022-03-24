package com.crm.autodeskSeleniumFramework.javaUtility;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
/**
 * its developed using MySQLConnector/J libraries,which used to handle data from database.
 * @author kailas
 *
 */
public class JDBCUtility {
	
	/**
	 * it is used to read data from database using MySQLConnector/J with the help of below arguments
	 * 
	 * @return String
	 * @throws SQLException 
	 * @throws IOException 
	 * @throws CsvValidationException 
	 */
	public ResultSet getDataFromDatabase(String drurl,String username,String password,String SqlQuery) throws SQLException {
		Connection con=DriverManager.getConnection(drurl,username,password);
		Statement smt=con.createStatement();
				ResultSet rs=smt.executeQuery(SqlQuery);
				return rs;
	}
}
