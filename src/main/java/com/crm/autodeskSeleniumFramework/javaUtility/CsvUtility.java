package com.crm.autodeskSeleniumFramework.javaUtility;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

/**
 * its developed using OpenCsv libraries,which used to handle CSV (comma separated file) file.
 * @author kailas
 *
 */
public class CsvUtility {
	/**
	 * it is used to read data one by one from csv file firstLine using below arguments
	 * @param readNext
	 * 
	 * @return String
	 * @throws IOException 
	 * @throws CsvValidationException 
	 */
	public String[] getDataFromCSVFirstLine(String filepath) throws CsvValidationException, IOException {
		FileReader fr=new FileReader(filepath);
		CSVReader csv=new CSVReader(fr);
		String[] firstLine=csv.readNext();
		return firstLine;
	}
}
