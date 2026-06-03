package day21;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteInExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Create the workbook
		
		XSSFWorkbook book = new XSSFWorkbook();
		
		// Create the sheet
		
		XSSFSheet sheet = book.createSheet("LoginData");
		
		// Store the details  Name (String) , age (int), city (String)
		
		Object[][] data = {   // [4][3]
				
				{"Name","Age","City"},
				{"John",15,"Chennai"},
				{"Doe",18,"Mumbai"},
				{"Arun",21,"Delhi"}	
		};
		
		
		// Put the data into each row
		
		int rowCount =0;
		
		// for each to get into each row
		
		for(Object[] row : data) {
			
			XSSFRow rows = sheet.createRow(rowCount++);
			
			// for each to get into each column
			
			int columnCount=0;
			
			for(Object col : row) {
				
				XSSFCell cell = rows.createCell(columnCount++);
				
				// Checking the type of data and making the entry
				
				if(col instanceof String) {
					
					cell.setCellValue((String)col);
					
				} else if(col instanceof Integer) {
					
					cell.setCellValue((Integer)col);
				}
				
			}
			
		}
		
		try {
			FileOutputStream output = new FileOutputStream("C:\\Users\\leema\\eclipse-workspace\\SelenimProject\\src\\test\\java\\day21\\Write_Excel.xlsx");
			book.write(output);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		book.close();
	}

}
