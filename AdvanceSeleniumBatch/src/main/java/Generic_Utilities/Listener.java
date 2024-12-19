package Generic_Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class Listener implements ITestListener {

	@Override
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot takesScreenshot = (TakesScreenshot) BaseClass.sdriver;
		
	
			File src = takesScreenshot.getScreenshotAs(OutputType.FILE);
			File dst = new File("./FailedScripts.png");
			
		try {
			FileUtils.copyFile(src,  dst);
		} catch(IOException e) {
			e.printStackTrace();
			
		}
	}


}
