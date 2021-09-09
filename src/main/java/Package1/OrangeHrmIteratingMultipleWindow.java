package Package1;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class OrangeHrmIteratingMultipleWindow {
    static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
          WebDriverManager.chromedriver().setup();
          driver=new ChromeDriver();
          driver.get("https://opensource-demo.orangehrmlive.com/");
          driver.manage().window().maximize();
          String socialSite[]= {"linkedin","facebook","twitter","youtube"};//declare array of link name
          String parent=driver.getWindowHandle();//get address of parent window
          //program to click all iinks and open multiple window at one go , get title of each page,
          //then close one by one 
          for(int i=0;i<socialSite.length;i++)//this will click all link at one go
          {
            clickSocialSite(socialSite[i]);
          }
          Set<String>s=driver.getWindowHandles();//this gets list of address of all window
          ArrayList<String>al=new ArrayList<String>(s);
          System.out.println("set address list is "+al);
          String child;
          for(int i=al.size()-1;i>=0;i--)//iterate to each index of array list and switch to window and get title
          {
        	  child=al.get(i);
        	  driver.switchTo().window(child);
        	  System.out.println(driver.getTitle());
        	  driver.close();        	  
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
         case "twitter":  System.out.println("Twitter Button Clicked");
                          doClick(twitter);
          				  break;
         case "linkedin": System.out.println("linkedin Button Clicked");
                          doClick(linkedin);
                          break;
         case "youtube":  System.out.println("youtube Button Clicked");
                          doClick(youtube);
                          break;
         case "facebook": System.out.println("facebook Button Clicked");
                          doClick(fb); 
                          break;
		 default:         System.out.println(" invalid button");
		                  break;
         }
         
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
