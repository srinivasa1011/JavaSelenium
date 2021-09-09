package Package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MultiSelect {

	public static void main(String[] args)  throws Exception{
		// TODO Auto-generated method stub
		 String browser="chrome";
			BrowserUtil br=new BrowserUtil();
			WebDriver driver=br.getBrowser(browser);
			ElementUtil el=new ElementUtil(driver);
			br.launchUrl("https://www.jqueryscript.net/demo/Drop-Down-Combo-Tree/");
			System.out.println(br.getTitle());
			By li=By.xpath("//div[@class='comboTreeDropDownContainer']//li/span");
			By id=By.xpath("//input[@id='justAnInputBox']");			
			By li2=By.xpath("//div[@class='comboTreeDropDownContainer']//li/span");
			By id2=By.xpath("//input[@id='justAnInputBox1']");			
			By li3=By.xpath("//div[@class='comboTreeDropDownContainer']//li/span");
			By id3=By.xpath("//input[@id='justAnotherInputBox']");
			
			el.doClick(id);
			Thread.sleep(2000);
			el.selectAllOptions(li,"choice 1","choice 2","choice 3");		
			List<WebElement> btn=driver.findElements(By.xpath("//button[@class='comboTreeArrowBtn']/span"));
			btn.get(0).click();//clicking drop down first button to close first drop down
			el.doClick(id2);
			Thread.sleep(2000);
			
			el.selectAllOptions(li2, "all");			
            btn.get(1).click();
            /*
			el.doClick(id3);
			Thread.sleep(2000);
			el.selectAllOptions(li3, "choice 5");
			*/el.doClick(id);
			Thread.sleep(2000);
			 driver.findElement(By.cssSelector(".multiplesFilter")).sendKeys("choice 2");
			List<WebElement>lis =driver.findElements(li);
			Thread.sleep(2000);
			for(WebElement e: lis)
			{
				System.out.println(e.getText());
				e.click();
			}
			
			 
		
		
	}

}
