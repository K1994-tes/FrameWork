package DDT;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertingMutlipeLinksIntoExcel 
{

	public static void main(String[] args) throws Throwable
	{
		FileInputStream fis = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\TestData1.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
    	
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.in");
		driver.manage().window().maximize();
		List<WebElement> allLinks=driver.findElements(By.xpath("//a"));//= shortcut key to check no of links in the web page
		for(int i=0; i<allLinks.size(); i++)
		{
			Row row = sheet.createRow(i);
			Cell cell = row.createCell(0);
			cell.setCellValue(allLinks.get(i).getAttribute("href"));
		}
		FileOutputStream fos = new FileOutputStream("C:\\Users\\saila\\OneDrive\\Desktop\\TestData1.xlsx");
		book.write(fos);
		book.close();
	
	}
}
