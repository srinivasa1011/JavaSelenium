package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class SpiceJet {

	static WebDriver driver;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		String browser="chrome";
		BrowserUtil br=new BrowserUtil();
	    driver=br.getBrowser(browser);
		br.launchUrl("https://www.spicejet.com/");
		By loc1=By.partialLinkText("LOGIN");
		By loc2=By.partialLinkText("SpiceClub");
		By loc3=By.linkText("Member Login");
		/*Actions act=new Actions(driver);
 		act.moveToElement(driver.findElement(By.partialLinkText("LOGIN"))).perform();
 		Thread.sleep(3000);
 		act.moveToElement(driver.findElement(By.partialLinkText("SpiceClub"))).build().perform();
  		act.click(driver.findElement(By.linkText("Member Login"))).build().perform();
  		*/
		int i=0;
		while(i<10)
		{
			try
			{
				driver.findElement(loc2).click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(1000);
				System.out.println(i);
			}
			i++;
		}
		//threelevelclick(loc1,loc2,loc3);

	}

	public static WebElement getElement(By loc)
	{
		return driver.findElement(loc);
	}
	public static void threelevelclick(By loc1, By loc2, By loc3) throws InterruptedException
	{
		Actions ac=new Actions(driver);
		ac.moveToElement(getElement(loc1)).perform();
		Thread.sleep(3000);	
		ac.moveToElement(getElement(loc2)).build().perform();
		ac.click(getElement(loc3)).build().perform();
	}
}
