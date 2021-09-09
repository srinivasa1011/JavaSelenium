package Package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver.TargetLocator;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoIbibo {
    static WebDriver driver;
	public GoIbibo() {
		// TODO Auto-generated constructor stub
	}
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.goibibo.com/");
		By from=By.id("gosuggest_inputSrc");
		By from2=By.xpath("//div[@id='downshift-3-item-0']/li/div/div");
		By from3=By.xpath("//div[@id='downshift-3-item-0']");
		//By to=By.id("gosuggest_inputDest");
		doSendkeys(from, "Bengaluru");
		Thread.sleep(9000);
		//driver.findElement(from3).click();
			List<WebElement>li=driver.findElements(from2);
		for(WebElement e: li)
		 System.out.println(e.getText());
		driver.findElement(from3);
		By clickdep=By.id("departureCalendar");
 		By clickarrival=By.id("returnCalendar");
 		//Assignment  :program to enter date value in goibibo website
		String DepmonthYear="September 2021";
		int depdate=27;
		String ArrivalmonthYear="November 2021";
		int arrivaldate=19;
		
		/*doClick(clickdep);//clicking text box to launch calender
		clickDepDate(DepmonthYear,depdate);
		
		doClick(clickarrival);//clicking text box to launch calender
		clickArrivalDate(ArrivalmonthYear,arrivaldate);*/
		
			
	}
		public static void clickDepDate(String mnthyear , int day)
		{
			By depmonthyear=By.cssSelector("div.DayPicker-Caption");
 			By date=By.xpath("//div[text()='"+day+"']");
 			By frdbtn=By.xpath("//span[@aria-label='Next Month']");
		        while(!driver.findElement(depmonthyear).getText().equals(mnthyear))
		        {
		        	doClick(frdbtn);
		        }
		        doClick(date);
		}
		
		public static void clickArrivalDate(String mnthyear , int day)
		{
 			By date=By.xpath("//div[text()='"+day+"']");
			By arrivalmonthyear=By.cssSelector("div.DayPicker-Caption");
 			By frdbtn=By.xpath("//span[@aria-label='Next Month']");

		        while(!driver.findElement(arrivalmonthyear).getText().equals(mnthyear))
		        {
		        	doClick(frdbtn);
		        }
		        doClick(date);
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
