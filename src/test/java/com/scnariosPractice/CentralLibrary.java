package com.scnariosPractice;


import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class CentralLibrary {
	
	public String getOrgname(String SheetName,int rowNumber,int cellNumber) throws EncryptedDocumentException, IOException{
		String filepath="E:\\Client\\Book1.xlsx";
		 FileInputStream fin = new FileInputStream(filepath);
		Workbook wb=WorkbookFactory.create(fin);
		String cellValue=wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		return cellValue;
}
}
