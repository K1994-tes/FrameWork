package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class OrgValidatePage 
{
	public OrgValidatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * 
	 * @param driver
	 * @param OrgName
	 * @return
	 */
	public String validateOrg(WebDriver driver,String OrgName)
	{
		String actData = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
/*		   if(actData.contains(OrgName))
		   {
			   System.out.println("Organization name is created");
		   }
		   else
		   {
			   System.out.println("Organization is not created");
		   }*/
		return actData;
		
	}
	
}
