package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ProdValidatePage
{
	public ProdValidatePage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	/**
	 * 
	 * @param driver
	 * @param ProdName
	 * @return
	 */
	public String validateProd(WebDriver driver,String ProdName)
	{
		 String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Product Name\"]")).getText();
	        if(actData.contains(ProdName))
	        {
	     	   System.out.println("Product name is created");
	        }
	        else
	        {
	     	   System.out.println("Product name is not created");
	        }

		return actData;
		
	}
}
