package Assignments;

import java.time.Duration;
import java.util.List;
import java.util.Scanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProkaaddiTeamnamesandTimeOfMatch {

	public static void main(String[] args) throws Throwable
	{
		WebDriver driver = new ChromeDriver();
		driver.get("  https://www.google.com/search?q=pro+kabaddi+schedule&oq");
		driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	Scanner sc=new Scanner(System.in);
	System.out.print("Enter any two kabaddi team names: ");
	Thread.sleep(2000);
	String nm1=sc.nextLine();
	String nm2=sc.nextLine();
	Thread.sleep(2000);
	String tName1= driver.findElement(By.xpath("(//span[text()='"+nm1+"'])[1]")).getText();
	Thread.sleep(2000);
	String tName2= driver.findElement(By.xpath("(//span[text()='"+nm2+"'])[1]")).getText();

	Thread.sleep(1000);
	String Jpp = driver.findElement(By.xpath("(//span[text()='"+nm1+"'])[1]/ancestor::div[@class='tsp-cd']/div//div[2]//div[2]//span[text()='"+nm1+"']")).getText();
	System.out.println(Jpp);
	String DD = driver.findElement(By.xpath("(//span[text()='"+nm1+"'])[1]/ancestor::div[@class='tsp-cd']/div//div[3]//span[text()='"+nm2+"']")).getText();
	System.out.println(DD);
	String TimeOfMatch = driver.findElement(By.xpath("(//span[text()='"+nm1+"'])[1]/ancestor::div[@class='tsp-cd']/div/div[1]//div//div[@class='tsp-frs tsp-pl4']")).getText();
	System.out.println(TimeOfMatch);
	
/*System.out.println(driver.findElement(By.xpath("(//span[text()='Jaipur Pink Panthers'])[1]/ancestor::div[@class='tsp-cd']/div//div[2]//div[2]//span[text()='Jaipur Pink Panthers']")).getText());
	Thread.sleep(1000);
	System.out.println(driver.findElement(By.xpath("(//span[text()='Jaipur Pink Panthers'])[1]/ancestor::div[@class='tsp-cd']/div//div[3]//span[text()='Dabang Delhi']")).getText());
System.out.println(driver.findElement(By.xpath("(//span[text()='Jaipur Pink Panthers'])[1]/ancestor::div[@class='tsp-cd']/div/div[1]//div//div[@class='tsp-frs tsp-pl4']")).getText());
Thread.sleep(1000);

System.out.println(driver.findElement(By.xpath("(//span[text()='Gujarat Giants'])[1]/ancestor::div[@class='tsp-cd']/div//div[2]//div[2]//span[text()='Gujarat Giants']")).getText());
System.out.println(driver.findElement(By.xpath("(//span[text()='Gujarat Giants'])[1]/ancestor::div[@class='tsp-cd']/div//div[3]//span[text()='Telugu Titans']")).getText());
System.out.println(driver.findElement(By.xpath("(//span[text()='Gujarat Giants'])[1]/ancestor::div[@class='tsp-cd']/div/div[1]//div//div[@class='tsp-frs tsp-pl4']")).getText());*/
	}

}
