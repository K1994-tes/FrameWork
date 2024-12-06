package DDT;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertingSingleDataIntoExcel 
{

	public static void main(String[] args) throws Throwable
	{
		//Keep Excel in Read Mode
		FileInputStream fis = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\Testdata.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		Row row=sheet.createRow(4);
	    Cell cell = row.createCell(5);
	    cell.setCellValue("Qspiders");
	    //Keep Excel file in Write Mode
	  FileOutputStream fos= new FileOutputStream("C:\\Users\\saila\\OneDrive\\Desktop\\Testdata.xlsx");
	      book.write(fos);
	      book.close();
	}
	}


