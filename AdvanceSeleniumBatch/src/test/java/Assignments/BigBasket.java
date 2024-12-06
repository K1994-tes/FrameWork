package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BigBasket {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("Apples");
		Thread.sleep(2000);
		List<WebElement> allSugg=driver.findElements(By.xpath("//span[@class='Label-sc-15v1nk5-0 QuickSearch___StyledLabel2-sc-rtz2vl-7 gJxZPQ gFDEBU']"));
		for(WebElement ele:allSugg)
		{

			 Thread.sleep(1000);
			System.out.println(ele.getText());
   if(ele.getText().contains("Apple - Red Delicious, Organically Grown"))
	       {
	    	   ele.click();
	       }
	        
		}
		Thread.sleep(1000);
	WebElement ele1=driver.findElement(By.xpath("//h1[text()='fresho! Apple - Red Delicious, Organically Grown, 4 pcs ']/ancestor::section[@class='Description___StyledSection-sc-82a36a-0 jMGGnR']//h1[text()='fresho! Apple - Red Delicious, Organically Grown, 4 pcs ']"));	
	System.out.print(ele1.getText());
	
	Thread.sleep(1000);
		
   WebElement ele2=driver.findElement(By.xpath("//h1[text()='fresho! Apple - Red Delicious, Organically Grown, 4 pcs ']/ancestor::section[@class='Description___StyledSection-sc-82a36a-0 jMGGnR']//h1[text()='fresho! Apple - Red Delicious, Organically Grown, 4 pcs ']/..//td[@class='Description___StyledTd-sc-82a36a-4 fLZywG']"));
     System.out.print(ele2.getText());
	
		
}

}
