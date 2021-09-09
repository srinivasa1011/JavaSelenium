package TestNG;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExceptionDependsonMethodInvocationcout {
	WebDriver driver;
	@BeforeTest
	public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.navigate().to("https://demo.opencart.com/index.php?route=account/account");
	}
	@Test(expectedExceptions= { Exception.class, ArithmeticException.class})
	public void afun1()
	{
		System.out.println("fun1");
		int c=10/0;
	}
	@Test(invocationCount=2)
	public void cfun9()
	{
		System.out.println("fnction 2");
	}
	@Test(dependsOnMethods="cfun9")
	public void bfun3()
	{
		System.out.println("function 3");
	}
	@Test(priority=1)
	public void afun3()
	{
		System.out.println("function pa");
	}

	@Test(priority=0)
	public void zfun43()
	{
		System.out.println("function z ");
	}


}
