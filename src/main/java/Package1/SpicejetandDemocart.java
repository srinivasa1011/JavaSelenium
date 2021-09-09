package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SpicejetandDemocart {
	static  WebDriver driver;

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		String browser="chrome";
		BrowserUtil br=new BrowserUtil();
	    driver=br.getBrowser(browser);
		//br.launchUrl("https://www.spicejet.com/");
		br.launchUrl("https://demo.opencart.com/");		
		Actions act=new Actions(driver);
		ElementUtil el=new ElementUtil(driver);
		By fname=By.xpath("//input[@name='firstname']");
		By lname=By.xpath("//input[@name='lastname']");
		By email=By.xpath("//input[@name='email']");
		By telephone=By.xpath("//input[@name='telephone']");
		By password=By.xpath("//input[@name='password']");
		By cfmpassword=By.xpath("//input[@name='confirm']");
		By noOption=By.xpath("//*[@class='radio-inline'][2]");
		By agree=By.xpath("//input[@type='checkbox']");
		By submit=By.xpath("//*[@type='submit']");
		By verifyText=By.xpath("//div[@id='content']//h1");
		WebElement w=driver.findElement(By.linkText("My Account"));
		act.moveToElement(w).click().perform();
		Thread.sleep(3000);
		WebElement w2=driver.findElement(By.linkText("Register"));
		act.moveToElement(w2).click().perform();
/*	    act.sendKeys(driver.findElement(fname),"firstname").perform();
	    act.sendKeys(driver.findElement(lname),"lastname").perform();
	    act.sendKeys(driver.findElement(email),"abc@gmail.com").perform();
	    act.sendKeys(driver.findElement(telephone),"909089098").perform();
	    act.sendKeys(driver.findElement(password),"password123").perform();
	    act.sendKeys(driver.findElement(cfmpassword),"password123").perform();*/
		doSend_SendKEYS(fname,"joh");
		doSend_SendKEYS(lname,"desilva");
		doSend_SendKEYS(email,"emai6l243@gmail.com");
		doSend_SendKEYS(telephone,"8088998882");
		doSend_SendKEYS(password,"abc1234");
		doSend_SendKEYS(cfmpassword,"abc1234");
		doSend_SendKEYSClick(noOption);
		doSend_SendKEYSClick(agree);
		doSend_SendKEYSClick(submit);
		if(driver.findElement(verifyText).getText().contains("Created"))
		System.out.println("account created");
		else
			System.out.println("acct not created");

	}
	
	public static WebElement getElement(By loc)
	{
		return driver.findElement(loc);
	}
	
	public static void doSend_SendKEYS(By loc, String str)
	{
		Actions ac=new Actions(driver);
		ac.sendKeys(getElement(loc),str).perform();
	}
	public static void doSend_SendKEYSClick(By loc)
	{
		Actions ac=new Actions(driver);
		ac.click(getElement(loc)).perform();
	}

}
