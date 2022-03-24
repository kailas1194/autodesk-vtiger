package com.scenarios;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelLib {
	
		public String getOrgname(String SheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException{
			String filepath="E:\\Client\\Book1.xlsx";
			FileInputStream fin = new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fin);
			Sheet sheet=wb.getSheet("Sheet1");
			Row row=sheet.getRow(1);
		       //getting the cell value from rowNumber and cell Number
		    String cellvalue = row.getCell(0).getStringCellValue();
		        
		        //returning the cell value as string
		        return cellvalue;
		    }
		
		public String getCellDataProduct(String SheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException{
			String filepath="E:\\Client\\Book1.xlsx";
			FileInputStream fin=new FileInputStream(filepath);
			Workbook wb=WorkbookFactory.create(fin);
			Sheet sheet=wb.getSheet("Sheet1");
			Row row=sheet.getRow(1);
		       //getting the cell value from rowNumber and cell Number
		    String cellvalue = row.getCell(2).getStringCellValue();
		        
		        //returning the cell value as string
		        return cellvalue;
		    }

		

	}

