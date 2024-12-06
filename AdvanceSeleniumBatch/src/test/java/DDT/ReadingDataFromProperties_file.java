package DDT;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ReadingDataFromProperties_file
{
public static void main(String[]args)throws Throwable
{
	WebDriver driver=new ChromeDriver();
	//giving physical representation of the file path
FileInputStream fis= new FileInputStream("C:\\Users\\saila\\OneDrive\\Desktop\\advanced selenium practical folder\\commondata.properties.txt");
//	FileInputStream fis= new FileInputStream(".//src/test/resources/commondata.properties.txt");
//loading all the "keys" into properties class
Properties pro = new Properties();
pro.load(fis);
//reading keys from properties file
String URL = pro.getProperty("url");
String USERNAME = pro.getProperty("username");
String PASSWORD = pro.getProperty("password");
 
driver.get(URL);
driver.findElement(By.name("user-name")).sendKeys(USERNAME);
driver.findElement(By.id("password")).sendKeys(PASSWORD);
driver.findElement(By.id("login-button")).click();
}
}
