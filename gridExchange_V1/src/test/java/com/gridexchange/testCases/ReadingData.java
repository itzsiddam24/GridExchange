package com.gridexchange.testCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.*;


public class ReadingData {

	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub

		FileInputStream file = new FileInputStream("./ConfigurationFiles/AlectraTestData.xlsx");
		
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		XSSFSheet sheet = workbook.getSheet("Sheet1");//Providing the Sheet Name
		
		//XSSFSheet sheet = workbook.getSheetAt(0);//Providing the Sheet Name
		
		int rowCount = sheet.getLastRowNum(); // Returns the Row Count
		System.out.println("The number of rows with data present are : " +  rowCount);
		
		int colCount = sheet.getRow(0).getLastCellNum();//Returns the number of column count
		System.out.println("The number of columns with data present are : " +  colCount);
		
		
		for(int i=0; i<rowCount; i++)
		{
			XSSFRow currentRow = sheet.getRow(i); //Focussed on the Current Row
			
			for(int j=0; j<colCount; j++)
			{
				String value =currentRow.getCell(j).toString();//Read the value from a Cell
				System.out.print("    "  + value);
			}
			
				System.out.println("  ");
				
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
