package Package1;

import java.awt.Window;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementNotVisibleException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Test {

	//private static final String JavascriptExecutor = null;

	public static void main(String[] args) throws InterruptedException {
		String browser = "chrome";
		BrowserUtil br = new BrowserUtil();
		WebDriver driver = br.getBrowser(browser);
		br.launchUrl("https://www.spicejet.com/");
		WebDriverWait w=new WebDriverWait(driver,15);
		Wait<WebDriver>w2=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(20)).pollingEvery(Duration.ofMillis(2000))
				.ignoring(ElementNotVisibleException.class);
		w2.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id$='originStation1_CTXT']"))).click();
		//Wait<WebDriver>w3=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofMillis(3000))
			//	.ignoring(Exception.class);
	    
		
		//w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input[id$='originStation1_CTXT']"))).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='dropdownGroup1']//li/a[contains(text(),'Bengaluru')]"))).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("(//div[@id='dropdownGroup1']//li/a[contains(text(),'Delh')])[2]"))).click();
		w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='ui-datepicker-title']")));
		while (!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText().contains("Sep")) {
			System.out.println(driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText());
			driver.findElement(By.xpath("//a[@title='Next']")).click();
		}
		driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='12']")).click();
		System.out.println("---------");
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#divpaxinfo"))).click();		
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='ctl00_mainContent_ddl_Adult']/option[text()=2]"))).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='ctl00$mainContent$ddl_Child']//option[text()=1]"))).click();
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@name='ctl00$mainContent$ddl_Infant']/option[text()=1]"))).click();
		w.until(ExpectedConditions.elementToBeClickable(By.name("ctl00$mainContent$btn_FindFlights"))).click();
 		Thread.sleep(9000);
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.trip-modify-btn")));
		do
		{
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("span.forward-icon"))).click();
		//js2.executeScript("arguments[0].click;", cli);
		System.out.println("attempting");
		}
		 while(!w.until(ExpectedConditions.urlContains("Cont")));
		
	  //  }
	
 		
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select#CONTROLGROUPPASSENGER_ContactInputPassengerView_DropDownListTitle>option:nth-of-type(3)"))).click();
		driver.findElement(By.cssSelector("input#CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxFirstName"))
				.sendKeys("srinivasa");
		driver.findElement(By.cssSelector("input#CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxLastName"))
				.sendKeys("srinivasa");
		driver.findElement(By.cssSelector("input#CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxHomePhone"))
				.sendKeys("9898989899");
		driver.findElement(By.cssSelector("input#CONTROLGROUPPASSENGER_ContactInputPassengerView_TextBoxEmailAddress"))
				.sendKeys("srinivasa@gmail.com");
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("select[name='contact_cities_list_india']>option:nth-of-type(5)		"))).click();

		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#CONTROLGROUPPASSENGER_ContactInputPassengerView_CheckBoxPromoOpt"))).click();
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("input#CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_SJFlyingView_IamFlying"))).click();
		w.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div#Details_Adult2 select#CONTROLGROUPPASSENGER_PassengerInputViewPassengerView_DropDownListTitle_1>option:nth-of-type(3)"))).click();

		driver.findElement(By.xpath("(//div[@id='Details_Adult2']//input)[1]")).sendKeys("hamsa");
		driver.findElement(By.xpath("(//div[@id='Details_Adult2']//input)[2]")).sendKeys("srinivasa");
		driver.findElement(By.xpath("(//div[@id='Details_Adult2']//input)[3]")).sendKeys("545454444");
		driver.findElement(By.xpath("(//div[@id='Details_Child1']//input)[1]")).sendKeys("aaaaaa");
		driver.findElement(By.xpath("(//div[@id='Details_Child1']//input)[2]")).sendKeys("aaaaaa");
		driver.findElement(By.xpath("(//div[@id='Details_Infant1']//input)[1]")).sendKeys("bbbbbb");
		driver.findElement(By.xpath("(//div[@id='Details_Infant1']//input)[2]")).sendKeys("bbbbbb");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement d1 = driver.findElement(By.cssSelector("input#inputDateContactInfant1"));
		d1.click();
		Thread.sleep(3000);
		// js.executeScript("argumments[0].setAttribute('value','29-04-2021');",d1);

		driver.findElement(By.xpath("//span[text()=2021]")).click();
		driver.findElement(By.xpath(" //span[text()='Mar']")).click();
		driver.findElement(By.xpath("//td[@class='validDate']//span[text()='12']")).click();

		driver.findElement(By.cssSelector("span.forward-icon")).click();

		Thread.sleep(5000);
		//driver.findElement(By.xpath("//div[@class='ao-right']//input[@id='hotMealsBtn']")).click();
		//Thread.sleep(3000);
		driver.findElement(By.cssSelector("div#continue-to-payment-page")).click();
		//

		Thread.sleep(3000);

		
		List<WebElement> li=driver.findElements(By.cssSelector("td.seatSelect input:nth-of-type(2)"));
		li.get(0).click();
		//ControlGroupUnitMapView_UnitMapViewControl_EquipmentConfiguration_0_PassengerNumber_0
		driver.findElement(By.xpath("//div[@id='0_Y_1_8A']")).click();
		Thread.sleep(5000);
		
		//driver.switchTo().frame(0);
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Cancel']")).click();
		//driver.switchTo().defaultContent();
		
		
		li.get(1).click();
		driver.findElement(By.xpath("//div[@id='0_Y_1_8B']")).click();
		
		li.get(2).click();
		driver.findElement(By.xpath("//div[@id='0_Y_1_8C']")).click();
		driver.findElement(By.cssSelector("span.forward-icon")).click();

		Thread.sleep(2000);
		/*
		 * driver.findElement(By.id("ctl00_mainContent_view_date2")).click();
		 * while(!driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).
		 * getText().contains("Dec")) { System.out.println(driver.findElement(By.xpath(
		 * "//div[@class='ui-datepicker-title']")).getText());
		 * driver.findElement(By.xpath("//a[@title='Next']")).click(); }
		 * driver.findElement(By.xpath("//td[@data-handler='selectDay']/a[text()='12']")
		 * ).click(); System.out.println("---------");
		 */
		//Thread.sleep(4000);
		
       /* List<WebElement>lis=driver.findElements(By.xpath("//span[@class='flightfare']"));
        Double small=Double.parseDouble(lis.get(0).getText().replaceAll("[A-Za-z]", ""));
        for(int i=1;i<=lis.size();i++)    
        {
           if (Double.parseDouble(lis.get(i).getText().replaceAll("[A-Za-z]", "")) <small)
        		   {
        	         small=Double.parseDouble(lis.get(i).getText().replaceAll("[A-Za-z]", ""));
        		   }
        	
        }
        System.out.println(small);
        driver.findElement(By.xpath("//span[contains(text(),"+small+")]")).click();
		//driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
		Thread.sleep(8000);*/
      //  JavascriptExecutor js2= (JavascriptExecutor) driver;
		//w.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[text()='Continue']"))).click();
		 
       // js2.executeScript("history.go(0)");
		//WebElement cli=driver.findElement(By.cssSelector("span.forward-icon"));
		
		
		/*
		 * WebElement e2=driver.findElement(By.xpath(
		 * "(//div[@id='dropdownGroup1']//li/a[contains(text(),'Hyder')])[2]"));
		 * e2.click(); driver.findElement(By.xpath("//a[@title='Next']")).click();
		 * JavascriptExecutor js=(JavascriptExecutor)driver; WebElement
		 * d1=driver.findElement(By.name("ctl00$mainContent$txt_Fromdate"));
		 * System.out.println(d1.getAttribute("value"));
		 * List<WebElement>li=driver.findElements(By.xpath(
		 * "//div[@class='ui-datepicker-title']")); for(WebElement e: li) {
		 * if(e.getText().contains("Aug")) {
		 * 
		 * } } //WebElement
		 * d2=driver.findElement(By.name("ctl00$mainContent$txt_Todate"));
		 * js.executeScript
		 * ("document.getElementById('date_picker_id_1').removeAttribute('readonly',0);"
		 * ); // Enables the from date box d1.clear(); d1.sendKeys("18-Aug-2021");
		 * //Enter date in required format
		 * //js.executeScript("argumments[0].setAttribute('value','29-08-2021');",d1);
		 * //js.executeScript("argumments[0].setAttribute('value','29-09-2021');",d2);
		 */

	}
}
