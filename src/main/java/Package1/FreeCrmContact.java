package Package1;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class FreeCrmContact {
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
		
		//Assignment 1 :program to click all check box of contacts web table
		clickAllCheckBox(); 
		
		//Assignment 2 :program to Fetch 3rd column data till last column for any single  user in contacts web table
		String s="Abe Sabian";
		List<String>list=GetOneUserInfo(s);
		System.out.println("DETAILS OF USER" + s +"IS  "+list);
		
		//EXPLORATORY TEST: program to dynamically fetch all rows and column by passing contact name 
		List<String> li=fetchEachValue();
		for(String e: li)
		{
			List<String>lis=GetOneUserInfo(e);
			System.out.println("Details of user " + e +" is "+lis);
		}
		
	}
	

	public static List<String> GetOneUserInfo(String name)	{
		By loct=By.xpath("//a[@context='contact' and text()='"+name+"']//parent::td//following-sibling::td");
		List<WebElement> li = getElements(loct);
		ArrayList<String>al=new ArrayList<String>();
		for(WebElement e:li)
		{
			//System.out.println(e.getText());
			al.add(e.getText());
		}
		return al;		
	}

	public static List<String> fetchEachValue()
	{
		By loct=By.xpath("//a[@context='contact']");
		List<WebElement> li = getElements(loct);
		ArrayList<String>al=new ArrayList<String>();
		for(WebElement e:li)
		{
			//System.out.println(e.getText());
			al.add(e.getText());
		}
		return al;
	}
	

	public static void clickAllCheckBox() {
		By loc=By.xpath("//input[@name='contact_id']");
		List<WebElement> li = getElements(loc);
		for (int i = 1; i < li.size(); i++) {
			li.get(i).click();
		}
	}
	public static void doSendkeys(By loc, String str)
	{
		getElement(loc).sendKeys(str);
	}
    public static WebElement getElement(By loc)
    {
    	return driver.findElement(loc);
    }
    
    public static List<WebElement> getElements(By loc)
    {
    	return driver.findElements(loc);
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
