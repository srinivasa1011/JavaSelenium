package Package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Freshworks {
  static WebDriver driver;
	public Freshworks() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://www.freshworks.com/?tactic_id=3419410&utm_source=Google-Adwords&utm_medium=FWorks-Search-Brand&utm_campaign=FWorks-Search-India-Brand&utm_term=freshworks&device=c&ad_pos=&gclid=CjwKCAjw0qOIBhBhEiwAyvVcf21doxlLq-NEk2uBTbrM7lFBx0kafIHa83cOix_Zn6yDwrASdAc1wxoCVm0QAvD_BwE");
        By ele=By.xpath("(//ul[@class='footer-nav'])[1]//a");
        driver.manage().deleteAllCookies();
        clickAll(ele);
	}
    public static void clickAll(By loc)
    {
    	List<WebElement>li=findElements(loc);
    	for(int i=0;i<li.size();i++)
    	{    		
    		System.out.println(li.get(i).getText());
    		li.get(i).click();
    		li=findElements(loc);
    	}
    }   
    
    public static  List<WebElement> findElements(By loc)
    {
    	return driver.findElements(loc);  
    }
}