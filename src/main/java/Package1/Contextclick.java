package Package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class Contextclick {
  static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String browser="chrome";
		BrowserUtil br=new BrowserUtil();
	    driver=br.getBrowser(browser);
		br.launchUrl("https://swisnl.github.io/jQuery-contextMenu/demo.html");		
		By rightClick=By.xpath("//span[text()='right click me']");
		By option=By.xpath("//li[contains(@class,'context-menu-item context-menu-icon')]");
		Actions ac=new Actions(driver);
		ac.contextClick(driver.findElement(rightClick)).perform();
		/*List<WebElement>li=driver.findElements(option);
		for(WebElement el:li)
		{
			System.out.println(el.getText());
			if(el.getText().equalsIgnoreCase("Copy"))
			{
				el.click();
				break;
			}
		}*/
	    findAndClick(option,"COPY");

	}
public static List<WebElement> getElements(By loc)
{
	return driver.findElements(loc);
}

public static void findAndClick(By loc, String str)
{
	List<WebElement>li= getElements(loc);
	for(WebElement e: li)
	{
			System.out.println(e.getText());
			if(e.getText().equalsIgnoreCase(str))
			{
				e.click();
			    break;
			}
				
	}
}
}
