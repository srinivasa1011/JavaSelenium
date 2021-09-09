package Package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class AutomationTestApp {

	public static void main(String[] args) throws Exception {
		    String browser="chrome";
			BrowserUtil br=new BrowserUtil();
			WebDriver driver=br.getBrowser(browser);
			br.launchUrl("http://automationpractice.com/index.php");
			System.out.println(br.getTitle());
			By li=By.xpath("//div[@class='ac_results']//li");
			By id=By.id("search_query_top");
			ElementUtil el=new ElementUtil(driver);
			el.doSendKeys(id, "dress");
			Thread.sleep(9000);
			List<String>lists=el.getList(li);
			el.printList(lists);
			el.clickDropDown(li, "Casual Dresses > Printed Dress");			
			/*driver.findElement(By.id("search_query_top")).sendKeys("dress");
			Thread.sleep(9000);
			List<WebElement> lis=driver.findElements(li);
			for(WebElement el: lis)
			{
				System.out.println(el.getText());
				if(el.getText().equals("Casual Dresses > Printed Dress"))
				{
					el.click();
					System.out.println("pass");
					break;
				}
				
			}*/
		//	br.closeBrowser();
			   
			

	}

}
