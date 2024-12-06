package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampPage {

		public CreateCampPage(WebDriver driver)
		{
			PageFactory.initElements(driver, this);
		}

		@FindBy(xpath ="//input[@name='campaignname']")
		private WebElement campName;

		@FindBy(xpath ="//input[@title='Save [Alt+S]']")
		private WebElement saveButton;
		
		@FindBy(xpath="//img[@alt='Select']")
		private WebElement PrdPlusSign;
		

		//getter methods
		public WebElement getCampName()
		{
			return campName;
		}

		public WebElement getSaveButton()
		{
			return saveButton;
		}
		

		public WebElement getPrdPlusSign() {
			return PrdPlusSign;
		}

		
		/**
		 * 
		 * @param name
		 */
		public void enterCampName(String name) 
		{
			campName.sendKeys(name);
		}
		public void clickPrdPlusSign()
		{
			PrdPlusSign.click();
		}

		public void clickSaveButton()
		{
			saveButton.click();
		}
	

	}


