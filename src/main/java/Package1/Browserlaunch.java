package Package1;

import java.util.List;

import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Browserlaunch {

	public Browserlaunch() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setProperty("webdriver.chrome.driver","C:\\Users\\skeshavkumar\\chromedriver.exe");
		String browser="chrome";
		BrowserUtil br=new BrowserUtil();
		WebDriver driver=br.getBrowser(browser);
		//br.launchUrl("https://www.orangehrm.com/orangehrm-30-day-trial/");
		br.launchUrl("https://google.com");
		System.out.println(br.getTitle());
		driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("sachin tendulkar");
		Thread.sleep(3000);
		List<WebElement> li=driver.findElements(By.xpath("//div[@class='pcTkSc']/div[@class='wM6W7d']/span"));
		for(WebElement e:li)
			System.out.println(e.getText());
		/*By username=By.id("Form_submitForm_subdomain");
		By firstName=By.id("Form_submitForm_FirstName");
		By lastName=(By.id("Form_submitForm_LastName"));
		By email=By.id("Form_submitForm_Email");
		By jobTitle=By.id("Form_submitForm_JobTitle");
		By compName=By.id("Form_submitForm_CompanyName");
		By phone=By.id("Form_submitForm_Contact");
		
		By noOfEmp=By.id("Form_submitForm_NoOfEmployees");
		By industry=By.id("Form_submitForm_Industry");
		By country=By.id("Form_submitForm_Country");
		
		By clickBox=By.id("Form_submitForm_SetDummyData");
		
		ElementUtil ele=new ElementUtil(driver);
	    ele.doSendKeys(username, "sriniv");
		ele.doSendKeys(firstName, "srinivasa");
		ele.doSendKeys(lastName, "keshavkumar");
		ele.doSendKeys(email,"srinivasa.k@gmail.com");
		ele.doSendKeys(jobTitle, "QA AUTOMATION");
		ele.doSendKeys(compName, "abc company");
		ele.doSendKeys(phone,"9898987666");
	    ele.doSelectByindex(noOfEmp, 2);
	    ele.doSelectByindex(industry,5);
	    ele.doSelectByText(country, "Iceland");
	    ele.doClick(clickBox);
	    
	    By val=By.xpath("//select[@id='Form_submitForm_Industry']/option");
	    ele.clickDropDown(val, "Education");
	    List<String>li=ele.getStringList(val);
	    System.out.println(li.size());
	    System.out.println(li.contains("Education"));
	   // br.closeBrowser();*/


	}

}
