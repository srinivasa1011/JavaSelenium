package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class W3schools {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.w3schools.com/html/html_tables.asp");
		By clickdep=By.id("departureCalendar");
 		System.out.println("PRINTING 2ND COL VALUES...");
 		getSecondColvalues();//returns all 2nd column values 
 		System.out.println("PRINTING 3RD COL VALUES...");
 		getThirdColvalues();//returns all 3RD column values 		
 		System.out.println("PRINT ALL ROWS AND COLUMN...");
 		getAllRowsCol();//returns all 3RD column values 		
		
			
	}
		public static void getSecondColvalues()
		{
			By rowsLength=By.xpath("//table[@id='customers']//tr");
			String s1="//table[@id='customers']//tr[";
			String s2="]//td[2]";
			for(int i=2;i<=driver.findElements(rowsLength).size();i++)
			{
				String xpath=s1+i+s2;
				System.out.println(driver.findElement(By.xpath(xpath)).getText());
			}		
		     
		}
		public static void getAllRowsCol()
		{
			By rowsLength=By.xpath("//table[@id='customers']//tr");
			String s1="//table[@id='customers']//tr[";
			String s2="]//td[";
			String s3="]";
			for(int i=2;i<=driver.findElements(rowsLength).size();i++)
			{
				for(int j=1;j<=3;j++)
				{
				String xpath=s1+i+s2+j+s3;
				System.out.print(driver.findElement(By.xpath(xpath)).getText()+" ");
				}
				System.out.println();
			}		
		     
		}
		public static void getThirdColvalues()
		{
			By rowsLength=By.xpath("//table[@id='customers']//tr");
			String s1="//table[@id='customers']//tr[";
			String s2="]//td[3]";
			for(int i=2;i<=driver.findElements(rowsLength).size();i++)
			{
				String xpath=s1+i+s2;
				System.out.println(driver.findElement(By.xpath(xpath)).getText());
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
	    
	     
	    public static void doClick(By loc)
	    {
	    	getElement(loc).click();
	    }
	    
	}
