package com.comcast.crm.fileUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelUtiltity {
	
	public String getDataFromExcelFile(String sheet,int rowno,int cellno) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/DataBook2.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		String data = wb.getSheet(null).getRow(rowno).getCell(cellno).getStringCellValue();
		wb.close();
		return data;
	}
	public int getRowCount(String sheetName) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/DataBook2.xlsx");
		Workbook wb=WorkbookFactory.create(fis);
		int lastrow = wb.getSheet(sheetName).getLastRowNum();
		wb.close();
		return lastrow;
		
	}
	
	public void setDataIntoExcel(String sheet,int rowno,int cellno) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream("./testdata/DataBook2.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		wb.getSheet(sheet).getRow(rowno).createCell(cellno);
		FileOutputStream fos=new FileOutputStream("./testdata/DataBook2.xlsx");
		wb.write(fos);
		wb.close();
	}

}
