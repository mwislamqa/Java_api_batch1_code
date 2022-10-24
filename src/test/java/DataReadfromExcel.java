import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataReadfromExcel {
	public static void main(String[] args) throws IOException {
		
	
	// flow=
			// fileInputstream for file locator
			// XSSFworkbook for for workbook class
			// XSSFSheet for sheet locator
			// XSSFRow locator
			// row count by call last row
			// column count by call last column
			// loop for row and inside loop for column

			// storing file
			FileInputStream file = new FileInputStream("C://Users//md islam//Documents//Book1.xlsx");
			// locate file
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			// locate sheet,after locate sheet we not need to new contractor
			// bcox we can get all things row and cell inside the sheet
			XSSFSheet sheet = workbook.getSheet("Sheet1");// for get sheet by sheet name or

			// XSSFSheet sheet= workbook.getSheetAt(0);//for get sheet by index

			int rowCount = sheet.getLastRowNum();// row count in work sheet which has data

			// first we need to know first row and then column = all cells
			int columnCount = sheet.getRow(0).getLastCellNum();// column count means cells count
			//first loop for row counting
			for (int i = 0; i < rowCount; i++) {

				XSSFRow correntRow = sheet.getRow(i);// its a method for loop the row and its also under XSSFRow class
				// we need another loop for cell loop
				
	            //second loop for column counting
				for (int j = 0; j < columnCount; j++) {

					String value = correntRow.getCell(j).toString();//toString() method for red the value from cell
					System.out.print("    " + value);
				}
				System.out.println();
			}

			}
}
