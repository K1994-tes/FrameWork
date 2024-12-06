package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrgPage 
{
	public CreateOrgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@name='accountname']")
	private WebElement orgName;
	@FindBy(xpath="//input[@id='phone']")
	private WebElement phNum;
	@FindBy(xpath="//input[@name='email1']")
	private WebElement mailId;
	@FindBy(xpath="//input[@title='Save [Alt+S]']")
	private WebElement saveButton;
	//getter Methods
	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getPhnNum() {
		return phNum;
	}

	public WebElement getMailId() {
		return mailId;
	}

	public void enterOrgName(String Name) {
		orgName.sendKeys(Name);
	}

	public void enterPhnNum(String phnNumber) {
		phNum.sendKeys(phnNumber);
	}

	public void enterMailId(String emailId) {
		mailId.sendKeys(emailId);
	}

	public void clickSaveButton() {
		saveButton.click();
	}

}
