package ObjectRepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class DeleteProductName 
{
	public DeleteProductName(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//input[@value='Delete']")
	private WebElement DeleteButton;
	
	public void selectProdName(WebDriver driver,String ProdName)
	{
		 driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+ProdName+"']/../preceding-sibling::td//input[@type='checkbox']")).click();
	}
	
	public void selectDeleteButton()
	{
		DeleteButton.click(); 
	}
	public String validateProdDeleted(WebDriver driver,String ProdName)
	{
		List<WebElement> allProd  =	 driver.findElements(By.xpath("(//table[@class='lvt small']/tbody/tr/td[3])[position()>1]"));
     	boolean flag=false;
     	for(WebElement prd : allProd)
     	{
     		String actData=prd.getText();
     		if(actData.contains(ProdName))
     		{
     			flag=true;
     			break;
     		}
     		
     	}
     //	if(flag)
    // 	{
    // 		System.out.println("product name is deleted");
    // 	}
     //	else
     //	{
     //		System.out.println("product name is not deleted");
     //	}
		return ProdName;
		
     	
		
	}
}
