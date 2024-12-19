package Generic_Utilities;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class WebDriver_Utility 
{
/**
 * This method is used to maximize the window
 * @param driver
 */
	public void maximizeWindow(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method is used to wait for page to load
	 * @param driver
	 */
	public void waitForPageToLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	/**
	 * This method is used to switch windows
	 * @param driver
	 * @param partialTitle
	 */
	public void windowSwitching(WebDriver driver,String partialTitle)
	{
		Set<String> allWins = driver.getWindowHandles();
		Iterator<String> id = allWins.iterator();
		while(id.hasNext()) //hasNext() - either true or false
		{
			String win = id.next(); // next() -  go next element i.e next window id 
			driver.switchTo().window(win);
			String title = driver.getTitle();
			if(title.contains(partialTitle)) //if title matches executes the loop
			{
				break;
			}
		}
		}
	public void  alertAccept(WebDriver driver) {
		driver.switchTo().alert().accept();
	}
	
	public static String takeScreenShot(WebDriver driver, String screenShotName) throws Throwable{
		TakesScreenshot takesScreenShot = (TakesScreenshot)driver;
		File src = takesScreenShot.getScreenshotAs(OutputType.FILE);
		File dst = new File("./ScreenShots/"+screenShotName+".png");
		FileUtils.copyFile(src, dst);
		return dst.getAbsolutePath();
		

}
	
	}

