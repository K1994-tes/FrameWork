package Organization;

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
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CampDetailedPage;
import ObjectRepo.CreateOrgPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.OrgDetailedPage;
import ObjectRepo.OrgValidatePage;
import ObjectRepo.VtigerHomePage;

public class CreateOrganizationTest extends BaseClass{
@Test(groups ="regression")
	public void CreateOrganizationTest() throws Throwable
	{
    
     WebDriver_Utility wlib = new WebDriver_Utility();
		
	/*	FileInputStream fis = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\commondata.propertires.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
	     String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
     
    /*     File_Utility flib = new File_Utility();
		
		String BROWSER = flib.getKeyAndValuePair("browser");
	    String URL =flib.getKeyAndValuePair ("url");
		String USERNAME =flib.getKeyAndValuePair("username");
		String PASSWORD =flib.getKeyAndValuePair("password");*/
	/*	if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
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
		}*/
	//	wlib.maximizeWindow(driver);
	//	wlib.waitForPageToLoad(driver);
	//	driver.get(URL);
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
//		LoginVtigerPage login = new LoginVtigerPage(driver);
//		login.loginIntoVtiger(USERNAME,PASSWORD);

	   // driver.findElement(By.linkText("Organizations")).click();
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickOrgLink();
	//	driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		OrgDetailedPage img = new OrgDetailedPage(driver);
		img.clickOrgLookUpImg();
//---------------------------------------------------------------------------------------------------
		//Random Class------- generating unique values(Avoid Duplicate value)
		//Random ran= new Random();
		//int ranNum= ran.nextInt(1000);
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

//----------------------------------------------------------------------------------------------------
	/*	FileInputStream fis1 = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\TestDatas.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("organization");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String OrgName= cell.getStringCellValue()+ ranNum;
        System.out.println(OrgName);*/
		Excel_Utility elib = new Excel_Utility();
		String OrgName =elib.readExcelDataUsingDataFormatter("organization",0,0)+ranNum;
		
//----------------------------------------------------------------------------------------------------
    /*    Row row1 = sheet.getRow(1);
		Cell cell1= row1.getCell(0);
		DataFormatter format1 = new DataFormatter();
		String phNum= format1.formatCellValue(cell1);
		System.out.println(phNum);*/
		String phNum=elib.readExcelDataUsingDataFormatter("organization",1,0)+ranNum;
//---------------------------------------------------------------------------------------------------
	/*	Row row2 = sheet.getRow(2);
		Cell cell2= row2.getCell(0);
		DataFormatter format2 = new DataFormatter();
		String emailId= format2.formatCellValue(cell2);
		System.out.println(emailId);*/
	String emailId=	elib.readExcelDataUsingDataFormatter("organization",2,0)+ranNum;
//---------------------------------------------------------------------------------------------------
 /*  driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(OrgName);
   driver.findElement(By.xpath("//input[@id='phone']")).sendKeys(phNum);
   driver.findElement(By.xpath("//input[@name='email1']")).sendKeys(emailId);
   driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();*/
	CreateOrgPage createPage = new CreateOrgPage(driver);
	createPage.enterOrgName(OrgName);
	createPage.enterPhnNum(phNum);
	createPage.enterMailId(emailId);
	createPage.clickSaveButton();
 //--------------------------------------------------------------------------------------------------
   Thread.sleep(2000);
  /* String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
   if(actData.contains(OrgName))
   {
	   System.out.println("Organization name is created");
   }
   else
   {
	   System.out.println("Organization is not created");
   }*/
   OrgValidatePage validate = new OrgValidatePage(driver);
   validate.validateOrg(driver, OrgName);
   
  //------------------------------------------------------------------------------------------------
 //  driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
  // driver.findElement(By.linkText("Sign Out")).click();
 //  home.logoutApp();
    	   
 }

	}

