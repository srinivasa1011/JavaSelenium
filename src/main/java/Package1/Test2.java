package Package1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Test2 {

	static WebDriver driver;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://tlc.ent.sirsidynix.net.uk/custom/web/registration/index.html?locale=en_GB&profile=essex");
		//By from=By.id("gosuggest_inputSrc");
		//By to=By.id("gosuggest_inputDest");
		//selecting month jan,we can handle dynamically using string variable for month
		By month=By.xpath("//select[@class='ui-datepicker-month']//option[text()='Jan']");
 		//selecting year 2020, we can handle dynamically using int variable for year 
		By year=By.xpath("//select[@class='ui-datepicker-year']//option[text()=2020]");
 		By date=By.xpath("//a[text()=3]");//clicking date val 3
 		driver.findElement(By.cssSelector("input#patron_birthDate_input")).click();
		driver.findElement(month).click();
		driver.findElement(year).click();
		driver.findElement(date).click();
	}
		 

}
