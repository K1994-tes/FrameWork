package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProdDetailedPage 
{
	public ProdDetailedPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//img[@alt='Create Product...']")
	private WebElement lookUpImg;

	
	public WebElement getLookUpImg() {
		return lookUpImg;
	}
	
	/**
	 * 
	 */
	
	public void clickProdLookUpImg()
	{
		lookUpImg.click();
	}

}
