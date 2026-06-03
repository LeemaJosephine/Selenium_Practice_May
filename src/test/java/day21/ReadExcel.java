package day21;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcel {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

		// Open the workbook
		XSSFWorkbook book = new XSSFWorkbook("C:\\Users\\leema\\eclipse-workspace\\SelenimProject\\src\\test\\java\\day21\\Write_Excel.xlsx");
		
		//Open the sheet
		XSSFSheet sheet = book.getSheet("LoginData");
		
		//Get the no. of rows
		
		int rowCount = sheet.getLastRowNum();
		
		// Get the no.of columns
		
		int columnCount = sheet.getRow(0).getLastCellNum();
		
		// Create 2D array
		
		Object[][] data = new Object[rowCount][columnCount];
		
		// Get into each row
		
		for(int i=1; i<=rowCount; i++) {
			
			XSSFRow row = sheet.getRow(i);
			
			// Get into the column
			
			for(int j=0; j<columnCount; j++) {
				
				XSSFCell cell = row.getCell(j);
				
				// read the value
				if (cell == null) {
					data[i-1][j] ="";
				} else {
					switch(cell.getCellType()) {
					
					case STRING:
						data[i-1][j] =cell.getStringCellValue();
						break;
						
					case NUMERIC:
						data[i-1][j] =cell.getNumericCellValue();
						break;
						
					default:
						data[i-1][j] = null;
					}
				
				}
			}
		}
		
		System.out.println("Printing from array");
		
		for(Object[] row: data) {
			
			for(Object x : row) {
				
				System.out.print(x +"|");
			}
			System.out.println();
		}
		
		book.close();
	}

}
