 package ObjectRepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginVtigerPage 
{
	//initialization
	public LoginVtigerPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//Element Declaration
	@FindBy(name="user_name")
	private WebElement UserTextField;
	
	@FindAll({@FindBy(css="[type='password']"),@FindBy(name="user_password")})
	private WebElement PasswordTextField;
	
	@FindAll({@FindBy(xpath="//input[type=\"submit\"]"),@FindBy(id="submitButton")})
	private WebElement LoginButton;
   //Getter Methods
	public WebElement getUserTextField() {
		return UserTextField;
	}

	public WebElement getPasswordTextField() {
		return PasswordTextField;
	}

	public WebElement getLoginButton() {
		return LoginButton;
	}
	//Business Logics
	
     /**
      * this method is used to login into Vtiger application
      * @author Keerthi
      */
	public void loginIntoVtiger(String username,String password)
	{
		UserTextField.sendKeys(username);
		PasswordTextField.sendKeys(password);
		LoginButton.click();
	}
	
	
	
	

}
