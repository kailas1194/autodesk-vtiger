package com.crm.autodeskSeleniumFramework.javaUtility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * its developed using Apache poi libraries,which used to handle Microsoft Excel sheet
 * @author kailas
 *
 */
public class ExcelUtility {
	/**
	 * it is used to count the rows from excelsheet using below arguments
	 * @param sheetName
	 * @param rowNumber
	 * @return int
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
public int getRowCount(String sheetName) throws IOException {
	
		String filepath="E:\\Client\\Book1.xlsx";
		FileInputStream fin = new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fin);
		Sheet sheet=wb.getSheet(sheetName);
	
	       //getting the cell value from rowNumber and cell Number
	    wb.close();
	        
	        //returning the cell value as string
	        return sheet.getLastRowNum();
	    }
	
/**
 * it is used to read the data from excelsheet using below arguments
 * @param sheetName
 * @param rowNumber
 * @param cellNumber
 * @return
 * @throws EncryptedDocumentException
 * @throws IOException
 */
	public String getDataFromExcel(String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException {
		
			String filepath="E:\\Client\\Book1.xlsx";
			FileInputStream fin=new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fin);
			Sheet sheet=wb.getSheet(sheetName);
			Row row=sheet.getRow(rowNumber);
		       //getting the cell value from rowNumber and cell Number
		    String cellvalue = row.getCell(cellNumber).getStringCellValue();
		        //returning the cell value as string
		        return cellvalue;
		    }
	
	
	public int getDataCharSequenceFromExcel(String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException {
		
		String filepath="E:\\Client\\Book1.xlsx";
		FileInputStream fin=new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fin);
		Sheet sheet=wb.getSheet(sheetName);
		Row row=sheet.getRow(rowNumber);
	
	       //getting the cell value from rowNumber and cell Number
	    int cellvalue = row.getCell(cellNumber).getRowIndex();
	   
	        //returning the cell value as string
	        return cellvalue;
	    }
	
	
	
	
	/**
	 * it is used to read the data from excelsheet using below arguments
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
		public double getNumericalDataFromExcel(String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException {
			
				String filepath="E:\\Client\\Book1.xlsx";
				FileInputStream fin=new FileInputStream(filepath);
				Workbook wb=WorkbookFactory.create(fin);
				Sheet sheet=wb.getSheet(sheetName);
				Row row=sheet.getRow(rowNumber);
			       //getting the cell value from rowNumber and cell Number
			    double cellvalue =row.getCell(cellNumber).getNumericCellValue();
			        //returning the cell value as string
			        return cellvalue;
			    }
		
		
		public double getNumericalIntegerDataFromExcel(String sheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException {
			
			String filepath="E:\\Client\\Book1.xlsx";
			FileInputStream fin=new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fin);
			Sheet sheet=wb.getSheet(sheetName);
			Row row=sheet.getRow(rowNumber);
		       //getting the cell value from rowNumber and cell Number
		    double cellvalue =row.getCell(cellNumber).getNumericCellValue();
		        //returning the cell value as string
		        return cellvalue;
		    }
		
	
	
	/**
	 * it is used to modify the data into excelsheet using below arguments
	 * @param sheetName
	 * @param rowNumber
	 * @param cellNumber
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
		public void setDataFromExcel(String sheetName,int rowNumber,int cellNumber,String data) throws EncryptedDocumentException, IOException {
			
				String filepath="E:\\Client\\Book1.xlsx";
				 FileInputStream fin = new FileInputStream(filepath);
				Workbook wb=WorkbookFactory.create(fin);
				Sheet sheet=wb.getSheet(sheetName);
				Row row=sheet.getRow(rowNumber);
			       //getting the cell value from rowNumber and cell Number
				Cell cell=row.createCell(cellNumber);
				cell.setCellValue(data);
			   FileOutputStream fout=new FileOutputStream(filepath);
			   wb.write(fout);
			   wb.close();
			    }
			
		
}
