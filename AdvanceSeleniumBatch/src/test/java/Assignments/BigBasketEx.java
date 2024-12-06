package Assignments;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BigBasketEx {

	public static void main(String[] args) throws Throwable
	{

		WebDriver driver = new ChromeDriver();
		driver.get("https://www.bigbasket.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.xpath("(//input[@type=\"text\"])[2]")).sendKeys("grapes");
		List<WebElement> allSugg= driver.findElements(By.xpath("//span[@class=\"Label-sc-15v1nk5-0 QuickSearch___StyledLabel4-sc-rtz2vl-9 gJxZPQ gpRcpM\"]"));
		for(WebElement ele:allSugg)
		{

			 Thread.sleep(1000);
			System.out.println(ele.getText());
		
int a= 50;
   if(ele.getText()<a)
	       {
	    	   ele.click();
	       }
	        
		}
	

	}

}
