package DDT;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingSingleDataFromExcel {

	public static void main(String[] args) throws Throwable
	{
	//Path setting of the Excel file	
FileInputStream fis = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\Testdata.xlsx");
//Keep file in read mode
Workbook book = WorkbookFactory.create(fis);
//Navigating to the sheet
Sheet sheet = book.getSheet("Sheet1");
//Navigating to the Row
Row row = sheet.getRow(0);
//Navigating to the Cell
Cell cell = row.getCell(0);
//String ExcelData = cell.getStringCellValue();
//normal apporach of reading numeric values from excel to console//
double ExcelData = cell.getNumericCellValue();
System.out.println(ExcelData);
}
}
