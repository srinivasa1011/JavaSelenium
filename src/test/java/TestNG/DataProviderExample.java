package TestNG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;
 
public class DataProviderExample {
	public WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://demo.opencart.com/index.php?route=account/account");
	}
	@DataProvider	
	public Object[][] usersInfo()
	{
		return new Object[][] {
			{"sachin","tendulkar","s@gmail.com","989898989","passwww"},
			{"virat","kohli","v@gmail.com","8899898989","passww44w"},
			{"rohith","sharma","s@gmail.com","8766898989","pass5www"},
			{"ravichandran","ashwin","s@gmail.com","9555456989","pas555swww"},
			{"japrit","bhumrah","s@gmail.com","989555559","pass6666www"}		
		};
	}
	
	@Test(dataProvider="usersInfo")
	public void verifyUserCreation(String fn, String ln, String eml,String tele, String password)
	{
		Boolean b=registerUsers(fn,ln,eml,tele,password);
		//Assert.assertTrue(registerUsers(fn,ln,eml,tele,password),"reistration fail");
	}
	
	public Boolean registerUsers(String fn, String ln, String eml,String tele, String password)
	{
		driver.findElement(By.name("firstname")).sendKeys(fn);
		driver.findElement(By.name("lastname")).sendKeys(ln);
		driver.findElement(By.name("email")).sendKeys(eml);
		driver.findElement(By.name("telephone")).sendKeys(tele);
		driver.findElement(By.name("confirm")).sendKeys(password);
		driver.findElement(By.name("password")).sendKeys(password);
		driver.findElement(By.name("agree")).click();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		return driver.findElement(By.xpath("//div[@id='content']/h1")).isDisplayed();
	    
	}
	
	@AfterTest
	public void closebrowsr()
	{
		//driver.quit();
	}

}
