package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProdPage 
{
	public CreateProdPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='productname']")
	private WebElement prodName;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	//getter methods
	public WebElement getProdName() 
	{
		return prodName;
	}
	public WebElement getSaveButton()
	{
		return saveButton;
	}
	/**
	 * 
	 * @param name
	 */
	public void enterProdName(String name) 
	{
		prodName.sendKeys(name);
	}

	public void clickSaveButton()
	{
		saveButton.click();
	}

	


}
