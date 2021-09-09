package Package1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BrowserUtil {

	public WebDriver driver;

	public WebDriver getBrowser(String browser) {

		if (browser.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
		} else
			System.out.println("wrong browser option");

		return driver;
	}

	public void launchUrl(String url) {

		driver.get(url);
	}

	public String getTitle() {

		return driver.getTitle();
	}

	public String getPageSource() {

		return driver.getPageSource();
	}

	public void closeBrowser() {

		driver.close();
	}
	public void QuitBrowser() {

		driver.quit();
	}
}