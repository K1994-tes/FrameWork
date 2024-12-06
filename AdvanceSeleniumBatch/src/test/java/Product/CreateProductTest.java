package Product;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
import ObjectRepo.CreateCampPage;
import ObjectRepo.CreateProdPage;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProdDetailedPage;
import ObjectRepo.ProdValidatePage;
import ObjectRepo.VtigerHomePage;

public class CreateProductTest extends BaseClass{
@Test(groups="sanity")
	public void createProductTest() throws Throwable
	{

//WebDriver driver;

 /*   FileInputStream fis = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\commondata.propertires.txt");
    Properties pro = new Properties();
    pro.load(fis);
    String BROWSER = pro.getProperty("browser");
    String URL = pro.getProperty("url");
    String USERNAME = pro.getProperty("username");
    String PASSWORD = pro.getProperty("password");*/
		
	/*	File_Utility flib = new File_Utility();
		
		String BROWSER = flib.getKeyAndValuePair("browser");
	    String URL =flib.getKeyAndValuePair ("url");
		String USERNAME =flib.getKeyAndValuePair("username");
		String PASSWORD =flib.getKeyAndValuePair("password");
		if(BROWSER.equalsIgnoreCase("chrome"))
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
		}
		driver.get(URL);*/
	//	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	//	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	//	driver.findElement(By.id("submitButton")).click();
	//	LoginVtigerPage login = new LoginVtigerPage(driver);
	//	login.getUserTextField().sendKeys(USERNAME);
	//	login.getPasswordTextField().sendKeys(PASSWORD);
	//	login.getLoginButton().click();
		
	//	LoginVtigerPage login = new LoginVtigerPage(driver);
	//	login.loginIntoVtiger(USERNAME,PASSWORD);
		
		//driver.findElement(By.xpath("//a[text()='Products']")).click();
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickPrdLink();
	//	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		ProdDetailedPage img = new ProdDetailedPage(driver); 
		img.clickProdLookUpImg();
       //   driver.manage().window().maximize();
		//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
//		WebDriver_Utility wlib = new WebDriver_Utility();
//		wlib.maximizeWindow(driver);
//		wlib.waitForPageToLoad(driver);
		
//---------------------------------------------------------------------------------------------------
		//Random ran= new Random();
		//int ranNum= ran.nextInt(1000);
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
   //     driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(ProdName);
   //    driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateProdPage createPage = new CreateProdPage(driver);
		createPage.enterProdName(ProdName);
		createPage.clickSaveButton();

//---------------------------------------------------------------------------------------------------
       Thread.sleep(2000);
   /*     String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
        if(actData.contains(ProdName))
        {
     	   System.out.println("Product name is created");
        }
        else
        {
     	   System.out.println("Product name is not created");
        }*/
       ProdValidatePage validate = new ProdValidatePage(driver);
       validate.validateProd(driver, ProdName);
//-----------------------------------------------------------------------------------------------------
     //   driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
     //   driver.findElement(By.linkText("Sign Out")).click();
     //   home.logoutApp();
       

	}

	}
