package Campiagns;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import ObjectRepo.CampDetailedPage;
import ObjectRepo.CampValidatePage;
import ObjectRepo.CreateCampPage;
import ObjectRepo.VtigerHomePage;

//@Listeners(Generic_Utilities.Listener.class)
//@Listeners(Generic_Utilities.ExtentReport.class)
public class CampaignsTest extends BaseClass {

	@Test(groups = {"smoke","regression"})
  // @Test(retryAnalyzer = Generic_Utilities.RetryImp.class)
//	@Test
	public void campaignsTest() throws Throwable
	{

		
	/*	FileInputStream fis = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\commondata.propertires.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String BROWSER = pro.getProperty("browser");
	     String URL = pro.getProperty("url");
		String USERNAME = pro.getProperty("username");
		String PASSWORD = pro.getProperty("password");*/
  //     File_Utility flib = new File_Utility();

   /*     String BROWSER = flib.getKeyAndValuePair("browser");
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
	/*	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();*/
//		LoginVtigerPage login = new LoginVtigerPage(driver);
//		login.loginIntoVtiger(USERNAME,PASSWORD);

	//	driver.manage().window().maximize();
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		WebDriver_Utility wlib = new WebDriver_Utility();
//		wlib.maximizeWindow(driver);
//		wlib.waitForPageToLoad(driver);
		
	//	driver.findElement(By.xpath("//a[text()='More']")).click();
	//	driver.findElement(By.xpath("//a[text()='Campaigns']")).click();
		VtigerHomePage home = new VtigerHomePage(driver);
		home.clickMoreLink();
		home.clickCampLink();
	//	driver.findElement(By.xpath("//img[@alt=\"Create Campaign...\"]")).click();
		CampDetailedPage img = new CampDetailedPage(driver);
		img.clickCampLookUpImg();
//----------------------------------------------------------------------------------------------------
	//	Random ran= new Random();
	//	int ranNum= ran.nextInt(1000);
		Java_Utility jlib = new Java_Utility();
		int ranNum = jlib.getRandomNum();

//----------------------------------------------------------------------------------------------------
	/*	FileInputStream fis1 = new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\TestData2.xlsx");
		Workbook book = WorkbookFactory.create(fis1);
		Sheet sheet = book.getSheet("campiagn");
		Row row = sheet.getRow(0);
		Cell cell = row.getCell(0);
		String cpgName= cell.getStringCellValue()+ ranNum;
        System.out.println(cpgName);*/
		Excel_Utility elib = new Excel_Utility();
		String cpgName = elib.readExcelData("campiagn", 0, 0)+ranNum;
	//----------------------------------------------------------------------------------------------------
     //   driver.findElement(By.xpath("//input[@name='campaignname']")).sendKeys(cpgName);
     //  driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
		CreateCampPage createPage = new CreateCampPage(driver);
		createPage.enterCampName(cpgName);
		createPage.clickSaveButton();
	//	Assert.fail();
//---------------------------------------------------------------------------------------------------
        Thread.sleep(2000);
  //      String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
  //      if(actData.contains(cpgName))
   //     {
  //   	   System.out.println("Campaigns name is created");
  //      }
  //      else
    //    {
    // 	   System.out.println("Campaigns is not created");
      //  }
        
        CampValidatePage validate = new CampValidatePage(driver);
		String actData=validate.validateCampaign(driver, cpgName);
    	Assert.assertEquals(actData,cpgName);
	//	Assert.fail("fail the script");
		System.out.println("Campagin Name is created");
		
  //      driver.findElement(By.cssSelector("[src=\"themes/softed/images/user.PNG\"]")).click();
  //      driver.findElement(By.linkText("Sign Out")).click();
    //    home.logoutApp();
	}
// =================================================================================================
}


