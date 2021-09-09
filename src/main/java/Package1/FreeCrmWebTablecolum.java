package Package1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeCrmWebTablecolum {

	static WebDriver driver;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://classic.crmpro.com/index.html");
		By username=By.name("username");
		By password=By.name("password");
		By submit=By.xpath("//input[@type='submit']");
		By contacts=By.linkText("CONTACTS");
		doSendkeys(username,"groupautomation");
		doSendkeys(password,"Test@12345");
		doClick(submit);
		gotoFrame("mainpanel");		
		clickDropDown(contacts);
		
		//Assignment 1 :program to get 2nd  column user name value ,apply pagination also		
		
		getColumnvaluesPaging();
	}
	// this will print all the table values from all the pages 
	public static void getColumnvaluesPaging()
	{
		getColumnValues();//getting first page value, 2nd column text 
		By loc=By.xpath("(//div[@class='pagination'])[1]/a");
		//getting 2nd to nth page value
		List<WebElement>li2=getElements(loc);
        for(int i=0;i<li2.size();i++)
        {
        	System.out.println("PRINTING PAGE  ............."+(i+2) +"");
        	li2.get(i).click();
        	getColumnValues();        	
        	li2=getElements(loc);
        }
	}
	public static void getColumnValues()
	{
		By loc=By.xpath("(//table[@class='datacard'])[3]//tr/td[2]/a");
		List<WebElement>li=getElements(loc);
 		for(int i=2;i<li.size();i++)
		{
			System.out.println(li.get(i).getText());
			
		}
	}
	
	 public static List<WebElement> getElements(By ele)
	 {
		 return driver.findElements(ele);
	 }
     
     public static WebElement getElement(By ele)
     {
    	 return driver.findElement(ele);
     }
    
 	public static void doSendkeys(By loc, String str)
 	{
 		getElement(loc).sendKeys(str);
 	}
     
     public static void doClick(By loc)
     {
     	getElement(loc).click();
     }
     public static TargetLocator frames()
     {
     	return driver.switchTo();
     }
     public static void  gotoFrame(String ele)
     {
        frames().frame(ele);
     }
     public static void clickDropDown(By loc1)
 	{
 		Actions act=new Actions(driver);
 		act.click(getElement(loc1)).perform();	
 	}
}