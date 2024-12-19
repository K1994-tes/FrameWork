package Campiagns;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
import java.util.Set;

import org.apache.poi.ss.usermodel.Cell;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CampDetailedPage;
import ObjectRepo.CampValidatePage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.CreateProdPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProdDetailedPage;
import ObjectRepo.SwitchingProductPage;
import ObjectRepo.ValidateCampiagnsWithProduct;
import ObjectRepo.VtigerHomePage;

public class CreateCampaignWithProductTest extends BaseClass{
    @Test(groups ="smoke")
	public void CreateCampaignWithProductTest() throws Throwable
	{

		
	/*	FileInputStream fis = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\commondata.propertires.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
	     String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
       
   //     File_Utility flib = new File_Utility();
         WebDriver_Utility wlib = new WebDriver_Utility();
   /*      String BROWSER = flib.getKeyAndValuePair("browser");
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
		driver.get(URL);*/
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
//		LoginVtigerPage login = new LoginVtigerPage(driver);
//		login.loginIntoVtiger(USERNAME,PASSWORD);

	//	driver.findElement(By.xpath("//a[text()='Products']")).click();
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickPrdLink();
	//	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		ProdDetailedPage img = new ProdDetailedPage(driver); 
		img.clickProdLookUpImg();
//---------------------------------------------------------------------------------------------------
	//	Random ran= new Random();
	//	int ranNum= ran.nextInt(1000);
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

//---------------------------------------------------------------------------------------------------
	/*	FileInputStream fis1 = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\TestData3.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("product");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String ProdName= cell.getStringCellValue()+ ranNum;
        System.out.println(ProdName);*/
		Excel_Utility elib = new Excel_Utility();
		String ProdName = elib.readExcelDataCP("product", 0, 0)+ranNum;
//---------------------------------------------------------------------------------------------------
     //   driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(ProdName);
      //  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateProdPage createPage = new CreateProdPage(driver);
		createPage.enterProdName(ProdName);
		createPage.clickSaveButton();

//---------------------------------------------------------------------------------------------------
        
    	//driver.findElement(By.xpath("//a[text()='More']")).click();
	     //driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
        VtigerHomePage home1 = new VtigerHomePage(driver);
		home1.clickMoreLink();
		home1.clickCampLink();
		
	//	driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
		CampDetailedPage img1 = new CampDetailedPage(driver);
		img1.clickCampLookUpImg();
		

//----------------------------------------------------------------------------------------------------
//Random class-----> generating unique values(Avoid Duplicate value)
	//	Random ran1= new Random();
	//	int ranNum1= ran.nextInt(1000);
		Java_Utility jlib1 = new Java_Utility();
		int ranNum1= jlib1.getRandomNum();

//----------------------------------------------------------------------------------------------------
	/*	FileInputStream fis2 = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\TestData2.xlsx");
		Workbook book1 = WorkbookFactory.create(fis2);
		Sheet sheet1 = book.getSheet("campiagn");
		Row row1 = sheet.getRow(0);
		Cell cell1 = row.getCell(0);
		String cpgName= cell.getStringCellValue()+ ranNum1;
        System.out.println(cpgName);*/
		Excel_Utility elib1 = new Excel_Utility();
		String cpgName = elib1.readExcelData("campiagn", 0, 0)+ranNum;
//----------------------------------------------------------------------------------------------------
   //    driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(cpgName);
   //     driver.findElement(By.xpath("//img[@alt='Select']")).click();
		 CreateCampPage campPage= new CreateCampPage(driver);
		 campPage.enterCampName(cpgName);
		 //click on + sign To navigate Product table
		 campPage.clickPrdPlusSign();
		   
        
   /*    Set<String> allWins = driver.getWindowHandles();
        Iterator<String> id = allWins.iterator();
        
        while(id.hasNext())
        {
        	String win = id.next();
        	driver.switchTo().window(win);
        	String title = driver.getTitle();
        	if(title.contains("Products&actions"))
        	{
        		break;
        		
        	}
        }*/
		
        wlib.windowSwitching(driver, "Products&action");
     //   driver.findElement(By.name("search_text")).sendKeys(ProdName);
      //  driver.findElement(By.name("search")).click();
        SwitchingProductPage switchWin = new SwitchingProductPage(driver);
        switchWin.enterPrdName(ProdName);
        switchWin.searchPrdName();
        Thread.sleep(2000);
        //dynamic xpath
       // driver.findElement(By.xpath("//a[text()='"+ProdName+"']")).click();//concatination --because as the name changes evertime to random
        switchWin.selectExpPrdName(driver, ProdName);
        //driver is in child window need shift to parent window
   /*     Set<String> allWins1 = driver.getWindowHandles();
        Iterator<String> id1 = allWins1.iterator();
        
        while(id1.hasNext())
        {
        	String win1 = id1.next();
        	driver.switchTo().window(win1);
        	String title1 = driver.getTitle();
        	if(title1.contains("Campaigns&action"))
        	{
        		break;
        		
        	}
        }*/
        wlib.windowSwitching(driver,"Campaigns&action" );
	
      //  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
        campPage.clickSaveButton();
      //---------------------------------------------------------------------------------------------------
           
       /*       String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
              if(actData.contains(cpgName))
              {
           	   System.out.println("Campaigns name is created");
              }
              else
              {
           	   System.out.println("Campaigns is not created");
              }*/
        

//--------------------------------------------------------------------------------------------------
    /*          String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
              if(actData1.contains(ProdName))
              {
           	   System.out.println("Product name is created");
              }
              else
              {
           	   System.out.println("Product name is not created");
              }*/
        ValidateCampiagnsWithProduct validate = new ValidateCampiagnsWithProduct(driver);
  String actData =      validate.validateCampName(driver, cpgName);
  Assert.assertEquals(actData,cpgName);
  System.out.println("Campiagns name is created");

   String actData1=validate.validateProdName(driver, ProdName);
   Assert.assertEquals(actData1,ProdName);
   System.out.println("Product name is created");

//-----------------------------------------------------------------------------------------------------
          //    driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
          //    driver.findElement(By.linkText("Sign Out")).click();
          //    home.logoutApp();
     }
     }


