package com.gridexchange.utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;





public class XLUtils {
	
	public static FileInputStream fi;
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	
	
	public static int getrowCount(String xlfile, String xlsheet) throws IOException
		{
		
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook();
		ws = wb.getSheet(xlsheet);
		int rowcount = ws.getLastRowNum();
		wb.close();
		fi.close();
		return rowcount;
		
		}
	
		public static int getCellCount(String xlfile, String xlshee, int rownum) throws IOException {

			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook();
			String xlsheet = null;
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			int cellcount = row.getLastCellNum();
			wb.close();
			fi.close();
			return cellcount;
		}
	
	
		public static String getCellData(String xlfile, String xlsheet, int rownum, int colnum) throws IOException{
			
			
			fi = new FileInputStream(xlfile);
			wb = new XSSFWorkbook();
			ws = wb.getSheet(xlsheet);
			row = ws.getRow(rownum);
			cell = row.getCell(colnum);
			String data;
			
			try {
				DataFormatter formatter = new DataFormatter();
				String cellData = formatter.formatCellValue((Cell) cell);
				return cellData;
				
				
			}catch (Exception e)
			{
				data = "";
			}
			
			wb.close();
			fi.close();
			return data;
			
		}
	
		
		public static void setCellData(String xlfile, String xlsheet, int rownum, int colnum, String data) throws IOException{
			
		fi = new FileInputStream(xlfile);
		wb = new XSSFWorkbook();
		ws = wb.getSheet(xlsheet);
	    //row = row.getCTRow(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(xlfile);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();
		
		}
	
	
		public String  setUniqueID(){
		    DateFormat dateFormat = new SimpleDateFormat("yyddmm");
		    Date date = new Date();
		    String dt=String.valueOf(dateFormat.format(date));
		    Calendar cal = Calendar.getInstance();
		    SimpleDateFormat time = new SimpleDateFormat("HHmm");
		    String tm= String.valueOf(time.format(new Date()));//time in 24 hour format
		    String id= dt+tm;
		    System.out.println(id);
		    return id;   
		}
	    
	
	
	
	
	
	
	

}

