package Product;

import java.io.FileInputStream;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import ObjectRepo.CreateProdPage;
import ObjectRepo.DeleteProductName;
import ObjectRepo.LoginVtigerPage;
import ObjectRepo.ProdDetailedPage;
import ObjectRepo.ProdValidatePage;
import ObjectRepo.VtigerHomePage;

public class VerifyProductIsDeletedTest extends BaseClass {
     @Test
	public void VerifyProductIsDeletedTest() throws Throwable
	{
		
//WebDriver driver;
		
	/*	FileInputStream fis = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\commondata.propertires.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
	     String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/

  /*      File_Utility flib = new File_Utility();

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
		driver.get(URL);*/
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
	//	LoginVtigerPage login = new LoginVtigerPage(driver);
	//	login.loginIntoVtiger(USERNAME,PASSWORD);

	//	driver.findElement(By.xpath("//a[text()='Products']")).click();
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickPrdLink();
	//	driver.findElement(By.xpath("//img[@alt='Create Product...']")).click();
		ProdDetailedPage img = new ProdDetailedPage(driver);
		img.clickProdLookUpImg();
		
   //	driver.manage().window().maximize();
     //	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	//	WebDriver_Utility wlib = new WebDriver_Utility();
	//	wlib.maximizeWindow(driver);
	//	wlib.waitForPageToLoad(driver);
		
		
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
       // driver.findElement(By.xpath("//input[@name='productname']")).sendKeys(ProdName);
      //  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateProdPage createPage = new CreateProdPage(driver);
		createPage.enterProdName(ProdName);
		createPage.clickSaveButton();
//----------------------------------------------------------------------------------------------------
	/*	 String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
	        if(actData.contains(ProdName))
	        {
	     	   System.out.println("Product name is created");
	        }
	        else
	        {
	     	   System.out.println("Product name is not created");
	        }*/
	       ProdValidatePage validate = new ProdValidatePage(driver);
              String actData =  validate.validateProd(driver, ProdName);
	       Assert.assertEquals(actData,ProdName);
	       System.out.println("Product name is created");


	//	driver.findElement(By.xpath("//a[text()='Products']")).click();
	       VtigerHomePage home1 = new VtigerHomePage(driver);
	       home1.clickPrdLink();
    //   driver.findElement(By.xpath("(//input[@type='checkbox'])[3]")).click();
    //  driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+ProdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
    //   driver.findElement(By.xpath("//input[@value='Delete']")).click();
	       DeleteProductName delete = new DeleteProductName(driver);
	       delete.selectProdName(driver, ProdName);
	       delete.selectDeleteButton();
	      
        
        //Handling AlterPopUp
        Alert alt = driver.switchTo().alert();
     	alt.accept();//----> click on OK button
   //  List<WebElement> allProd=	 driver.findElements(By.xpath("//a[text()='Product Name']"));
     	
  /*   for(WebElement ele : allProd)
		{
		System.out.print(ele.getText());
		if(ele.getText().contains(""+ProdName+""))
		{
			System.out.print("product is present");
		}
		else
		{
			System.out.println("product is deleted");
		}
	}*/
     	//another approach of traversing concept
  /*   	List<WebElement> allProd  =	 driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
     	boolean flag=false;
     	for(WebElement prd : allProd)
     	{
     		String actData=prd.getText();
     		if(actData.contains(ProdName))
     		{
     			flag=true;
     			break;
     		}
     	}
     	if(flag)
     	{
     		System.out.println("product name is deleted");
     	}
     	else
     	{
     		System.out.println("product name is not deleted");
     	}*/
    
   actData=  delete.validateProdDeleted(driver, ProdName);
   Assert.assertEquals(actData,ProdName);
   
  //  driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
  // driver.findElement(By.linkText("Sign Out")).click();
     //	 home.logoutApp();
}

}
