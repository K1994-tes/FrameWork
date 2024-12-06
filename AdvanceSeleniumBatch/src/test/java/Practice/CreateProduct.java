package Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateProduct 
{
public static void main(String[]args) throws Throwable 
{
	WebDriver driver;
	FileInputStream fis = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\commondata.propertires.txt");
	Properties pro = new Properties();
	pro.load(fis);
	String BROWSER=pro.getProperty("browser");
	String URL = pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
	else if (BROWSER.equalsIgnoreCase("edge"))
	{
		driver = new EdgeDriver();
	}
	else 
	{
		driver = new ChromeDriver();
	}
	driver.get(URL);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	driver.findElement(By.id("submitButton")).click();
	driver.findElement(By.xpath("//a[text()='Organizations']")).click();
	driver.findElement(By.xpath("//img[@title=\"Create Organization...\"]")).click();
	Random ran = new Random();
	int random = ran.nextInt(1000);
	FileInputStream fis1 = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\TestDatas.xlsx");
	Workbook book = WorkbookFactory.create(fis1);	
	Sheet sheet =book.getSheet("organization");
	Row row = sheet.getRow(0);
	Cell cell = row.getCell(0);
String OrgName=	cell.getStringCellValue()+random;
System.out.println(OrgName);

Row row1 = sheet.getRow(1);
Cell cell1 = row1.getCell(0);
DataFormatter format = new DataFormatter();
String PhnNum=format.formatCellValue(cell1);
System.out.println(PhnNum);

Row row2 = sheet.getRow(2);
Cell cell2 = row2.getCell(0);
String MailId=	cell2.getStringCellValue();
System.out.println(MailId);
driver.findElement(By.xpath("//input[@name=\"accountname\"]")).sendKeys(OrgName);
driver.findElement(By.xpath("//input[@name=\"phone\"]")).sendKeys(PhnNum);
driver.findElement(By.xpath("//input[@name=\"email1\"]")).sendKeys(MailId);
driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
Thread.sleep(2000);
String actData=driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
if(actData.contains(OrgName))
{
	System.out.println("Organization is created");
}
else
{
	System.out.println("Organization is not created");
}
driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
driver.findElement(By.xpath("//a[text()='Sign Out']")).click();


	
}
}
