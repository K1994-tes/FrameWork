package Lead;

import java.io.FileInputStream;
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

import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.LoginVtigerPage;

public class CreateLead {

	public static void main(String[] args) throws Throwable
	{
		
WebDriver driver;
       WebDriver_Utility wlib = new WebDriver_Utility();
		
	/*	FileInputStream fis = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\commondata.propertires.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
	     String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
        File_Utility flib = new File_Utility();

        String BROWSER = flib.getKeyAndValuePair("browser");
        String URL =flib.getKeyAndValuePair ("url");
        String USERNAME =flib.getKeyAndValuePair("username");
        String PASSWORD =flib.getKeyAndValuePair("password");
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
			driver.manage().window().maximize();
		} 
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver= new FirefoxDriver();
		}
		else if (BROWSER.equalsIgnoreCase("edge"))
		{
			driver= new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}
		wlib.maximizeWindow(driver);
		wlib.waitForPageToLoad(driver);
		
		driver.get(URL);
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
		LoginVtigerPage login = new LoginVtigerPage(driver);
		login.loginIntoVtiger(USERNAME,PASSWORD);

        driver.findElement(By.xpath("//a[@href=\"index.php?module=Leads&action=index\"]")).click();
        driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
//---------------------------------------------------------------------------------------------------
     //   Random ran= new Random();
	//	int ranNum= ran.nextInt(1000);
        Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();
		
//----------------------------------------------------------------------------------------------------
	/*	FileInputStream fis1 = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\TestData4.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("Lead");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String FirstName= cell.getStringCellValue()+ ranNum;
        System.out.println(FirstName);*/
		Excel_Utility elib = new Excel_Utility();
		String FirstName = elib.readExcelDataLead("Lead", 0, 0)+ranNum;
//----------------------------------------------------------------------------------------------------
    /*    Row row1 = sheet.getRow(1);
		Cell cell1= row1.getCell(0);
		DataFormatter format1 = new DataFormatter();
		String LastName= format1.formatCellValue(cell1)+ranNum;
		System.out.println(LastName);*/
		String LastName = elib.readExcelDataLead("Lead", 1, 0)+ranNum;
//---------------------------------------------------------------------------------------------------
	/*	Row row2 = sheet.getRow(2);
		Cell cell2= row2.getCell(0);
		DataFormatter format2 = new DataFormatter();
		String CompName= format2.formatCellValue(cell2);
		System.out.println(CompName);*/
		String CompName = elib.readExcelDataLead("Lead", 2, 0)+ranNum;
//----------------------------------------------------------------------------------------------------
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FirstName);
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
        driver.findElement(By.xpath("//input[@name='company']")).sendKeys(CompName);
        driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        driver.findElement(By.xpath("//a[@href=\"index.php?module=Leads&action=index\"]")).click();
//-------------------------------------------------------------------------------------------------
        //validation of last name is created
       String LastnameData= driver.findElement(By.xpath("//a[text()='"+LastName+"']")).getText();
       if(LastnameData.contains(LastnameData))
       {
    	   System.out.println("Last name is created");
       }
       else
       {
    	   System.out.println("Last name is not created");
    	}
//----------------------------------------------------------------------------------------------------
       // validation of company name is created 
       String CompnameData= driver.findElement(By.xpath("//td[text()='Jspiders ']")).getText();
       if(LastnameData.contains(CompnameData))
       {
    	   System.out.println("Company name is created");
       }
       else
       {
    	   System.out.println("Company name is not created");
    	}
       driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
       driver.findElement(By.linkText("Sign Out")).click();

	}

}
