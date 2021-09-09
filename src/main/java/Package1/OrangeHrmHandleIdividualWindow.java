package Package1;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmHandleIdividualWindow {
 	    static WebDriver driver;
		public static void main(String[] args) {
			// TODO Auto-generated method stub
	          WebDriverManager.chromedriver().setup();
	          driver=new ChromeDriver();
	          driver.get("https://opensource-demo.orangehrmlive.com/");
	          driver.manage().window().maximize();
	          String socialSite[]= {"linkedin","facebook","twitter","youtube"};//declare array of link name
	          
	          //for each of the iteration , single link is clicked , then control goes to child window
	          //and title of  1  child window is printed and 1 child window is closed , 
	          //finally control goes to parent window
	          //one by one window is handled
	          for(int i=0;i<socialSite.length;i++)
	          {
	            clickSocialSite(socialSite[i]);
	            switchToChileNbackToParent();
	          }	          
		}
		
		//this will click on link based on site name sent as parameter 
		static void clickSocialSite(String sitename)
		{
			 By linkedin=By.xpath("//img[@alt='LinkedIn OrangeHRM group']");
	         By fb=By.xpath("//img[@alt='OrangeHRM on Facebook']");
	         By youtube=By.xpath("//img[@alt='OrangeHRM on youtube']");
	         By twitter=By.xpath("//img[@alt='OrangeHRM on twitter']");
	         switch(sitename)
	         {
	         case "twitter":  System.out.println("Twitter page opened");
	                          doClick(twitter);
	          				  break;
	         case "linkedin": System.out.println("linkedin page opened");
	                          doClick(linkedin);
	                          break;
	         case "youtube":  System.out.println("youtube page opened");
	                          doClick(youtube);
	                          break;
	         case "facebook": System.out.println("facebook page opened");
	                          doClick(fb); 
	                          break;
			 default:         System.out.println(" invalid button");
			                  break;
	         }
	         
		} 
		//this will navigate to child window and gets the title 
		//after getting title of child window, child window is closed, control is back to parent window 
		static void switchToChileNbackToParent()
		{
			Set<String>s=driver.getWindowHandles();//this gets list of address of all window
	          ArrayList<String>al=new ArrayList<String>(s);
	          driver.switchTo().window(al.get(1));
	          System.out.println("title of page is" +driver.getTitle());
	          driver.close();
	          driver.switchTo().window(al.get(0));
	          System.out.println("back to orangHRM home page....");
		}
		
		static WebElement getElement(By loc)
		{
			return driver.findElement(loc);
		}
		static void doClick(By loc)
		{
			getElement(loc).click();
		}

	}
