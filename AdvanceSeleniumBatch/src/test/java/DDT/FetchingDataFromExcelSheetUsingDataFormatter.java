package DDT;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcelSheetUsingDataFormatter  
{

	public static void main(String[] args) throws Throwable
	{
		// Path setting of the EXcel file
		FileInputStream fis = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\Testdata.xlsx");
		//Keep the file in read mode
		Workbook book = WorkbookFactory.create(fis);
		//Navigating to the sheet
		Sheet sheet = book.getSheet("Sheet1");
		//Navigating to the Row
		Row row = sheet.getRow(0);
		//Navigating to the Cell
		Cell cell = row.getCell(0);
		DataFormatter format = new DataFormatter();
		String ExcelData = format.formatCellValue(cell);
		System.out.println(ExcelData);

	}

}
