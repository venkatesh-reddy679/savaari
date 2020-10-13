package com.pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;

public class ExcelPage {
     WebDriver driver;
     
	
	public ExcelPage(WebDriver driver) {
		
		this.driver = driver;
	}


	public static String getCellValue(String sheetName, int rowNum,int cellNum ) throws FileNotFoundException {
		String cellValue = null;
		FileInputStream stream;
		try {
			stream = new FileInputStream("G:\\selenium\\savaari2\\Excel\\SavaariExcel.xlsx");
			XSSFWorkbook workbook = new  XSSFWorkbook(stream);
			XSSFSheet  sheet= workbook.getSheet(sheetName);
			XSSFRow row =sheet.getRow(rowNum);
			XSSFCell cell= row.getCell(cellNum);
			cellValue = cell.getStringCellValue();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cellValue;
		
		
	}
}
