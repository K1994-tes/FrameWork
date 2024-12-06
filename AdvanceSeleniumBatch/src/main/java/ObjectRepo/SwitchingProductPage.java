package ObjectRepo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SwitchingProductPage 
{
	public SwitchingProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(name="search_text")
	private WebElement prdName;
	
	@FindBy(name="search")
	private WebElement searchPrd;

	//getter methods
	public WebElement getPrdName() {
		return prdName;
	}

	public WebElement getSearchPrd() {
		return searchPrd;
	}

	public void enterPrdName(String Name)
	{
		prdName.sendKeys(Name);
	}
   public void searchPrdName()
   {
	   searchPrd.click();
   }
   public void selectExpPrdName(WebDriver driver,String ProdName)
   {
	   WebElement Name =  driver.findElement(By.xpath("//a[text()='"+ProdName+"']"));
	   Name.click();
   }
}
