package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CampValidatePage 
{
	public CampValidatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * 
	 * @param driver
	 * @param CampName
	 * @return
	 */
	public String validateCampaign(WebDriver driver,String cpgName)
	{
		  String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
	        if(actData.contains(cpgName))
	        {
	     	   System.out.println("Campaigns name is created");
	        }
	        else
	        {
	     	   System.out.println("Campaigns is not created");
	        }
			return actData;
		
		

	}
	
}

