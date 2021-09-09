package Package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CalenderPractice {

	public CalenderPractice() {
		// TODO Auto-generated constructor stub
	}
	static WebDriver driver;

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("http://seleniumpractise.blogspot.com/2016/08/how-to-handle-calendar-in-selenium.html");
 		By dateentry=By.cssSelector("input#datepicker");
  		doClick(dateentry);
        String mnthYear="January 2020";       
        int date=30;
        //Assignment : select previous year month&&date
        clickDate(mnthYear,date);       	       
	}
	
	public static void clickDate(String mnthyear , int day)
	{
		By defmonthyear=By.cssSelector("div.ui-datepicker-title");
		By backbtn=By.cssSelector("span.ui-icon.ui-icon-circle-triangle-w"); 
		By dateloc=By.xpath("//td//a[text()='"+day+"']");
	        while(!driver.findElement(defmonthyear).getText().equals(mnthyear))
	        {
	        	doClick(backbtn);
	        }
	        doClick(dateloc);
	}
	 
	public static void doSendkeys(By loc, String str)
	{
		getElement(loc).sendKeys(str);
	}
    public static WebElement getElement(By loc)
    {
    	return driver.findElement(loc);
    }
    
     
    public static void doClick(By loc)
    {
    	getElement(loc).click();
    }
    
}
