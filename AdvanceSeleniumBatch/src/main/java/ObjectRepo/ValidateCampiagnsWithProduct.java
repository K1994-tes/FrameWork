package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ValidateCampiagnsWithProduct 
{
	public ValidateCampiagnsWithProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	public void validateCampName(WebDriver driver,String CampName)
	{
		   String actData = driver.findElement(By.xpath("//span[@id='dtlview_Campaign Name']")).getText();
           if(actData.contains(CampName))
           {
        	   System.out.println("Campaigns name is created");
           }
           else
           {
        	   System.out.println("Campaigns is not created");
           }
	}
           public void validateProdName(WebDriver driver,String PrdName)
           {
        	   String actData1 = driver.findElement(By.xpath("//span[@id='dtlview_Product']")).getText();
               if(actData1.contains(PrdName))
               {
            	   System.out.println("Product name is created");
               }
               else
               {
            	   System.out.println("Product name is not created");
               }
           }
	}

