package Assignments;
import java.time.Duration;
import java.util.Scanner;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ProkabaddiStatusOfATeam
{
public static void main(String[]args) throws Throwable
{
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.prokabaddi.com/standings");
	driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
Scanner sc = new Scanner(System.in);
System.out.println("Enter any Kabaddi Team name");
String nm=sc.nextLine();
String tName= driver.findElement(By.xpath("//p[text()='"+nm+"']")).getText();
String Plays = driver.findElement(By.xpath("//p[text()='"+nm+"']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data matches-play']")).getText();
System.out.println(Plays);
String Won = driver.findElement(By.xpath("//p[text()='"+nm+"']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data matches-won']")).getText();
System.out.println(Won);
String Lost= driver.findElement(By.xpath("//p[text()='"+nm+"']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data matches-lost']")).getText();
System.out.println(Lost);
String Draw = driver.findElement(By.xpath("//p[text()='"+nm+"']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data matches-draw']")).getText();
System.out.println(Draw);
String ScoreDiff = driver.findElement(By.xpath("//p[text()='"+nm+"']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data score-diff']")).getText();
System.out.println(ScoreDiff);
String Form = driver.findElement(By.xpath("//p[text()='"+nm+"']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data form']")).getText();
System.out.println(Form);
String Points = driver.findElement(By.xpath("//p[text()='"+nm+"']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data points']")).getText();
System.out.println(Points);
/*System.out.println(driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data matches-play']")).getText());
System.out.println(driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data matches-won']")).getText());
System.out.println(driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data matches-lost']")).getText());
System.out.println(driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data matches-draw']")).getText());
System.out.println(driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data score-diff']")).getText());
System.out.println(driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data form']")).getText());
System.out.println(driver.findElement(By.xpath("//p[text()='Haryana Steelers']/ancestor::div[@class=\"table-row-wrap\"]/div//div[@class='table-data points']")).getText());*/

}
}
