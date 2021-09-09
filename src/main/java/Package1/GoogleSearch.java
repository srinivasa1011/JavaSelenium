package Package1;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GoogleSearch {

	 

	public static void main(String[] args) throws Exception{
		   String browser="chrome";
					BrowserUtil br=new BrowserUtil();
					/*WebDriver driver=br.getBrowser(browser);
					br.launchUrl("http://google.com");
					System.out.println(br.getTitle());
					By li=By.xpath("//div[@class='pcTkSc']");
					By id=By.name("q");
					ElementUtil el=new ElementUtil(driver);
					el.doSendKeys(id, "naveen automation labs");
					Thread.sleep(6000);
					List<String>lists=el.getList(li);
					el.printList(lists);
					el.clickDropDown(li, "naveen automation labs testng");	*/
					String s="1234.45   djfkjskf  ";
					System.out.println(Double.parseDouble(s.replaceAll("[A-Za-z]", "")));
					System.out.println();

	}

}
